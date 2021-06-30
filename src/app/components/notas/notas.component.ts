import { Component, OnInit } from '@angular/core';
import {CreatenotasService} from "../../service/createnotas.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {InfoDialogComponent} from "../info-dialog/info-dialog.component";
import {MatDialog} from "@angular/material/dialog";


@Component({
  selector: 'app-notas',
  templateUrl: './notas.component.html',
  styleUrls: ['./notas.component.css']
})
export class NotasComponent implements OnInit {
  notas:Array<any>=[];
  notasimport:Array<any>=[];
  notasNombre:Array<any>=[];
  notasFC:Array<any>=[];

  dataUpdate:any;
  errormessage:any;
  public notasID:FormGroup;

  range = new FormGroup({
    start: new FormControl(),
    end: new FormControl()
  });
  constructor(private notaService:CreatenotasService,private fb:FormBuilder,public dialog: MatDialog) { }

  ngOnInit(): void
  {
    this.notasID=this.fb.group({
      id_usuario:['',Validators.required],
      importancia:['',Validators.required],
      nota_nombre:['',Validators.required],
      id_nota:['',Validators.required],
      description:['',Validators.required]
    })
  }
  cleandata()
  {
    this.notas=[];
    this.notasimport=[];
  }
  getNotas():void
  {
   // this.notaService.getNotas().subscribe(notas=>this.notas=notas);
  }
  getNotaByFCFC()
  {

    this.notaService.getNotasByFC(this.range.get("start")?.value,this.range.get("end")?.value).subscribe((result:any)=>{this.notasFC=result.data;
   })
  }

  getNotasByID():void
  {
    if(this.notasID.get("id_usuario")?.value!='')
    {
      this.notaService.getNotasByID(this.notasID.get("id_usuario")?.value).subscribe((result:any)=>{this.notas=result.data})
    }else
      {
        const title="Fallo al Obtener Notas"
        const info = "Rellene todos los campos solicitados"
        this.openDialog(title, info)
      }
  }

  getNotasByImportancia():void
  {
    if(this.notasID.get("importancia")?.value!='' &&this.notasID.get("id_usuario")?.value!='')
    {
      this.notaService.getNotasByImportancia(this.notasID.get("importancia")?.value,this.notasID.get("id_usuario")?.value).subscribe((result:any)=>{this.notasimport=result.data})
    }else
      {
        const title="Fallo al Obtener Notas"
        const info = "Rellene todos los campos solicitados"
        this.openDialog(title, info)
      }
  }

  getNotasByNotaName():void
  {
    if(this.notasID.get("nota_nombre")?.value!='' &&this.notasID.get("id_usuario")?.value!='')
    {
      this.notaService.getNotasFiltroNombre(this.notasID.get("nota_nombre")?.value,this.notasID.get("id_usuario")?.value).subscribe((result:any)=>{this.notasNombre=result.data})
    }else
    {
      const title="Fallo al Obtener Notas"
      const info = "Rellene todos los campos solicitados"
      this.openDialog(title, info)
    }
  }

  actualizarNameNota()
  {
    if(this.notasID.get("nota_nombre")?.value!='' &&this.notasID.get("id_nota")?.value!='')
    {
      this.notaService.updateNameNota(this.notasID.get("nota_nombre")?.value,this.notasID.get("id_nota")?.value).subscribe((result:any)=>
      {
        if(result=='0')
        {
          const title="Fallo al Actualizar el Nombre de la Nota"
          const info = "Rellene todos los campos solicitados"
          this.openDialog(title, info)
        }else
        {
          const title="Se  actualizo el Nombre de la Nota"
          const info = "Logrado"
          this.openDialog(title, info)
        }
      })
    }else
    {
      const title="Fallo al Actualizar el Nombre de la Nota"
      const info = "Rellene todos los campos solicitados"
      this.openDialog(title, info)
    }
  }

  actualizarDescriptionNota()
  {
    if(this.notasID.get("description")?.value!='' &&this.notasID.get("id_nota")?.value!='')
    {
      this.notaService.updateDescripcionNota(this.notasID.get("description")?.value,this.notasID.get("id_nota")?.value).subscribe((result:any)=>
      {
        if(result=='0')
        {
          const title="Fallo al Actualizar la descripción de la Nota"
          const info = "Rellene todos los campos solicitados"
          this.openDialog(title, info)
        }else
          {
            const title="Se  actualizo la descripción de la Nota"
            const info = "Logrado"
            this.openDialog(title, info)
          }
      })
    }else
    {
      const title="Fallo al Actualizar la descripción de la Nota"
      const info = "Rellene todos los campos solicitados"
      this.openDialog(title, info)
    }
  }

  eliminarCuenta()
  {
    if(this.notasID.get("id_nota")?.value!='')
    {
      this.notaService.eliminarNota(this.notasID.get("id_nota")?.value).subscribe(data=>this.dataUpdate=data,error =>{this.errormessage=error;console.error('No se encontro Nota',error);
        const title="Fallo al Eliminar Nota"
        const info = "Usuario no existe"
        this.openDialog(title, info)} );
    }
    else
    {
      const title="Fallo al Eliminar Usuario"
      const info = "Rellene todos los campos solicitados"
      this.openDialog(title, info)
    }
  }

  openDialog(title: string, info: string): void {
    const dialogRef = this.dialog.open(InfoDialogComponent, {
      width: '350px',
      data: {title: title, info: info}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
}

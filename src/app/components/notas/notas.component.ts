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
  notas:any;
  public notasID:FormGroup;
  constructor(private notaService:CreatenotasService,private fb:FormBuilder,public dialog: MatDialog) { }
  //typesOfShoes: string[] = ['Boots', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers'];
  id_user=new FormControl('',[Validators.required])

  ngOnInit(): void
  {
    this.notasID=this.fb.group({
      id_usuario:['',Validators.required]
    })
  }

  getNotas():void
  {
    this.notaService.getNotas().subscribe(notas=>this.notas=notas);
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

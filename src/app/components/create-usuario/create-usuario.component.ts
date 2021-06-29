import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CrearusuarioService} from "../../service/crearusuario.service";
import {Usuario} from "../../models/usuario.model";
import {ActivatedRoute, Router} from "@angular/router";
import {InfoDialogComponent} from "../info-dialog/info-dialog.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-create-usuario',
  templateUrl: './create-usuario.component.html',
  styleUrls: ['./create-usuario.component.css']
})
export class CreateUsuarioComponent implements OnInit {
  public userForm:FormGroup;
  public usuario=new Usuario();

  constructor(public dialog: MatDialog,private fb:FormBuilder,private crearusuario: CrearusuarioService,private router: Router) { }

  ngOnInit(): void
  {
    this.initForm();
  }

  initForm()
  {
    this.userForm=this.fb.group({
      nombre:['',Validators.required],
      correo:['',Validators.required],
      contrasena:['',Validators.required]
    })
  }
  setUsuario()
  {
    this.usuario.nombre=this.userForm.get('nombre')?.value,
    this.usuario.correo=this.userForm.get('correo')?.value,
    this.usuario.contrasena=this.userForm.get('contrasena')?.value
  }
  createUsuario()
  {
    this.setUsuario()
    console.log(this.usuario.nombre,this.usuario.contrasena,this.usuario.correo)
    if(this.usuario.nombre!='' && this.usuario.correo!=''&&this.usuario.contrasena!='' )
    {
      this.crearusuario.createUsuario(this.usuario.nombre,this.usuario.correo,this.usuario.contrasena).subscribe((result:any)=>{
        console.log(result.data)
        if(result.data==null)
        {
          const title="Fallo al Crear Usuario"
          const info = "El correo ya existe"
          this.openDialog(title, info)
        }else{
        const title="Usuario Creado Satisfactoriamente"
        const info = "No compartas tu informacion con nadie,ninguno de nuestros tecnicos solicitara estos datos"
        this.openDialog(title, info)}
      })
    }else
      {
        const title="Fallo al Crear Usuario"
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
  regresar()
  {
    this.router.navigateByUrl('/login');
  }
}

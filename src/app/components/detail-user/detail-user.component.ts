import { Component, OnInit } from '@angular/core';
import {LoginService} from "../../service/login.service";
import {UserLogin} from "../../models/usuario.model";
import {MatTabsModule} from "@angular/material/tabs";
import {CrearusuarioService} from "../../service/crearusuario.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {InfoDialogComponent} from "../info-dialog/info-dialog.component";
import {MatDialog} from "@angular/material/dialog";

@Component({
  selector: 'app-detail-user',
  templateUrl: './detail-user.component.html',
  styleUrls: ['./detail-user.component.css']
})
export class DetailUserComponent implements OnInit
{
  public infor:any;
  //public name:string;
  public usuario:any;
  public user:FormGroup;
  public username:any;
  public password:any;
  public correo:any;
  public id_usuario:any;
  public datos:any;
  public errormessage:any;

  constructor(public dialog: MatDialog,private loginService:LoginService,private createUsuario:CrearusuarioService,private fb:FormBuilder )
  {}

  ngOnInit(): void {
    this.loginService.disparadorUserData.subscribe((datos)=>{console.log("Recibiendo data ..",datos)//JSON.parse(datos).data //datos.data
      this.createUsuario.InformacionUsuario(datos).subscribe((result:any)=>{console.log('Recibiendo data..',result.data),this.usuario=result.data});
    })
    this.user = this.fb.group({
      name_user: ['', Validators.required],
      contrasena: ['', Validators.required],
      correo: ['', Validators.required],
      id_usuario: ['', Validators.required]
    })
  }
  informacionUsuario()
  {
    //this.ngOnInit()
    //this.user.get("name_user")?.value
    //console.log(String(this.usuario.data))
    this.createUsuario.InformacionUsuario(this.user.get("name_user")?.value).subscribe((result:any)=>{console.log('Recibiendo datods..',result.data),this.usuario=result.data});

  }
  actualizarContrasena()
  {
    this.username=this.user.get("name_user")?.value;
    this.password=this.user.get("contrasena")?.value;
    if(this.username!=''&&this.password!='')
    {
      this.createUsuario.actualizarContraseña(this.username,this.password).subscribe(data=>this.datos=data);

    }else
    {
      const title="Fallo al Actualizar Contraseña"
      const info = "Rellene todos los campos solicitados"
      this.openDialog(title, info)
    }
  }

  actualizarCorreo()
  {
    this.username=this.user.get("name_user")?.value;
    this.correo=this.user.get("correo")?.value;
    if(this.username!=''&&this.correo!='')
    {
      this.createUsuario.actualizarCorreo(this.username,this.correo).subscribe(data=>this.datos=data);

    }else
    {
      const title="Fallo al Actualizar Correo"
      const info = "Rellene todos los campos solicitados"
      this.openDialog(title, info)
    }
  }
  eliminarCuenta()
  {
    this.id_usuario=this.user.get("id_usuario")?.value;
    if(this.id_usuario!='')
    {
      this.createUsuario.eliminarUsuario(this.id_usuario).subscribe(data=>this.datos=data,error =>{this.errormessage=error;console.error('No se encontro Usuario',error);
        const title="Fallo al Eliminar Usuario"
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

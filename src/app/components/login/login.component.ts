import {Component, Input, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {LoginService} from "../../service/login.service";
import {UserLogin} from "../../models/usuario.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatDialog} from "@angular/material/dialog";
import {InfoDialogComponent} from "../info-dialog/info-dialog.component";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  logo="./assets/img/logo.png"
  public usuario_log=new UserLogin();
  public usuarioForm: FormGroup;
  @Input() dataentrante:any;
  //@Input() dataEntrante:any;
  constructor(private router: Router,private loginService:LoginService,private fb:FormBuilder,public dialog: MatDialog) { }

  ngOnInit(): void
  {
    this.usuarioForm=this.fb.group({password:['',Validators.required],nombre_user:['',Validators.required]})
  }

  ingresar() {
    this.router.navigateByUrl('/navbar');
  }
  crearUsuario()
  {
    this.router.navigateByUrl('/create');
  }

  login()
  {
    if(this.usuarioForm.get('password')?.value=='' || this.usuarioForm.get('nombre_user')?.value=='')
    {
      const title="Fallo al Iniciar Sesion"
      const info = "Verifique si su usuario o contraseña estan correctamente escritas."
      this.openDialog(title, info)
    }else {
      if (this.usuarioForm.get('password')?.value =="" && this.usuarioForm.get('nombre_user')?.value == "") {
        this.router.navigateByUrl('/login');
        const title = "Fallo al Iniciar Sesion"
        const info = "Verifique si su usuario o contraseña estan correctamente escritas."
        this.openDialog(title, info)

      }else
        {
          this.loginService.login(this.usuarioForm.get('password')?.value,this.usuarioForm.get('nombre_user')?.value).subscribe(
            (result:any)=>{
              if(result.status=="Succes Login")
              {
                this.dataentrante=result.data;
                this.loginService.disparadorUserData.emit(this.usuarioForm.get('nombre_user')?.value);
                this.ingresar();
            }else
              {
                const title = "Fallo al Iniciar Sesión"
                const info = "Verifique si su usuario o contraseña estan correctamente escritas."
                this.openDialog(title, info)
              }
            })
        }
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

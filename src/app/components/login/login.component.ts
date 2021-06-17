import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {LoginService} from "../../service/login.service";
import {UserLogin} from "../../models/usuario.model";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  logo="./assets/img/logo.png"
  public usuario_log=new UserLogin();
  public usuarioForm: FormGroup;
  constructor(private router: Router,private loginService:LoginService,private fb:FormBuilder) { }

  ngOnInit(): void
  {
    this.usuarioForm=this.fb.group({password:['',Validators.required],nombre_user:['',Validators.required]})
  }

  ingresar() {
    //this.router.navigateByUrl('/notes');
    console.log(this.usuario_log.nombre)
  }
  login()
  {
    this.loginService.login(this.usuarioForm.get('password')?.value,this.usuarioForm.get('nombre_user')?.value).subscribe(
      (result:any)=>{this.usuario_log=result.data})
  }
}

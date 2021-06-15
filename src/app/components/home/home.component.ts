import { Component, OnInit } from '@angular/core';
import {ChartOptions, ChartType} from "chart.js";
import {Color, Label, SingleDataSet} from "ng2-charts";
import {CreateUsuario} from "../../interface/usuario.interface";
import {UsuarioService} from "../../services/usuario.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  usuarios:any;
  nombre:string;
  correo:string;
  password:string;
  //nombre:"hola"
  constructor(private usuarioService:UsuarioService)
  {
   this.nombre="gg";
   this.correo="ah";
   this.password="az";
  }

  ngOnInit(): void
  {

  }

  createUsuario()
  {
    this.usuarioService.createUsuario(this.usuarios).subscribe(usuario=>this.usuarios.push(this.usuarios.nombre,this.usuarios.correo,this.usuarios.password));
  }


}

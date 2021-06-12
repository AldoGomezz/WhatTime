import { Component, OnInit } from '@angular/core';
import {UsuarioService} from "../../services/usuario.service";
import {Usuario} from "../../models/usuario";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  usuarios:Usuario[]=[];
  constructor(private usuarioService:UsuarioService) { }

  ngOnInit(): void
  {
    this.getUsuarios();
  }
  getUsuarios():void
  {
    this.usuarioService.getUsuario().subscribe(usuarios=>this.usuarios=usuarios.slice(1,5));

  }
}

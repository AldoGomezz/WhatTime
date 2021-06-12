import { Component, OnInit } from '@angular/core';
import { Usuario } from '../../models/usuario';
import {UsuarioService} from "../../services/usuario.service";
import {MessageService} from "../../services/message.service";
@Component({
  selector: 'app-usuario-gestor',
  templateUrl: './usuario-gestor.component.html',
  styleUrls: ['./usuario-gestor.component.css']
})
export class UsuarioGestorComponent implements OnInit {

  usuarios:Usuario[]=[];

  constructor(private usuarioservice:UsuarioService, private messageService: MessageService) { } //Inyeccion de dependecias (Datos)

  ngOnInit(): void
  {
    // Aqui se recomiendatodo que querramos que corra de una vez al inicio de la carga la primera vez.
    this.getUsuarios();
  }
  /*onSelect(usuario: Usuario): void {
    this.selectedusuarios = usuario;
    this.messageService.add(`UsuarioComponente: Seleccionando el usuario id = ${usuario.id}`);
    console.log(this.selectedusuarios);
  }*/
  getUsuarios():void
  {
    this.usuarioservice.getUsuario().subscribe(usuarios=>this.usuarios=usuarios);
  }
}

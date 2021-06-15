import { Component, OnInit } from '@angular/core';
import {UsuarioService} from "../../../services/usuario.service";
import {UsuarioInterface} from "../../../interface/usuario.interface";

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {
  usuarios:any; //UsuarioInterface en lugar de Any
  constructor(private usuarioService:UsuarioService ) { }

  ngOnInit(): void
  {
    this.getAllUsers();
  }
  getAllUsers():void
  {
    this.usuarioService.getUsuarios().subscribe(usuarios=>this.usuarios=usuarios);
  }
}

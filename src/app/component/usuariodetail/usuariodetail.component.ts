import {Component, Input, OnInit} from '@angular/core';
import {Usuario} from "../../models/usuario";
import {ActivatedRoute} from "@angular/router";
import {UsuarioService} from "../../services/usuario.service";
import { Location } from '@angular/common';

@Component({
  selector: 'app-usuariodetail',
  templateUrl: './usuariodetail.component.html',
  styleUrls: ['./usuariodetail.component.css']
})
export class UsuariodetailComponent implements OnInit {
  /*@Input() usuarios?:Usuario;*/
  usuario?:Usuario;
  constructor(private route: ActivatedRoute,private usuarioService:UsuarioService,private location:Location) { }

  ngOnInit(): void
  {
    this.getUsuarioxId();
  }


  getUsuarioxId():void
  {
    const id=Number(this.route.snapshot.paramMap.get('id'));
    this.usuarioService.getUsuarioxId(id).subscribe(usuario=>this.usuario=usuario);
  }
  goback():void
  {
   this.location.back();

  }
}

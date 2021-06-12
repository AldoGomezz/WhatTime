import { Injectable } from '@angular/core';
import {Usuario} from "./usuario-gestor/usuario";
import {User} from "./usuario-gestor/mock-Usuario";
import {Observable, of} from "rxjs";
import {MessageService} from "./services/message.service";

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private messageService:MessageService) { }
  getUsuario(): Observable<Usuario[]>
  {
   const usuarios=of(User);
   this.messageService.add('Se cargo exitosamente el usuario');
   return usuarios;
  }
  getUsuarioxId(id:number): Observable<any>
  {
    const usuario=User.find(h=>h.id === id)
    this.messageService.add('Se cargo exitosamente el usuario');
    return of(usuario);
  }
}

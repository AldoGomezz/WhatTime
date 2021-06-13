import { Injectable } from '@angular/core';
import {Usuario} from "../models/usuario";

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService {

  constructor() { }
  createDb() {
    const usuarios = [
      { id: 11, nombre: 'Dr Nice',correo:'ss@gmail.com',contraseña:"morales" },
      { id: 12, nombre: 'Narco' ,correo:'ss@gmail.com',contraseña:"morales" },
      { id: 13, nombre: 'Bombasto',correo:'ss@gmail.com',contraseña:"morales" },
      { id: 14, nombre: 'Celeritas',correo:'ss@gmail.com',contraseña:"morales"},
      { id: 15, nombre: 'Magneta' ,correo:'ss@gmail.com',contraseña:"morales"},
      { id: 16, nombre: 'RubberMan',correo:'ss@gmail.com',contraseña:"morales" },
      { id: 17, nombre: 'Dynama',correo:'ss@gmail.com',contraseña:"morales" },
      { id: 18, nombre: 'Dr IQ',correo:'ss@gmail.com',contraseña:"morales" },
      { id: 19, nombre: 'Magma',correo:'ss@gmail.com',contraseña:"morales" },
      { id: 20, nombre: 'Tornado',correo:'ss@gmail.com',contraseña:"morales" }
    ];
    return {usuarios};
  }
  genId(usuarios: Usuario[]): number {
    return usuarios.length > 0 ? Math.max(...usuarios.map(usuario => usuario.id)) + 1 : 11;
  }
}

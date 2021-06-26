import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {UserLogin, Usuario} from "../models/usuario.model";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CrearusuarioService {

  constructor(private http: HttpClient) {
  }

  createUsuario(name: string, correo: string, password: string) {
    return this.http.post(`${environment.apiUsuarioUrl}/create`, {name, correo, password})
  }
  InformacionUsuario(name:string)
  {
    return this.http.get(`${environment.apiUsuarioUrl}/${name}`)
  }

  actualizarContraseña(name: string, password: string)
  {
    return this.http.put(`${environment.apiUsuarioUrl}/updatepassword?contrasena=${password}&username=${name}`,{password,name});
  }
  actualizarCorreo(name: string, correo: string)
  {
    return this.http.put(`${environment.apiUsuarioUrl}/updateemail?correo=${correo}&username=${name}`,{correo,name});
  }

  eliminarUsuario(id:number)
  {
    return this.http.delete(`${environment.apiUsuarioUrl}/deleteuser?id=${id}`);
  }
}

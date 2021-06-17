import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Usuario} from "../models/usuario.model";
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
}

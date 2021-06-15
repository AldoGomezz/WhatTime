import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {CreateUsuario, UsuarioInterface} from "../interface/usuario.interface";
import {environment} from "../../environments/environment";
import {catchError, map} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UsuarioService
{
  constructor(private http:HttpClient)
  {}

  getUsuarios():Observable<UsuarioInterface[]>
  {
    return this.http.get<UsuarioInterface[]>(`${environment.apiUsuarioUrl}/getusers`).pipe(catchError(e=>{return throwError(e)}));
  }
  createUsuario(usuario:CreateUsuario):Observable<CreateUsuario>
  {
    return this.http.post(`${environment.apiUsuarioUrl}/create`,usuario).pipe(map((d:any)=>d as CreateUsuario));
  }
}

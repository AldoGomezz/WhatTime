import { Injectable } from '@angular/core';
import {MessageService} from "./message.service";
import {Usuario} from "../models/usuario";
import {Observable, of} from "rxjs";
import {User} from "../models/mock-Usuario";
import {HttpClient} from "@angular/common/http";
import {catchError,tap} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  private usuariosUrl='api/usuarios';
  constructor(private messageService:MessageService,private http:HttpClient) { }
  getUsuario(): Observable<Usuario[]>
  {
    return this.http.get<Usuario[]>(this.usuariosUrl).pipe(tap(_=>this.log('error usuarios')),catchError(this.handleError<Usuario[]>('getUsuarios', [])));
  }
  getUsuarioxId(id:number): Observable<any>
  {
    const usuario=User.find(h=>h.id === id)
    return of(usuario);
  }
  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    this.messageService.add(`UsuarioService: ${message}`);
  }
  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}

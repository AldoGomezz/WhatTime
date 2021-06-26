import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Nota} from "../models/nota.model";
import {Usuario} from "../models/usuario.model";


@Injectable({
  providedIn: 'root'
})
export class CreatenotasService {

  constructor(private http:HttpClient) { }

  getNotas()
  {
    return this.http.get(`${environment.apiNotaURL}/getnotes`);
  }
  getNotasByID(id:string)
  {
    return this.http.get(`${environment.apiNotaURL}/getnotebyuser?usuarioId=${id}`);
  }

  createNota(nota:Nota,id:string)
  {
    return this.http.post(`${environment.apiNotaURL}/create?id=${id}`,nota);
  }


}

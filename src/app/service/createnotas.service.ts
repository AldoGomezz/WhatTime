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
  public Nota:Nota;
  getNotas()
  {
    return this.http.get(`${environment.apiNotaURL}/getnotes`);
  }
  getNotasByID(id:string):Observable<Nota[]>
  {
    return this.http.get<Nota[]>(`${environment.apiNotaURL}/getnotebyuser?usuarioId=${id}`);
  }

  createNota(nota:Nota,id:string)
  {
    //date=${fecha_Create}&dateTimeFinsih=${fecha_finish}&
    return this.http.post(`${environment.apiNotaURL}/create?id=${id}`,nota);
  }

  getNotasByImportancia(importancia:string,id:string):Observable<Nota[]>
  {
    return this.http.get<Nota[]>(`${environment.apiNotaURL}/gnoteByImport?importancia=${importancia}&usuarioID=${id}`);
  }

  getNotasByFC(fecha_Crea:string,fecha_culmin:string):Observable<Nota[]>
  {
    return this.http.get<Nota[]>(`${environment.apiNotaURL}/gnoteFCbtFC?fecha_Creacion=${fecha_Crea}&fecha_culminacion=${fecha_culmin}`);
  }

  getNotasFiltroNombre(nombre_nota:string,id:string):Observable<Nota[]>
  {
    return this.http.get<Nota[]>(`${environment.apiNotaURL}/gnotename?nombre_nota=${nombre_nota}&usuarioID=${id}`);
  }

  updateNameNota(nombre_nota:string,id:string)
  {
    return this.http.put(`${environment.apiNotaURL}/updatename?name_nota=${nombre_nota}&noteId=${id}`,{nombre_nota,id});

  }
  updateDescripcionNota(descripcion:string,id:string)
  {
    return this.http.put(`${environment.apiNotaURL}/updatedescription?contenido=${descripcion}&noteId=${id}`,{descripcion,id});

  }

  eliminarNota(id:number)
  {
    return this.http.delete(`${environment.apiNotaURL}/deletenote?noteId=${id}`);
  }


}

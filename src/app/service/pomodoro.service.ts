import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {Pomodoro} from "../models/pomodoro.model";

@Injectable({
  providedIn: 'root'
})
export class PomodoroService {

  constructor(private http:HttpClient)
  { }

  getPomodoroID(id:string):Observable<Pomodoro>
  {
    return this.http.get<Pomodoro>(`${environment.pomodoroURL}/getPomodoro?id=${id}`);
  }
  createPomodoro(duracion:string,nombre:string,id_nota:string)
  {

    return this.http.post(`${environment.pomodoroURL}/pomodoros?duracion=${duracion}&nombre=${nombre}&notaId=${id_nota}`,{duracion,nombre,id_nota});
  }

  updateDuracionPomodoro(duracion:number,id_pomo:string)
  {
    return this.http.put(`${environment.apiNotaURL}/updateDuracion?duracion=${duracion}&pomo_id=${id_pomo}`,{duracion,id_pomo});

  }
}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {ITask, ITaskOption} from "../interface/task.interface";
import {environment} from "../../environments/environment";
import {catchError} from "rxjs/operators";

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  constructor(private http:HttpClient) { }

  getTasks():Observable<ITask[]>
  {
    return this.http.get<ITask[]>(`${environment.apiUrl}notaUser?usuarioId=17`).pipe(catchError(e=>{return throwError(e)}));

  }
  /*postTask(task:ITask):Observable<ITask>
  {

  }
  getTypeOptions():Array<ITaskOption>
  {
    return
    [
      {type:'done'},
      {type:'todo'},
      {type:'pending'}
    ];
  }*/

}

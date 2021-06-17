import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http:HttpClient) { }

  login(pass:string,name:string)
  {
    return this.http.get(`${environment.apiUsuarioUrl}/LoginUser?contrasena=${pass}&nombre=${name}`)
    ///LoginUser?contrasena=${pass}&nombre=${name}
  }
}

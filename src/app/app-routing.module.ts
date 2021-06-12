import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DashboardComponent} from "./component/dashboard/dashboard.component";
import {UsuarioGestorComponent} from "./component/usuario-gestor/usuario-gestor.component";
import {UsuariodetailComponent} from "./component/usuariodetail/usuariodetail.component";

const routes: Routes = [{path:'',redirectTo:'/dashboard',pathMatch:'full'},
  { path:'dashboard',component:DashboardComponent},
  {path:'usuarios',component:UsuarioGestorComponent},
  {path:'detalle/:id',component:UsuariodetailComponent} ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

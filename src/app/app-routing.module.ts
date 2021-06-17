

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import {CreateUsuarioComponent} from "./components/create-usuario/create-usuario.component";
import {NotasComponent} from "./components/notas/notas.component";
import {CreatenotaComponent} from "./components/createnota/createnota.component";

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {path:'create',component:CreateUsuarioComponent},
  {path:'notes',component:NotasComponent},
  {path:'createnota',component:CreatenotaComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

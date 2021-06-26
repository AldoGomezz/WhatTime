

import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import {CreateUsuarioComponent} from "./components/create-usuario/create-usuario.component";
import {NotasComponent} from "./components/notas/notas.component";
import {CreatenotaComponent} from "./components/createnota/createnota.component";
import {NavbarComponent} from "./components/navbar/navbar.component";
import {FirstnavbarComponent} from "./components/firstnavbar/firstnavbar.component";

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {path:'create',component:CreateUsuarioComponent},
  {path:'notes',component:NotasComponent},
  {path:'createnota',component:CreatenotaComponent},
  {path:'navbar',component:NavbarComponent},
  {path:'firstnavbar',component:FirstnavbarComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

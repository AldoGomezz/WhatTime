import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {HomeComponent} from "./components/home/home.component";
import {AddComponent} from "./components/task/add/add.component";
import {ListComponent} from "./components/task/list/list.component";

const routes: Routes = [
  {path:'home',component:HomeComponent},{path:'usuarios',component:AddComponent},{path:'list',component:ListComponent}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

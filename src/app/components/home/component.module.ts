import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {HomeComponent} from "./home.component";
import {ChartsModule} from "ng2-charts";
import {ListComponent} from "../task/list/list.component";
import {MaterialModule} from "../../material/material.module";
import {AddComponent} from "../task/add/add.component";



@NgModule({
  declarations: [HomeComponent,ListComponent],
  imports: [
    CommonModule,
    ChartsModule,
    MaterialModule
  ],
  exports: [HomeComponent, ChartsModule, ListComponent,MaterialModule]
})
export class ComponentModule { }

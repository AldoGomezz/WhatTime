import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatListModule} from '@angular/material/list';
import {MatTabsModule} from '@angular/material/tabs';

@NgModule({
  declarations: [],
  imports: [
    CommonModule,MatListModule,MatTabsModule
  ],
  exports: [
    CommonModule,MatListModule,MatTabsModule
  ]
})
export class MaterialModule { }

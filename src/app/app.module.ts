import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {DashboardComponent} from "./component/dashboard/dashboard.component";
import {MessageComponent} from "./component/message/message.component";
import {UsuariodetailComponent} from "./component/usuariodetail/usuariodetail.component";
import {UsuarioGestorComponent} from "./component/usuario-gestor/usuario-gestor.component";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {HttpClientInMemoryWebApiModule} from "angular-in-memory-web-api";
import {InMemoryDataService} from "./services/in-memory-data.service";


@NgModule({
  declarations: [
    AppComponent,
    DashboardComponent,
    MessageComponent,
    UsuariodetailComponent,
    UsuarioGestorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false })

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

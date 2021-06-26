import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { MaterialModule } from '../material/material.module';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InfoDialogComponent } from './info-dialog/info-dialog.component';
import { NgxStripeModule} from 'ngx-stripe';
import { CreateUsuarioComponent } from './create-usuario/create-usuario.component';
import { NotasComponent } from './notas/notas.component';
import { CreatenotaComponent } from './createnota/createnota.component';
import { FirstnavbarComponent } from './firstnavbar/firstnavbar.component';
import { DetailUserComponent } from './detail-user/detail-user.component'
@NgModule({
  declarations: [
    LoginComponent,
    NavbarComponent,
    InfoDialogComponent,
    CreateUsuarioComponent,
    NotasComponent,
    CreatenotaComponent,
    FirstnavbarComponent,
    DetailUserComponent
  ],
  imports: [
    CommonModule,
    MaterialModule,
    ReactiveFormsModule,
    FormsModule,
    NgxStripeModule.forRoot('pk_test_51Ix2oaAfbfzmGRwRHQnJLshYLzZo2RcLiM84U4g823jlPeOJ1fvrt9T0winWXnbX68lntR7WYFeHg9Mb5YNB5fim004d1uxDUx')
  ],
    exports: [
        LoginComponent,
        MaterialModule,
        NavbarComponent,
        ReactiveFormsModule,
        FormsModule,
        CreateUsuarioComponent,
        FirstnavbarComponent
    ]
})
export class ComponentModule { }

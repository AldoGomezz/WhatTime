import { Component, OnInit } from '@angular/core';
import {CreatenotasService} from "../../service/createnotas.service";
import {FormControl, Validators} from "@angular/forms";

@Component({
  selector: 'app-notas',
  templateUrl: './notas.component.html',
  styleUrls: ['./notas.component.css']
})
export class NotasComponent implements OnInit {
  notas:any;
  constructor(private notaService:CreatenotasService) { }
  //typesOfShoes: string[] = ['Boots', 'Clogs', 'Loafers', 'Moccasins', 'Sneakers'];
  id_user=new FormControl('',[Validators.required])
  ngOnInit(): void
  {

  }

  getNotas():void
  {
    this.notaService.getNotas().subscribe(notas=>this.notas=notas);
  }
  getNotasByID():void{
    this.notaService.getNotasByID('id_user').subscribe((result:any)=>{this.notas=result.data})
  }
}

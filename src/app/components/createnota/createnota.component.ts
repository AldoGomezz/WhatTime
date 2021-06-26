import { Component, OnInit } from '@angular/core';
import {CreatenotasService} from "../../service/createnotas.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Nota} from "../../models/nota.model";
import {LoginService} from "../../service/login.service";

@Component({
  selector: 'app-createnota',
  templateUrl: './createnota.component.html',
  styleUrls: ['./createnota.component.css']
})
export class CreatenotaComponent implements OnInit {
  public notaForm:FormGroup;
  public nota=new Nota();
  constructor(private notaService:CreatenotasService,private fb:FormBuilder, private loginService:LoginService) { }
  public data:any;

  range = new FormGroup({
    start: new FormControl(),
    end: new FormControl()
  });


  ngOnInit(): void
  {
    this.initForm()
    //this.loginService.disparadorUserData.subscribe(data=>{console.log('Recibiendo data...',data),this.data==data});
  }
  initForm()
  {
    this.notaForm=this.fb.group({
      name_nota:['',Validators.required],
      importancia:['',Validators.required],
      contenido:['',Validators.required],
      fecha_creacion:['',Validators.required],
      fecha_culminacion:['',Validators.required],
      id:['',Validators.required]
    })

  }

  setNota()
  {
    this.nota.name_nota=this.notaForm.get('name_nota')?.value,
      this.nota.importancia=this.notaForm.get('importancia')?.value,
      this.nota.contenido=this.notaForm.get('contenido')?.value,
      //this.nota.fecha_creacion=this.notaForm.get('fecha_creacion')?.value,
      this.nota.fecha_creacion=this.range.get("start")?.value,
      //this.nota.fecha_culminacion=this.notaForm.get('fecha_culminacion')?.value
      this.nota.fecha_culminacion=this.range.get("end")?.value

  }


  createNota()
  {
    this.setNota()
    this.notaService.createNota(this.nota,this.notaForm.get('id')?.value).subscribe((result:any)=>{console.log(result.data)})
  }
}

import { Component, OnInit, OnDestroy, Input, EventEmitter, Output } from '@angular/core';
import { Observable, Subscription, interval } from 'rxjs';
import {MatDialog} from "@angular/material/dialog";
import {InfoDialogComponent} from "../info-dialog/info-dialog.component";
import {CreatenotasService} from "../../service/createnotas.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PomodoroService} from "../../service/pomodoro.service";
import {Pomodoro} from "../../models/pomodoro.model";

@Component({
  selector: 'app-timer',
  templateUrl: './timer.component.html',
  styleUrls: ['./timer.component.css']
})
export class TimerComponent implements OnInit, OnDestroy {

  @Input() m: number;
  @Input() s: number;
  // tslint:disable-next-line:no-output-on-prefix
  @Output() onComplete: EventEmitter<any> = new EventEmitter();
  public pomo=new Pomodoro();
  //notas:Array<any>=[];
  notas:any;
  public errormessage:any;
  public datapomo:any;
  duracion:any;

  public pomoID:FormGroup;

  running = false;
  value = [0,10, 0];
  subscription: Subscription;

  constructor(public dialog: MatDialog,private notaService:CreatenotasService,private fb:FormBuilder, private pomoService:PomodoroService) { }

  ngOnInit(): void {
    this.pomoID=this.fb.group({
      nombre_pomodoro:['',Validators.required],
      duracion:['',Validators.required],
      id_nota:['',Validators.required]
    })

    if (this.m) {
      this.value[0] = this.m;
    } else {
      this.m = 25;
    }
    if (this.s) {
      this.value[1] = this.s;
    } else {
      this.s = 0;
    }
  }

  ngOnDestroy(): void {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  startTimer(): void {
    if (!this.running) {
      // Set running to true.
      this.running = true;
      // Check if the timer is comeplete and if so reset it before starting.
      if (this.value[0] === 0 && this.value[1] === 0) {
        this.resetTimer();
      }
      // Create Rxjs interval to call a update method every second.
      this.subscription = interval(1000).subscribe(x => this.updateTimer());
    }
  }

  stopTimer(): void {
    if (this.running) {
      // Set running to false.
      this.running = false;
      // If we want to stop the timer then unsubscribe from the interval.
      if (this.subscription) {
        this.subscription.unsubscribe();
      }
    }
  }

  resetTimer(): void {
    // Set the minutes and seconds back to their original values.
    this.stopTimer();
    this.value = [this.m, this.s];
  }

  updateTimer(): void {
    if (this.running) {
      // Check if the timer is comeplete and if so stop the timer and run onComplete().
      if (this.value[0] === 0 && this.value[1] === 0) {
        this.stopTimer();
        this.duracion-=1
        //this.actualizarDuracion(this.duracion)

        if(this.duracion==0)
        {
          this.actualizarStatusNota()
          const title=`Tarea Finalizada`
          const info = "Felicidades esta mejorando"
          this.openDialog(title, info)
        }else{
        // Make a sound/send an alert.
        const title=`Pomodo Numero ${this.duracion}`
        const info = "Felicidades esta mejorando"
        this.openDialog(title, info)}

        this.onComplete.emit();
      } else if (this.value[0] !== 0 && this.value[1] === 0) {
        this.value = [this.value[0] - 1, 59];
      } else if (this.value[1] !== 0) {
        this.value = [this.value[0], this.value[1] - 1];
      }
    }
  }

  openDialog(title: string, info: string): void {
    const dialogRef = this.dialog.open(InfoDialogComponent, {
      width: '350px',
      data: {title: title, info: info}
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }
  setPomodoro()
  {
    this.pomo.nombre_pomodoro=this.pomoID.get('nombre_pomodoro')?.value,
      this.pomo.duracion=this.pomoID.get('duracion')?.value

  }

  crearPomodoro()
  {
    this.setPomodoro()
    this.pomoService.createPomodoro(this.pomoID.get('duracion')?.value,this.pomoID.get('nombre_pomodoro')?.value,this.pomoID.get('id_nota')?.value).subscribe((result:any)=>{console.log(result.data), this.datapomo=result.data},error => {this.errormessage=error;
      const title="Fallo al Crear Pomodoro"
      const info = "Ingrese los datos correctamente"
      this.openDialog(title, info)})
  }

  getNotaID()
  {
    this.duracion=Number(this.pomoID.get('duracion')?.value)
    this.notaService.getNotasporsuID(this.pomoID.get('id_nota')?.value).subscribe((result:any)=>{this.notas=result.data},error => {this.errormessage=error;
      const title="Fallo al Obtener Nota"
      const info = "Ingrese los datos correctamente"
      this.openDialog(title, info)})
  }

  actualizarStatusNota()
  {
    this.notaService.updateStatus('INACTIVE',this.pomoID.get('id_nota')?.value).subscribe((result:any)=>{console.log(result)})
  }

  actualizarDuracion(duracion:number)
  {

    this.pomoService.updateDuracionPomodoro(duracion,this.datapomo.id).subscribe((result:any)=>{console.log(result)})

  }


}

import { Component, OnInit } from '@angular/core';
import {TaskService} from "../../../services/task.service";
import {ITask} from "../../../interface/task.interface";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  tasks:any;
  constructor(private taskService:TaskService) { }

  ngOnInit(): void
  {
    this.getNotas();
  }
  getNotas():void
  {
    this.taskService.getTasks().subscribe(tasks=>this.tasks=tasks);

  }
}

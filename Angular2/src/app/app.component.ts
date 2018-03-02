import { Component } from '@angular/core';
import { TaskService } from "./services/task.service";
import { NgForm } from '@angular/forms';
import { Task } from './models/task';
import {Tasks} from './task.interface'



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
 export class AppComponent{
  tasks;
  constructor(private taskService: TaskService ) {
    this.tasks = taskService.getTasks();
 }

submit(form : NgForm)
{
  console.log(form.value);
  this.taskService.addTask(form.value);
}
}
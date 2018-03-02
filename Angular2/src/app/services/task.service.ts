import { Injectable } from '@angular/core';
import { Http, Response, RequestOptions, RequestMethod, Headers } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import { Task } from "../models/task";
import 'rxjs/Rx'

@Injectable()
export class TaskService {
   constructor(private http: Http) {
   }
 
   getTasks(): Observable<Task[]> {
      return this.http.get("http://localhost:8080/BruceFoxTask/rest/task/all")
         .map((res: Response) => res.json())
         .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
   }

   addTask(Task){
      let headers = new Headers({ 'Content-Type': 'application/json' });
      let options = new RequestOptions({ headers: headers }); 
      let body = JSON.stringify(Task);
     console.log(body);
     return this.http.post("http://localhost:8080/BruceFoxTask/rest/task/add", body, options).map((res: Response) => res.json());
   }
}
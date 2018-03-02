import{BrowserModule} from '@angular/platform-browser'
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { TaskService } from "./services/task.service";
import { AppComponent } from './app.component';
import { DataTablesModule } from 'angular-datatables';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent
  ],
  exports: [DataTablesModule],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    DataTablesModule
  ],
  providers: [TaskService],
  bootstrap: [AppComponent]
})
export class AppModule { }

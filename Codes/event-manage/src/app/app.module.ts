import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http'
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { EmpComponent } from './emp/emp.component';
import { EmpOperationComponent } from './emp-operation/emp-operation.component';
import { EmpUpdateComponent } from './emp-update/emp-update.component';
import { EmpStoreComponent } from './emp-store/emp-store.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EmpComponent,
    EmpOperationComponent,
    EmpUpdateComponent,
    EmpStoreComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,HttpClientModule,FormsModule,ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

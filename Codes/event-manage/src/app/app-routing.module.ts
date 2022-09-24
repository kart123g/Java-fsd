import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Emp } from './emp';
import { EmpOperationComponent } from './emp-operation/emp-operation.component';
import { EmpStoreComponent } from './emp-store/emp-store.component';
import { EmpUpdateComponent } from './emp-update/emp-update.component';
import { EmpComponent } from './emp/emp.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  {path:"home",component:HomeComponent},
  {path:"home/emp",component:EmpComponent},
  {path:"home/emp/emp-store",component:EmpStoreComponent},
  {path:"emp-operation",component:EmpOperationComponent},
  {path:"emp-update",component:EmpUpdateComponent},
  {path:"login",component:LoginComponent},
  {path:"emp-store/emp",component:EmpComponent},
  {path:"emp/emp-update",component:EmpUpdateComponent},
  {path:"emp-operation/emp",component:EmpComponent},
  {path:"emp-operation/home",component:HomeComponent},
  {path:"emp-update/emp",component:EmpComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

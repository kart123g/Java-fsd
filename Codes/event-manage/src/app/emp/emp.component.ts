import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Emp } from '../emp';
import { EmpService } from '../emp.service';
import {FormGroup,FormControl} from '@angular/forms';

@Component({
  selector: 'app-emp',
  templateUrl: './emp.component.html',
  styleUrls: ['./emp.component.css']
})
export class EmpComponent implements OnInit {

  empRef= new FormGroup({
    id:new FormControl(),
    first_name:new FormControl(),
    last_name:new FormControl(),
    email:new FormControl()
  });

  employees:Array<Emp>=[]

  constructor(public es:EmpService,public router:Router) { }

  ngOnInit(): void {
    this.loadEmpDetails();
  }

  loadEmpDetails() {
    //this.ps.loadProductData();
    this.es.loadEmpData().subscribe({
      next:(data:any)=>this.employees=data,
      // next:(data:any)=>console.log(data),
      error:(error:any)=>console.log(error),
      complete:()=>console.log("Completed")
    })
  }

  storeEmp(){
    let emp = this.empRef.value;
    this.es.storeEmpData(emp).subscribe({
      next:(data:any)=>console.log(data),
      error:(error:any)=>console.log(error),
      complete:()=>this.loadEmpDetails()
    })
    this.empRef.reset();
  }

  viewDetails(emp:any){
    sessionStorage.setItem("empInfo",JSON.stringify(emp));
    this.router.navigate(["emp-operation"]);
  }

  storeData(emp:any){
    sessionStorage.setItem("empInfo",JSON.stringify(emp));
    this.router.navigate(["emp-store"]);
  }

}

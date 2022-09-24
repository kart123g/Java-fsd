import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl} from '@angular/forms'
import { Router } from '@angular/router';
import { Emp } from '../emp';
import { EmpService } from '../emp.service';

@Component({
  selector: 'app-emp-store',
  templateUrl: './emp-store.component.html',
  styleUrls: ['./emp-store.component.css']
})
export class EmpStoreComponent implements OnInit {

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

  ViewAll(){
    this.router.navigate(["emp-store/emp"]);
  }

}

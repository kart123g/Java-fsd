import { Component, OnInit } from '@angular/core';
import {FormGroup,FormControl} from '@angular/forms';
import { Route, Router } from '@angular/router';
import { Emp } from '../emp';
import { EmpService } from '../emp.service';

@Component({
  selector: 'app-emp-update',
  templateUrl: './emp-update.component.html',
  styleUrls: ['./emp-update.component.css']
})
export class EmpUpdateComponent implements OnInit {
  emp:any;

  msg:String = "";

  empRef= new FormGroup({
    id:new FormControl(),
    first_name:new FormControl(),
    last_name:new FormControl(),
    email:new FormControl()
  });

  employees:Array<Emp>=[]

  constructor(public es:EmpService,public router:Router) { }

  ngOnInit(): void {
    let obj = sessionStorage.getItem("empInfo");
    if(obj != null){
      this.emp = JSON.parse(obj);
    }
  }



  updateEmp(){
    let emp1 = this.empRef.value;
    this.emp.first_name = emp1.first_name;
    this.emp.last_name = emp1.last_name;
    this.emp.email = emp1.email;
    this.es.updateEmpData(this.emp.id,this.emp).subscribe({
      next:(data:any)=>console.log(data),
      error:(error:any)=>console.log(error),
      complete:()=>this.msg="Updated Successfully"
    })
    //this.productRef.reset();
  }
  
  ViewAll(){
    this.router.navigate(["emp-update/emp"]);
}


}

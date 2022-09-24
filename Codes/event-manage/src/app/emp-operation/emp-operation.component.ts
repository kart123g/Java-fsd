import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmpService } from '../emp.service';

@Component({
  selector: 'app-emp-operation',
  templateUrl: './emp-operation.component.html',
  styleUrls: ['./emp-operation.component.css']
})
export class EmpOperationComponent implements OnInit {
  emp:any;
  constructor(public router:Router,public es:EmpService) { }

  ngOnInit(): void {
    let obj = sessionStorage.getItem("empInfo");
    if(obj != null){
        this.emp = JSON.parse(obj);
    }
  }

  ViewAll(){
      this.router.navigate(["emp-operation/emp"]);
  }

  deleteEmp(id:any){
      this.es.delete(id).subscribe({
        next:(result:any)=>console.log(result),
        error:(error:any)=>console.log(error),
        complete:()=>console.log("completed")
      })
  }

  updateEmp(emp:any){
    sessionStorage.setItem("empInfo",JSON.stringify(emp));
    this.router.navigate(["emp/emp-update"]);
  }

}

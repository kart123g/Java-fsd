import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {FormGroup,FormControl} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(public router:Router) { }

  ngOnInit(): void {
  }
  
  msg:string="";

  loginRef = new FormGroup({
    user:new FormControl(),
    pass:new FormControl()
  })

  
  checkUser(){
    let login = this.loginRef.value;
    if(login.user == "raj@abc.com" && login.pass == "123"){
      console.log("Succes");
      sessionStorage.setItem("token",login.user); 
      this.router.navigate(["home"]);  //
    }
    else{
      this.msg = "Invalid username or password"
    }


 }


}

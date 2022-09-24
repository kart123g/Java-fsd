import { Component } from '@angular/core';

import { FormGroup,FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  toDisplay:boolean = true;
  toggleData(){
    this.toDisplay = !this.toDisplay;
  }
 
}

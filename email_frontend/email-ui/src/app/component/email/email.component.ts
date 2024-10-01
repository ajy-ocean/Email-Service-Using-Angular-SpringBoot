import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { EmailService } from '../../service/email.service';
import { response } from 'express';
import { error } from 'console';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css'] 
})
export class EmailComponent {
  data = {
    to: "",
    subject: "",
    message: "",
  };

  flag = false;

  constructor(private email : EmailService, private snack : MatSnackBar) {}

  ngOnInit(): void {}

  doSubmitForm() {
    console.log("Trying to submit form");    
    console.log("Data", this.data); 

    if(this.data.to=='' || this.data.subject=='' || this.data.message==''){
      this.snack.open("Fields Can Be Empty", "Ok");
      return 
    }

    this.flag = true;
    this.email.sendEmail(this.data).subscribe(
      response=>{
        console.log(response);
        this.flag = false;
        this.snack.open("Email Send", "Ok");
      },
      error=>{
        console.log(error);
        this.flag = false;
        this.snack.open("Something Went Wrong", "Ok");
      }
    )
  }
}

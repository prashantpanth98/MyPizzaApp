import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/authService.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private authServic:AuthService, private regSnackBar:MatSnackBar){}

  registrationForm =new FormGroup({
    "email":new FormControl('',[Validators.required,Validators.pattern("[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$")]),
    "password":new FormControl('',[Validators.required,Validators.pattern(/^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$/)]),
    "userName":new FormControl('', [Validators.required,Validators.minLength(4),Validators.pattern("[A-Za-z ]{1,22}[a-zA-Z]{1,22}")]),
    "phoneNo":new FormControl('', [Validators.required ,Validators.pattern(/^[789]\d{9,9}$/)]),
  });


  get email() { return this.registrationForm.get("email") }
  get password() { return this.registrationForm.get("password") }
  get userName() { return this.registrationForm.get("userName") }
  get phoneNo() { return this.registrationForm.get("phoneNo"); }

  resdata:any;
  onSubmit()
  {
    console.log(this.registrationForm.value);
    this.authServic.registerUserData(this.registrationForm.value).subscribe(response=>{
      this.resdata=response;
      localStorage.setItem("userName",this.resdata.userName);
      console.log()
      console.log(response);
      console.log("data added");
    },error=>{
      console.log("no data added");
    });

      this.showSnackBar();
      this.registrationForm.reset();
      console.log(this.registrationForm.value);
  }

  showSnackBar(){
    this.regSnackBar.open(this.registrationForm.value.userName+" Register Successfully", "Ok",{ duration:3000 });
  }

}

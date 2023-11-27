import { Component } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/authService.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { RouteService } from '../services/route.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  nameUser!:string;
  
  constructor(private loginUser:AuthService,private route:RouteService , private Snack:MatSnackBar){}

  userForm=new FormGroup({
    "email":new FormControl('',[Validators.required]),
    "password":new FormControl('',[Validators.required]),
  })

  get email() { return this.userForm.get("email"); }
  get password() { return this.userForm.get("password"); }

  respdata:any;
  onSubmit(){
    this.loginUser.loginUserData(this.userForm.value).subscribe(response=>{
      this.loginUser.loggedIn();
      console.log(response); // message + token

      this.respdata=response;
      console.log(this.respdata.token);
      
      localStorage.setItem("jwttoken", this.respdata.token);
      localStorage.setItem("email",this.respdata.email);
      //localStorage.setItem("nameUser",this.respdata.email)
      
      this.showSnackBar();
      this.route.navigateToMenu();  
    })
  }

  showSnackBar(){
    this.Snack.open(this.userForm.value.email+" Loggin Successfully", "Ok", {duration: 3000});
  }
   /* this.loginUser.userLogDetails={
        email:this.userForm.value.email!,
        password:this.userForm.value.password!
      };*/
}
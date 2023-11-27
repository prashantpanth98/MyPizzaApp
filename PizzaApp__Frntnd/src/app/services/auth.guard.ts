import { Injectable } from '@angular/core';
import { CanActivate, /*ActivatedRouteSnapshot,  RouterStateSnapshot, UrlTree*/ } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthService } from './authService.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

 //logInorNot:boolean=false;
 // usertoken:any=localStorage.setItem();

  constructor(private authServc:AuthService, private SnackBar:MatSnackBar) {}
  canActivate(){
    if(this.authServc.isLoggedIn==true){
      //this.openSnackBar();
      return true;
    }
    else{
      this.showSnackBar();
      return false;
    }
  }
  

  showSnackBar(){
    this.SnackBar.open("First Loggin User First!", "Ok", {duration: 1000});
  }
  openSnackBar(){
    this.SnackBar.open("User Loggin Successfully", "Ok", {duration: 1000});
  }
}

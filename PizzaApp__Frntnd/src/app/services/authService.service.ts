import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { User } from 'src/Models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService
{
  public userLogDetails!:User;
  base_url:string="http://localhost:8081/api/v1/";
  isLoggedIn:boolean=false;

  constructor(private httpClient:HttpClient) { }
 
  registerUserData(userData:any):Observable<any>{
    return this.httpClient.post(this.base_url+"register",userData)
  }

  loginUserData(logData:any):Observable<any>{
  //let httpHeaders =new HttpHeaders({ 'Authorization' : 'Bearer' + localStorage.getItem("jwtToken") });
  //let requestOption ={ headers: httpHeaders };
    return this.httpClient.post(this.base_url+"login",logData); // ,requestOption
  }


  loggedIn():boolean{
    this.isLoggedIn = true;
    return this.isLoggedIn;
  }

  isUserLoggedIn():any{
    return localStorage.getItem("jwtToken");
  }
}

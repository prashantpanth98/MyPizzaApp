import { Component, Input } from '@angular/core';
import { AuthService } from '../services/authService.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  @Input('uName') userName:any=localStorage.getItem("email");

  constructor(private authServc:AuthService){}

  loginValid():boolean{
    return this.authServc.isLoggedIn;
  }
}

import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouteService 
{
  constructor(private router:Router) { }

  navigateToRegister(){
    this.router.navigate([""]);
  }

  navigateToLogin(){
    this.router.navigate(["login"])
  }

  navigateToMenu() {
    this.router.navigate(["menu"]);
  }

  navigateToCart(){
    this.router.navigate(["cart"]);
  }

  navigateToOrder(){
    this.router.navigate(["order"]);
  }

}

import { Component } from '@angular/core';
import { pizzaMeal } from 'src/Models/pizzaMeal';
import { PizzaService } from '../services/pizzaService.service';
import { AuthService } from '../services/authService.service';
import { Route } from '@angular/router';
import { RouteService } from '../services/route.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  pizzaMeals: pizzaMeal[]=[];

  constructor(private pizServc:PizzaService,private authServc:AuthService, private routeServc:RouteService,private Snackbar:MatSnackBar) {}

  ngOnInit():void{
    this.pizzaMeals=this.pizServc.getAllPizzas();
  }

  arrLen:number=0;
  temp:number=0;
  addToCart(onePizza:any){
    this.pizServc.pizzasAddedinCart.push(onePizza);
    console.log(this.pizServc.pizzasAddedinCart);
    this.showSnackBar();
}

  goToCart(){
    this.authServc.isLoggedIn=true;
    this.routeServc.navigateToCart();
  }

  LogOut(){
    sessionStorage.clear();
    this.authServc.isLoggedIn=false;
    this.routeServc.navigateToRegister();
  }
  
  showSnackBar() {
    this.Snackbar.open("Order added Successfully to cart", "Ok",{
      duration: 1000
})}

}

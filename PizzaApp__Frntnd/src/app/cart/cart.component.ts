import { Component, OnInit } from '@angular/core';
import { PizzaService } from '../services/pizzaService.service';
import { pizzaMeal } from 'src/Models/pizzaMeal';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AuthService } from '../services/authService.service';
import { RouteService } from '../services/route.service';
import { User } from 'src/Models/user';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cartAllPizza:pizzaMeal[]=this.pizServc.pizzasAddedinCart;
  totalBill:number=0;
  isOrderPlaced:boolean = false;
  snackbar!:any;
  quantitye!:number;
  price!:number;
  userEmail:any;
  getRegUser!:User;
  reqUser:any;

  ngOnInit(){
    this.totalBill=0;
    this.pizServc.pizzasAddedinCart.forEach((piza:pizzaMeal)=>{
      this.totalBill=this.totalBill+ piza.pizzaPrice;
    });

    this.getTheUser();
    //console.log("USer outside "+this.reqUser); 
  }

  constructor(private pizServc:PizzaService, private authServc:AuthService, private routeServc:RouteService,private snackBar:MatSnackBar){}

  delete(piz:pizzaMeal){
    let index=this.cartAllPizza.findIndex(x=>x.pizzaId===piz.pizzaId);
    //if(index!==1){
      this.cartAllPizza.splice(index,1);
    //}
    console.log(piz);
    this.totalBill=this.totalBill-piz.pizzaPrice;
    this.openSnackBar();
  }

  order(){
   // console.log(this.reqUser);
    this.pizServc.getUserByEmail().subscribe(response=>{
      this.reqUser=response;
      this.reqUser.pizza=this.pizServc.pizzasAddedinCart;
      this.pizServc.updatePizzaCart(this.reqUser).subscribe(response=>{
       // console.log(response);
        console.log("User "+response.email);
        console.log("Ordered Pizza's:"+this.pizServc.pizzasAddedinCart.forEach((y:pizzaMeal)=>{y.pizzaId}));
        console.log("User Name: Prashant");
        this.isOrderPlaced= true;
        //console.log(this.reqUser);
        this.totalBillSnack();
        this.routeServc.navigateToOrder();
        this.pizServc.pizzasAddedinCart=[];
      });
    });
  }
  //+" : "+y.pizzaName +" : "+y.pizzaPrice
  
  getTheUser(){
    this.pizServc.getUserByEmail().subscribe(response=>{
      this.reqUser=response;
      //console.log("USer insdie "+this.reqUser); 
    });
    
  }

  openSnackBar() { this.snackBar.open("Delete Successfully", "Ok",{ duration: 1000}); }
  openSnack() { this.snackBar.open("Order Placed Successfully", "Ok",{ duration: 1000 })};
  totalBillSnack(){ this.snackBar.open("Your Total BILL : $"+this.totalBill,"OK",{ duration: 7000 }); }
}

  /*Quantity1(pizzaId:number,pizzaO:pizzaMeal){
    this.pizServc.pizzasAddedinCart.forEach((piza:pizzaMeal) => {
      if(pizzaId==piza.pizzaId){
        pizzaO.Quantity= pizzaO.Quantity+1;
        this.quantitye= pizzaO.Quantity;
        console.log(this.quantitye);
        pizzaO.totalAmount=pizzaO.pizzaPrice*this.quantitye;
      }
      this.ngOnInit();
    });
  }*/

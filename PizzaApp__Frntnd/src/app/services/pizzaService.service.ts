import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { pizzaMeal } from 'src/Models/pizzaMeal';
import { User } from 'src/Models/user';

@Injectable({
  providedIn: 'root'
})
export class PizzaService {

  userLogDetail!:User;
  baseurl:string="http://localhost:8083/api/v2/";
  pizzasAddedinCart: pizzaMeal[]=[];

  pizzaList:pizzaMeal[]=[];
  //userEmail1:any;

  constructor(private httpClient:HttpClient) { }
  
    /*ngOnInit(){
     this.userEmail1=localStorage.getItem("email");
    }*/
  
  getAllPizzas() {
    this.pizzaList = [
      { pizzaId: 1, pizzaName: 'Margherita Pizza', pizzaPrice: 20, imageUrl:"/assets/Margherita Pizza.jpeg", Quantity: 1, totalAmount: 0 },
      { pizzaId: 2, pizzaName: 'Mexican Pizza', pizzaPrice: 40, imageUrl:"/assets/Mexican Pizza.jpeg", Quantity: 1, totalAmount: 0},
      { pizzaId: 3, pizzaName: 'Paneer Pizza', pizzaPrice: 60, imageUrl:"/assets/Paneer Pizza.jpeg", Quantity: 1, totalAmount: 0 },
      { pizzaId: 4, pizzaName: 'Pepperoni Pizza', pizzaPrice: 80, imageUrl:"/assets/Pepperoni Pizza.jpeg", Quantity: 1, totalAmount: 0 },
      { pizzaId: 5, pizzaName: 'Veggie Pizza', pizzaPrice: 100, imageUrl:"/assets/Veggie Pizza.jpeg", Quantity: 1, totalAmount : 0 },
      { pizzaId: 5, pizzaName: 'American Pizza', pizzaPrice: 100, imageUrl:"/assets/American Pizza.jpeg", Quantity: 1, totalAmount: 0 }
    ]

    return this.pizzaList;
  }
  
  updatePizzaCart(userData:any):Observable<any>{
    let email:any=localStorage.getItem('email');

    let httpHeaders =new HttpHeaders({ 'Authorization':'Bearer '+localStorage.getItem("jwttoken") });

    let requestOption ={ headers: httpHeaders };
    //alert("order added");
    return this.httpClient.post(this.baseurl+"update",userData,requestOption);
   
  }

  getUserByEmail():Observable<any>{
    let email:any=localStorage.getItem('email');

    let httpHeader=new HttpHeaders({
      'Authorization':'Bearer '+localStorage.getItem('jwttoken')
    });
    let requestOptions={headers:httpHeader}
    return this.httpClient.get(this.baseurl+"user/"+email, requestOptions);
  }
}
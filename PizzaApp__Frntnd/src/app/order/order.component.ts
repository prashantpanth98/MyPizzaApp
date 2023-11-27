import { Component } from '@angular/core';

@Component({
  selector: 'app-order',
  template: ` <h2 id = "p1">Your order Placed Successfully!!</h2>
              <h2 id = "p2">Thanks for Ordering Pizzas from PizzaHut!!</h2>`,

  styles: ['#p1 { color:green; text-align: center; margin-top:100px }', '#p2{ color:green;text-align: center}']
})
export class OrderComponent {

}

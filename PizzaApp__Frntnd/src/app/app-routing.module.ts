import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MenuComponent } from './menu/menu.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = 
[
  { path:'menu',component:MenuComponent, canActivate:[AuthGuard]},
  { path:'', component:RegisterComponent},
  { path:'login', component:LoginComponent },
  { path: 'cart', component:CartComponent, canActivate:[AuthGuard]},
  { path: 'order', component:OrderComponent, canActivate:[AuthGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}

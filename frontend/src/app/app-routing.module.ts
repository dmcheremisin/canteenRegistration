import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {WeekComponent} from "./week/week.component";
import {ErrorComponent} from "./error/error.component";
import {LoginComponent} from "./login/login.component";
import {RouteGuardService} from "./service/route-guard.service";


const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'week', component: WeekComponent, canActivate: [RouteGuardService]},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import {Component, OnInit} from '@angular/core';
import {AuthService} from "../service/auth.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public username: string = null;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    if(this.authService.isUserLoggedIn())
      this.router.navigate(["week"]);
  }

  login() {
    this.authService.authenticate(this.username);
  }
}

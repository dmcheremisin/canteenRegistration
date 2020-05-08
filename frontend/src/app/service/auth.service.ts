import {Injectable} from '@angular/core';
import {Router} from "@angular/router";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private readonly username = "username";

  public usernameValue = new Subject<string>();

  constructor(private router: Router) { }

  authenticate(username: string) {
    this.usernameValue.next(username);
    window.localStorage.setItem(this.username, username);
    this.router.navigate(["week"]);
  }

  isUserLoggedIn() {
    return !!this.getUserName();
  }

  public getUserName() {
    return window.localStorage.getItem(this.username);
  }
}

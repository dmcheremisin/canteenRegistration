import {Component, OnInit} from '@angular/core';
import {AuthService} from "../service/auth.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public username: string = null;

  constructor(private authService: AuthService) {
    this.authService.usernameValue.asObservable()
      .subscribe(value => this.username = value);
  }

  ngOnInit(): void {
    this.username = this.authService.getUserName();
  }

}

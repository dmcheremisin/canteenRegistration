import {Component, OnInit} from '@angular/core';
import {WeekService} from "../service/week.service";
import {Week} from "../model/week";

@Component({
  selector: 'app-week',
  templateUrl: './week.component.html',
  styleUrls: ['./week.component.css']
})
export class WeekComponent implements OnInit {

  public week: Week;

  constructor(private weekService: WeekService) {
  }

  ngOnInit(): void {
    this.weekService.selectedWeekId.asObservable()
      .subscribe(value => {
        this.weekService.getWeekById(value).subscribe(result => {
          this.week = result;
        });
      });
  }

}

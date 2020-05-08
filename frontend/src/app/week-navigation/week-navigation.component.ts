import {Component, OnInit} from '@angular/core';
import {WeekService} from "../service/week.service";
import {Week} from "../model/week";

@Component({
  selector: 'app-week-navigation',
  templateUrl: './week-navigation.component.html',
  styleUrls: ['./week-navigation.component.css']
})
export class WeekNavigationComponent implements OnInit {

  public weeks: Week[];
  public selectedWeekId: number;

  constructor(private weekService: WeekService) {
  }

  ngOnInit(): void {
    this.weekService.getNavigationWeeks()
      .subscribe(result => {
        this.weeks = result;
        this.selectedWeekId = this.weeks[0].id;
        this.weekService.selectedWeekId.next(this.selectedWeekId);
      });
  }

  changeSelectedWeek(weekId: number) {
    this.selectedWeekId = weekId;
    this.weekService.selectedWeekId.next(this.selectedWeekId);
  }
}

import {Component, Input, OnInit} from '@angular/core';
import {Day} from "../model/day";
import {DayService} from "../service/day.service";

@Component({
  selector: 'app-day',
  templateUrl: './day.component.html',
  styleUrls: ['./day.component.css']
})
export class DayComponent implements OnInit {

  @Input()
  public day: Day;

  public today: Date = new Date();

  constructor(private dayService: DayService) {
  }

  ngOnInit(): void {
  }

  reloadDay($event: any) {
    this.dayService.getDayById(this.day.id).subscribe(
      response => {
        this.day = response;
        console.log(new Date(this.day.date));
      }
    )
  }

  checkDate(date: Date): boolean {
    let checkedDate = new Date(date);
    return this.isToday(checkedDate) || checkedDate.getTime() > this.today.getTime();
  }

  isToday(date: Date) {
    return date.getDate() == this.today.getDate() &&
      date.getMonth() == this.today.getMonth() &&
      date.getFullYear() == this.today.getFullYear()
  }
}

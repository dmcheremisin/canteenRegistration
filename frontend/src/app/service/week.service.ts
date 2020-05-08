import {Injectable} from '@angular/core';
import {Week} from "../model/week";
import {HttpClient} from "@angular/common/http";
import {API_URL} from "../util/app.constants";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WeekService {

  private weekPath: string = "week";

  public selectedWeekId = new Subject<number>();

  constructor(private http: HttpClient) {
  }

  getWeekById(id: number) {
    let path = `${API_URL}/${this.weekPath}/${id}`;
    return this.http.get<Week>(path);
  }

  getNavigationWeeks() {
    let path = `${API_URL}/${this.weekPath}/navigation`;
    return this.http.get<Week[]>(path);
  }


}

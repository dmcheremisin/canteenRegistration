import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {API_URL} from "../util/app.constants";
import {Day} from "../model/day";

@Injectable({
  providedIn: 'root'
})
export class DayService {

  private dayPath: string = "day";

  constructor(private http: HttpClient) {
  }

  public getDayById(id: number) {
    let path = `${API_URL}/${this.dayPath}/${id}`;
    return this.http.get<Day>(path);
  }

}

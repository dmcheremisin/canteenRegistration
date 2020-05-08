import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {API_URL} from "../util/app.constants";
import {ReserveSlot} from "../model/reserveSlot";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  private reservationPath: string = "reservation";

  constructor(private http: HttpClient) {
  }

  public reserveSlot(reservation: ReserveSlot) {
    return this.http.post(`${API_URL}/${this.reservationPath}`, reservation);
  }

}

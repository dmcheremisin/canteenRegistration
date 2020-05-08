import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Slot} from "../model/slot";
import {AuthService} from "../service/auth.service";
import {ReservationService} from "../service/reservation.service";
import {ReserveSlot} from "../model/reserveSlot";

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit {

  @Input()
  public slot: Slot;

  @Output()
  onReservation = new EventEmitter();

  public menuId: number = 1;

  constructor(private authService: AuthService, private reservationService: ReservationService) {
  }

  ngOnInit(): void {
  }

  submit() {
    let reserveSlot = new ReserveSlot(this.authService.getUserName(), this.menuId, this.slot.id);
    this.reservationService.reserveSlot(reserveSlot)
      .subscribe(
        response => this.onReservation.emit(response)
      );
  }

}

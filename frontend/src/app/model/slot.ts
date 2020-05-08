import {Reservation} from "./reservation";
import {SlotTemplate} from "./slotTemplate";

export class Slot {

  public constructor(
    public id: number,
    public slotTemplate: SlotTemplate,
    public reserved: number,
    public reservations: Reservation[]
  ) {
  }

}

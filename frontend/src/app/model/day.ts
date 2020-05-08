import {Slot} from "./slot";

export class Day {

  public constructor(
    public id: number,
    public name: string,
    public date: Date,
    public slots: Slot[]
  ) {
  }

}

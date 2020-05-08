import {Day} from "./day";

export class Week {

  public constructor(
    public id: number,
    public month: string,
    public start: Date,
    public end: Date,
    public days: Day[]
  ) {
  }

}

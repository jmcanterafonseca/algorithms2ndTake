export class Parser {
  constructor() {

  }

  public parse(i: string): string[] {
    if (typeof i !== "string") {
      throw new Error ("This is not a string");
    }
    return i.split(":");
  }

  public cut(i: string, numChars: number): string {
    if (typeof i !== "string") {
      throw new Error ("This is not a string");
    }

    if (numChars > i.length) {
      throw new Error ("Too many chars");
    }

    return i.substring(0, numChars);
  }
}

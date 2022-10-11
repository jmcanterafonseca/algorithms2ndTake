import { Parser } from '../src/parser';

describe("Test Suite 1", () => {
  const parser = new Parser();

  test("Must be 2 strings", () => {
    const str: string = "a:b";

    const result = parser.parse(str);

    expect(result.length).toBe(2);
  });

  test ("Must throw an error", () => {
    expect(() => parser.cut("", 1)).toThrow(Error);
  });

  test ("Must return empty string", () => {
    expect(parser.cut("", 0)).toBe("");
  });

  test ("Must return string cut", () => {
    expect(parser.cut("he", 1)).toBe("h");
  });
});

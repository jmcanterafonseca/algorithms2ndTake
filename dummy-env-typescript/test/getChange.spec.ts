import { getChange } from '../src/getChange';
describe("Test Suite Get Change", () => {
  test("test 1", () => {
    const price = 0.99;
    const money = 5;

    const result = getChange(money, price);

    expect(result).toStrictEqual([1, 0, 0, 0, 0, 4]);
  });

  test("test 2", () => {
    const price = 0.01;
    const money = 5;

    const result = getChange(money, price);

    expect(result).toStrictEqual([4, 0, 2, 1, 1, 4]);
  });
  
});

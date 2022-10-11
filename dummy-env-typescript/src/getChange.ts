export function getChange(input: number, price: number): number[] {
  if (typeof input !== "number" || typeof price !== "number") {
    throw new Error("It must be numbers");
  }

  if (input < price) {
    throw new Error("Not enough funds to pay");
  }

  // We need this to deal with floating point using just two decimals
  const difference = Math.round((input - price) * 100) / 100;

  // Number of bills returned
  const billNumber = Math.trunc(difference);
  // Remaining quantity with precision of cents
  const remainingQuantity = Math.round((difference - billNumber) * 100) / 100;

  // Quantities in cents
  const quantities = [50, 25, 10, 5, 1];

  // Cents 
  const totalCents = remainingQuantity * 100;
  let remainingCents = totalCents;

  const result: number[] = [];
  let index = quantities.length  - 1;

  for (const quantity of quantities) {
    // Number of coins needed integer division 
    const numCoins = Math.floor(remainingCents / quantity);

    result[index--] = numCoins;

    remainingCents -= numCoins * quantity;
  }

  result.push(billNumber);

  return result;
}


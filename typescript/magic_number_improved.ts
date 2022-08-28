// This algorithm also works with duplicated values

const arr: number[] = [-3, -2, -1, 3];
const arr2: number[] = [0];
const arr3: number[] = [-3, -2, 3, 3];
const arr4: number[] = [-10, -5, 2, 2, 2, 3, 4, 5, 9, 12, 13];

function magicIndex(array: number[]): number {
    if (!Array.isArray(array) || array.length === 0) {
        return -1;
    }

    return getMagicIndex(array, 0, array.length - 1);
}

function getMagicIndex(array: number[], start: number, end: number): number {
    if (end < start) {
        return -1;
    }

    const middleIndex = end - start / 2;
    const middleValue = array[middleIndex];

    if (middleIndex === middleValue) {
        return middleIndex;
    }

    // Look up through the left
    const leftSearch = getMagicIndex(array, start, Math.min(middleValue, middleIndex - 1));
    if (leftSearch >= 0) {
        return leftSearch;
    }

    // Look up through the right
    return getMagicIndex(array, Math.max(middleIndex + 1, middleValue), end);
}

console.log(magicIndex(arr4));
console.log(magicIndex(arr3));
console.log(magicIndex(arr2));
console.log(magicIndex(arr));

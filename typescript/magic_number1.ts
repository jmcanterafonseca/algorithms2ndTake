const arr: number[] = [-3, -2, -1, 3];
const arr2: number[] = [-1];
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

    const middle = end - start / 2;

    if (array[middle] === middle) {
        return middle;
    }

    if (array[middle] < middle) {
        return getMagicIndex(array, middle + 1, end);
    }

    return getMagicIndex(array, start, middle - 1);
}

const result = magicIndex(arr4);

console.log(result);

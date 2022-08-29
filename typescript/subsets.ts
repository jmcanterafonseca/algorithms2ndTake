// Input set
const set: number[] = [1, 2, 3];

function generateSets(set: Array<number>): Array<number>[] {
    if (set.length === 0) {
        // Empty set
        return [[]];
    }

    // Pivot element
    const pivot = set[0];
    const subSets = generateSets(set.slice(1));

    const result: Array<number>[] = [];

    for (const subSet of subSets) {
        // Add to the output list of subSets
        const aux = new Array<number>();
        const extendedSubset = aux.concat(subSet);
        extendedSubset.push(pivot);
    
        // Now a new subset with the pivot is on the set of sets
        result.push(extendedSubset);
        result.push(subSet);
    }

    return result;
}

console.log(generateSets(set));

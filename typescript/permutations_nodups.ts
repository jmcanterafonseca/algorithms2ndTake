/**
 * Calculates all the possible permutations of a string that
 * does not contain duplicate chars
 */

function permutations(str: string): string[] {
    if (str.length === 0) {
        return [];
    }

    if (str.length === 1) {
        return [str];
    }

    const result: string[] = [];
    for (let i = 0; i <  str.length; i++) {
        const char = str.charAt(i);

        let subString = "";
        for (let j = 0; j < i; j++) {
            subString += str.charAt(j);
        }

        for (let j = i+ 1; j < str.length; j++) {
            subString += str.charAt(j);
        }

        const permList = permutations(subString);

        for (const perm of permList) {
            result.push(char + perm);
        }
    }

    return result;
}

console.log(permutations("abcd"));

/*
a
ab: ab ba 

abc: abc acb bac bca cab cba 
*/

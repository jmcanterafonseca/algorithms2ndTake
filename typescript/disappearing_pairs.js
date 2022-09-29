function solution(S) {
    if (typeof S !== "string") {
        throw new Error("It must be a string");
    }

    // write your code in JavaScript (Node.js 8.9.4)
    let strBuffer = "";

    for (let j = 0; j < S.length; j++) {
        const chr = S.charAt(j);

        let prevChr = '';
        if (strBuffer.length > 0) {
            prevChr = strBuffer.charAt(strBuffer.length - 1);
        }

        if (prevChr === chr) {
            // Removing the last char on the buffer
            strBuffer = strBuffer.substr(0, strBuffer.length - 1);
        }
        else {
            strBuffer += chr;
        }
    }

    return strBuffer;
}

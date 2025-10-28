// Last updated: 10/27/2025, 9:32:39 PM
/**
 * @param {Array<number>} arr
 * @param {number} startIndex
 * @yields {number}
 */
var cycleGenerator = function* (arr, startIndex) {
    while (true) {
        const jump = yield arr.at(startIndex  % arr.length);
        startIndex += jump;
    }

};

/**
 *  const gen = cycleGenerator([1,2,3,4,5], 0);
 *  gen.next().value  // 1
 *  gen.next(1).value // 2
 *  gen.next(2).value // 4
 *  gen.next(6).value // 5

 [1,2,3,4,5]
 [0,1,2,3,4]

 gen.next() -> 0 = 1
 gen.next(1) -> arr[1] = 2
 gen.next(2) -> arr[3] = 4
 gen.next(6) -> arr[9] = arr[9 - 5] = arr[4] = 5
 */
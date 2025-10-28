// Last updated: 10/27/2025, 9:32:34 PM
/**
 * @param {number} n
 * @yields {number}
 */
function* factorial(n) {
    if (n === 0) {
        yield 1;
    }

    let fact = 1;
    for (let i = 1 ; i <= n ; i++) {
        fact *= i;
        yield fact;
    }
};

/**
 * const gen = factorial(2);
 * gen.next().value; // 1
 * gen.next().value; // 2
 */
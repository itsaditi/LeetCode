// Last updated: 8/14/2025, 5:43:05 AM
/**
 * @return {Generator<number>}
 */
var fibGenerator = function*() {
    let a = 0;
    let b = 1;

    yield a;
    yield b;

    while (true) {
        let c = a + b;
        yield c;

        a = b;
        b = c;
    }
};

/**
 * const gen = fibGenerator();
 * gen.next().value; // 0
 * gen.next().value; // 1
 */
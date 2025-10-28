// Last updated: 10/27/2025, 9:32:41 PM
/**
 * @param {Array} arr
 * @return {Generator}
 */
var inorderTraversal = function*(arr) {

    for (let elem of arr) {
        if (Array.isArray(elem)) {
            yield* inorderTraversal(elem);
        } else {
            yield elem;
        }
    }
};

/**
 * const gen = inorderTraversal([1, [2, 3]]);
 * gen.next().value; // 1
 * gen.next().value; // 2
 * gen.next().value; // 3
 */
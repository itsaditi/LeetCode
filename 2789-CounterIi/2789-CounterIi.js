// Last updated: 10/27/2025, 9:32:41 PM
/**
 * @param {integer} init
 * @return { increment: Function, decrement: Function, reset: Function }
 */
var createCounter = function(init) {
    let initialVal = init;
    let updatedVal = init;

    function increment() {
        return ++updatedVal;
    }

    function reset() {
        updatedVal = initialVal;
        return updatedVal;
    }

    function decrement() {
        return --updatedVal;
    }

    return {
        increment,
        reset,
        decrement
    }
};

/**
 * const counter = createCounter(5)
 * counter.increment(); // 6
 * counter.reset(); // 5
 * counter.decrement(); // 4
 */

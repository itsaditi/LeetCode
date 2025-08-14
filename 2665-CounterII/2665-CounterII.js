// Last updated: 8/14/2025, 5:55:43 AM
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

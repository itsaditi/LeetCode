// Last updated: 8/4/2025, 4:50:15 PM
/**
 * @param {Function} fn
 * @param {number} delay
 * @param {number} period
 * @return {number} id
 */

let intervalIdCounter = 0;
const intervalMap = new Map();

function customInterval1(fn, delay, period){
    let count = 0;
    let customId = intervalIdCounter++;

    function dfs() {
        const timerId = setTimeout(() => {
            fn();
            dfs();
        }, delay + period * count);
        count ++;
        intervalMap.set(customId, timerId);
    }

    dfs();

    return customId;    
}

/**
 * @param {number} id
 * @return {void}
 */
function customClearInterval1(id) {
    const timerId = intervalMap.get(id);
    clearTimeout(timerId);
    intervalMap.delete(id);
}

// Using Self Invoking Funtion

const CustomInterval = (() => {
    let intervalIdCounter = 0;
    const intervalMap = new Map();

    function setCustomInterval(fn, delay, period) {
        let count = 0;
        let customId = intervalIdCounter++;

        function dfs() {
            const timerId = setTimeout(() => {
                fn();
                dfs();
            }, delay + period * count);
            count++;
            intervalMap.set(customId, timerId);
        }

        dfs();
        return customId;
    }

    function clearCustomInterval(id) {
        const timerId = intervalMap.get(id);
        clearTimeout(timerId);
        intervalMap.delete(id);
    }

    return {
        setCustomInterval,
        clearCustomInterval
    };

})();

function customInterval(fn, delay, period) {
    return CustomInterval.setCustomInterval(fn, delay, period);
}

function customClearInterval(id) {
    CustomInterval.clearCustomInterval(id);
}
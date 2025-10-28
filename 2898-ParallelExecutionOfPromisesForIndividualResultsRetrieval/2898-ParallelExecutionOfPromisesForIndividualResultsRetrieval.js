// Last updated: 10/27/2025, 9:32:37 PM
/**
 * @param {Array<Function>} functions
 * @return {Promise<Array>}
 */
var promiseAllSettled = function(functions) {

    return new Promise((resolve, reject) => {
        const res = new Array(functions.length).fill(null);
        let settledCounter = 0;

        functions.forEach((func, index) => {
            func().then((response) => {
                res[index] = ({status: "fulfilled", value: response});
            }).catch((err) => {
                res[index] = ({status: "rejected", reason: err});
            }).finally(() => {
                settledCounter++;

                if(settledCounter === functions.length) {
                    resolve(res);
                }
            });
        })
    });

};


/**
 * const functions = [
 *    () => new Promise(resolve => setTimeout(() => resolve(15), 100))
 * ]
 * const time = performance.now()
 *
 * const promise = promiseAllSettled(functions);
 *              
 * promise.then(res => {
 *     const out = {t: Math.floor(performance.now() - time), values: res}
 *     console.log(out) // {"t":100,"values":[{"status":"fulfilled","value":15}]}
 * })
 */
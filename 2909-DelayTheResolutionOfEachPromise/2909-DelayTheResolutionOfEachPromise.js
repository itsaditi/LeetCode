// Last updated: 8/4/2025, 4:50:14 PM
/**
 * @param {Array<Function>} functions
 * @param {number} ms
 * @return {Array<Function>}
 */
var delayAll = function(functions, ms) {
    const newFunctions = [];

    functions.forEach((func) => {
        const newFunctionWithDelayedPromise = () => {
            return new Promise((resolve, reject) => {
                setTimeout(async () => {
                    try {
                        const res = await func();
                        resolve(res);
                    } catch(error) {
                        console.log(error);
                        reject(error);
                    }
                }, ms);
            });
        }
        newFunctions.push(newFunctionWithDelayedPromise);
    });

    return newFunctions;
};


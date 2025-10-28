// Last updated: 10/27/2025, 9:32:35 PM
/**
 * @param {Function} fn
 * @param {Array} args
 * @return {Function}
 */
var partial2 = function(fn, args) {
    
    return function(...restArgs) {

        let replaced = 0;

        for (let i = 0 ; i < args.length ; i++) {
            if (args[i] === "_") {
                args[i] = restArgs.shift();
            }
        }

        while (restArgs.length > 0) {
            args.push(restArgs.shift());
        }

        console.log(args, restArgs, replaced);
        return fn(...args);
    }
    
};

var partial = function(fn, args) {
    return function(...restArgs) {
        const replacedArgs = args.map(arg => arg === '_' ? restArgs.shift() : arg);
        return fn(...replacedArgs, ...restArgs);
    }
}
// Last updated: 8/4/2025, 11:14:08 PM
/**
 * @param {Object|Array} obj
 * @return {Object|Array}
 */
var undefinedToNull = function(obj) {
    for (const key in obj) {
        if (Array.isArray(obj[key]) || typeof obj[key] === 'object') {
            undefinedToNull(obj[key]);
        } else {
            if (obj[key] === undefined) {
                obj[key] = null;
            }
        }
    }

    return obj;
};

/**
 * undefinedToNull({"a": undefined, "b": 3}) // {"a": null, "b": 3}
 * undefinedToNull([undefined, undefined]) // [null, null] 
 */
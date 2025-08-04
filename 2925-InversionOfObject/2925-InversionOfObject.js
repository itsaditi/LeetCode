// Last updated: 8/4/2025, 4:50:13 PM
/**
 * @param {Object|Array} obj
 * @return {Object}
 */
var invertObject = function(obj) {
    

    const newObj = {};

    for (const key in obj) {
        const val = obj[key];

        if (val in newObj) {
            if (Array.isArray(newObj[val])) {
                newObj[val].push(key);
            } else {
                const arr = [];
                arr.push(newObj[val]);
                arr.push(key);
                newObj[val] = arr;
            }
        } else {
            newObj[val] = key;
        }
        
    }

    return newObj;

};
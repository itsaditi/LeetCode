// Last updated: 8/4/2025, 10:27:18 PM
/**
 * @param {Array} keysArr
 * @param {Array} valuesArr
 * @return {Object}
 */
var createObject = function(keysArr, valuesArr) {
    const newObj = {}


    for(let i = 0 ; i < keysArr.length ; i++) {
        const key = new String(keysArr[i]);
        const val = valuesArr[i];
        if (key in newObj) {
            continue;
        }

        newObj[key] = val;
    }

    return newObj;

};
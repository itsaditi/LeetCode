// Last updated: 8/4/2025, 10:59:45 PM
/** 
 * @param {number} target
 * @return {number}
 */


Array.prototype.upperBound = function(target) {

    const map = new Map();

    for (let i = 0 ; i < this.length ; i ++) {
        map.set(this[i], i);
    }

    return map.has(target) ? map.get(target) : -1;
};


// [3,4,5].upperBound(5); // 2
// [1,4,5].upperBound(2); // -1
// [3,4,6,6,6,6,7].upperBound(6) // 5
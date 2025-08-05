// Last updated: 8/4/2025, 11:08:34 PM
/** 
 * @param {number} target
 * @return {number}
 */

// Approach 1 
// Array.prototype.upperBound = function(target) {

//     const map = new Map();

//     for (let i = 0 ; i < this.length ; i ++) {
//         map.set(this[i], i);
//     }

//     return map.has(target) ? map.get(target) : -1;
// };

// Approach 2 - Inbuilt function
// Array.prototype.upperBound = function(target) {
//     return this.lastIndexOf(target);
// };

// Approach 3 - Binary search
Array.prototype.upperBound = function(target) {
    let left = 0;
    let right = this.length - 1;

    let result = -1;

    while (left <= right) {
        let mid = left + ((right - left) >> 1);

        if (this[mid] === target) {
            result = mid;
            left = mid + 1
        } else if (this[mid] < target) {
            left = mid + 1
        } else {
            right = mid - 1;
        }

    }

    return result;



}

// [3,4,5].upperBound(5); // 2
// [1,4,5].upperBound(2); // -1
// [3,4,6,6,6,6,7].upperBound(6) // 5
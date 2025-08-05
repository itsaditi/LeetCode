// Last updated: 8/5/2025, 11:46:53 AM
/**
 * @param {number[]} nums
 * @param {Function} fn
 * @param {number} init
 * @return {number}
 */
var reduce = function(nums, fn, init) {
    if (nums.length === 0) return init;

    let val = 0;

    for (let i = 0 ; i < nums.length ; i++) {
        val = fn(i === 0 ? init : val, nums[i]);
        console.log(val);
    }

    return val;
};
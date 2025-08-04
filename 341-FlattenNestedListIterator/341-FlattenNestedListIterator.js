// Last updated: 8/4/2025, 6:05:38 PM
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * function NestedInteger() {
 *
 *     Return true if this NestedInteger holds a single integer, rather than a nested list.
 *     @return {boolean}
 *     this.isInteger = function() {
 *         ...
 *     };
 *
 *     Return the single integer that this NestedInteger holds, if it holds a single integer
 *     Return null if this NestedInteger holds a nested list
 *     @return {integer}
 *     this.getInteger = function() {
 *         ...
 *     };
 *
 *     Return the nested list that this NestedInteger holds, if it holds a nested list
 *     Return null if this NestedInteger holds a single integer
 *     @return {NestedInteger[]}
 *     this.getList = function() {
 *         ...
 *     };
 * };
 */
/**
 * @constructor
 * @param {NestedInteger[]} nestedList
 */

let currIndex = 0; 
const flattenedList = [];

var NestedIterator = function(nestedList) {

    // [1, 2, [3, 4], 7, 2, [1, 2, 3]]
    function dfs(node) {
        for (const nestedObj of node) {
            if (nestedObj.isInteger()) {
                flattenedList.push(nestedObj.getInteger());
            } else {
                dfs(nestedObj.getList());
            }
        }
    }

    dfs(nestedList);

    console.log(flattenedList);
    
};


/**
 * @this NestedIterator
 * @returns {boolean}
 */
NestedIterator.prototype.hasNext = function() {
    if (currIndex === flattenedList.length) {
        return false;
    }
    return true;
};

/**
 * @this NestedIterator
 * @returns {integer}
 */
NestedIterator.prototype.next = function() {
    const val = flattenedList[currIndex];
    currIndex++;
    return val;
};

/**
 * Your NestedIterator will be called like this:
 * var i = new NestedIterator(nestedList), a = [];
 * while (i.hasNext()) a.push(i.next());
*/
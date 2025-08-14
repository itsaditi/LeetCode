// Last updated: 8/13/2025, 10:07:35 PM
/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {

    if (s === "" && t === "") return true;

    let pointer = 0;

    for (let ch of t) {
        if (s.charAt(pointer) === ch) {
            pointer++ ;
        }

        if (pointer === s.length) {
            return true;
        }
    }


    return false;
};
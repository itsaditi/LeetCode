// Last updated: 8/4/2025, 6:05:56 PM
/**
 * @param {number} times
 * @return {string}
 */
String.prototype.replicate = function(times) {
    let str = "";
    while(times > 0) {
        str += this;
        times--;
    }
    return str;
}

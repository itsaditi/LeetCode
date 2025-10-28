// Last updated: 10/27/2025, 9:32:36 PM
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

// Last updated: 10/27/2025, 9:32:57 PM
/**
 * @param {number[]} salary
 * @return {number}
 */
var average = function(salary) {
    let minSal = Number.MAX_VALUE;
    let maxSal = Number.MIN_VALUE;
    let sumSal = 0;

    for (let amount of salary) {
        minSal = Math.min(minSal, amount);
        maxSal = Math.max(maxSal, amount);

        sumSal += amount;
    }

    console.log(minSal, maxSal, sumSal);

    return (sumSal - minSal - maxSal) / (salary.length - 2);
};
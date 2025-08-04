// Last updated: 8/4/2025, 4:50:55 PM
function dominantIndex(nums: number[]): number {

    const maxNumber = Math.max(...nums);
    const indexOfMaxNumber = nums.indexOf(maxNumber);
    let checkEveryOtherElement = 0;
    
    for (let num of nums) {
        console.log(num, maxNumber);
        if (num != maxNumber && maxNumber >= (2 * num) ) {
            checkEveryOtherElement++;
        }
    }
    
    if (checkEveryOtherElement === nums.length - 1) {
        return indexOfMaxNumber;
    }
    
    
    return -1;
};
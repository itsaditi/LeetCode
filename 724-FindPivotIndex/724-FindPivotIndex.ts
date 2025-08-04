// Last updated: 8/4/2025, 4:50:57 PM
function pivotIndex(nums: number[]): number {
    for (let i = 0 ; i < nums.length ; i++) {
        let sumLeft = 0;
        let sumRight = 0;
        const possiblePivotIndex = i ;
        
        for (let j = 0 ; j < possiblePivotIndex ; j ++){
            sumLeft += nums[j]
        }
        console.log("sumleft - ",  sumLeft);
        
        for (let k = i+1 ; k < nums.length ; k ++){
            sumRight += nums[k]
        }
        console.log("sumleft - ",  sumLeft, "sumright - ", sumRight);
        
        if (sumLeft === sumRight) return possiblePivotIndex;
        
    }
    return -1;
};
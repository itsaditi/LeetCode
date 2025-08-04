// Last updated: 8/4/2025, 4:50:13 PM
/**
 * @param {Object|Array} obj
 * @param {Function} fn
 * @return {Object|Array|undefined}
 */
var deepFilter = function(obj, fn) {
    return dfs(obj, fn);
};

function dfs(node, fn) {
    
    // Base cases
    if (node === null || typeof node !== 'object') {
        if (fn(node)) return node;

        return undefined;
    }

    // Check if node is an array
    if (Array.isArray(node)) {
        const newArr = [];

        for (let i = 0 ; i < node.length ; i++) {
            const curr = node[i];
            const subRes = dfs(curr, fn);

            if (subRes !== undefined) {
                newArr.push(subRes);
            }
        }

        if (newArr.length == 0) {
            return undefined;
        }

        return newArr;        
    }

    // Check if node is an object
    if (typeof node === 'object') {
        const newObj = {};
        let isEmpty = true;

        for (const key in node) {
            const subRes = dfs(node[key], fn);

            if (subRes !== undefined) {
                newObj[key] = subRes;
                isEmpty = false;
            }
        }

        if (isEmpty) return undefined;

        return newObj;
    }
}
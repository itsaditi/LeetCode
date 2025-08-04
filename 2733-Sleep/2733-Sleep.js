// Last updated: 8/4/2025, 4:50:18 PM
/**
 * @param {number} millis
 * @return {Promise}
 */

// Approach 1 -  Asynchronous Programming with Promises and setTimeout
async function sleep(millis) {
    return new Promise((resolve) => {
        setTimeout(resolve, millis);
    })
}

async function sleep2(millis) {
    return new Promise((resolve, reject) => {
        try {
            setTimeout(resolve, millis);
        } catch(error) {
            reject(error);
        }
    })
}

// Approach 2: Asynchronous Programming with Promises and setTimeout without Return
async function sleep3(millis) {
    await new Promise((resolve, reject) => {
        try {
            setTimeout(resolve, millis);
        } catch(err) {
            reject(err);
        }
    })
}

/** 
 * let t = Date.now()
 * sleep(100).then(() => console.log(Date.now() - t)) // 100
 */
// Last updated: 8/4/2025, 11:21:49 PM
/** 
 * @return {string}
 */
Date.prototype.nextDay = function() {
    const newDate = new Date(this.setDate(this.getDate() + 1));
    const year = newDate.getFullYear();
    const month = String(newDate.getMonth() + 1).padStart(2, '0');
    const day = String(newDate.getDate()).padStart(2, '0');
    const formatted = `${year}-${month}-${day}`;

    // return newDate;
    return formatted;
}

/**
 * const date = new Date("2014-06-20");
 * date.nextDay(); // "2014-06-21"
 */
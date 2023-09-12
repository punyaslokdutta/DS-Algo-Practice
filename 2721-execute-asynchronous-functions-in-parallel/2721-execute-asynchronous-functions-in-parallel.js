/**
 * @param {Array<Function>} functions
 * @return {Promise<any>}
 */
var promiseAll = async function(functions) {
    return  new Promise((resolve, reject) => {
        let arr = Array(functions.length);
        let n = functions.length;
        let count = 0;
        for(let i = 0; i < n; ++i){
            functions[i]()
                .then((result) => { 
                    arr[i] = result; 
                    count++;
                    if(count === n ) resolve(arr);
                }).catch(reject);
        }
    });
};
/**
 * const promise = promiseAll([() => new Promise(res => res(42))])
 * promise.then(console.log); // [42]
 */







    
    

    
    
    
    
public class AmazonFE1 {
    public static void main(String args[]) {
        int[] arr = {0,1,1,1,1,1,1};
        System.out.println(solve(arr));
    }
}

// Find the index of an odd number in an array of numbers
// If there are multiple odd numbers in the array ensure indices are returned with equal probability.
// [1,3,4,6] -> 0 or 1. x1000 -> ~ 500x 0, ~500x 1
/**
 * for(let i = 0; i < 1000; i++) {
 *  console.log(solve([1,2,3,5]); // 0 or 3
 *}
 *
 **/
// let randomCounter = 0;
// let oddIndicesLen = 0;
// //let oddObj = {};
// let oddIndices = [];
// function solve(arr) {
//     // let oddIndices = [];
//     if (oddIndices.length) {
//         randomCounter = (randomCounter + 1) % oddIndicesLen;
//         console.log(randomCounter);
//         return;
//     }
//     for (let i = 0; i < arr.length; i++) {
//         let curr = arr[i];
//         if (curr % 2 !== 0) {
//             oddIndex = i;
//             oddIndices.push(i);
//             break;
//         }
//     }
//     oddIndicesLen = oddIndices.length;
//     //randomCounter = (randomCounter + 1) % oddIndicesLen;
//     console.log(randomCounter);
//     //[0,1,3];
//     //let len = oddIndices.length;
//     //let oddIndex = Math.floor(Math.random(0, len));
//     return oddIndices;
// }

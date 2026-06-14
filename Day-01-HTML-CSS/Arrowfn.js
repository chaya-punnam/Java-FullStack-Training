const numbers = [10,20,30,40,50,60,70,80];

const result = numbers.filter((ele)=>ele > 45).map((ele)=>ele / 2)
// console.log(result);
const output=result.reduce((a,b)=>a+b)
console.log(output);
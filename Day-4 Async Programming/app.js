async function getProducts()
{
    const output=await fetch("https://fakestoreapi.com/products");
    const productsOutput=await output.json();
    console.log(productsOutput);
}
getProducts();

console.log("Hi")
console.log("welcome to async programming")
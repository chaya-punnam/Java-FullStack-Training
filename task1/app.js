const AddButton = document.getElementById("add");

AddButton.addEventListener("click", function () {

    let name = document.getElementById("task").value;
    let age = document.getElementById("age").value;
    let city = document.getElementById("city").value;
    let phone = document.getElementById("phone").value;

    const h3 = document.createElement("h3");

    h3.textContent =
        `Name: ${name}, Age: ${age}, City: ${city}, Phone: ${phone}`;

    document.body.append(h3);

    document.getElementById("task").value = ""; 
    document.getElementById("age").value = "";  
    document.getElementById("city").value = "";
    document.getElementById("phone").value = "";
});
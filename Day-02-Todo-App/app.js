const AddButton = document.getElementById("add");
const HtmlBody = document.body;

AddButton.addEventListener("click", function(a) {

    a.preventDefault();

    let capaturedTask = document.getElementById("task").value;

    const H3tag = document.createElement("h3");

    H3tag.textContent = capaturedTask;

    HtmlBody.append(H3tag);

    document.getElementById("task").value = "";

});
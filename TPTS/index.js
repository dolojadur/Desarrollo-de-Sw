fetch('https://fakestoreapi.com/products')
    .then(function (res) { return res.json(); })
    .then(function (products) {
    // Prepare table HTML
    var tableHTML = '<thead><tr><th>ID</th><th>Title</th><th>Description</th><th>Price</th></tr></thead><tbody>';
    // loop thru all products to generate table rows
    products.forEach(function (p) {
        tableHTML += "<tr><td>".concat(p.id, "</td><td>").concat(p.title, "</td><td>").concat(p.description, "</td><td>").concat(p.price, "</td></tr>");
    });
    // close tbody
    tableHTML += '</tbody>';
    // grab tableElement to set its inner html
    // ! significa que no va a ser opcional, si o si voy a encontrar algo
    document.querySelector('#tableElement').innerHTML = tableHTML;
    // hide spinner
    var spinnerElement = document.querySelector('#spinnerContainer');
    spinnerElement.style.display = 'none';
});

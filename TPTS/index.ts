type Rating = {
    rate: number;
    count: number;
};

type Product = {
    id: number;
    title: string;
    price: number;
    description: string;
    category: string;
    image: string;
    rating: Rating;
};

fetch('https://fakestoreapi.com/products')
    .then(res => res.json())
    .then((products: Product[]) => {
        // Prepare table HTML
        let tableHTML: string = '<thead><tr><th>ID</th><th>Title</th><th>Description</th><th>Price</th></tr></thead><tbody>';
        // loop thru all products to generate table rows
        products.forEach((p: Product) => {
            tableHTML += `<tr><td>${p.id}</td><td>${p.title}</td><td>${p.description}</td><td>${p.price}</td></tr>`;
        });
        // close tbody
            tableHTML += '</tbody>';
        // grab tableElement to set its inner html
        // ! significa que no va a ser opcional, si o si voy a encontrar algo
        document.querySelector('#tableElement')!.innerHTML=tableHTML;
        // hide spinner
        const spinnerElement: HTMLElement = document.querySelector('#spinnerContainer')!;
        spinnerElement.style.display = 'none';
    });
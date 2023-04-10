function submitForm(event) {
    event.preventDefault();
    const form = document.querySelector('form');
    const inputs = Array.from(form.querySelectorAll('input[type="number"]'));
    const values = inputs.map(input => parseFloat(input.value));

    let points = parseTable(values);

    console.log(JSON.stringify(points))

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/submit',
        contentType: "application/json",
        data: JSON.stringify(points),
        dataType: 'json',
        success: (data) => {
            console.log(data)
        }
    });
}
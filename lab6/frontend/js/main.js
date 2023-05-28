document.getElementById('myForm').addEventListener('submit', function(event) {
    event.preventDefault();
    validateForm();
});

function submitForm(dto) {
    // Implement your submit function here
    console.log(dto);

    $.ajax({
        type: 'POST',
        url: backendUrl,
        contentType: "application/json",
        data: JSON.stringify(dto),
        dataType: 'json',

        success: (data) => {
            console.log(data);
        }
    });
}
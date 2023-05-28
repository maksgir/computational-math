document.getElementById('myForm').addEventListener('submit', function(event) {
    event.preventDefault();
    validateForm();
});

function submitForm(dto) {
    // Implement your submit function here
    console.log(dto);
}
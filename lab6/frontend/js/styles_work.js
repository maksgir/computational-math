function markAsInvalid(fieldName, errorMessage) {
    var field = document.getElementById(fieldName);
    field.classList.add('error');
    field.addEventListener('animationend', function() {
        field.classList.remove('error');
    });

    var errorElement = document.createElement('p');
    errorElement.classList.add('error-message');
    errorElement.textContent = errorMessage;

    field.parentNode.appendChild(errorElement);
}

function resetValidation() {
    var errorMessages = document.getElementsByClassName('error-message');
    while (errorMessages.length > 0) {
        errorMessages[0].parentNode.removeChild(errorMessages[0]);
    }
}
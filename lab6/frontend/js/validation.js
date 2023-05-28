function validateForm() {
    // Reset validation styles
    resetValidation();

    // Get form values
    var functionId = parseFloat(document.getElementById('function').value);
    const y0 = parseFloat(document.getElementById("y0").value.replace(",", "."));
    const x0 = parseFloat(document.getElementById("x0").value.replace(",", "."));
    const xn = parseFloat(document.getElementById("xn").value.replace(",", "."));
    const h = parseFloat(document.getElementById("h").value.replace(",", "."));
    const e = parseFloat(document.getElementById("e").value.replace(",", "."));


    // Perform validation
    var isValid = true;

    if (isNaN(y0)) {
        markAsInvalid("y0", "Invalid value. Please enter a numeric value.");
        isValid = false;
    }

    if (isNaN(x0)) {
        markAsInvalid("x0", "Invalid value. Please enter a numeric value.");
        isValid = false;
    }

    if (isNaN(xn)) {
        markAsInvalid("xn", "Invalid value. Please enter a numeric value.");
        isValid = false;
    }

    if (isNaN(h)) {
        markAsInvalid("h", "Invalid value. Please enter a numeric value.");
        isValid = false;
    }

    if (isNaN(e)) {
        markAsInvalid("e", "Invalid value. Please enter a numeric value.");
        isValid = false;
    }

    if (xn <= x0) {
        markAsInvalid('xn', 'Right interval (Xn) should be greater than x0.');
        isValid = false;
    }

    if (e <= 0 || e >= 1) {
        markAsInvalid('e', 'Accuracy (e) should be between 0 and 1.');
        isValid = false;
    }

    if (h <= 0) {
        markAsInvalid('h', 'Step (h) should be greater than 0.');
        isValid = false;
    }

    if (!Number.isInteger(h)) {
        markAsInvalid("h", "Invalid value. Please enter an integer value for h.");
        isValid = false;
    }

    if (isValid) {
        var dto = {
            functionId: functionId,
            y0: y0,
            x0: x0,
            xn: xn,
            h: h,
            e: e
        };

        submitForm(dto);
    }
}
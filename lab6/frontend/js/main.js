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
            clearDisplayBlocks();
            generateDisplayBlock(data);
        }
    });
}

function generateDisplayBlock(data) {
    const displayContainer = document.createElement("div");
    displayContainer.id = "display-container";

    // Loop through each array in the data object
    for (const arrayName in data) {
        if (Array.isArray(data[arrayName])) {
            const arrayData = data[arrayName];

            // Create a block for the array
            const arrayBlock = document.createElement("div");
            arrayBlock.classList.add("array-block");

            // Create a heading for the array name
            const arrayNameHeading = document.createElement("h2");
            arrayNameHeading.textContent = arrayName;
            arrayBlock.appendChild(arrayNameHeading);

            if (arrayData.length > 0) {
                // Create a table for the array values
                const table = document.createElement("table");

                // Create table headers
                const tableHeaders = document.createElement("tr");
                const xHeader = document.createElement("th");
                xHeader.textContent = "x";
                const yHeader = document.createElement("th");
                yHeader.textContent = "y";
                tableHeaders.appendChild(xHeader);
                tableHeaders.appendChild(yHeader);
                table.appendChild(tableHeaders);

                // Populate table rows with x and y values
                for (const point of arrayData) {
                    const tableRow = document.createElement("tr");
                    const xCell = document.createElement("td");
                    xCell.textContent = point.x;
                    const yCell = document.createElement("td");
                    yCell.textContent = point.y;
                    tableRow.appendChild(xCell);
                    tableRow.appendChild(yCell);
                    table.appendChild(tableRow);
                }

                // Append the table to the array block
                arrayBlock.appendChild(table);
            } else {
                // Create a message for empty array
                const errorMessage = document.createElement("p");
                errorMessage.textContent = "No data available.";
                arrayBlock.appendChild(errorMessage);
            }

            // Append the array block to the display container
            displayContainer.appendChild(arrayBlock);
        }
    }

    // Append the display container to the page
    document.body.appendChild(displayContainer);
}

function clearDisplayBlocks() {
    const displayContainer = document.querySelector("#display-container");
    if (displayContainer) {
        displayContainer.remove();
    }
}
function build_table(n, arr){
    generateTable(n);
    console.log(arr);
}

function generateTable(n) {

    // Create a table element
    const table = document.createElement("table");

    // Loop to create rows and columns
    for (let i = 0; i < n; i++) {
        const row = table.insertRow(i);
        for (let j = 0; j < n + 1; j++) {
            const cell = row.insertCell(j);
            cell.innerHTML = "Row " + (i + 1) + ", Column " + (j + 1);
        }
    }

    // Append the table to the div
    document.getElementById("tableContainer").appendChild(table);
}
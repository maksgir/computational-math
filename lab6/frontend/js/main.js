$(document).ready(() => {
    let board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-6, 6, 6, -6], axis: true, showCopyright: false});


    document.getElementById('myForm').addEventListener('submit', function(event) {
        event.preventDefault();
        validateForm(board);
    });
});



function submitForm(dto, board) {
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
            generateGraph(data, board);
        }
    });
}

function generateDisplayBlock(data) {
    const displayContainer = document.createElement("div");
    displayContainer.id = "display-container";

    for (const arrayName in data) {
        if (arrayName === "errorMsg" ||  typeof data[arrayName] == 'number') continue;
        const arrayData = data[arrayName];

        const arrayBlock = document.createElement("div");
        arrayBlock.classList.add("array-block");

        const arrayNameHeading = document.createElement("h2");
        arrayNameHeading.textContent = arrayName;
        arrayBlock.appendChild(arrayNameHeading);

        if (Array.isArray(arrayData) && arrayData.length > 0) {
            const table = document.createElement("table");

            const tableHeaders = document.createElement("tr");
            const xHeader = document.createElement("th");
            xHeader.textContent = "x";
            const yHeader = document.createElement("th");
            yHeader.textContent = "y";
            tableHeaders.appendChild(xHeader);
            tableHeaders.appendChild(yHeader);
            table.appendChild(tableHeaders);

            for (const point of arrayData) {
                const tableRow = document.createElement("tr");
                const xCell = document.createElement("td");
                xCell.textContent = point.x.toFixed(3);
                const yCell = document.createElement("td");
                if (isFinite(point.y)) {
                    yCell.textContent = point.y.toFixed(3);
                } else {
                    yCell.textContent = point.y;
                }

                tableRow.appendChild(xCell);
                tableRow.appendChild(yCell);
                table.appendChild(tableRow);
            }

            arrayBlock.appendChild(table);
        } else {
            const errorMessage = document.createElement("p");
            errorMessage.textContent = arrayData === null ? data.errorMsg : "No data available.";
            arrayBlock.appendChild(errorMessage);
        }

        displayContainer.appendChild(arrayBlock);
    }

    document.body.appendChild(displayContainer);
}

function clearDisplayBlocks() {
    const displayContainer = document.querySelector("#display-container");
    if (displayContainer) {
        displayContainer.remove();
    }


}

function generateGraph(data, board) {

    let x_delta = Math.abs(data.xmax / 10), y_delta = Math.abs(data.ymax / 10)

    board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [data.xmin - x_delta, data.ymax + y_delta, data.xmax + x_delta, data.ymin - y_delta],
        axis: true, showCopyright: false});

    draw_points(board, data.exactPoints, '#3366cc')
    draw_points(board, data.eulerPoints, '#dc3912')
    draw_points(board, data.rungePoints, '#ff9900')
    draw_points(board, data.milnPoints, '#40ff00')
}

function draw_points(board, points, color) {

    for (let i = 0; i < points.length; i++) {
        let point = points[i];
        if (!isFinite(point.y)) {

            return;
        }
    }

    points.forEach((point) => {
        board.create("point", [point.x, point.y], {fixed: true, color: color, label: "point"});
    });
}




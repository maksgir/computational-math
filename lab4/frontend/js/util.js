function isValid(x) {
    return x >= -100 && x <= 100;
}

function parseTable(cells) {
    let points = []

    let point;
    for (let i = 0; i < cells.length; i += 2) {
        point = {}
        point.x = parseFloat(cells[i])
        point.y = parseFloat(cells[i + 1])
        if (!isNaN(point.x) && !isNaN(point.y)) {
            points.push(point)
        }


    }

    return points
}
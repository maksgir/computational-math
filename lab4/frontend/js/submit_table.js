function submitForm(event) {
    event.preventDefault();
    const form = document.querySelector('form');
    const inputs = Array.from(form.querySelectorAll('input[type="number"]'));
    const values = inputs.map(input => parseFloat(input.value));

    let points = parseTable(values);

    console.log(JSON.stringify(points))
    http://localhost:8080/api/submit
        $.ajax({
            type: 'POST',
            url: 'http://localhost:8080/api/submit',
            contentType: "application/json",
            data: JSON.stringify(points),
            dataType: 'json',
            success: (data) => {
                console.log(data);

                min_x = points[0].x;
                max_x = points[0].x;

                min_y = points[0].y;
                max_y = points[0].y;

                points.forEach((point) => {
                    min_x = Math.min(min_x, point.x);
                    max_x = Math.max(max_x, point.x);

                    min_y = Math.min(min_y, point.y);
                    max_y = Math.max(max_y, point.y);
                });

                board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [min_x - 1, max_y + 1, max_x + 1, min_y - 1], axis: true, showCopyright: false});

                functionRule = getFunction(data);

                board.create('functiongraph',[functionRule, min_x, max_x]);

                draw_points(board, points);

                $("#result").html(getTypeTextRepresentation(data));
                $("#function").html(getFunctionTextRepresentation(data));
            }
        });
}
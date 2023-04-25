function submitForm(event) {

    const inputs1 = document.getElementsByTagName('input');
    let error = false;
    let set = new Set();
    for (let i = 0; i < rows * 2; i++) {
        const val = parseFloat(inputs1[i].value);
        console.log(val);
        console.log(set)
        if (isNaN(val)) {
            inputs1[i].classList.add('error');
            error = true;
        } else {
            inputs1[i].classList.remove('error');
            if (set.has(val) && i % 2 === 0) {
                for (j = 0; j < rows * 2; j += 2) {
                    const new_val = parseFloat(inputs1[j].value);
                    if (new_val === val) {
                        inputs1[j].classList.add('error');
                    }
                }
                error = true;
            }
            if (i % 2 === 0){
                set.add(val);
            }


        }
    }
    if (error) {
        return;
    }


    event.preventDefault();
    const form = document.querySelector('form');
    const inputs = Array.from(form.querySelectorAll('input[type="number"]'));
    const values = inputs.map(input => parseFloat(input.value));
    console.log(values)

    let points = parseTable(values);


    console.log(JSON.stringify(points))

    $.ajax({
        type: 'POST',
        url: backendUrl,
        contentType: "application/json",
        data: JSON.stringify(points),
        dataType: 'json',
        success: (data) => {
            console.log(data);
            build_table(data.n, data.finiteDifference)

            let min_x = points[0].x;
            let max_x = points[0].x;

            let min_y = points[0].y;
            let max_y = points[0].y;

            points.forEach((point) => {
                min_x = Math.min(min_x, point.x);
                max_x = Math.max(max_x, point.x);

                min_y = Math.min(min_y, point.y);
                max_y = Math.max(max_y, point.y);
            });

            board = JXG.JSXGraph.initBoard('jxgbox', {
                boundingbox: [min_x - 1, max_y + 1, max_x + 1, min_y - 1],
                axis: true,
                showCopyright: false
            });

            let functionRule = getFunction(data);

            board.create('functiongraph', [functionRule, min_x, max_x]);

            draw_points(board, points);

            $("#result").html(getTypeTextRepresentation(data));
            $("#function").html(getFunctionTextRepresentation(data));
        }
    });
}




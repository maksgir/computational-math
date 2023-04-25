let points;
let lagrangeFunc;
let newtonFunc;


function submitForm(event) {

    const inputs1 = document.getElementsByTagName('input');
    let error = false;
    let set = new Set();
    for (let i = 0; i < rows * 2; i++) {
        const val = parseFloat(inputs1[i].value);
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

    points = parseTable(values);

    $.ajax({
        type: 'POST',
        url: backendUrl,
        contentType: "application/json",
        data: JSON.stringify(points),
        dataType: 'json',
        success: (data) => {
            console.log(data);
            build_table(data.n, data.finiteDifference);
            newton_arr = data.newton;
            lagrange_arr = data.cLang;
            xs = data.xs;

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
                boundingbox: [min_x - 5, max_y + 5, max_x + 5, min_y - 5],
                axis: true,
                showCopyright: false
            });

            lagrangeFunc = getLagrangeFunc(data.clang);
            newtonFunc = getNewtonFunc(data.newton);


            board.create('functiongraph', [lagrangeFunc, min_x, max_x]);
            board.create('functiongraph', [newtonFunc, min_x, max_x], {strokecolor:'red'});

            draw_points(board, points);

        }
    });
}

function countX(){
    const target_x = parseFloat(document.getElementById("input-X").value);
    $("#lagrange_result").text(lagrangeFunc(target_x));
    $("#newton_result").text(newtonFunc(target_x));
}




let rows = 5;
let board;


function initialize_table() {
    rows = 5;
    board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-6, 6, 6, -6], axis: true, showCopyright: false});
    checkRowLimits();
}


function checkRowLimits() {
    document.getElementById("row_num").innerHTML = rows;
    checkRemove()
    checkAdd()
}

function checkRemove() {
    if (rows === 5) {
        document.querySelector('#dec_btn').disabled = true;
        document.getElementById("dec_btn").classList.add("disabled_btn");
    }

    if (rows === 11) {
        document.querySelector('#inc_btn').disabled = false;
        document.getElementById("inc_btn").classList.remove("disabled_btn")
    }
}

function checkAdd() {
    if (rows === 12) {
        document.querySelector('#inc_btn').disabled = true;
        document.getElementById("inc_btn").classList.add("disabled_btn");
    }
    if (rows === 6) {
        document.querySelector('#dec_btn').disabled = false;
        document.getElementById("dec_btn").classList.remove("disabled_btn")
    }
}

function increment() {

    if (rows + 1 <= 12) {
        rows++;
        const str = '#row-' + rows;
        $(str).css('display', 'table-row');

    }
    checkRowLimits();
}

function decrement() {
    console.log("dec");
    console.log(rows)
    if (rows - 1 >= 5) {
        const str = '#row-' + rows;
        console.log(str)
        $(str).css('display', 'none');
        rows--;
    }
    checkRowLimits();
}


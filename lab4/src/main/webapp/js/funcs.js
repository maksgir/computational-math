let rows = 8;

function initialize_table() {
    console.log("fvgewg");
    rows = 8;
    show_rows_num();
}

function show_rows_num() {

    console.log(rows);
    document.getElementById("row_num").innerHTML = rows;
    check_dec()
    check_inc()
}

function check_dec() {
    if (rows === 8) {
        document.querySelector('#dec_btn').disabled = true;
        document.getElementById("dec_btn").classList.add("disabled_btn");
    }

    if (rows === 11) {
        document.querySelector('#inc_btn').disabled = false;
        document.getElementById("inc_btn").classList.remove("disabled_btn")
    }
}

function check_inc() {
    if (rows === 12) {
        document.querySelector('#inc_btn').disabled = true;
        document.getElementById("inc_btn").classList.add("disabled_btn");
    }
    if (rows === 9) {
        document.querySelector('#dec_btn').disabled = false;
        document.getElementById("dec_btn").classList.remove("disabled_btn")
    }
}

function increment() {
    console.log("inc");

    if (rows + 1 <= 12) {
        rows++;
    }
    check_inc();

    show_rows_num();
}

function decrement() {
    console.log("dec");
    if (rows - 1 >= 8) {
        rows--;
    }
    check_dec();

    show_rows_num();
}
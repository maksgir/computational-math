function loadFunc() {

    const a = parseInt(document.getElementById("input-a").value);
    const b = parseInt(document.getElementById("input-b").value);
    const n = parseInt(document.getElementById("input-n").value) - 1;
    const option = document.querySelector('input[name="toggle-option"]:checked').id;


    if (isNaN(a)) {
        document.getElementById("input-a").classList.add('error');
    } else {
        document.getElementById("input-a").classList.remove('error');
    }

    if (isNaN(b) || a >= b) {
        document.getElementById("input-b").classList.add('error');
    } else {
        document.getElementById("input-b").classList.remove('error');
    }

    if (isNaN(n) || n <= 4 || n > 12) {
        document.getElementById("input-n").classList.add('error');
    } else {
        document.getElementById("input-n").classList.remove('error');
    }

    if (isNaN(a) || isNaN(b) || isNaN(n) || a >= b || n <= 4 || n > 12) {
        return;
    }


    const arr = [];
    const step = (b - a) / n;

    for (let i = 0; i < n + 1; i++) {
        const x = a + i * step;
        let y = 0;
        if (option === "sin-option") {
            y = Math.sin(x);
        } else if (option === "square-option") {
            y = Math.pow(x, 2) + x
        }

        arr.push(y);

        const xInput = document.getElementsByName(`x${i + 1}`)[0];
        const yInput = document.getElementsByName(`y${i + 1}`)[0];

        const str = '#row-' + (i + 1);
        rows = i + 1
        $(str).css('display', 'table-row');
        checkRowLimits();

        xInput.value = isValid(x) ? x.toFixed(2) : "gg";
        yInput.value = isValid(y) ? y.toFixed(2) : "gg";

    }



    console.log(arr);

}
function loadFile() {
    const input = document.createElement('input');
    input.type = 'file';
    input.accept = '.txt'; // optional file types
    input.onchange = () => {
        const file = input.files[0];
        const reader = new FileReader();
        reader.onload = function (e) {
            const lines = e.target.result.split('\n');
            for (let i = 0; i < lines.length && i < 12; i++) {
                const values = lines[i].trim().split(/\s+/);
                if (values.length >= 2) {
                    const xInput = document.getElementsByName(`x${i + 1}`)[0];
                    const yInput = document.getElementsByName(`y${i + 1}`)[0];
                    const str = '#row-' + (i + 1);
                    rows = i + 1
                    $(str).css('display', 'table-row');
                    checkRowLimits();

                    xInput.value = isValid(values[0])?values[0]:"gg";
                    yInput.value = isValid(values[1])?values[1]:"gg";
                }
            }
        }
        reader.readAsText(file);
    };
    input.click();

}
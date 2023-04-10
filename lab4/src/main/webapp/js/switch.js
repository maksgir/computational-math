let flag = false;

function switch_input(){
    console.log("bom")
    flag = !flag;
    if (flag){
        $('#console-input').css('display', 'none');
        $('#file-input').css('display', 'block');
    } else {
        $('#file-input').css('display', 'none');
        $('#console-input').css('display', 'block');
    }
}
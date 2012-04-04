//function writeOperation(oper){
//    var str = document.getElementById('calcField').value;
//    if("*/+-".indexOf(str.substr(str.length-1)) == -1){
//        document.getElementById('calcField').value += oper;
//    }
//}

function writeOperation(oper){
    var str = document.getElementById('calcField').value;
    if(str.length != 0 && (str.indexOf("*") == -1 || str.indexOf("*") ==  0) && (str.indexOf("/") == -1 || str.indexOf("/") ==  0) && (str.indexOf("+") == -1 || str.indexOf("+") ==  0) && (str.indexOf("-") == -1 || str.indexOf("-") ==  0))
    //&& str.indexOf("/") == (-1 || 0) && str.indexOf("+") == (-1 || 0) && str.indexOf("-") == (-1 || 0))
    {
        document.getElementById('calcField').value += oper;
    }
}

function backOneCharacter(){
//    document.getElementById('calcField').valie = document.getElementById.('calcFiled').substr(0,document.getElementById.('calcField').value.length-2);
    var str2 = document.getElementById('calcField').value;
    document.getElementById('calcField').value = str2.slice(0,str2.length-1);
}

function validateNumber(){
    var str = document.getElementById('calcField').value;
    if(eval(str)>999999999){
        document.getElementById('calcField').value = "Number too big!";
    } else {
        document.getElementById('calcField').value = eval(str);
    }
}
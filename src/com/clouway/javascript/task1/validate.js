function validateFirstName() {
    if (document.getElementById('firstName').value.length < 5) {
        alert("First name must be at least 5 characters");
        return false;
    } else return true;
}

function validateLastName() {
    if (document.getElementById('lastName').value.length < 5) {
        alert("Last name must be at least 5 characters");
        return false;
    } else return true;
}

function validateEGN() {
    if ((document.getElementById('egn').value.length < 10) || (isNaN(document.getElementById('egn').value))) {
        alert("egn must me only from numbers and must be 10 chars");
        return false;
    } else return true;
}

function validateAge() {
    if ((document.getElementById('age').value < 18) || (document.getElementById('age').value > 118) || (isNaN(document.getElementById('age').value))) {
        alert("Age must be between 18 and 118 and must be numbers only");
        return false;
    }
    return true;
}

function validatePassword() {
    var pattern = /^[a-zA-Z0-9]{6,18}$/;
    if (!pattern.test(document.getElementById('password').value)) {
        alert("Only numbers and a-z A-Z symbols allowed!");
        return false;
    }
    return true;
}

function matchPassword() {
    var pass = new String(document.getElementById('password').value);
    var passConfirm = new String(document.getElementById('confirmPassword').value);
    if (pass.localeCompare(passConfirm) != 0) {
        alert("Passwords doesn't match");
        return false;
    }
    return true;
}

function sendIt() {
    if (validateFirstName() && validateLastName() && validateEGN() && validateAge() && validatePassword() && matchPassword()) {
        document.getElementById('regForm').submit();
    } else {
        validateFirstName();
        validateLastName();
        validateEGN();
        validateAge();
        validatePassword();
        matchPassword();
    }
}



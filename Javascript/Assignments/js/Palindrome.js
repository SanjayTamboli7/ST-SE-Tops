function isPalindrome() {
  
    let name1 = document.getElementById('Name');
    let cstr  = name1.value;
    let cResult = document.getElementById('Result');

    if (cstr == '')
        {
            cResult.innerHTML = '<h3>String is empty</h3>';
            return false;
        }

    let i = 0;
    let j = cstr.length - 1;

    while(i < j) {
        if(cstr[i] == cstr[j]) {
            i++; 
            j--;
        }
        else {
            cResult.innerHTML = '<h3> No ' + cstr + ' is not palindrome</h3>';
            return false;
        }
    }

    cResult.innerHTML = '<h3> Yes ' + cstr + ' is palindrome</h3>';
    return true;
}

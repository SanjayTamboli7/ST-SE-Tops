
function isPalindrome() {

    let entrystr = document.getElementById("input").innerHTML;
    let str_entry = document.getElementById("input").innerHTML;

    // const len = entrystr.length;
    // for (let i = 0; i < len / 2; i++) {
    //   if (entrystr[i] !== entrystr[len - 1 - i]) {
    //     document.getElementById("output").innerHTML = "Result: No" 
    //     return false;
    //   }
    // }
    // document.getElementById("output").innerHTML = "Result: Yes" 
    // return true;

    // Write a JavaScript function that checks whether a passed string is palindrome or not? 

// function check_Palindrome(str_entry){
  // Change the string into lower case and remove  all non-alphanumeric characters
     var cstr = str_entry.toLowerCase().replace(/[^a-zA-Z0-9]+/g,'');
    var ccount = 0;
  // Check whether the string is empty or not
    if(cstr==="") {
      console.log("String is empty");
      return false;
    }
  // Check if the length of the string is even or odd 
    if ((cstr.length) % 2 === 0) {
      ccount = (cstr.length) / 2;
    } else {
  // If the length of the string is 1 then it becomes a palindrome
      if (cstr.length === 1) {
        console.log("Entry is a palindrome.");
        return true;
      } else {
  // If the length of the string is odd ignore middle character
        ccount = (cstr.length - 1) / 2;
      }
    }
  // Loop through to check the first character to the last character and then move next
    for (var x = 0; x < ccount; x++) {
  // Compare characters and drop them if they do not match 
      if (cstr[x] != cstr.slice(-1-x)[0]) {
        console.log("Entry is not a palindrome.");
        return false;
      }
    }
    console.log("The entry is a palindrome.");
    return true;
  }
  // check_Palindrome('madam');
  // check_Palindrome('nursesrun');
  // check_Palindrome('fox');
  
  }

//   const entrystr1 = 'madam';
//   const entrystr2 = 'nursesrun';
//   const entrystr3 = 'fox';
//   console.log(isPalindrome(entrystr1)); 
//   console.log(isPalindrome(entrystr2)); 
//   console.log(isPalindrome(entrystr3));
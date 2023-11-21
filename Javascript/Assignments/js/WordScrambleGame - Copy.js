// Word Scramble Game script starts here
// script.js 

const words = [ 
	"react", 
	"angular", 
	"javascript", 
	"bootstrap", 
	"tailwind", 
]; 

// Respective list of hints 
const hints = [ 
	"JavaScript framework", 
	"JavaScript Framework", 
	"Scripting Language", 
	"Styling Library", 
	"Styling Library", 
]; 

// Initialize display word 
let displayWord = ""; 

let countdown;

const timerDisplay = document.querySelector('.display__time-left');

// Function to shuffle letters 
function shuffle(str) { 
	strArray = Array.from(str); 
	for (let i = 0; i < strArray.length - 1; ++i) { 
		let j = Math.floor(Math.random() * strArray.length); 
		// Swap letters 
		let temp = strArray[i]; 
		strArray[i] = strArray[j]; 
		strArray[j] = temp; 
	} 
	return strArray.join(" "); 
} 

// Function to check input and display result 
function check() { 
	let input = document.getElementById("input"); 
	let output = document.getElementById("output"); 
	if ( 
		input.value.toLocaleLowerCase() === 
		displayWord.toLocaleLowerCase() 
	) 
		output.innerHTML = "Result: Correct"; 
	else output.innerHTML = "Result: Incorrect"; 
} 

// To refresh and show new word 
function refresh() { 
	index = Math.floor(Math.random() * 5); 
	displayWord = words[index]; 
	displayHint = hints[index]; 
	scrambleWord = 
		document.getElementById("scrambleWord"); 
	scrambleWord.innerText = 
		shuffle(displayWord).toUpperCase(); 
	let hint = document.getElementById("hint"); 
	hint.innerHTML = "<b>Hint:</b> " + displayHint; 
	document.getElementById("output").innerText = "Result:"; 
	startTimer();
} 

// Function call when page load for first time 
refresh();

// Word Scramble Game script ends here

// Timer script starts here 

// window.onload(startTimer());

// This is our main function
function timer(seconds) {
	//If any timers are already going, clear them
	console.log("In Timer Function 1");
	clearInterval(countdown);

	// Date.now is a new JS function, will give time in MS.
	const now = Date.now();

	// Find time in SECONDS by multiplying default MS by 1000
	const then = now + seconds * 1000;

	// Run another function, defined below, as soon as this function is invoked
	console.log("In Timer Function 2");
	displayTimeLeft(seconds);
	console.log("In Timer Function 3");

	// Set this function to the variable that lives in the browser. Set interval is a function that runs every 1000 ms 
	countdown = setInterval(() => {
		const secondsLeft = Math.round((then - Date.now()) / 1000);
	
		// Check when timer is done. 
		if(secondsLeft < 0){
			clearInterval(countdown);
			return;
		}
	
		//display it
		console.log("In Timer Function 3");
		displayTimeLeft(secondsLeft);
		console.log("In Timer Function 4");
						
		// Run this function every 1000 ms
	}, 1000);
}

//Convert seconds to the formatted display value
function displayTimeLeft(seconds) {

	console.log("In Display Timer Left Function 1");
	// Round seconds to whole numbers
	const minutes = Math.floor(seconds / 60);

	// Get the number of whole seconds remaining
	const remainderSeconds = seconds % 60;

	// Check if display needs a leading 0, if there is less than 10 seconds. so, '9' will display as '09'
	const display = `Time Left: ${minutes}:${remainderSeconds < 10 ? '0' : ''}${remainderSeconds}`;

	timerDisplay.textContent = display;
	console.log("In Display Timer Left Function 2");
}

function startTimer(){

	// By default 1 minute is to solve one scramble.
	console.log("In Start Timer Function");
	const seconds = 60;
	timer(seconds);
}

startTimer();
// Timer script ends here 


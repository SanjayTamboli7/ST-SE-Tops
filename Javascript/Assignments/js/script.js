// Global Variable used to store the quotes fetched from the API 
var data; 
let front = true; 

// Getting the front and the back author boxes 
const authors = document.querySelectorAll(".author"); 

// Getting the front and the back texts 
const texts = document.querySelectorAll(".text"); 

// Getting the body 
const body = document.getElementById("body"); 

// Getting the buttons 
const button = document.querySelectorAll(".new-quote"); 

const blockFront = document.querySelector(".block__front"); 
const blockBack = document.querySelector(".block__back"); 

const authorFront = authors[0]; 
const authorBack = authors[1]; 

const textFront = texts[0]; 
const textBack = texts[1]; 

const buttonFront = button[0]; 
const buttonBack = button[1]; 

// Get the text area and speak button elements
// let textArea = document.getElementById("text");
let speakButton = document.getElementById("speak-button");

function ReadLoudQuote(){
	// Get the quote from the quote area
	
	if (front)
	{
		text = textBack.innerHTML ;
	}
	else
	{			
		text = textFront.innerHTML ;
	}
	
	// Create a new SpeechSynthesisUtterance object
	let utterance = new SpeechSynthesisUtterance();
	
	// Set the text and voice of the utterance
	utterance.text = text;
	utterance.voice = window.speechSynthesis.getVoices()[0];
	
	// Speak the utterance
	window.speechSynthesis.speak(utterance);
	
	}

// An arrow function used to get a quote randomly 
const displayQuote = () =>{ 

	// Generates a random number between 0 and the length of the dataset 
	let index = Math.floor(Math.random()*data.length); 

	// Stores the quote present at the randomly generated index 
	let quote = data[index].text; 

	// Stores the author of the respective quote 
	let author = "-"+"-"+"- "+data[index].author; 

	// Making the author anonymous if no author is present 
	if(!author)
	{ 
		author = "Anonymous"
	} 
	author = author + "<hr>"

	// Replacing the current quote and the author with a new one 

	if(front)
	{ 
		// Changing the front if back-side is displayed 
		textFront.innerHTML = quote; 
		authorFront.innerHTML = author; 
	}
	else
	{ 
		// Changing the back if front-side is displayed 
		textBack.innerHTML = quote; 
		authorBack.innerHTML = author; 
	} 	
	front = !front; 
} 

// Fetching the quotes from the type.fit API using promises 
fetch("https://type.fit/api/quotes") 
	.then(function(response) { 
		return response.json(); 
	}) // Getting the raw JSON data 
	.then(function(data) { 

		// Storing the quotes internally upon 
		// successful completion of request 
		this.data = data; 

		// Displaying the quote When the Webpage loads 
		displayQuote() 
}); 


// Adding an onclick listener for the button 
function newQuote(){ 
	
	// Rotating the Quote Box 
	blockBack.classList.toggle('rotateB'); 
	blockFront.classList.toggle('rotateF'); 

	// Displaying a new quote when the webpage loads 
	displayQuote(); 
}

function CopyToClipboard(){
	if (front)
		{
			navigator.clipboard.writeText(textBack.innerHTML) ;
		}
	else
		{			
			navigator.clipboard.writeText(textFront.innerHTML) ;
		}
}

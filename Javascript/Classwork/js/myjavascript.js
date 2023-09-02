function myFunction() 
{
    document.getElementById("demo").innerHTML = "Paragraph changed.";
}
function displayvalue()
{
    document.getElementById("demo").innerHTML = 5 + 6;
}
function windowalert()
{
    window.alert(5 + 7);
}
function consolelog()
{
    console.log(5+9);
}
function multiply(a, b) 
{
    document.getElementById("demo").innerHTML = "Result = " + (a * b);
}
function simplealert()
{
    alert(5+8);
}
function ShowDateTime()
{
    document.getElementById('demo').innerHTML = Date();
}
function slicedemo(Indicator)
{
    let text = "Apple, Banana, Kiwi";
    let part;
    switch (Indicator) 
    {
        case 'P1':            
            part = text.slice(7,13);
            break;  
        case 'M1':            
            part = text.slice(-12);
            break;  
        case 'M2':            
            part = text.slice(-12, -6);
            break;
        default:
            alert("Invalid parameter...." + Indicator);
    }
    document.getElementById("slc").innerHTML = part; 
}
function Stringsub()
{
    let str = document.getElementById("substring1").innerHTML;
    document.getElementById("substring1").innerHTML = str.substring(7,13);
}
function streplace()
{
    let text = document.getElementById("streplace").innerHTML;
    document.getElementById("streplace").innerHTML = text.replace("Microsoft","W3Schools");
}
function FirstLetter()
{
    let str = document.getElementById("substring1").innerHTML;
    document.getElementById("substring1").innerHTML = str.toUpperCase();
}
function SecondLetter()
{
    let str = document.getElementById("substring1").innerHTML;
    document.getElementById("substring1").innerHTML = str.toLowerCase();
}
function JoinString()
{
    document.getElementById("Joinstr").innerHTML = document.getElementById("substring1").innerHTML.concat(" ", document.getElementById("streplace").innerHTML) 
}
function Striming()
{
    let text1 = "     Hello World!     ";
    document.getElementById("Strim").innerHTML = text1.trim();
}
function StarTrim()
{
    let text1 = "     Hello World!     ";
    document.getElementById("Sartrim").innerHTML = text1.trimStart() + "More text" ;
}
function Endtrim()
{
    let text1 = "     Hello World!     ";
    document.getElementById("Endtrim").innerHTML = "More text" + text1.trimEnd();
}
function StartPad()
{
    let text = "5";
    document.getElementById("StartPad").innerHTML = text.padStart(4,"0");
}
function EndPad()
{
    let text = "5";
    document.getElementById("EndPad").innerHTML = text.padEnd(4,"0");
}
function AtChar()
{
    let text = document.getElementById("AtChar").innerHTML;
    document.getElementById("AtChar").innerHTML = text.charAt(0);
}
function CharCode()
{
    let text = document.getElementById("CharCode").innerHTML;
    document.getElementById("CharCode").innerHTML = text.charCodeAt(0);

}
function Txt()
{
    let text = document.getElementById("Txt").innerHTML;
    document.getElementById("Txt").innerHTML = text[1];
}
function OfIndex()
{
    let text = document.getElementById("IndexOf").innerHTML;
    document.getElementById("IndexOf").innerHTML = text.indexOf("locate");         
}
function LastOfIndex(sop)
{
    switch (sop) 
        {
            case 'No':
                // document.getElementById("LastIndexOf").innerHTML = document.getElementById("LastIndexOf").innerHTML.lastIndexOf("locate");
                let txt = document.getElementById("LastIndexOf").innerHTML;
                let indx = txt.indexOf("locate");
                document.getElementById("LastIndexOf").innerHTML = indx;
                break;
            case 'Yes':
                // let text = "Please locate where 'locate' occurs!";
                let text = document.getElementById("LastIndexOf1").innerHTML;
                let index = text.indexOf("locate",15);
                document.getElementById("LastIndexOf1").innerHTML = index; 
                break;
            default:
                alert("Invalid parameter!!!")
                break;
        }
}
function srch(sop)
{
    switch (sop) 
    {
        case 'No':            
            document.getElementById("search1").innerHTML = document.getElementById("search1").innerHTML.search("search"); 
            break;
        case 'Yes':            
            document.getElementById("search2").innerHTML = document.getElementById("search2").innerHTML.search(/search/); 
            break;
        default:
            alert("Invalid parameter!!!")
            break;
    }
}
function mach(para1)
{
    let txt = "";
    switch (para1) 
    {
        case '1':           
            txt = document.getElementById("match1").innerHTML;
            const myArr = txt.match("ain");
            document.getElementById("match1").innerHTML = myArr.length + " " + myArr;        
            break;    
        case '2':           
            txt = document.getElementById("match2").innerHTML;
            const myArr1 = txt.match(/ain/);
            document.getElementById("match2").innerHTML = myArr1.length + " " + myArr1;
            break;
        case '3':           
            txt = document.getElementById("match3").innerHTML;
            const myArr2 = txt.match(/ain/g);
            document.getElementById("match3").innerHTML = myArr2.length + " " + myArr2;
            break;
        case '4':
            // let text = "I love cats. Cats are very easy to love. Cats are very popular."
            txt = document.getElementById("matchall").innerHTML;
            const iterator = document.getElementById("matchall").innerHTML.matchAll(/Cats/gi);            
            document.getElementById("matchall").innerHTML = Array.from(iterator);            
            break;
        default:
            alert("Invalid parameter!!!")
            break;
    }
}
function inklude(para1)
{
    switch (para1) 
    {
        case '1':
            document.getElementById("include1").innerHTML = document.getElementById("include1").innerHTML.includes("world");                        
            break;
        case '2':
            document.getElementById("include2").innerHTML = document.getElementById("include2").innerHTML.includes("world", 12);                        
            break;
        default:
            alert("Invalid parameter!!!")
            break;
    }
}
function Start_with(para1)
{
    switch (para1) 
    {
        case '1':
            document.getElementById("StartWith1").innerHTML = document.getElementById("StartWith1").innerHTML.startsWith("Hello");    
            break;    
        case '2':
            document.getElementById("StartWith2").innerHTML = document.getElementById("StartWith2").innerHTML.startsWith("world");    
            break;    
        case '3':
            document.getElementById("StartWith3").innerHTML = document.getElementById("StartWith4").innerHTML.startsWith("world", 5);    
            break;    
        case '4':
            document.getElementById("StartWith4").innerHTML = document.getElementById("StartWith4").innerHTML.startsWith("world", 6);    
            break;    
        default:
            alert("Invalid parameter!!!")
            break;
    }
}
function End_with(para1)
{
    switch (para1) 
    {
        case '1':
            document.getElementById("EndWith1").innerHTML = document.getElementById("EndWith1").innerHTML.endsWith("Doe");    
            break;    
        case '2':
            document.getElementById("EndWith2").innerHTML = document.getElementById("EndWith2").innerHTML.endsWith("world", 11);    
            break;    
        default:
            alert("Invalid parameter!!!")
            break;
    }
}
function Back_tick(para1)
{
    switch (para1) 
    {
        case '1':
            let txt = `Hello world!`;
            document.getElementById("BackTick").innerHTML = txt;
            break;    
        case '2':
            break;    
        default:
            alert("Invalid parameter!!!")
            break;
    }
}
function VarSubstitution()
{
    let firstName = "John";
    let lastName = "Doe";
    let txt = `Welcome ${firstName}, ${lastName}!`;
    document.getElementById("VarSubstitutions").innerHTML = txt;
}
function ExpressionSubstitution()
{
    let price = 10;
    let VAT = 0.25;
    let total = `Total: ${(price * (1 + VAT)).toFixed(2)}`;
    document.getElementById("ExpSubstitutions").innerHTML = total;
}
function TemplateLiteral()
{
    let header = "Templates Literals";
    let tags = ["template literals", "javascript", "es6"];    
    let html = `<h2>${header}</h2><ul>`;
    
    for (const x of tags) 
    {
      html += `<li>${x}</li>`;
    }
    
    html += `</ul>`;
    document.getElementById("TemplateLiteral").innerHTML = html;    
}
function Templateoff()
{
    document.getElementById("TemplateLiteral").innerHTML = `Hello world, Template Literals...`;   
}
function AutoStrToNo()
{
    let x = "100";
    let y = "10";
    document.getElementById("AutoStrToNo").innerHTML = "Answer = " + (x / y);    
}
function StrAddition()
{
    let x = "100";
    let y = "10";
    document.getElementById("StrAddition").innerHTML = "Answer = " + (x + y);    
}
function NotANumber()
{
    document.getElementById("NotANumber").innerHTML = 100 / "Apple";
}
function InPhinity()
{
    let myNumber = 2, ctr = 0; 
    let txt = "";
    while (myNumber != Infinity) 
    {
       myNumber = myNumber * myNumber;
       txt = txt + myNumber + "<br>";
       ctr++ ;
       if (ctr>5) break;       
    }
    document.getElementById("Infinity").innerHTML = txt;    
}
function Big_Init()
{
    let x = 123456789012345678901234567890n;
    let y = BigInt("123456789012345678901234567890");
    document.getElementById("BigInit").innerHTML = x + "<br>" + y;    
}
function To_String()
{
    let x = 123;
    document.getElementById("To_String").innerHTML = x.toString() + "<br>" + (123).toString() + "<br>" + (100 + 23).toString();
}
function To_Exponential() 
{
    let x = 9.656;
    document.getElementById("To_Exponential").innerHTML = x.toExponential() + "<br>" + x.toExponential(2) + "<br>" + x.toExponential(4) + "<br>" + x.toExponential(6);
}
function To_Fixed()
{
    let x = 9.656;
    document.getElementById("To_Fixed").innerHTML = x.toFixed(0) + "<br>" + x.toFixed(2) + "<br>" + x.toFixed(4) + "<br>" + x.toFixed(6);    
}
function To_Precision()
{
    let x = 9.656;
    document.getElementById("To_Precision").innerHTML = x.toPrecision() + "<br>" + x.toPrecision(2) + "<br>" + x.toPrecision(4) + "<br>" + x.toPrecision(6);  
}
function Value_Of()
{
    let x = 123;
    document.getElementById("Value_Of").innerHTML = x.valueOf() + "<br>" + (123).valueOf() + "<br>" + (100 + 23).valueOf();
}
function Number_Method()
{
    document.getElementById("Number_Method").innerHTML = 
    Number(true) + "<br>" +
    Number(false) + "<br>" +
    Number("10") + "<br>" + 
    Number("  10") + "<br>" +
    Number("10  ") + "<br>" +
    Number(" 10  ") + "<br>" +
    Number("10.33") + "<br>" + 
    Number("10,33") + "<br>" +
    Number("10 33") + "<br>" +
    Number("John");    
}
function Date_Number(para1)
{
switch (para1) 
    {
        case 1:
            document.getElementById("Date_Number1").innerHTML = Number(new Date("1970-01-01"));     
            break;
        case 2:
            document.getElementById("Date_Number2").innerHTML = Number(new Date("1970-01-02"));     
            break;
        default:
            alert("Invalid parameter!!!")
            break;
    }
}
function Parse_Integer()
{
    document.getElementById("Parse_Integer").innerHTML = 
    parseInt("-10") + "<br>" +
    parseInt("-10.33") + "<br>" +
    parseInt("10") + "<br>" +
    parseInt("10.33") + "<br>" +
    parseInt("10 6") + "<br>" +  
    parseInt("10 years") + "<br>" +  
    parseInt("years 10");      
}
function Parse_Float()
{
    document.getElementById("Parse_Float").innerHTML = 
    parseFloat("10") + "<br>" +
    parseFloat("10.33") + "<br>" +
    parseFloat("10 6") + "<br>" +  
    parseFloat("10 years") + "<br>" +
    parseFloat("years 10");       
}
function Number_IsInteger()
{
    document.getElementById("Number_IsInteger").innerHTML =
    Number.isInteger(10) + "<br>" + Number.isInteger(10.5);
}
function Number_IsSafeInteger()
{
    document.getElementById("Number_IsSafeInteger").innerHTML =
    Number.isSafeInteger(10) + "<br>" + Number.isSafeInteger(10.5);
}
function Number_parseFloat()
{
    document.getElementById("Number_ParseFloat").innerHTML = 
    Number.parseFloat("10") + "<br>" +
    Number.parseFloat("10.33") + "<br>" +
    Number.parseFloat("10 20 30") + "<br>" +
    Number.parseFloat("10 years") + "<br>" +
    Number.parseFloat("years 10");
}
function Number_ParseInteger()
{
    document.getElementById("Number_ParseInteger").innerHTML = 
    Number.parseInt("-10") + "<br>" +
    Number.parseInt("-10.33") + "<br>" +
    Number.parseInt("10") + "<br>" +
    Number.parseInt("10.33") + "<br>" +
    Number.parseInt("10 6") + "<br>" +  
    Number.parseInt("10 years") + "<br>" +  
    Number.parseInt("years 10");  
}
function Number_EPSILON()
{
    document.getElementById("Number_EPSILON").innerHTML = Number.EPSILON;
}
function Number_MaxJS()
{
    document.getElementById("Number_MaxJS").innerHTML = Number.MAX_VALUE;
}
function Number_SafeMaxJS()
{
    document.getElementById("Number_SafeMaxJS").innerHTML = Number.MAX_SAFE_INTEGER;
}
function Number_MinJS()
{
    document.getElementById("Number_MinJS").innerHTML = Number.MIN_VALUE;
}
function Number_SafeMinJS()
{
    document.getElementById("Number_SafeMinJS").innerHTML = Number.MIN_SAFE_INTEGER;
}
function Positive_Infinity()
{
    document.getElementById("Positive_Infinity").innerHTML = 1/0;
}
function Negative_Infinity()
{
    document.getElementById("Negative_Infinity").innerHTML = -1/0;
}
function NotANumber()
{
    document.getElementById("NotANumber1").innerHTML = Number.NaN;
}
function AccessFullArray()
{
    const cars = ["Saab", "Volvo", "BMW"];
    document.getElementById("AccessFullArray").innerHTML = cars;
}
function Array2String()
{
    const fruits = ["Banana", "Orange", "Apple", "Mango"];
    document.getElementById("Array2String").innerHTML = fruits.toString();
}
function ArrayLength()
{
    const fruits = ["Banana", "Orange", "Apple", "Mango"];
    document.getElementById("ArrayLength").innerHTML = fruits + " Length = " + fruits.length;
}
function Array2List()
{
    const fruits = ["Banana", "Orange", "Apple", "Mango"];
    let fLen = fruits.length;
    
    let text = "<ul>";
    for (let i = 0; i < fLen; i++) 
        {
            text += "<li>" + fruits[i] + "</li>";
        }
    text += "</ul>";    
    document.getElementById("Array2List").innerHTML = text;    
}
function AddElementInArray()
{    
    fruits.push("Lemon");
    document.getElementById("AddElementInArray").innerHTML = fruits;
}

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
    document.getElementById("Array2String").innerHTML = fruits.toString();
}
function ArrayLength()
{
    document.getElementById("ArrayLength").innerHTML = fruits + " Length = " + fruits.length;
}
function Array2List()
{
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
function DeleteArrayElement()
{
    fruits.pop();
    document.getElementById("DeleteArrayElement").innerHTML = fruits;    
}
function DeleteFirstElement()
{
    fruits.shift();
    document.getElementById("DeleteFirstElement").innerHTML = fruits;    
}
function DeleteIndexElement()
{
    delete fruits[0];    
    document.getElementById("DeleteIndexElement").innerHTML =
    "The first fruit is: " + fruits[0];
}
function InsertFirstElement()
{
    fruits.unshift("Lemon");
    document.getElementById("InsertFirstElement").innerHTML = fruits;        
}
function AppendElement()
{
    fruits[fruits.length] = "Kiwi";
    document.getElementById("AppendElement").innerHTML = fruits;    
}
function ChangeFirstElement()
{
    fruits[0] = "Kiwi";
    document.getElementById("ChangeFirstElement").innerHTML = fruits;    
}
function ArrayType()
{
    document.getElementById("ArrayType").innerHTML = typeof fruits;
}
function ArrayJoin()
{
    document.getElementById("ArrayJoin").innerHTML = fruits.join(" * ");
}
function ArrayMerge()
{
    const myGirls = ["Cecilie", "Lone"];
    const myBoys = ["Emil", "Tobias", "Linus"];
    const myChildren = myGirls.concat(myBoys);    
    document.getElementById("ArrayMerge").innerHTML = myChildren;    
}
function ArrayFlatten()
{
    const myArr = [[1,2],[3,4],[5,6]];
    const newArr = myArr.flat();
    document.getElementById("ArrayFlatten").innerHTML = newArr;
}
function ArraySplice()
{
    fruits.splice(2, 0, "Lemon", "Kiwi");
    document.getElementById("ArraySplice").innerHTML = fruits;    
}
function ArraySlice()
{
    const citrus = fruits.slice(1);
    document.getElementById("ArraySlice").innerHTML = fruits + "<br>" + citrus;        
}
function ArraySort()
{
    fruits.sort();
    document.getElementById("ArraySort").innerHTML = fruits;    
}
function ArrayReverse()
{
    fruits.sort();
    fruits.reverse();
    document.getElementById("ArrayReverse").innerHTML = fruits;
}
function NumericSort1()
{
    points.sort(function(a, b){return a - b});
    document.getElementById("NumericArraySort1").innerHTML = points;    
}
function NumericArrayReverse1()
{
    points.sort(function(a, b){return b - a});
    document.getElementById("NumericArrayReverse1").innerHTML = points;    
}
function AlphabaticalSort1()
{
    points.sort();
    document.getElementById("AlphabaticalSort1").innerHTML = points;    
}
function SortArrayRandomOrder()
{
    points.sort(function(){return 0.5 - Math.random()});
    document.getElementById("SortArrayRandomOrder").innerHTML = points;  
}
function SortArrayFisherYates()
{
    for (let i = points.length -1; i > 0; i--) 
    {
        let j = Math.floor(Math.random() * (i+1));
        let k = points[i];
        points[i] = points[j];
        points[j] = k;
    }
    document.getElementById("SortArrayFisherYates").innerHTML = points;
}
function SmallestInArray()
{
    points.sort(function(a, b){return a-b});
    document.getElementById("SmallestInArray").innerHTML = points[0];        
}
function SmallestInArray2()
{
    document.getElementById("SmallestInArray2").innerHTML = Math.min.apply(null, points);
}
function SmallestInArray3()
{
    let lenh = points.length;
    let minx = Number.MAX_SAFE_INTEGER;
    while (lenh--) 
    {
      if (points[lenh] < minx) 
      {
        minx = points[lenh];
      }
    }
    document.getElementById("SmallestInArray3").innerHTML = minx;    
}
function HighestInArray()
{
    points.sort(function(a, b){return a-b});
    document.getElementById("HighestInArray").innerHTML = points[points.length-1];        
}
function HighestInArray2()
{
    document.getElementById("HighestInArray2").innerHTML = Math.max.apply(null, points);
}
function HighestInArray3()
{
    let lenh = points.length;
    let maxx = -Infinity;
    while (lenh--) 
    {
      if (points[lenh] > maxx) 
      {
        maxx = points[lenh];
      }
    }
    document.getElementById("HighestInArray3").innerHTML = maxx;    
}
function SortObjectArray1()
{
    const cars = 
      [
        {type:"Volvo", year:2016},
        {type:"Saab", year:2001},
        {type:"BMW", year:2010}
      ];      
      displayCars();      
      cars.sort(function(a, b){return a.year - b.year});
      displayCars();      
      function displayCars() 
      {
          document.getElementById("SortObjectArray1").innerHTML =
          cars[0].type + " " + cars[0].year + "<br>" +
          cars[1].type + " " + cars[1].year + "<br>" +
          cars[2].type + " " + cars[2].year;
      }            
}
function StableSortingAlgorithm()
{
    const myArr = [
        {name:"X00",price:100 },
        {name:"X01",price:100 },
        {name:"X02",price:100 },
        {name:"X03",price:100 },
        {name:"X04",price:110 },
        {name:"X05",price:110 },
        {name:"X06",price:110 },
        {name:"X07",price:110 },
        {name:"X08",price:120 },
        {name:"X09",price:120 },
        {name:"X10",price:120 },
        {name:"X11",price:120 },
        {name:"X12",price:130 },
        {name:"X13",price:130 },
        {name:"X14",price:130 },
        {name:"X15",price:130 },
        {name:"X16",price:140 },
        {name:"X17",price:140 },
        {name:"X18",price:140 },
        {name:"X19",price:140 }
      ];      
      myArr.sort( (p1, p2) => {
        if (p1.price < p2.price) return -1;
        if (p1.price > p2.price) return 1;
        return 0;
      });      
      let txt = "Name : ";
      myArr.forEach(myFunction);      
      function myFunction(value) 
      {
        txt += value.name + " Price : " + value.price + " Name : "; 
      }
      window.alert(txt);      
}
function ArrayForEach()
{
    let txt = "";
    numbers.forEach(myFunction);
    document.getElementById("ArrayForEach").innerHTML = txt;
    
    function myFunction(value, index, array) 
    {
      txt += value + "<br>"; 
    }    
}
function ArrayMap()
{
    numbers2 = numbers.map(myFunction);
    document.getElementById("ArrayMap").innerHTML = numbers2;    
    function myFunction(value, index, array) 
    {
      return value * 2;
    }
}
function ArrayFlatMap()
{
    const newArr = numbers.flatMap((x) => x * 2);
    document.getElementById("ArrayFlatMap").innerHTML = newArr;
}
function ArrayFilter()
{
    const over18 = numbers.filter(myFunction);
    document.getElementById("ArrayFilter").innerHTML = over18;    
    function myFunction(value, index, array) 
    {
      return value > 18;
    }    
}
function ArrayReduce()
{
    let sum = numbers.reduce(myFunction);
    document.getElementById("ArrayReduce").innerHTML = numbers.join(" + ") + " = " + sum;    
    function myFunction(total, value, index, array) {
      return total + value;
    }    
}
function ArrayReduceRight()
{
    let sum = numbers.reduceRight(myFunction);
    document.getElementById("ArrayReduceRight").innerHTML = numbers.join(" + ") + " = " + sum;    
    function myFunction(total, value, index, array) 
    {
      return total + value;
    }
}
function ArrayEvery()
{
    let allOver18 = numbers.every(myFunction);
    document.getElementById("ArrayEvery").innerHTML = "All over 18 is " + allOver18;
    function myFunction(value, index, array) 
    {
        return value > 18;
    }
}
function ArraySome()
{
    let someOver18 = numbers.some(myFunction);
    document.getElementById("ArraySome").innerHTML = "Some over 18 is " + someOver18;    
    function myFunction(value, index, array) 
    {
      return value > 18;
    }    
}
function ArrayIndexOf()
{
    let position = fruits.indexOf("Apple") + 1;
    document.getElementById("ArrayIndexOf").innerHTML = "Apple is found in position " + position;    
}
function ArrayLastIndexOf()
{
    let position = fruits.lastIndexOf("Orange") + 1;
    document.getElementById("ArrayLastIndexOf").innerHTML = "Orange is found in position " + position;    
}
function ArrayFind()
{
    let first = numbers.find(myFunction);
    document.getElementById("ArrayFind").innerHTML = "First number over 18 is " + first;    
    function myFunction(value, index, array) 
    {
      return value > 18;
    }        
}
function ArrayFindIndex()
{
    document.getElementById("ArrayFindIndex").innerHTML = "First number over 18 has index " + numbers.findIndex(myFunction);
    function myFunction(value, index, array) 
    {
      return value > 18;
    }
}
function ArrayFrom()
{
    const myArr = Array.from("ABCDEFG");
    document.getElementById("ArrayFrom").innerHTML = myArr;    
}
function ArrayKeys()
{
    const keys = fruits.keys();
    let text = "";
    for (let x of keys) 
    {
      text += x + ", ";
    }
    document.getElementById("ArrayKeys").innerHTML = text;
}
function ArrayEntries()
{
    const f = fruits.entries(); 
    for (let x of f) 
    {
      document.getElementById("ArrayEntries").innerHTML += x + "<br>";
    }
}
function ArrayIncludes()
{
    document.getElementById("ArrayIncludes").innerHTML = fruits.includes("Mango");    
}
function ArraySpreads()
{
    const q1 = ["Jan", "Feb", "Mar"];
    const q2 = ["Apr", "May", "Jun"];
    const q3 = ["Jul", "Aug", "Sep"];
    const q4 = ["Oct", "Nov", "May"];    
    const year = [...q1, ...q2, ...q3, ...q4];
    document.getElementById("ArraySpreads").innerHTML = year;     
}
function Date1()
{
    document.getElementById("Date1").innerHTML = new Date();    
}
function Date2()
{
    document.getElementById("Date2").innerHTML = new Date("October 13, 2014 11:13:00");    
}
function ISODate()
{
    document.getElementById("ISODate").innerHTML = new Date("2015-03");    
}
function OnlyYear()
{
    document.getElementById("OnlyYear").innerHTML = new Date("2015");    
}
function ISODateTime()
{
    document.getElementById("ISODateTime").innerHTML = new Date("2015-03-25T12:00:00Z");
}
function AddHHMM()
{
    document.getElementById("AddHHMM").innerHTML = new Date("2015-03-25T12:00:00-06:00");    
}
function GetFullYr()
{
    document.getElementById("GetFullYr").innerHTML = (new Date("2021-03-25")).getFullYear();    
}
function GetMonthNo()
{
    document.getElementById("GetMonthNo").innerHTML = (new Date()).getMonth() + 1;
}
function GetMonthName()
{
    const month_name = ["January","February","March","April","May","June","July","August","September","October","November","December"];
    const d = new Date("2021-03-25");
    let month = month_name[d.getMonth()];
    document.getElementById("GetMonthName").innerHTML = month;
}
function GetDayOfDate()
{
    const d = new Date();
    document.getElementById("GetDayOfDate").innerHTML = d.getDate();    
}
function GetHoursOfDate()
{
    const d = new Date();
    document.getElementById("GetHoursOfDate").innerHTML = d.getHours();
}
function GetMinutesOfDate()
{
    const d = new Date();
    document.getElementById("GetMinutesOfDate").innerHTML = d.getMinutes();    
}
function GetSecondsOfDate()
{
    const d = new Date();
    document.getElementById("GetSecondsOfDate").innerHTML = d.getSeconds();    
}
function GetMiliSecondsOfDate()
{
    const d = new Date("2021-03-25");
    document.getElementById("GetMiliSecondsOfDate").innerHTML = d.getMilliseconds();    
}
function GetDayOfWeek()
{
    const d = new Date();
    document.getElementById("GetDayOfWeek").innerHTML = d.getDay();    
}
function GetDayName()
{
    const days = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
    const d = new Date();
    let day = days[d.getDay()];
    document.getElementById("GetDayName").innerHTML = day;
}
function GetTimeZone()
{
    const d = new Date();
    document.getElementById("GetTimeZone").innerHTML = "time zone difference in minutes = " + d.getTimezoneOffset();
}
function SetFullYr()
{
    const d = new Date();
    d.setFullYear((new Date()).getFullYear());
    document.getElementById("SetFullYr").innerHTML = d;
}
function Set_Month()
{
    const d = new Date();
    d.setMonth((new Date()).getMonth());
    document.getElementById("Set_Month").innerHTML = d;
}
function Set_Date1()
{
    const d = new Date();
    d.setDate(d.getDate());
    document.getElementById("Set_Date1").innerHTML = d;    
}
function Set_Date2()
{
    const d = new Date();
    d.setDate(d.getDate() + 50);
    document.getElementById("Set_Date2").innerHTML = d;
}
function Set_Hours()
{
    const d = new Date();
    d.setHours(22);
    document.getElementById("Set_Hours").innerHTML = d;    
}
function Set_Minutes()
{
    const d = new Date();
    d.setMinutes(30);
    document.getElementById("Set_Minutes").innerHTML = d;
}
function Set_Seconds()
{
    const d = new Date();
    d.setSeconds(30);
    document.getElementById("Set_Seconds").innerHTML = d;    
}
function CompareDates()
{
    let text;
    const today = new Date();
    const someday = new Date();
    someday.setFullYear(2100, 0, 14);    
    if (someday > today) 
        {
            text = "Today is before January 14, 2100.";
        } 
        else 
        {
            text = "Today is after January 14, 2100.";
        }    
    document.getElementById("CompareDates").innerHTML = text;
}
function MathConstants()
{
    document.getElementById("MathConstants").innerHTML = 
    "<p><b>Math.E:</b> " + Math.E + "</p>" +
    "<p><b>Math.PI:</b> " + Math.PI + "</p>" +
    "<p><b>Math.SQRT2:</b> " + Math.SQRT2 + "</p>" +
    "<p><b>Math.SQRT1_2:</b> " + Math.SQRT1_2 + "</p>" +
    "<p><b>Math.LN2:</b> " + Math.LN2 + "</p>" +
    "<p><b>Math.LN10:</b> " + Math.LN10 + "</p>" +
    "<p><b>Math.LOG2E:</b> " + Math.LOG2E + "</p>" +
    "<p><b>Math.Log10E:</b> " + Math.LOG10E + "</p>";
}
function MathRound()
{
    document.getElementById("MathRound").innerHTML = Math.round(4.6);
}
function MathCeil()
{
    document.getElementById("MathCeil").innerHTML = Math.ceil(4.4);
}
function MathFloor()
{
    document.getElementById("MathFloor").innerHTML = Math.floor(4.7);    
}
function MathTruncate()
{
    document.getElementById("MathTruncate").innerHTML = Math.trunc(4.7);    
}
function MathSign()
{
    document.getElementById("MathSign").innerHTML = Math.sign(4);
}
function MathPower()
{
    document.getElementById("MathPower").innerHTML = Math.pow(8,2);
}
function MathAbsolute()
{
    document.getElementById("MathAbsolute").innerHTML = Math.abs(-4.7);    
}
function MathSine()
{ 
    document.getElementById("MathSine").innerHTML = 
    "The sine value of 90 degrees is " + Math.sin(90 * Math.PI / 180);
}
function MathCos()
{
    document.getElementById("MathCos").innerHTML = 
    "The cosine value of 0 degrees is " + Math.cos(0 * Math.PI / 180);    
}
function MathMin()
{
    document.getElementById("MathMin").innerHTML =
    Math.min(0, 150, 30, 20, -8, -200);
}
function MathMax()
{
    document.getElementById("MathMax").innerHTML =
    Math.max(0, 150, 30, 20, -8, -200);
}
function MathRandom()
{
    document.getElementById("MathRandom").innerHTML = Math.random();    
}
function MathLog()
{
    document.getElementById("MathLog").innerHTML = Math.log(3.14);
}

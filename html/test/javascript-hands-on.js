let x, y, z;
x = NaN;
y = "20";
z = x + y;
console.log(z);
const check = true;
console.log(check);
//const variable cannot be reassign the value, constant array, constant object
//But we can able to change the element if constant array, the properties of constant object
// check = false;
// console.log(check);

const place = [ "Salem", "Ooty", "Coimbatore"];
console.log(place);

place[0]="Attur";

place.push("Chennai");

console.log(place);

//Data types - String, Number, Bigint, Boolean, Undefined, Null, Symbol, Object
//Object data types - Object, Array, Date


let sample = 666e10;
console.log(sample);

let bigInt =  BigInt('123456789065432123456789');
console.log(bigInt);


const person = {
    firstname : "Sudhakar",
    lastname : "Senthilkumar",
    age : "20",
    fullname :  this.firstname
    }


console.log(person.fullname);

let collegeName = "Karpagam College of Engineering";
let college = 'Karpagam College of Engineering';
let favPlace = "I love 'Kovai'";
let templateStrings = `Do's and Don's in "KCE"`;

//String methods

console.log(college.length);//31
console.log(college.charAt(3));//p
console.log(college.charCodeAt(3));//112
console.log(college.at(3));//p form ES2022
console.log(college[3]);//p

console.log(collegeName.slice(0, 7));//Karpaga
console.log(collegeName);
console.log(collegeName.substring(0, 7));
console.log(collegeName.substr(0, 7));

console.log(collegeName.toLowerCase());
console.log(collegeName.toUpperCase());
console.log(collegeName.toLocaleLowerCase());
console.log(collegeName);
console.log(collegeName.toLocaleUpperCase());

console.log(collegeName.concat(favPlace));
console.log(collegeName+" "+favPlace);
console.log(`${collegeName} ${favPlace}`);

let trimString = "       hhhhhh          ";
console.log(trimString.trim());
console.log(trimString.trimStart());
console.log(trimString.trimEnd());

let padString = "pad ";
console.log(padString.padStart(10,"*"));
console.log(padString.padEnd(10,"+"))

console.log(padString.repeat(10));

let replaceString = "Replacing String Content";
console.log(replaceString.replace("Content","content by replace() method"));
console.log(replaceString);

replaceString = "KARPAGAM COLLEGE OF ENGINEERING KARPAGAM COLLEGE OF ENGINEERING";
console.log(replaceString.replace(/karpagam/i,"Tagore")); // ignore the case
console.log(replaceString.replace(/karpagam/g,"Tagore")); // no changes in the output
console.log(replaceString.replace(/KARPAGAM/g,"Tagore")); // replace all the string matches in that

console.log(replaceString.replaceAll("KARPAGAM", "TAGORE")); // replace all the string matches in that

//convert String to array
console.log(replaceString.split(" "));//['KARPAGAM', 'COLLEGE', 'OF', 'ENGINEERING', 'KARPAGAM', 'COLLEGE', 'OF', 'ENGINEERING']

//String search

console.log(replaceString.indexOf("E")); // 13
console.log(replaceString.indexOf("OF")) // 17

console.log(replaceString.lastIndexOf("OF")); // 49
console.log(replaceString.lastIndexOf("**")); // -1

//indexOf() with start position
console.log(replaceString.indexOf("KARPAGAM",18));// 32
console.log(replaceString.lastIndexOf("KARPAGAM",25));// 0

console.log(replaceString.search("ENGINEERING"));// 20
console.log(replaceString.search(/Engineering/i)); // 20

//String match
console.log(replaceString.match("NEER"));
console.log(replaceString.match(/NEER/));
console.log(replaceString.match(/NEER/g));
console.log(replaceString.match(/NEER/g));
console.log(replaceString.match("uufduu"));
const iterator =  replaceString.matchAll("NEER");
console.log(Array.from(iterator));
console.log(Array.from(replaceString.matchAll(/NEER/g)));
console.log(Array.from(replaceString.matchAll(/NEeR/gi)));

console.log(replaceString.includes("THE")); // false
console.log(replaceString.includes("OF")); // true
console.log(replaceString.includes("OF", 20)); // true

console.log(replaceString.startsWith("KARPAGAM")); // true
console.log(replaceString.startsWith("KARPAGAM", 10)); // false

console.log(replaceString.endsWith("ENGINEERING")); // true
console.log(replaceString.endsWith("ENGINEERING", 20)); // false

//Infinity
let myNumber = 20;
while(myNumber != Infinity)
{
    myNumber = myNumber * myNumber;
}
console.log(myNumber);
console.log(2 / 0);
console.log(-2 / 0);
console.log(typeof(-2 / 0));

//Hexadecimal
let hexaValue = 0xFF;
console.log(typeof(hexaValue));

myNumber = 40;
//base2
console.log(myNumber.toString(2));
//base8
console.log(myNumber.toString(8));
//base10
console.log(myNumber.toString(10));
//base16
console.log(myNumber.toString(16));

let hex = 0x20000000000003n;
let oct = 0o400000000000000003n;
let bin = 0b100000000000000000000000000000000000000000000000000011n;

console.log(hex.toString(10));
console.log(oct.toString(10));
console.log(bin.toString(10));

myNumber = 123456789012345678901234n;
console.log(myNumber>>2n);

console.log(Number.MAX_SAFE_INTEGER);
console.log(Number.MIN_SAFE_INTEGER);

//ES6

console.log(Number.isInteger(10)); // true
console.log(Number.isInteger(10.5)); // false
console.log(Number.isSafeInteger(20)); // false
console.log(Number.isSafeInteger(9007199254740998)); // false

myNumber = 7845.55;

//convert number as a string
console.log(myNumber.toString());

//write number in a exponential -> toExpontential() range from 0 - 100
console.log(myNumber.toExponential(5)); //7.84555e+3

//toFixed() returns a string with specified number of decimals
console.log(myNumber.toFixed(0)); // 7846
console.log(myNumber.toFixed(1)); // 7845.6
console.log(myNumber.toFixed(2)); // 7845.55
console.log(myNumber.toFixed(3)); // 7845.550
console.log(myNumber.toFixed(10)); // 7845.5500000000

//toPrecision Returns a number written with a specified length
console.log(myNumber.toPrecision(6));


//Number method
console.log(Number(true));
console.log(Number(false));
console.log(Number("2"));
console.log(Number(" 2 "));
console.log(Number("2.3"));
console.log(Number("2,3"));
console.log(Number("2 3"));
console.log(Number("number"));
console.log(new Date(Number(new Date())));


//parseInt If the number cannot be converted, NaN (Not a Number) is returned
console.log(parseInt("2 -"));

//parseFloat
console.log(parseFloat(" . 2 . 45"));

console.log(Number.MAX_VALUE);
console.log(Number.MIN_VALUE);

//javascript arrays

const names = ["Ragavan", "Parthiban", "Chandru", "Viswa", "Tharan"];
console.log(names.toString());
console.log(typeof(names));
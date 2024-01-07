//Generate random strings
function randomString(lenString) {
    lenString = lenString === undefined ? 7 : lenString;
    const characters = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz";

    let resultRandomString = '';

    for (var i = 0; i < lenString; i++) {
        let randomNumber = Math.floor(Math.random() * characters.length);
        resultRandomString += characters.substring(randomNumber, randomNumber + 1);
    }

    return resultRandomString;
}


const questions = [
    {
        question: `Which of the following is not a CSS selector which is used to "find" the HTML elements we want to style?`,
        options: ["Complex Selectors", "Combinator Selectors", "Pseudo-elements Selectors", "Simple Selectors"],
        correct_answer: "Complex Selectors"
    },
    {
        question: "The elements between the and tags of an HTML table are ______ by default.",
        options: ["Justified", "Left aligned", "Centrally aligned", "Right aligned"],
        correct_answer: "Left aligned"
    },
    {
        question: ".NET Framework was designed and developed by _______.",
        options: ["Microsoft", "IBM", "Oracle", "Google"],
        correct_answer: "Microsoft"
    },
    {
        question: "The basic elements of a form are called :",
        options: ["Objects", "Table", "Record", "Controls"],
        correct_answer: "Controls"
    },
    {
        question: "The stylesheet file will not be loaded by the browser if you omit ______",
        options: ["REL", "STYLE", "BODY", "HTML"],
        correct_answer: "REL"
    },
    {
        question: "Which of the following multimedia text-based features generalize the concepts of footnotes and cross-references for accessing text documents?",
        options: ["Text importing and exporting", "Text style", "Hypertext", "text search"],
        correct_answer: "Hypertext"
    },
    {
        question: "What is the latest version of CSS available?",
        options: ["CSS2", "CSS3", "CSS3.1", "CSS4"],
        correct_answer: "CSS3"
    },
    {
        question: "What does the abbreviation HTML stand for?",
        options: ["HyperText Markup Language", "HighText Markup Language", "HyperText Markdown Language", "None of the above"],
        correct_answer: "HyperText Markup Language"
    },
    {
        question: "The correct sequence of HTML tags for starting a webpage is -",
        options: ["Head, Title, HTML, body", "HTML, Body, Title, Head", "HTML, Head, Title, Body", "HTML, Title, Head, Body"],
        correct_answer: "HTML, Head, Title, Body"
    },
    {
        question: "Which of the following element is responsible for making the text bold in HTML?",
        options: ["<pre>", "<a>", "<b>", "<br>"],
        correct_answer: "<b>"
    },
    {
        question: " Which of the following tag is used for inserting the largest heading in HTML?",
        options: ["<h3>", "<h1>", "<h5>", "<h6>"],
        correct_answer: "<h1>"
    },
    {
        question: "How to create an unordered list (a list with the list items in bullets) in HTML?",
        options: ["<ul>", "<ol>", "<li>", "<i>"],
        correct_answer: "<ul>"
    },
    {
        question: "Which of the following tag is used to define options in a drop-down selection list?",
        options: ["<select>", "<list>", "<dropdown>", "<option>"],
        correct_answer: "<option>"
    },
    {
        question: "HTML tags are enclosed in-",
        options: ["# and #", "{ and }", "! and ?", "< and >"],
        correct_answer: "< and >"
    },
    {
        question: "Which of the following tag is used to add rows in the table?",
        options: ["<td> and </td>", "<th> and </th>", "<tr> and </tr>", "<row> and </row>"],
        correct_answer: "<tr> and </tr>"
    },
    {
        question: "The <hr> tag in HTML is used for -",
        options: ["new line", "vertical ruler", "new paragraph", "horizontal ruler"],
        correct_answer: "horizontal ruler"
    },
    {
        question: "Which of the following attribute is used to provide a unique name to an element?",
        options: ["class", "id", "type", "None of the above"],
        correct_answer: "id"
    },
    {
        question: "What are the types of unordered or bulleted list in HTML?",
        options: ["disc, square, triangle", "polygon, triangle, circle", "disc, circle, square", "All of the above"],
        correct_answer: "disc, circle, square"
    },
    {
        question: "CSS stands for -",
        options: ["Cascade style sheets", "Color and style sheets", "Cascading style sheets", "None of the above"],
        correct_answer: "Cascading style sheets"
    },
    {
        question: "Which of the following is the correct syntax for referring the external style sheet?",
        options: ["<style src = example.css>", '<style src = "example.css" >', "<stylesheet> example.css </stylesheet>", '<link rel="stylesheet" type="text/css" href="example.css">'],
        correct_answer: '<link rel="stylesheet" type="text/css" href="example.css">'
    },
    {
        question: "The property in CSS used to change the text color of an element is -",
        options: ["bgcolor", "color", "background-color", "All of the above"],
        correct_answer: "color"
    },
    {
        question: "Which type of JavaScript language is ___",
        options: ["Object-Oriented", "Object-Based", "Assembly-language", "High-level"],
        correct_answer: "Object-Based"
    },
    {
        question: "Which one of the following also known as Conditional Expression:",
        options: ["Alternative to if-else", "Switch statement", "If-then-else statement", "immediate if"],
        correct_answer: "immediate if"
    },
    {
        question: "In JavaScript, what is a block of statement?",
        options: ["Conditional block", "block that combines a number of statements into a single compound statement", "both conditional block and a single statement", "block that contains a single statement"],
        correct_answer: "block that combines a number of statements into a single compound statement"
    },
    {
        question: 'The "function" and " var" are known as:',
        options: ["Keywords", "Data types", "Declaration statements", "Prototypes"],
        correct_answer: "Declaration statements"
    },
    {
        question: "Which of the following variables takes precedence over the others if the names are the same?",
        options: ["Global variable", "The local element", "The two of the above", "None of the above"],
        correct_answer: "The local element"
    },
    {
        question: "Which one of the following is the correct way for calling the JavaScript code?",
        options: ["Preprocessor", "Triggering Event", "RMI", "Function/Method"],
        correct_answer: "Function/Method"
    },
    {
        question: "Which of the following type of a variable is volatile?",
        options: ["Mutable variable", "Dynamic variable", "Volatile variable", "Immutable variable"],
        correct_answer: "Mutable variable"
    },
    {
        question: "Which of the following option is used as hexadecimal literal beginning?",
        options: ["00", "0x", "0X", "Both 0x and 0X"],
        correct_answer: "Both 0x and 0X"
    },
    {
        question: "When there is an indefinite or an infinite value during an arithmetic computation in a program, then JavaScript prints______.",
        options: ["Prints an exception error", "Prints an overflow error", 'Displays "Infinity"', "Prints the value as such"],
        correct_answer: 'Displays "Infinity"'
    }
]

//Generate random array ranges from 0 to question.length-1;
const randomIndices = [];

while (randomIndices.length < 10) {
    const randomIndex = Math.floor(Math.random() * questions.length);
    if (!randomIndices.includes(randomIndex)) {
        randomIndices.push(randomIndex);
    }
}

const divEl = document.createElement('div');
divEl.id = "form-div";
const scoreDivEl = document.createElement('div');
divEl.appendChild(scoreDivEl);

const quizFormEl = document.createElement('form');
quizFormEl.id = 'quizForm';
quizFormEl.method = 'post';
quizFormEl.action = 'javascript:void(0)';

const quizHeadingEl = document.createElement('h1');
quizHeadingEl.textContent = 'Quiz: Test Your Knowledge';
quizFormEl.appendChild(quizHeadingEl);

//start button
const startBtn = document.createElement("button");
startBtn.className = "quiz-start";
startBtn.textContent = "Start Quiz";
startBtn.addEventListener("click", displayQuestion);
quizFormEl.appendChild(startBtn);

// store the correct answers in the array
const correct_answers = [];

function displayQuestion() {
    startBtn.remove();
    
    randomIndices.forEach(random => {
        const question = questions[random];

        const questionDivEl = document.createElement("div");
        questionDivEl.className = "question-container";

        const questionLabelEl = document.createElement("label");
        questionLabelEl.textContent = `Q${random + 1}. ${question.question}`;
        questionDivEl.appendChild(questionLabelEl);

        const optionDivEl = document.createElement("div");

        question.options.forEach(option => {
            const inputEl = document.createElement("input");
            const randomName = randomString(10);
            inputEl.type = "radio";
            inputEl.value = option;
            inputEl.id = randomName;
            inputEl.className = "quiz-option";
            inputEl.required = true;
            inputEl.name = `Q${random + 1}`;

            const optionLabel = document.createElement("label");
            optionLabel.textContent = option;
            optionLabel.setAttribute("for", randomName);

            optionDivEl.appendChild(inputEl);
            optionDivEl.appendChild(optionLabel);
            optionDivEl.appendChild(document.createElement('br'));
        })
        questionDivEl.appendChild(optionDivEl);
        quizFormEl.appendChild(questionDivEl);
        quizFormEl.appendChild(document.createElement('br'));

        //push the correct answer for each question in the array for validation
        correct_answers.push(question.correct_answer);
    })

    const submitBtn = document.createElement('button');
    submitBtn.type = 'submit';
    submitBtn.className = 'quiz-submit';
    submitBtn.textContent = 'Submit Quiz';
    quizFormEl.appendChild(submitBtn);
    quizFormEl.addEventListener('submit', calculateQuizScore);
}


function calculateQuizScore(e) {
    e.preventDefault();
    let score = 0;
    let correctAnswerIndex = 0;
    randomIndices.forEach(index => {
        const selectedAnswer = document.querySelector(`input[name="Q${index + 1}"]:checked`);
        if (selectedAnswer) {
            const selectedAnswerLabel = document.querySelector('label[for=' + selectedAnswer.id + ']');
            const userAnswer = selectedAnswer.value;
            if (userAnswer === correct_answers[correctAnswerIndex]) {
                selectedAnswerLabel.classList.add("correct-answer");
                score++;
            }
            else
            {
                selectedAnswerLabel.classList.add("incorrect-answer");
            }
        }
        correctAnswerIndex += 1;
    });
    scoreDivEl.className = "quiz-score";
    scoreDivEl.textContent = (`Your score: ${score}/${randomIndices.length}`);

    const submitBtn = document.querySelector(`button`)
    if (submitBtn) {
        quizFormEl.removeChild(submitBtn);
    }
    const restartButtonEl = document.createElement("button");
    restartButtonEl.type = "reset";
    restartButtonEl.className = 'quiz-restart';
    restartButtonEl.textContent = "Restart Quiz";
    restartButtonEl.addEventListener("click", restartQuiz);
    quizFormEl.appendChild(restartButtonEl);
}

function restartQuiz(e) {

    scoreDivEl.textContent = '';

    //I need to remove the restart button after click
    const restartButton = document.querySelector('button');
    if (restartButton) {
        quizFormEl.removeChild(restartButton);
    }
    window.location.reload();
}
divEl.appendChild(quizFormEl);
document.body.appendChild(divEl);



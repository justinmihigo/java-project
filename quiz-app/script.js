const quizData =[{question:"Who was the first to land on moon",a:'Elon Musk',b:'Neil armstrong',c:'Mihigo Justin',d:'Mark Zuckerberg',correct:'b'},
{question:"What was is the popular programming language",a:'Python',b:'Java',c:'Javascript',d:'C#',correct:'a'},
{question:"When Javascript was invented",a:'1990',b:'1994',c:'1993',d:'1995',correct:'d'}
]
let score=0;
let answer;
var qtext=document.getElementById('qtext');
var qa=document.getElementById('qa');
var qb=document.getElementById('qb');
var qc=document.getElementById('qc');
var qd=document.getElementById('qd');
var radios=document.querySelectorAll("input[type='radio']");
let currentQuiz=0;
function display(){
    var currentQuestion=quizData[currentQuiz];
    qtext.innerText=currentQuestion.question;
    qa.innerText=currentQuestion.a;
    qb.innerText=currentQuestion.b;
    qc.innerText=currentQuestion.c;
    qd.innerText=currentQuestion.d;
  
}
display();
function checkanswer(){
    for(x in radios){
        if(radios[x].checked){
            return radios[x].id;
        }
    }
}
function turnoff(){
    for(x in radios){
        if(radios[x].checked){
            return radios[x].checked=false;
        }
}
}
var submitbtn=document.querySelector(".button");
submitbtn.addEventListener('click',()=>{
    document.querySelector("h1").style.display="none";

    var users=checkanswer();
    var currentQuestion=quizData[currentQuiz];
    answer=currentQuestion.correct;
    if(users===answer){
        score++;
    }
        
        if(currentQuiz < quizData.length-1){
            currentQuiz++;
            display();
        }
        else{
            alert("congratulations you have successfully completed the questions");
            document.querySelector(".quiz-container").innerHTML=`<h2>You got score(s) of ${score} out of ${quizData.length} 
            <button onclick="location.reload()">Retry</button>`;
        }
        turnoff();
}
);

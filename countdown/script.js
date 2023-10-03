const target="12-31-2023";
var daysC=document.getElementById('days');
var hoursC=document.getElementById('hours');
var minutesC=document.getElementById('minutes');
var secsC=document.getElementById('seconds');
hoursC.innerHTML="justin";
function countdown(){
    const newYear=new Date(target);
    const today=new Date();
    const diff=newYear-today;
    const totalSeconds=diff/1000;
    const days=Math.floor((totalSeconds/3600)/24);
    const hours=Math.floor(((totalSeconds/3600)%24));
    const minutes=Math.floor((totalSeconds/60)%24);
    const seconds=Math.floor((totalSeconds%60));
    console.log(hours);
    daysC.innerHTML=days;
    hoursC.innerHTML=formatTime(hours);
    minutesC.innerHTML=formatTime(minutes);
    secsC.innerHTML=formatTime(seconds);

}
function formatTime(time){
    return time<10?`0${time}`:time;
}
countdown();
setInterval(countdown,1000);
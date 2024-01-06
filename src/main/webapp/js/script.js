var i=0;
var time=3000;
var images=[];
images[0]="P:\my web\images\kid1.jpg";
images[1]="P:\my web\images\kid2.jpg";
images[2]="P:\my web\images\kid3.jpg";
images[3]="P:\my web\images\kid4.jpg";
function showslides(){
    document.slides.src=images[i];
if(i<images.length-1){
    i++;
}
else{
    i=0;
}
setTimeout("showslides()",time);
}
window.onload=showslides;
var slideid=0;
let menu=document.getElementById("menu");
let closeBtn=document.getElementById("close");
let list=document.getElementById("list");
let side=document.getElementById("side");
if(window.innerWidth<=900){
window.addEventListener('load',()=>{
    list.style.display="none";
    side.style.display="none";
});
}

menu.addEventListener('click',()=>{
    list.style.display="grid";
    list.style.gap="20px";
    side.style.display="block";
    side.style.width="200px";
    side.appendChild(list);
    closeBtn.style.display="block";
    closeBtn.addEventListener('click',()=>{
        side.style.display="none";
        menu.style.display="block";
        closeBtn.style.display="none";
    });
    menu.style.display="none";
});
function slideshow()
{
    var slides=document.querySelectorAll(".slides");
    for(var i=0;i<slides.length;i++){
        slides[i].style.display="none";
    }
    if(slideid<slides.length-1){
    slideid++;
    }
    else{
        slideid=1;
    }
    slides[slideid-1].style.display="block";
    setTimeout(slideshow,6000);
}
function slider(n){
    var slides=document.querySelectorAll(".slides");
    var left=document.querySelectorAll(".l");
    slides[n].style.display="block";
}
window.onload=slideshow;
function view(a,c){
    const about=document.querySelector(a);
    var section=document.querySelector(c);
    section.scrollIntoView({behavior:'smooth'});
    section.style.paddingTop="55px";
}
function collapse(){
    var cot=document.querySelector(".art1");
    var read=document.getElementById("read");
    var link=document.querySelector(".link");
    var hide=document.createElement("a");
    hide.classList.add("link");
    read.style.display="block";
    hide.innerText="Hide"
    read.appendChild(hide);
    link.style.display="none";
    cot.style.height="auto";
    hide.onclick= function(){
        read.style.display="none";
        read.removeChild(hide);
        link.style.display="block";
    };
}



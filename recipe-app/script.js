const meals=document.querySelector(".meals");
const favs=document.getElementById('favmeals');
const searchTerm=document.getElementById("searchTerm");
const search=document.getElementById("search");
const btnClose=document.querySelector(".btn-close");
const mealContainer=document.querySelector(".meal-info-container");
const mealsEl=document.getElementById('meals');
getrandmeal();
fetchmeals();
async function getrandmeal(){
    const resp=await fetch("https://www.themealdb.com/api/json/v1/1/random.php");
    const respData= await resp.json();
    const randmeal= respData.meals[0];
    addMeal(randmeal, true);
} 
async function getMealById(id){
    const resp= await fetch("https://www.themealdb.com/api/json/v1/1/lookup.php?i="+id);
    const respData= await resp.json();
    const meal=respData.meals[0];
    return meal;
}
async function getMealsBySearch(term){
    const resp= await fetch ("https://www.themealdb.com/api/json/v1/1/search.php?s="+term);
    const respData= await resp.json();
    const meals= respData.meals;
    return meals;
}
function addMeal(mealData, random=false){
    const meal=document.createElement('div');
    meal.classList.add('meal');
    meal.innerHTML=`<div class="randmeal">
    ${random?'<h2>Random meal</h2>':''}
    <img src='${mealData.strMealThumb}' alt='${mealData.strMeal}'>
</div>
<div class="fav">
    <h3>${mealData.strMeal}</h3>
    <button class='fav-btn'><i class="fa fa-heart"></i></button>
</div>`;
const btn=meal.querySelector('.fav .fav-btn');
btn.addEventListener('click',()=>{
    if(btn.classList.contains('active')){
        removemeals(mealData.idMeal);
        btn.classList.remove('active');
    }
    else{
        addmeals(mealData.idMeal);
        btn.classList.add('active');
    }
});
mealsEl.appendChild(meal);
}

function removemeals(mealid){
    const mealIds= getmeals();
    localStorage.setItem('mealIds',JSON.stringify(mealIds.filter(id => id !== mealid)));

}
function addmeals(mealid){
const mealIds= getmeals();
localStorage.setItem('mealIds',JSON.stringify([...mealIds,mealid]));
}
function getmeals(){
const mealIds=JSON.parse(localStorage.getItem('mealIds'));
return mealIds===null?[]:mealIds;
}

async function fetchmeals(){
    favs.innerHTML="";
    const mealsIds= getmeals();
    for(let i=0; i<mealsIds.length; i++){
        const mealId=mealsIds[i];
        const meal =await getMealById(mealId);
        addMealFav(meal);
    }
}
function addMealFav(mealData){
    const favmeal=document.createElement('li');
    favmeal.innerHTML=`
    <img src="${mealData.strMealThumb}" alt="${mealData.strMeal}"<br>
    <span>${mealData.strMeal}</span>
    <button id="btn" class="btnfav">
    <i class="fa fa-window-close"></i>
    </btn>
    `;
    const btn=favmeal.querySelector("#btn");
    btn.addEventListener('click',()=>{
        removemeals(mealData.idMeal);
        fetchmeals();
    });
    favs.appendChild(favmeal); 
    favmeal.addEventListener("click",()=>{
        mealContainer.innerHTML="";
        showMealdataInfo(mealData);
    });
}
search.addEventListener('click',async()=>{
    mealsEl.innerHTML=" "
    const search=searchTerm.value;
    const mealss= await(getMealsBySearch(search));
    mealss.forEach((meal) => {
        addMeal(meal);
    });
});
function showMealdataInfo(mealData){
    const division=document.createElement("div");
    const ingredients=[];
    for(let i=1;i<=20;i++){
        if(mealData["strIngredient"+i]){
            ingredients.push(`${mealData["strIngredient"+i]} - ${mealData["strMeasure"+i]}`);
        }
        else{
            break;
        }
    }
    division.classList.add("meal-info");
    division.innerHTML=` 
    <h2>${mealData.strMeal}</h2>
    <img src="${mealData.strMealThumb}" alt="${mealData.strMeal}" height="auto"/>
    <p>${mealData.strInstructions}</p>
        <button class="btn-close"><i class="fa fa-window-close-o"></i></button>
        <h3>ingredients</h3>
    <ul>
    ${ingredients.map((ing)=> `<li>${ing}</li>`).join("")}
    </ul>
    `
    mealContainer.appendChild(division);
    mealContainer.classList.remove("hidden");
    const btnclose=mealContainer.querySelector(".btn-close");
    btnclose.addEventListener("click", ()=>{
        mealContainer.classList.add("hidden");
    })
}


console.log(users[0].first_name);
//users.forEach(item=>{
//console.log(item.id);
//console.log(item.first_name);
//});
var mytable=document.querySelector(".mytable tbody");
users.forEach(items=>{
    const row=document.createElement("tr");
    const idcell=document.createElement("td");
    idcell.textContent=items.id;
    row.appendChild(idcell);
    const namecell=document.createElement("td");
    namecell.textContent=items.first_name;
    row.appendChild(namecell);
    const othername=document.createElement("td");
    othername.textContent=items.last_name;
    row.appendChild(othername);
    const email=document.createElement("td");
    email.textContent=items.email;
    row.appendChild(email);
    const gender=document.createElement("td");
    gender.textContent=items.gender;
    row.appendChild(gender);
    const tel=document.createElement("td");
    tel.textContent=items.Telephone;
    row.appendChild(tel);

    mytable.appendChild(row);

});



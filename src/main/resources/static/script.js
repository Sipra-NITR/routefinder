
let searchCount = 0;
let historyList = [];

const API_URL = "http://localhost:8081";
let map;
let marker1;
let marker2;
let routingControl;

function initMap(){

    map = L.map("map").setView([20.2961,85.8245],7);

    L.tileLayer(

        "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",

        {

            attribution:"© OpenStreetMap Contributors"

        }

    ).addTo(map);

}

document
.getElementById("routeBtn")
.addEventListener(
"click",
findRoute
);

async function findRoute(){

    const source =
    document
    .getElementById("source")
    .value.trim();

    const destination =
    document
    .getElementById("destination")
    .value.trim();

    if(source==="" || destination===""){

        alert(
        "Please enter both cities."
        );

        return;

    }

    showLoader();

    try{

        const response =
        await fetch(

`${API_URL}/route?source=${encodeURIComponent(source)}&destination=${encodeURIComponent(destination)}`

        );

        if(!response.ok){

            throw new Error(
            "Server Error"
            );

        }

        const data =
        await response.json();

        displayRoute(data);

        await drawRoute(
            source,
            destination
        );

        updateHistory(
            source,
            destination
        );

        searchCount++;

        document
        .getElementById("searchCount")
        .innerText =
        searchCount;

        document
        .getElementById("resultSection")
        .classList
        .remove("hidden");

    }

    catch(error){

        console.log(error);

        alert(
        "Unable to connect to backend."
        );

    }

    hideLoader();

}

function displayRoute(data){

document
.getElementById("distance")
.innerHTML =
`📍 Distance : <b>${data.distance} km</b>`;

document
.getElementById("time")
.innerHTML =
`⚡ Execution Time : <b>${data.executionTime} ms</b>`;

let traffic =
Math.floor(Math.random()*3);

let trafficText="";

if(traffic===0){

trafficText="🟢 Low Traffic";

}

else if(traffic===1){

trafficText="🟡 Moderate Traffic";

}

else{

trafficText="🔴 Heavy Traffic";

}

document
.getElementById("traffic")
.innerHTML=trafficText;

let html="";

data.path.forEach(

(city,index)=>{

html +=
`<div class="city">${city}</div>`;

if(index!=data.path.length-1){

html +=
`<div class="arrow">⬇</div>`;

}

}

);

document
.getElementById("path")
.innerHTML=html;

}
async function getCoordinates(city){

    const response = await fetch(

`https://nominatim.openstreetmap.org/search?format=json&q=${encodeURIComponent(city)}`

    );

    const data = await response.json();

    if(data.length===0){

        throw new Error("City not found");

    }

    return{

        lat:parseFloat(data[0].lat),

        lng:parseFloat(data[0].lon)

    };

}

function updateHistory(source,destination){

historyList.push(

`${source} ➜ ${destination}`

);

let html="";

historyList.forEach(route=>{

html +=

`<li>${route}</li>`;

});

document
.getElementById("history")
.innerHTML=html;

}

async function drawRoute(source,destination){

    const src = await getCoordinates(source);

    const dest = await getCoordinates(destination);

    if(marker1){

        map.removeLayer(marker1);

    }

    if(marker2){

        map.removeLayer(marker2);

    }

    marker1 = L.marker([src.lat,src.lng])

        .addTo(map)

        .bindPopup(source)

        .openPopup();

    marker2 = L.marker([dest.lat,dest.lng])

        .addTo(map)

        .bindPopup(destination);

    if(routingControl){

        map.removeControl(routingControl);

    }

    routingControl = L.Routing.control({

        waypoints:[

            L.latLng(src.lat,src.lng),

            L.latLng(dest.lat,dest.lng)

        ],

        routeWhileDragging:false,

        addWaypoints:false,

        draggableWaypoints:false,

        show:false

    }).addTo(map);

}

function showLoader(){

document
.getElementById("loader")
.classList
.remove("hidden");

}

function hideLoader(){

document
.getElementById("loader")
.classList
.add("hidden");

}

document
.getElementById("themeBtn")
.addEventListener(

"click",

()=>{

document.body.classList.toggle("light");

}

);

document
.getElementById("cityCount")
.innerText="25";

document
.getElementById("roadCount")
.innerText="60";

window.onload=function(){

    initMap();

}
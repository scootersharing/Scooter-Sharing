// Getting map API with Leaflet.js 

var mymap = L.map('map').setView([41.00605048498004, 39.73101109585673], 13);

 const attribution = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors';

 const tileUrl = 'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png';
 const tiles = L.tileLayer(tileUrl, { attribution });
 tiles.addTo(mymap);

// Fetching scooter infos from data.json file.

 function getData(){

    function ScooterNew (id, active, charge, lat, long) {
        this.scooterID = id;
        this.isActive = active;
        this.charge = charge;
        this.lat = lat;
        this.long = long;
    }

    var scootersData = [];

    $.getJSON("data.json", function (data) {

        for(let i = 0; i < data.length; i++) {

            scootersData [i] = new ScooterNew(
                data[i]["scooter_ID"], 
                data[i]["is_active"], 
                data[i]["charge"], 
                data[i]["latitude"], 
                data[i]["longitude"]
            );
                
            
        }
// Adding marker to the map through location infos from JSON file.      
        console.log(scootersData[0]["lat"]);
    
        for(let i = 0; i < scootersData.length; i++) {

            L.marker([scootersData[i]["lat"], scootersData[i]["long"]]).addTo(mymap);
            
           }
    });
 }




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
// Adding custom marker to the map through location infos from JSON file.
// 

var hamsyIcon = L.Icon.extend({
    options: {
        shadowUrl: 'image/Hamsi-icon.jpeg',
        iconSize:     [38, 95],
        shadowSize:   [50, 64],
        iconAnchor:   [22, 94],
        shadowAnchor: [4, 62],
        popupAnchor:  [-3, -76]
    }
});

var defaultIcon = new hamsyIcon({iconUrl: 'image/Hamsi-icon.jpeg'}),
    redIcon = new hamsyIcon({iconUrl: 'image/Hamsi-icon-low.jpg'}),
    yellowIcon = new hamsyIcon({iconUrl: 'image/Hamsi-icon-mid.jpg'});
    
        for(let i = 0; i < scootersData.length; i++) {

            console.log(scootersData[i]["charge"])

            switch(true) {
                
                case(scootersData[i]["charge"] < 10):
                L.marker([scootersData[i]["lat"],scootersData[i]["long"]], {icon: redIcon}).addTo(mymap).bindPopup("Bittum!");
                break;

                case(10 < scootersData[i]["charge"] < 20):
                L.marker([scootersData[i]["lat"],scootersData[i]["long"]], {icon: yellowIcon}).addTo(mymap).bindPopup("Bitiyrım!");
                break;

                default:
                L.marker([scootersData[i]["lat"],scootersData[i]["long"]], {icon: defaultIcon}).addTo(mymap).bindPopup("Gel gezelım ballim!");
            }   
        }
    });
}

    




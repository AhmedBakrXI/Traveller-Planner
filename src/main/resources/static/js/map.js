var map = L.map('map').setView([26.8206, 30.8025], 3);
const key = 'JAIrgQ3Wm2cZgks51HZC'

L.tileLayer('https://api.maptiler.com/maps/dataviz-dark/{z}/{x}/{y}.png?key=JAIrgQ3Wm2cZgks51HZC', {
    attribution: '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>',
    crossOrigin: true
}).addTo(map);

L.control.maptilerGeocoding({ apiKey: key }).addTo(map);

var marker;

var leafletIcon = L.icon({
    iconUrl: '../imgs/pin.png',
    iconSize: [32, 32], // Size of the icon
    iconAnchor: [16, 32], // Point of the icon which will correspond to marker's location
    popupAnchor: [0, -32] // Point from which the popup should open relative to the iconAnchor
});

map.on('click', function(e) {
    var lat = e.latlng.lat;  
    var lng = e.latlng.lng;  

    // Remove previous marker (if any)
    if (marker) {
        map.removeLayer(marker);
    }

    // Add a new marker at the clicked position
    marker = L.marker([lat, lng], {icon: leafletIcon}).addTo(map);

    // Perform reverse geocoding
    fetch(`https://api.maptiler.com/geocoding/${lng},${lat}.json?key=JAIrgQ3Wm2cZgks51HZC`)
    .then(response => response.json())
    .then(data => {
        // Extract country name from the JSON response
        var cityName = data.features[5].text;
        
        // Create a popup with the country name and attach it to the marker
        marker.bindPopup(cityName).openPopup();
    })
    .catch(error => {
        console.error('Error:', error);
    });
});




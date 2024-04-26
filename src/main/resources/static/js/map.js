var map = L.map('map').setView([26.8206, 30.8025], 3);
const key = 'JAIrgQ3Wm2cZgks51HZC'

L.tileLayer('https://api.maptiler.com/maps/dataviz-dark/{z}/{x}/{y}.png?key=JAIrgQ3Wm2cZgks51HZC', {
    attribution: '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>',
    crossOrigin: true
}).addTo(map);

L.control.maptilerGeocoding({ apiKey: key }).addTo(map);

var marker;

var defaultIcon  = L.icon({
    iconUrl: '../images/home_page/pin.png',
    iconSize: [32, 32], // Size of the icon
    iconAnchor: [16, 32], // Point of the icon which will correspond to marker's location
    popupAnchor: [0, -32] // Point from which the popup should open relative to the iconAnchor
});

var flagIcon = L.icon({ // Flag icon
    iconUrl: '../images/home_page/flag.png',
    iconSize: [32, 32],
    iconAnchor: [16, 32],
    popupAnchor: [0, -32]
});

    //var lat = e.latlng.lat;  
    //var lng = e.latlng.lng;  

    
var chosenMarker = null; // Variable to store the currently chosen marker
var chosenCity = null; // Variable to store the name of the chosen city

fetch('/api/city')
    .then(response => response.json())
    .then(data => {
        data.forEach(city => {
            var lat = city.lat;
            var lng = city.city_long;
            var city_name = city.cityName;
            var cityInfo = city.info;
            
            var marker = L.marker([lat, lng], { icon: defaultIcon }).addTo(map);

            // Event listener for marker click
            marker.on('click', function(e) {
                chosenCity = city_name; // Update chosenCity variable with the name of the clicked city
                // If another marker is already selected, revert its icon back to the default
                if (chosenMarker && chosenMarker !== marker) {
                    chosenMarker.setIcon(defaultIcon);
                }
                // Update the chosenMarker variable with the clicked marker
                chosenMarker = marker;
    
                if (marker.getIcon() === defaultIcon) {
                    marker.setIcon(flagIcon);
                } else {
                    marker.setIcon(defaultIcon);
                }
                // Toggle the icon between default and flag
            });
            marker.bindPopup(`<b>${city_name}</b><br>${cityInfo}`).openPopup();
        });
    })
    .catch(error => {
        console.error('Error:', error);
    });




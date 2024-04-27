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

// Fetch city data when the page loads
fetch('/api/city')
  .then(response => response.json())
  .then(data => {
    console.log("page loaded");
    data.forEach(city => {
      const lat = city.lat;
      const lng = city.city_long;
      const city_name = city.cityName;
      const cityInfo = city.info;

      const marker = L.marker([lat, lng], { icon: defaultIcon }).addTo(map);

      marker.bindPopup(`<b>${city_name}</b><br>${cityInfo}`).openPopup();

      // Event listener for marker click
      marker.on('click', function(e) {
        handleMarkerClick(city_name, marker);

        // Fetch accommodations data for the chosen city
        fetch('/api/accommodations', {
          method: 'POST',
          headers: {
            'Content-Type': 'text/plain', // Set the content type according to your API requirements
          },
          body: chosenCity,
        })
          .then(response => {
            if (!response.ok) {
              throw new Error('Network response was not ok');
            }
            return response.json();
          })
          .then(data => {
            // Clear previous accommodation elements
            document.getElementById('offcanvasAccommodations').innerHTML = '';

            // Assuming data is an array of accommodations objects
            data.forEach(accommodations => {
              // Create HTML elements to display accommodation information
              const accommodationElement = document.createElement('div');
              accommodationElement.innerHTML = `<div class="inner">
              <h1>${accommodations.hotel_name}</h1>
              <img src="${accommodations.image_url || 'images/home_page/hotel.jpg'}" alt="${accommodations.hotelName}">
              <p>Stars: ${accommodations.stars}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Price: ${accommodations.price}</p>
            </div>
              `;
              // Append the HTML elements to the accommodations sidebar
              document.getElementById('offcanvasAccommodations').appendChild(accommodationElement);
            });
          })
          .catch(error => {
            console.error('Error:', error);
          });


        // Fetch activities data for the chosen city
        fetch('/api/activities', {
          method: 'POST',
          headers: {
            'Content-Type': 'text/plain', // Set the content type according to your API requirements
          },
          body: chosenCity,
        })
          .then(response => {
            if (!response.ok) {
              throw new Error('Network response was not ok');
            }
            return response.json();
          })
          .then(data => {
            // Clear previous activities elements
            document.getElementById('offcanvasactivities').innerHTML = '';

            // Assuming data is an array of activities objects
            data.forEach(activities => {
              // Create HTML elements to display activities information
              const activityElement = document.createElement('div');
              activityElement.innerHTML = `<div class="inner">
              <h1>${activities.name}</h1>
              <img src="${activities.image || 'images/home_page/activity.jpg'}" alt="${activities.name}">
              <p>${activities.info}</p>
              <p>Price: ${activities.price}</p>
            </div>
              `;
              // Append the HTML elements to the activities sidebar
              document.getElementById('offcanvasactivities').appendChild(activityElement);
            });
          })
          .catch(error => {
            console.error('Error:', error);
          });
      });
    });
  })
  .catch(error => {
    console.error('Error:', error);
  });

// Function to handle marker click event
const handleMarkerClick = (city_name, marker) => {
  chosenCity = city_name; // Update chosenCity variable with the name of the clicked city

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
};

 
    







/*
var data = "sssssssssssss";
  fetch('/api/fake',{
    method: 'POST',
    headers: {
      'Content-Type': 'text/plain', // Set the content type according to your API requirements
    },
    body: data, 
  })  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {
    console.log(data);
    })
  .catch(error => {
    console.error('Error:', error);
  });
  */

// Initialize Leaflet map with a specified center and zoom level
var map = L.map('map').setView([26.8206, 30.8025], 3);

// API key for MapTiler services
const key = 'JAIrgQ3Wm2cZgks51HZC';

// Add MapTiler tile layer to the map
L.tileLayer('https://api.maptiler.com/maps/dataviz-dark/{z}/{x}/{y}.png?key=JAIrgQ3Wm2cZgks51HZC', {
    attribution: '<a href="https://www.maptiler.com/copyright/" target="_blank">&copy; MapTiler</a> <a href="https://www.openstreetmap.org/copyright" target="_blank">&copy; OpenStreetMap contributors</a>',
    crossOrigin: true
}).addTo(map);

// Add MapTiler Geocoding control to the map
L.control.maptilerGeocoding({ apiKey: key }).addTo(map);

// Variable to store the marker object
var marker;

// Define default icon properties for markers
var defaultIcon = L.icon({
    iconUrl: '../images/home_page/pin.png', // Path to the default icon image
    iconSize: [32, 32], // Size of the icon
    iconAnchor: [16, 32], // Point of the icon which will correspond to marker's location
    popupAnchor: [0, -32] // Point from which the popup should open relative to the iconAnchor
});

// Define flag icon properties for markers
var flagIcon = L.icon({
    iconUrl: '../images/home_page/flag.png', // Path to the flag icon image
    iconSize: [32, 32], // Size of the icon
    iconAnchor: [16, 32], // Point of the icon which will correspond to marker's location
    popupAnchor: [0, -32] // Point from which the popup should open relative to the iconAnchor
});

// Variable to store the currently chosen marker
var chosenMarker = null;

// Variable to store the name of the chosen city
var chosenCity = null;
// Fetch city data when the page loads
fetch('/api/city')
  .then(response => response.json())
  .then(data => {
    console.log("page loaded");
    data.forEach(city => {
      // Extract city data
      const lat = city.lat;
      const lng = city.city_long;
      const city_name = city.cityName;
      const cityInfo = city.info;

      // Create marker with city coordinates and default icon, and add it to the map
      const marker = L.marker([lat, lng], { icon: defaultIcon }).addTo(map);

      // Bind popup with city name and info to the marker, and open it by default
      marker.bindPopup(`<b>${city_name}</b><br>${cityInfo}`).openPopup();

      // Event listener for marker click
      marker.on('click', function(e) {
        // Handle marker click event
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
                console.log(accommodations.image);
                // Create HTML elements to display accommodation information
              const accommodationElement = document.createElement('div');
              accommodationElement.innerHTML = `<div class="inner">
              <h1>${accommodations.hotel_name}</h1>
              <img src="/images/accommodations/${accommodations.image}" alt="${accommodations.hotelName}">
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
        
          // Fetch local attractions data for the chosen city
          fetch('/api/local-attractions', {
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
            // Clear previous local attractions elements
            document.getElementById('offcanvasactivitieslocal').innerHTML = '';
        
            // Assuming data is an array of local attractions objects
            data.forEach(local=> {
                console.log("hey");
                // Create HTML elements to display information
              const localElement = document.createElement('div');
              localElement.innerHTML = `<div class="inner">
              <h1>${local.name}</h1>
              <img src="/images/Local Attractions/${local.image}" alt="${local.name}">
              <p>${local.info}</p>
            </div>
              `;
              // Append the HTML elements to the local attractions sidebar
              document.getElementById('offcanvasactivitieslocal').appendChild(localElement);
            });
          })
          .catch(error => {
            console.error('Error:', error);
          });

          // Fetch user city data
          var usercity = null;
          fetch('/api/usercity')
          .then(response => response.json())
          .then(data => { 
            usercity = data.cityName; // Extract cityName from the data object
            console.log(usercity); // Log the city name to the console
          })
          .catch(error => {
            console.error('Error:', error);
          });
        
          // Fetch flights data for the chosen city
           fetch('/api/flights', {
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
                console.log("flight");

                // Clear previous flights elements
              document.getElementById('offcanvasflights').innerHTML = '';
        
              // Assuming data is an array of flights objects
              data.forEach(flights => {
                console.log(flights);

                // Create HTML elements to display flights information
                const flightsElement = document.createElement('div');
                flightsElement.innerHTML = `<div class="inner">
                <h1>${flights.company}</h1>
                <p> from: ${flights.time_start} to ${flights.time_end} </p>
                <p> from: ${flights.cityName} to ${flights.destination} </p>
                <p>Price: ${flights.price}</p>
                <img src="/images/logo/${flights.logo}" alt="${flights.company}">
              </div>
                `;
                // Append the HTML elements to the flights sidebar
                document.getElementById('offcanvasflights').appendChild(flightsElement);
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
              <img src="/images/Activities/${activities.image}" alt="${activities.name}">
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
    // Update chosenCity variable with the name of the clicked city
    chosenCity = city_name;
  
    // If there is a chosenMarker and it's not the same as the clicked marker, reset its icon to default
    if (chosenMarker && chosenMarker !== marker) {
      chosenMarker.setIcon(defaultIcon);
    }
  
    // Update the chosenMarker variable with the clicked marker
    chosenMarker = marker;
  
    // Toggle the icon between default and flag
    if (marker.getIcon() === defaultIcon) {
      marker.setIcon(flagIcon);
    } else {
      marker.setIcon(defaultIcon);
    }
  };
  
 
    
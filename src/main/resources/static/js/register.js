// Get reference to the city select element and check for error message in the URL
const options = document.getElementById('city');
const url = new URL(window.location.href);
const errorMessage = url.searchParams.has('error');
const logHead = document.getElementById('log-head');

// Display error message if 'error' parameter exists in URL
if (errorMessage) {
    // Create HTML for error message
    const html =
        '<div class="input-box" style="align-items: center; color: #e12729;"><h2>Username not valid</h2></div>';
    // Insert error message after the log head element
    logHead.insertAdjacentHTML("afterend", html);
}

// Fetch city data from the server and populate the city select element
fetch('/api/city')
    .then(response => {
        // Check if response is successful (status code 200)
        if (!response.ok) {
            // Throw an error if response is not successful
            throw new Error('Failed to fetch data from the API');
        }
        // Parse JSON response
        return response.json();
    })
    .then(data => {
        // Extract city names from the data
        const cityNames = data.map(city => city.cityName);

        // Populate city select element with city names
        cityNames.forEach(cityName => {
            // Append option element with city name to the select element's HTML
            options.innerHTML += `
                <option value="${cityName}">${cityName}</option>
            `;
        });
    })
    .catch(error => {
        // Log any errors that occur during the fetch operation
        console.error('Error:', error);
    });

const options = document.getElementById('city');
const url = new URL(window.location.href);
const errorMessage = url.searchParams.has('error');
const logHead = document.getElementById('log-head');
if (errorMessage) {
    const html =
        '<div class="input-box" style="align-items: center; color: #e12729;"><h2>Username not valid</h2></div>';
    logHead.insertAdjacentHTML("afterend", html);
}

fetch('/api/city')
  .then(response => {
    // Check if response is successful (status code 200)
    if (!response.ok) {
      throw new Error('Failed to fetch data from the API');
    }
    // Parse JSON response
    return response.json();
  })
  .then(data => {
    // Extract city names
    const cityNames = data.map(city => city.cityName);

    // Print city names
    cityNames.forEach(cityName => {
      options.innerHTML += `
        <option value="${cityName}">${cityName}</option>
      `;
    });
  })
  .catch(error => {
    console.error('Error:', error);
  });

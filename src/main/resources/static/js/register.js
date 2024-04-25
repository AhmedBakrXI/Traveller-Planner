const options = document.getElementById('city');

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

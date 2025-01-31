// Function to fetch and display the random bear image
async function loadBearImage() {
    try {
        // Remove old image class
        const bearImage = document.getElementById('bearImage');
        bearImage.classList.remove('loaded');

        const response = await fetch('http://localhost:8080/rawr');
        const data = await response.json(); // Parse json
        console.log(data)
        const img = data.url; // "url" in the JSON is where img link is located
        const photographer = "Credit: " + data.photographer; // "photographer" in the JSON is where img link is located
        console.log('Fetched bear image:', img);

        // Update image source in HTML
        bearImage.src = img;
        // Update photographer name in HTML
        document.getElementById('photographerName').textContent = photographer;

        // Add fade-in animation to new image
        bearImage.onload = function() {
            fadeIn(bearImage);
        };
    } catch (error) {
        // TODO: Update both bearImage and photographerName to error images instead of nothing
        console.error('Error fetching bear image:', error);
    }
}

async function loadBearCount() {
    try {
        const response = await fetch('http://localhost:8080/floofs/count');
        const data = await response.json(); // Parse json
        console.log(data)
        const bearCount = data
        console.log('Fetched bear count:', bearCount);

        // Update bear count in the bottom left corner
        const bearCountElement = document.getElementById('bearCount');
        bearCountElement.textContent = bearCount + " immortal cubs";

    } catch (error) {
        console.error('Error fetching bear image:', error);
    }
}

// Add fade-in animation for bear image
function fadeIn(element) {
    element.classList.add('loaded');
}

// Check if the load button exists in the html before attaching an event listener
if (document.getElementById('loadButton')) {
    // Add event listener to button
    document.getElementById('loadButton').addEventListener('click', loadBearImage);
}

// Load a bear image on page
// Load bear count on page load
window.onload = function() {
    loadBearImage().then(r => console.log('Loaded Initial Bear Image') );
    loadBearCount().then(r => console.log('Loaded Bear Count') );
}
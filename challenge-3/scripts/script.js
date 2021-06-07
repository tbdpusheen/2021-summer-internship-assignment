// Searches for all elements with the 'image' class
const images = document.querySelectorAll('.image');
images.forEach(image => { // Adds a click event listener to every element, which opens the overlay
  image.addEventListener('click', function(){openOverlay(image.id)})
});

// Opens the overlay page depending on which image was clicked
function openOverlay(imageId) {
  switch(imageId) {
    case 'top-left-image':
      document.location.href = 'html/top-left-image.html';
      break;
    case 'top-right-image':
      document.location.href = 'html/top-right-image.html';
      break;
    case 'bottom-left-image':
      document.location.href = 'html/bottom-left-image.html';
      break;
    case 'bottom-right':
      document.location.href = 'html/bottom-right-image.html';
      break;
    default:
  }
}
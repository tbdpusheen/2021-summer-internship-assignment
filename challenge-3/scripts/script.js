window.onload = () => {
  // Searches for all elements with the 'image' class
  const images = document.querySelectorAll('.image');
  images.forEach(image => { // Adds a click event listener to every element which opens the overlay
    image.addEventListener('click', () => {
      // Opens the overlay page depending on which image was clicked
      switch(image.id) {
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
    });
  });

  // Adds a click event listener to the close button which closes the overlay
  const closeButton = document.querySelector('#close');
  if (closeButton != null) {
    closeButton.addEventListener('click', () => { document.location.href = '../index.html'; });
  }
};
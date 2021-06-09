window.onload = () => {
  linkImages();
  disableOverlayScrolling();
  setupClose();
};

// Disable scrolling on overlay pages.
function disableOverlayScrolling() {
  if (document.querySelector('#overlay') != null) {
    setInterval(() => {
      const html = document.querySelector('html');
      // Enable the scrollbar even without scrolling so as to preserve the width of the page
      // Only enable the scrollbar if it was supposed to be there already
      if (html.offsetHeight > window.innerHeight) {
        html.style.position = "fixed";
        html.style.overflowY = "scroll";
        html.style.width = "100%";
      } else {
        html.style.position = "";
        html.style.overflowY = "";
        html.style.width = "";
      }
    })
  }
}

// Links the images to their respective overlays
function linkImages() {
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
}

// Adds a click event listener to the close button which closes the overlay
function setupClose() {
  const closeButton = document.querySelector('#close');
  if (closeButton != null) {
    closeButton.addEventListener('click', () => { document.location.href = '../index.html'; });
  }
}

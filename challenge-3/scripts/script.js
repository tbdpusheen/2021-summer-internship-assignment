const images = document.querySelectorAll('.image');
images.forEach(image => {
  image.addEventListener('click', function(){openOverlay(image)})
});

function openOverlay(image) {
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
}
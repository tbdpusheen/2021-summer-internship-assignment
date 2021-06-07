const images = document.querySelectorAll('.image');
images.forEach(image => {
  image.addEventListener('click', function(){openOverlay(image)})
});

function openOverlay(image) {
  alert('test?');
}
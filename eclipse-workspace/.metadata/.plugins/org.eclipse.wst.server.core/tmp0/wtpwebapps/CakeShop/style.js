document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll('.cake-slider').forEach(function(slider) {
      slider.addEventListener('wheel', function(event) {
        event.preventDefault();
        slider.scrollLeft += event.deltaY;
      });
    });
  });
  
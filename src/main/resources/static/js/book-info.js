const toListButton = document.getElementById('to-list');

toListButton.addEventListener('click', function (e) {
    e.preventDefault();
    location.href = '/books';
})
const toRegisterFormButton = document.getElementById('back-button');

toRegisterFormButton.addEventListener('click', function (e) {
    e.preventDefault();
    location.href = '/';
})
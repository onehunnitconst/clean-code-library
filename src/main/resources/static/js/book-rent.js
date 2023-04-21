const toRegisterFormButton = document.getElementById('rent-button');

toRegisterFormButton.addEventListener('click', function (e) {
    e.preventDefault();
    location.href = '/rent';
})
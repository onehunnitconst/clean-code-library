const toRegisterFormButton = document.getElementById('register-form-button');

toRegisterFormButton.addEventListener('click', function (e) {
    e.preventDefault();
    location.href = '/register';
})
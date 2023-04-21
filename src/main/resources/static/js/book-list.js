const toRegisterFormButton = document.getElementById('to-register');



toRegisterFormButton.addEventListener('click', function (e) {
    e.preventDefault();
    location.href = '/books/register';
})
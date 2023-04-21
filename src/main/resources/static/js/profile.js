const id = getCookie('userId')
fetch('/api/v1/users/' + id)
    .then(function (res) { return res.json() })
    .then(function (res) {
        console.log(res);
        const { name } = res;
        const div = document.getElementById("profile");
        const profile = document.createElement("p");
        const logout = document.createElement("button");
        logout.innerText = "로그아웃";
        logout.onclick = function (e) {
            e.preventDefault();
            document.cookie = 'userId=; Max-Age=0'
            profile.innerHTML = '<p>로그아웃되었습니다. 새로고침하면 로그인 페이지로 이동합니다.</p>';
            div.removeChild(logout);
        }
        profile.innerHTML = `<b>${name}</b>님, 환영합니다!`
        div.appendChild(profile);
        div.appendChild(logout);
    });

function getCookie(name) {
    let matches = document.cookie.match(new RegExp(
        "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"
    ));
    return matches ? decodeURIComponent(matches[1]) : undefined;
}
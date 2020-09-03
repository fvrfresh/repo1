$(function () {
    document.onscroll=function (event) {
        $('.iconArea').remove();
    };
    $('body').click(function(){
        $('.iconArea').remove();
    });

});
function togglePhotoDiv(event) {

    if (document.querySelector('.iconArea')) {
        return false;
    }
    let contactPhoto = document.createElement('div');
    contactPhoto.classList.add('iconArea');
    $(contactPhoto).css({
        'position': 'fixed',
        'left': event.clientX - 105,
        'top': event.clientY + 50,
        'z-index': 88
    });
    $(contactPhoto).html('<div class="text-center" style="margin: 0 auto;height: 30px">\n' +
        '                                <a class="navbar-brand" href="javascript:;">\n' +
        '                                    <img src="images/1597999897180.jpg" th:src="@{/images/1597999897180.jpg}"\n' +
        '                                         alt="qq二维码" width="100px" height="100px"\n' +
        '                                         class="d-inline-block align-top"\n' +
        '                                         loading="lazy">\n' +
        '                                </a>\n' +
        '                                <a class="navbar-brand mr-0" href="javascript:;">\n' +
        '                                    <img src="images/1597998093365.png" th:src="@{/images/1597998093365.png}"\n' +
        '                                         alt="微信二维码" width="100px" height="100px"\n' +
        '                                         class="d-inline-block align-top"\n' +
        '                                         loading="lazy">\n' +
        '                                </a>\n' +
        '                            </div>');
    event.target.parentElement.parentElement.parentElement.appendChild(contactPhoto);
    event.stopPropagation();
}

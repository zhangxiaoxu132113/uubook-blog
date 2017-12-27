var navTimer = [];
(function ($) {
    $(".art_navmore").mouseover(function () {
        if (!$(this).hasClass("hover")) {
            $(this).addClass("hover");
            $(this).find("#drop_nav").stop(true, true).slideDown(230);
        }
        window.clearTimeout(navTimer[0], navTimer[00]);
    }).mouseleave(function () {
        if ($(this).hasClass("hover")) {
            var _this = this;
            navTimer[0] = window.setTimeout(function () {
                $(_this).find("#drop_nav").stop(true, true).slideUp(150);
            }, 300);
            navTimer[00] = window.setTimeout(function () {
                $(_this).removeClass("hover");
            }, 450);
            return false;
        }
    });

    //top tool end
})(jQuery);

function setUserLoginFrame() {
    $('#userinfo_box').bind('click', function () {
        if ($('.dl_box').css('display') == 'none') {
            $('.dl_box').stop(true, true).slideDown("slow");
            window.clearTimeout(navTimer[2], navTimer[22]);
        } else {
            $('.dl_box').stop(true, true).slideUp("slow");
        }
    });

    $("#userinfo_box").find("em,.UIbox").mouseover(function () {
        alert("h")
        if (!$("#userinfo_box").hasClass("h")) {
            $("#userinfo_box").addClass("h");
            $("#userinfo_box").find(".UIbox").stop(true, true).slideDown(slow);
        }
        window.clearTimeout(navTimer[2], navTimer[22]);
    });
    $("#userinfo_box").mouseleave(function () {
        if ($(this).hasClass("h")) {
            var _this = this;
            navTimer[2] = window.setTimeout(function () {
                $(_this).find(".UIbox").stop(true, true).slideUp(150);
            }, 300);
            navTimer[22] = window.setTimeout(function () {
                $(_this).removeClass("h");
            }, 450);
            return false;
        }
    });

    $(".n_msgs").find("em,.msgs_box").mouseover(function () {
        if (!$(".n_msgs").hasClass("h")) {
            $(".n_msgs").addClass("h");
            $(".n_msgs").find(".msgs_box").stop(true, true).slideDown(230);
        }
        window.clearTimeout(navTimer[3], navTimer[33]);
    });
    $(".n_msgs").mouseleave(function () {
        if ($(".n_msgs").hasClass("h")) {
            var _this = $(".n_msgs");
            navTimer[3] = window.setTimeout(function () {
                _this.find(".msgs_box").stop(true, true).slideUp(150);
            }, 300);
            navTimer[33] = window.setTimeout(function () {
                _this.removeClass("h");
            }, 450);
            return false;
        }
    });

    var userinfoWidth = $(".n_userinfo em a").width();
    if (userinfoWidth - 100 > 0) {
        $(".n_userinfo em a").css("width", "100px");
    }
}

// 定义回调方法
var TopLoginCallback = function (cbtype, data) {
    if (cbtype == "login") {
        if (data.Success) {
            // 登录成功
            window.location.reload();
            return;
        }
    }
    if (cbtype == "qq") {
        window.location.reload();
        return;
    } else if (cbtype == "weibo") {
        window.location.reload();
        return;
    }
}

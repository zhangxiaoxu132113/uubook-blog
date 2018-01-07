jQuery(function ($) {
    $('[data-slidizle]').slidizle({
        beforeChange: function (api) {
        }
    });

    $("ul.tabClick li").hover(function () {
        $(this).addClass("active").siblings().removeClass("active"); //切换选中的按钮高亮状态
        var index = $(this).index(); //获取被按下按钮的索引值，需要注意index是从0开始的
        $('.lineDiv').css('margin-left', (index * 140) + 'px');
        $(".tabBox > div").eq(index).show().siblings().hide(); //在按钮选中时在下面显示相应的内容，同时隐藏不需要的框架内容
    });

    $(window).scroll(function () {
        var height = $('#header').height() + $('#category-nav').height() + $('#view-info').height() + $('#long-ad').height() + 30;
        if ($(window).scrollTop() >= height) {
            $('.tabClick').addClass('nav-fixed');
        } else {
            $('.tabClick').removeClass("nav-fixed");
        }
    });

    if ('ontouchstart' in window) {
        var click = 'touchstart';
    } else {
        var click = 'click';
    }
    $('span.person-nav').on(click, function () {
        if (!$(this).hasClass('open')) {
            openMenu();
        } else {
            closeMenu();
        }
    });
    $('span.search-btn').on(click, function () {
        if (!$('.search_panel').hasClass('search_panel_animails')) {
            $('.search_panel').addClass('search_panel_animails');
        } else {
            $('.search_panel').removeClass('search_panel_animails');
        }
    });
    $('div.menu ul li a').on(click, function (e) {
        e.preventDefault();
        closeMenu();
    });
    function openMenu() {
        $('span.person-nav').addClass('open');
        $('div.screen').addClass('animate');
        setTimeout(function () {
            $('div.x').addClass('rotate30');
            $('div.z').addClass('rotate150');
            $('.menu').addClass('animate');
            setTimeout(function () {
                $('div.x').addClass('rotate45');
                $('div.z').addClass('rotate135');
            }, 100);
        }, 10);

        //禁止屏幕滚动
        $("body,html").css({"overflow": "hidden"});
    }
    function closeMenu() {
        $('div.screen, .menu').removeClass('animate');
        $('span.person-nav').removeClass('open');
        $("body,html").css({"overflow": "auto"});
    }
});
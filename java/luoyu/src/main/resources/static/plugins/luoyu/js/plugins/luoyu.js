var $modal = {
    params: function (params) {
        return {
            'id': $.fn.uuid(),
            'title': params.title || '',
            'url': params.url || '',
            'z-index': 100
        };
    },
    openModalDialog: function (target, params) {
        let _param = this.params(params);
        let $dialog = $(this.defaultModalDialog(_param));
        $dialog.modal({keyboard: false});
        $dialog.on('hidden.bs.modal', function (e) {
            $dialog.remove();
        });
        $.fn.loading.loading();
        $.ajax({
            url: _param.url,
            type: 'post',
            timeout: 30,
            async: false,
            cache: false,
            // dataType: 'text/html',
            success: function(data){
                $.fn.loading.unloading();
                setTimeout(function () {
                    $('div.modal-body', $dialog).html(data);
                    var _$dialog = $('.modal-content','div#' + _param.id);
                    var m_top = (document.body.clientHeight - _$dialog.height()) / 2;
                    $dialog.css({'top': m_top});
                }, 500);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.loading.unloading();
            }
        })
    },
    defaultModalDialog: function (param) {
        const root = document.createElement('div');
        root.setAttribute('tabindex', '-1');
        root.setAttribute('role', 'dialog');
        root.setAttribute('data-backdrop', 'static');
        root.setAttribute('aria-labelledby', 'ModalLable' + param.id);
        root.setAttribute('class', 'modal fade text-center');
        root.setAttribute('style', 'align-items:center;');
        root.setAttribute('id', param.id);
        document.getElementsByClassName('modal-list')[0].appendChild(root);

        var dialog = document.createElement('div');
        dialog.setAttribute('class','modal-dialog');
        dialog.setAttribute('role','document');
        dialog.setAttribute('style','display:inline-block;width:auto;');
        root.appendChild(dialog);

        var content = document.createElement('div');
        content.setAttribute('class','modal-content');
        dialog.appendChild(content);

        var header = document.createElement('div');
        header.setAttribute('class','modal-header');
        header.setAttribute('style','text-align:left !important;;');
        content.appendChild(header);

        var button = document.createElement('button');
        button.setAttribute('type','button');
        button.setAttribute('data-dismiss','modal');
        button.setAttribute('aria-label','Close');
        button.setAttribute('class','close');
        header.appendChild(button);

        var span = document.createElement('span');
        span.setAttribute('aria-hidden','true');
        span.innerText = '×';
        button.appendChild(span);


        var h4 = document.createElement('h4');
        h4.setAttribute('class','modal-title');
        h4.setAttribute('id','ModalLable' + param.id);
        h4.innerText = param.title + '：';
        header.appendChild(h4);

        var body = document.createElement('div');
        body.setAttribute('class','modal-body');
        body.innerText = '正在加载中...';
        content.appendChild(body);
        return root;
    }
};

var $alert = {
    alert: function(msg, callback){
        let $dialog = $(this._dialog(msg,'警告'));
        $dialog.modal({keyboard: false});
        let _$dialog = $('.modal-content',$dialog);
        let m_top = (document.body.clientHeight - _$dialog.height()) / 3;
        $dialog.css({'top': m_top});
        $dialog.on('hidden.bs.modal', function (e) {
            $dialog.remove();
        });
        $dialog.modal('show');
    },
    tip: function (msg, callback) {
        let $dialog = $(this._dialog(msg,'提示'));
        $dialog.modal({keyboard: false});
        let _$dialog = $('.modal-content',$dialog);
        let m_top = (document.body.clientHeight - _$dialog.height()) / 3;
        $dialog.css({'top': m_top});
        $dialog.on('hidden.bs.modal', function (e) {
            $dialog.remove();
        });
        let timeout = setTimeout(function (){
            clearTimeout(timeout);
            $dialog.modal('toggle');
            if (typeof callback === 'function') {
                callback();
            }
        },1000);
    },
    confirm: function(msg,callback1,cakkback2){

    },
    _dialog: function (msg,title){
        let dialogId = UUID();
        const root = document.createElement('div');
        root.setAttribute('tabindex', '-1');
        root.setAttribute('role', 'dialog');
        root.setAttribute('data-backdrop', 'static');
        root.setAttribute('aria-labelledby', 'Dialog' + dialogId);
        root.setAttribute('class', 'modal fade text-center');
        root.setAttribute('style', 'align-items:center;');
        root.setAttribute('id', dialogId);
        document.getElementsByClassName('modal-list')[0].appendChild(root);

        let dialog = document.createElement('div');
        dialog.setAttribute('class','modal-dialog');
        dialog.setAttribute('role','document');
        dialog.setAttribute('style','display:inline-block;width:auto;');
        root.appendChild(dialog);

        let content = document.createElement('div');
        content.setAttribute('class','modal-content');
        content.setAttribute('style','min-width:350px;text-align:left;');
        dialog.appendChild(content);

        let header = document.createElement('div');
        header.setAttribute('class','modal-header');
        header.setAttribute('style','text-align:left !important;padding:5px;');
        content.appendChild(header);

        let h4 = document.createElement('span');
        h4.setAttribute('style','font-size:x-large;padding-left:10px;');
        h4.setAttribute('class','modal-title');
        h4.setAttribute('id','Dialog' + dialogId);
        h4.innerHTML = '<img style="height: 23px;" src="plugins/luoyu/static/svg/allow-32.svg" alt=""/>';
        header.appendChild(h4);

        let span2 = document.createElement('span');
        span2.setAttribute('style','font-size:17px;padding-left:5px;');
        span2.innerText = title+'：'
        header.appendChild(span2);

        let body = document.createElement('div');
        body.setAttribute('class','modal-body');
        body.setAttribute('style','font-size:20px;');
        body.innerText = msg;
        content.appendChild(body);
        return root;
    }
};

const $body = $('body');
$body.on('click', '.logout', function (ev) {
    $modal.openModalDialog(ev, {'url':'dialog.html','title':'提示'});
    ev.preventDefault();
    return false;
});
$body.on('click', 'a[target="tab"]', function (ev) {
    ev.preventDefault();
    return false;
});

+function ($) {
    'use strict';
    const $menuDiv = $('div.nav-menu'),$menuUl= $('ul#ul_menu',$menuDiv), loadMenuUrl = 'system/menu/loginUserMenu';
    let $navMenu = {
        _getliLevelNum: function ($li) {
            return parseInt($li.attr('class').replace(/[a-zA-Z_\- ]/ig,''));
        },
        initMenu: function () {
            let userMenus = this._getUserMenus();
            const levelPrefix = 'level_';
            let menuEmpty = true;
            $.each(userMenus, function (index, element) {
                let _li = document.createElement('li');
                _li.setAttribute('id', element.id);
                _li.setAttribute('rel', element.rel);
                _li.setAttribute('title', element.title);
                _li.style.cursor = 'pointer';
                let _a = document.createElement('a');
                _a.setAttribute('href', (element.href !== '#') ? element.href : '#');
                _a.setAttribute('rel', element.code);
                let _icon = document.createElement('i');
                _icon.setAttribute('aria-hidden', 'true');
                _icon.className = 'fa fa-lg ' + element.icon;
                _a.appendChild(_icon);
                let span = document.createElement('span');
                span.textContent = element.title;
                _a.appendChild(span);
                _li.appendChild(_a);
                if (element.childFlag === true) {
                    let _childIcon = document.createElement('i');
                    _childIcon.className = 'fa fa-angle-left';
                    _childIcon.setAttribute('aria-hidden', 'true');
                    _childIcon.style.float = 'right';
                    _childIcon.style.paddingRight = '7px';
                    _a.appendChild(_childIcon);
                }
                if (element.level === 1) {
                    _li.className = 'level_1 closed' + (element.childFlag === true ? ' has-child' :'');
                } else {
                    _li.className = 'level_' + element.level + ' ' + (element.childFlag ? 'closed' : '');
                    _li.style.display = 'none';
                }
                if (element.level === 1 && menuEmpty) {
                    $menuUl.append($((_li)));
                    menuEmpty = false;
                    return true;
                }
                let $rel = $('li[rel="' + element.rel + '"]');
                if ($rel.length > 0) {
                    $rel.last().after(_li);
                } else {
                    $('li#' + element.rel).after(_li);
                }


            });
        },
        _getUserMenus: function () {
            let menus;
            $.ajax({
                url: loadMenuUrl,
                type: 'post',
                timeout: 30,
                async: false,
                cache: false,
                success: function(data){
                    menus = data;
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    menus = [];
                }
            })
            return menus;
        },
        bindEvent: function (){
            $navMenu.initMenu();
            $menuDiv.on('click', '#ul_menu li a', function (event) {
                event.preventDefault();
            });
            $menuDiv.on('click', '#ul_menu li', function () {
                let levelNum = this.className.replace(/[a-zA-Z_\- ]/ig,''),
                    $li = $(this), hasChild = $li.hasClass('has-child'),
                    operate = $li.hasClass('closed') ? 'opened' : 'closed',$lastli = $('li.current');
                $('li.current', $menuDiv).removeClass('current');
                $li.removeClass($li.hasClass('opened') ? 'opened' : 'closed');
                $li.addClass('current');
                if (!hasChild) {
                    if ($li.attr('rel') !== $lastli.attr('rel') && !$lastli.hasClass('has-child')) {
                        $('li[rel="' + $lastli.attr('rel') + '"]').css('display', 'none');
                        let _$li = $('li#' + $lastli.attr('rel'));
                        if (_$li.hasClass('has-child')) {
                            _$li.removeClass('opened').addClass('closed');
                        }
                        _$li.find('i:last').removeClass('fa-angle-down').addClass('fa-angle-left');
                    }
                    $navTab.openTab($navTab.getTabModel($li));
                    return false;
                } else {
                    $li.addClass(operate);
                    let $childIcon = $li.find('i:last'),open = operate === 'opened';
                    $childIcon.removeClass(open ? 'fa-angle-left' : 'fa-angle-down').addClass(!open ? 'fa-angle-left' : 'fa-angle-down');
                    if ($navMenu._getliLevelNum($li) === 1) {
                        $.each($('li.opened', $menuDiv), function(index, element){
                            let _$li = $(element);
                            if (!$li.is(_$li) && _$li.hasClass('has-child')) {
                                _$li.find('i:last').removeClass('fa-angle-down').addClass('fa-angle-left');
                                _$li.removeClass('opened').addClass('closed');
                            }
                        })
                        $childIcon.addClass(!open ? 'fa-angle-left' : 'fa-angle-down');
                        $('li.level_2', $menuDiv).css('display', 'none');
                        $('li.level_3', $menuDiv).css('display', 'none');
                        $('li.level_4', $menuDiv).css('display', 'none');
                        $('li.level_5', $menuDiv).css('display', 'none');
                        $('li[rel="' + $li.attr('id') + '"]', $menuDiv).css('display', open ? 'block' : 'none');
                    } else {
                        if ($lastli.hasClass('has-child') && $navMenu._getliLevelNum($lastli) === parseInt(levelNum)) {
                            $('li[rel="' + $lastli.attr('id') + '"]', $menuDiv).css('display', open ? 'none' : 'block');
                            if ($lastli.hasClass('has-child')) {
                                $lastli.find('i:last').removeClass('fa-angle-down').addClass('fa-angle-left');
                                $lastli.removeClass('opened').addClass('closed');
                            }
                        } else if ($navMenu._getliLevelNum($lastli) - parseInt(levelNum) === 1) {
                            $('li[rel="' + $lastli.attr('rel') + '"]').css('display', 'none');
                            let _$li = $('li#' + $lastli.attr('rel'));
                            if (_$li.hasClass('has-child')) {
                                _$li.removeClass('opened').addClass('closed');
                            }
                            _$li.find('i:last').removeClass('fa-angle-down').addClass('fa-angle-left');
                        }
                        $('li[rel="' + $li.attr('id') + '"]', $menuDiv).css('display', open ? 'block' : 'none');

                    }
                }
            });
        }

    };
    $navMenu.bindEvent();
}(jQuery);

function TabModel(){
    return {id:'', title:'', href:'', pid:'', active: false}
}

let $navTab = {
    cacheTabs :new Map(),
    currentTab: null,
    navTabHeader: $('ul#tab-list'),
    navTabContent:$('div#navTabContent'),
    openTab: function  (tabModel) {
        if (tabModel.href === '#') {
            return false;
        }
        if (this.cacheTabs.has(tabModel.id)) {
            let _$navtabHeader = $('a[aria-controls="tab_' + tabModel.id + '"]', $navTab.navTabHeader);
            let _$navtabContent = $('div#tab_' + tabModel.id, $navTab.navTabContent);
            if (_$navtabHeader && _$navtabContent) {
                $('li.active', $navTab.navTabHeader).removeClass('active');
                $('div.active', $navTab.navTabContent).removeClass('active');
                _$navtabHeader.parent().addClass('active');
                _$navtabContent.addClass('active');
                $navTab.refreshTab(tabModel.id);
            }
        } else {
            this.cacheTabs.set(tabModel.id, tabModel);
            $('li.active', this.navTabHeader).removeClass('active');
            this.navTabHeader.append('<li role="presentation" class="active"><a href="#tab_' + tabModel.id + '" aria-controls="tab_' + tabModel.id + '" role="tab" data-toggle="tab">' + tabModel.title + '</a></li>');
            $('div.active', this.navTabContent).removeClass('active');
            this.navTabContent.append('<div role="tabpanel" class="tab-pane active" id="tab_' + tabModel.id + '">加载中</div>');
            $.fn.loading.loading();
            $.ajax({
                url: tabModel.href,
                type: 'post',
                timeout: 30,
                cache: false,
                success: function (data) {
                    $.fn.loading.unloading();
                    $($('div#tab_' + tabModel.id), $navTab.navTabContent).html(data);
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    $.fn.loading.unloading();
                    if (XMLHttpRequest.status === 404) {
                        $($('div#tab_' + tabModel.id), $navTab.navTabContent).html('未找到请求资源！');
                    }
                },
                complete: function( xhr,data ){
                    // 获取相关Http Response header
                    /*
                    cacheControl: null
                    connection: null
                    contentEncoding: null
                    contentLength: "92"
                    contentType: "text/html"
                    date: "Sat, 26 Sep 2020 14:40:09 GMT"
                    exprires: null
                    lastModified: null
                    server: null
                    transferEncoding: null
                    vary: "origin"
                    * */
                    var wpoInfo = {
                        // 服务器端时间
                        "date" : xhr.getResponseHeader('Date'),
                        // 如果开启了gzip，会返回这个东西
                        "contentEncoding" : xhr.getResponseHeader('Content-Encoding'),
                        // keep-alive ？ close？
                        "connection" : xhr.getResponseHeader('Connection'),
                        // 响应长度
                        "contentLength" : xhr.getResponseHeader('Content-Length'),
                        // 服务器类型，apache？lighttpd？
                        "server" : xhr.getResponseHeader('Server'),
                        "vary" : xhr.getResponseHeader('Vary'),
                        "transferEncoding" : xhr.getResponseHeader('Transfer-Encoding'),
                        // text/html ? text/xml?
                        "contentType" : xhr.getResponseHeader('Content-Type'),
                        "cacheControl" : xhr.getResponseHeader('Cache-Control'),
                        // 生命周期？
                        "exprires" : xhr.getResponseHeader('Exprires'),
                        "lastModified" : xhr.getResponseHeader('Last-Modified')
                    };
                    // 在这里，做想做的事。。。
                },
                statusCode: {
                    401: function() {
                        alert('登录失效，请重新登录');
                        window.location.href = "login.html";
                    },
                    504: function() {
                        alert('数据获取/输入失败，服务器没有响应。504');
                    },
                    500: function() {
                        alert('服务器有误。500');
                    }
                }

            });
        }
    },
    getTabModel:function ($li) {
        let tabModel = new TabModel();
        tabModel.id = $li.find('a').attr('rel') || $.fn.uuid();
        tabModel.title = $li.attr('title');
        tabModel.href = $li.find('a').attr('href');
        tabModel.pid = '';
        tabModel.active = true;
        tabModel.href += ((tabModel.href.indexOf('?') === -1) ? '?' : '&') + ('_=' + new Date().getTime());
        return tabModel;
    },
    closeTab:function(tabId){
        tabId = tabId || $navTab.getCurrentTab().id;
        if (tabId === 'home') {
            return false;
        }
        $('a[href="#tab_' + tabId +'"]', this.navTabHeader).parent().remove();
        $('div#tab_' + tabId, this.navTabContent).remove();
        $navTab.cacheTabs.delete(tabId);
        tabId = $('div[role="tabpanel"]',this.navTabContent).last().attr('id');
        tabId = tabId.substring(4);
        $('a[href="#tab_' + tabId +'"]', this.navTabHeader).parent().addClass('active');
        $('div#tab_' + tabId, this.navTabContent).addClass('active');
    },
    refreshTab: function (tabId) {
        tabId = tabId || $navTab.getCurrentTab().id;
        let tabModel = $navTab.cacheTabs.get(tabId);
        $.fn.loading.loading();
        $.ajax({
            url: tabModel.href,
            type: 'post',
            timeout: 30,
            cache: false,
            success: function (data) {
                $.fn.loading.unloading();
                $($('div#tab_' + tabModel.id), $navTab.navTabContent).html(data);
            },
            error: function (XMLHttpRequest, textStatus, errorThrown) {
                $.fn.loading.unloading();
                if (XMLHttpRequest.status === 404) {
                    $($('div#tab_' + tabModel.id), $navTab.navTabContent).html('未找到请求资源！');
                }

            },
            complete: function( xhr,data ){
                // 获取相关Http Response header
                var wpoInfo = {
                    // 服务器端时间
                    "date" : xhr.getResponseHeader('Date'),
                    // 如果开启了gzip，会返回这个东西
                    "contentEncoding" : xhr.getResponseHeader('Content-Encoding'),
                    // keep-alive ？ close？
                    "connection" : xhr.getResponseHeader('Connection'),
                    // 响应长度
                    "contentLength" : xhr.getResponseHeader('Content-Length'),
                    // 服务器类型，apache？lighttpd？
                    "server" : xhr.getResponseHeader('Server'),
                    "vary" : xhr.getResponseHeader('Vary'),
                    "transferEncoding" : xhr.getResponseHeader('Transfer-Encoding'),
                    // text/html ? text/xml?
                    "contentType" : xhr.getResponseHeader('Content-Type'),
                    "cacheControl" : xhr.getResponseHeader('Cache-Control'),
                    // 生命周期？
                    "exprires" : xhr.getResponseHeader('Exprires'),
                    "lastModified" : xhr.getResponseHeader('Last-Modified')
                };
                // 在这里，做想做的事。。。
            },
            statusCode: {
                401: function() {
                    alert('登录失效，请重新登录');
                    window.location.href = "login.html";
                },
                504: function() {
                    alert('数据获取/输入失败，服务器没有响应。504');
                },
                500: function() {
                    alert('服务器有误。500');
                }
            }

        });
    },
    closeOtherTab: function (){

    },
    getCurrentTab: function (){
        let tabId = $('div.active[role="tabpanel"]',$navTab.navTabContent).attr('id').substring(4);
        return $navTab.cacheTabs.get(tabId);
    },

    init:function () {
        //页面文档对象注册上下文（右键）菜单事件
        $(document).on("contextmenu",'#tab-list li',function(event){
            let pageX = event.pageX;//鼠标单击的x坐标
            let pageY = event.pageY;//鼠标单击的y坐标
            //获取菜单
            var contextMenu = $("#navTabMenu");
            var cssObj = {
                top:pageY+"px",//设置菜单离页面上边距离，top等效于y坐标
                left:pageX+"px"//设置菜单离页面左边距离，left等效于x坐标
            };
            //判断横向位置（pageX）+自定义菜单宽度之和，如果超过页面宽度及为溢出，需要特殊处理；
            var menuWidth = contextMenu.width();
            var pageWidth = $(document).width();
            if(pageX+contextMenu.width()>pageWidth){
                cssObj.left = pageWidth-menuWidth-5+"px"; //-5是预留右边一点空隙，距离右边太紧不太美观；
            }
            //设置菜单的位置
            contextMenu.css(cssObj).show();//显示使用淡入效果,比如不需要动画可以使用show()替换;
            event.preventDefault();//阻止浏览器与事件相关的默认行为；此处就是弹出右键菜单
        });
        let $navTabMenu = $("#navTabMenu");
        $('a.refreshCurrentTab').on('click', function () {
            $navTabMenu.hide();
            $navTab.refreshTab();
        });
        $('a.closeCurrentTab').on('click', function () {
            $navTabMenu.hide();
            $navTab.closeTab();
        });
        $('a.closeOtherTab').on('click', function () {
            $navTabMenu.hide();
            $navTab.closeOtherTab();
        });
        $body.on('click', function (){
            if ($navTabMenu.css('display') !== 'none') {
                $navTabMenu.hide();
            }
        });
        let tabModel = new TabModel();
        tabModel.id = 'home';
        tabModel.title = '首页';
        tabModel.href = 'home' + '?_=' + (new Date().getTime());
        tabModel.pid = '';
        tabModel.active = true;
        $navTab.openTab(tabModel);
        $(document).on('click','tr:gt(0)', function () {
            // 找到checkbox对象
            var chks = $("input[type='checkbox']",this);
            var tag = $(this).attr("tag");
            if(tag==="selected"){
                // 之前已选中，设置为未选中
                $(this).attr("tag","");
                chks.prop("checked",false);
            }else{
                // 之前未选中，设置为选中
                $(this).attr("tag","selected");
                chks.prop("checked",true);
            }
            let $table = $(this).parents('table.table');
            var checked = $table.find('input[name="ids"]:checked').length === $table.find('input[name="ids"]').length;
            $table.find('input[group=ids]').prop('checked', checked);
        });
        $(document).on('click','input[group=ids]', function () {
            let $checkbox = $(this);
            let $table = $checkbox.parents('table.table'), $trs = $table.find('tr:gt(0)');
            let $checkboxes = $table.find('input[name="ids"]').prop('checked');
            if ($checkbox.prop('checked')) {
                $trs.attr("tag","selected");
                $trs.find('input[name="ids"]').prop('checked', true);
            } else {
                $trs.attr("tag","");
                $trs.find('input[name="ids"]').prop("checked",false);
            }
        });
    }
};


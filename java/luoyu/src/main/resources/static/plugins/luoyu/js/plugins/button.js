/**
 * 按钮组件
 */
(function (){
    /**
     * 按钮默认点击事件
     */
    let defaultClick = {
        newClick: function (event) {
            let $el = $(this), checkboxes = $el.parents('.content').find('input[name=ids]:checked');
            if ($el.attr('multipleFlag') === 'false' && checkboxes.length !== 1) {
                alert(message.selectOne);
            }
            alert('new-' + event.type);
        },
        openClick: function () {
            let $el = $(this), checkboxes = $el.parents('.content').find('input[name=ids]:checked');
            if ($el.attr('multipleFlag') !== undefined && $el.attr('multipleFlag') === 'false' && checkboxes.length !== 1) {
                alert(message.selectOne);
                return false;
            }
            alert('open');
        },
        deleteClick: function () {
            let $el = $(this), checkboxes = $el.parents('.content').find('input[name=ids]:checked');
            if ($el.attr('multipleFlag') === 'false' && checkboxes.length !== 1) {
                alert(message.selectOne);
                return false;
            }
            alert('delete');
        },
        refreshClick: function () {
            alert('refresh');
        },
        searchClick: function () {
            alert('search');
        }
    }
    /**
     * 按钮默认配置
     * @type {{refreshBtn: {enable: boolean, icon: string, text: string, click: defaultClick.refreshClick, url: string, target: string}, openBtn: {enable: boolean, icon: string, multiple: boolean, text: string, click: (function(): (boolean|undefined)), url: string, target: string}, newBtn: {enable: boolean, icon: string, text: string, click: defaultClick.newClick, url: string, target: string}, searchBtn: {enable: boolean, icon: string, text: string, click: defaultClick.searchClick, url: string, target: string}, deleteBtn: {enable: boolean, icon: string, multiple: boolean, text: string, click: (function(): (boolean|undefined)), url: string, target: string}}}
     */
    let defaultSetting = {
        newBtn:{
            icon: '',
            enable: false,
            text: '新建',
            target: 'dialog',
            url: '',
            click: defaultClick.newClick
        },
        openBtn: {
            icon: '',
            enable: false,
            text: '打开',
            target: 'dialog',
            url: '',
            multiple: true,
            click: defaultClick.openClick
        },
        deleteBtn: {
            icon: '',
            enable: false,
            text: '删除',
            target: 'dialog',
            url: '',
            multiple: true,
            click: defaultClick.deleteClick
        },
        refreshBtn: {
            icon: '',
            enable: false,
            text: '刷新',
            target: '',
            url: '',
            click: defaultClick.refreshClick
        },
        searchBtn: {
            icon: '',
            enable: false,
            text: '查询',
            target: '',
            url: '',
            linkDiv:'',
            click: defaultClick.searchClick
        }
    };
    let HTML = {
        default: '<button type="button" class="button"></button>'
    }
    /**
     * 默认提示语
     */
    let message = {
        selectOne: '请选择一条数据！',
        deleteAll: '确认删除选中记录吗？该操作不可恢撤销！'
    }
    function addButton (button, _btnSetting, type) {
        button.text(_btnSetting.text);
        button.attr('target', _btnSetting.target);
        if (defaultSetting[type].multiple !== undefined) {
            button.attr('multipleFlag', (_btnSetting.multiple === true) ? 'true' : 'false');
        }
        if (!$.fn.isnull(_btnSetting.url)) {
            button.attr('href', _btnSetting.url);
        }
        button.on('click', _btnSetting.click || defaultSetting[val.type].click);
    }
    function getBtnSetting(_params){
        if (typeof defaultSetting[_params.type] !== 'undefined') {
            return jQuery.extend(true, {}, defaultSetting[_params.type], _params);
        }
        return null;

    }
    jQuery.fn.addButton = function (settings) {
        let that = $(this);
        that.css('padding', '10px 0 10px 0');

        jQuery.each(settings, function(index, val){
            if (val.enable && defaultSetting.hasOwnProperty(val.type)) {
                let button = $(HTML.default);
                let btnSetting = getBtnSetting(val);
                addButton(button, btnSetting, val.type);
                that.append(button);
            }
        });
    }
})(jQuery);
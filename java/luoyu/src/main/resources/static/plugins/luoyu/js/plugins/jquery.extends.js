$.fn.uuid = function () {
    function S4() {
        return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
    }
    return (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
}
$.fn.loading =  {
    loading: function (){
        let $modalList = $('div.modal-list');
        let _$loading = $('div#loading', $modalList);
        _$loading.modal({keyboard: false});
        let _$dialog = $('.modal-content',_$loading);
        let m_top = (document.body.clientHeight - _$dialog.height()) / 3;
        _$loading.css({'top': m_top});
        _$loading.modal('show');
    },
    unloading: function () {
        let $modalList = $('div.modal-list');
        let _$loading = $('div#loading', $modalList);
        _$loading.modal('hide')
    }
}
$.fn.isnull = function (object) {
    return object === null || typeof object === 'undefined' || object.length === 0;
}
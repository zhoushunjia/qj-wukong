/**
 * 初始化客户管理详情对话框
 */
var OfCustomerInfoDlg = {
    ofCustomerInfoData : {}
};

/**
 * 清除数据
 */
OfCustomerInfoDlg.clearData = function() {
    this.ofCustomerInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OfCustomerInfoDlg.set = function(key, val) {
    this.ofCustomerInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
OfCustomerInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
OfCustomerInfoDlg.close = function() {
    parent.layer.close(window.parent.OfCustomer.layerIndex);
}

/**
 * 收集数据
 */
OfCustomerInfoDlg.collectData = function() {
    this
    .set('Id')
    .set('name')
    .set('email')
    .set('phone')
    ;
}

/**
 * 提交添加
 */
OfCustomerInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ofCustomer/add", function(data){
        Feng.success("添加成功!");
        window.parent.OfCustomer.table.refresh();
        OfCustomerInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ofCustomerInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
OfCustomerInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/ofCustomer/update", function(data){
        Feng.success("修改成功!");
        window.parent.OfCustomer.table.refresh();
        OfCustomerInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.ofCustomerInfoData);
    ajax.start();
}

$(function() {

});

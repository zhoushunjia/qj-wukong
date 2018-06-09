/**
 * 初始化测试代码生成详情对话框
 */
var CodeInfoDlg = {
    codeInfoData : {}
};

/**
 * 清除数据
 */
CodeInfoDlg.clearData = function() {
    this.codeInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CodeInfoDlg.set = function(key, val) {
    this.codeInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CodeInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CodeInfoDlg.close = function() {
    parent.layer.close(window.parent.Code.layerIndex);
}

/**
 * 收集数据
 */
CodeInfoDlg.collectData = function() {
    this
    .set('Id')
    ;
}

/**
 * 提交添加
 */
CodeInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/code/add", function(data){
        Feng.success("添加成功!");
        window.parent.Code.table.refresh();
        CodeInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.codeInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CodeInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/code/update", function(data){
        Feng.success("修改成功!");
        window.parent.Code.table.refresh();
        CodeInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.codeInfoData);
    ajax.start();
}

$(function() {

});

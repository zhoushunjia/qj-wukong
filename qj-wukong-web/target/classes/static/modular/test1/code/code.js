/**
 * 测试代码生成管理初始化
 */
var Code = {
    id: "CodeTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Code.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'Id', visible: true, align: 'center', valign: 'middle'},
            {title: '名字', field: 'name', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Code.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Code.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加测试代码生成
 */
Code.openAddCode = function () {
    var index = layer.open({
        type: 2,
        title: '添加测试代码生成',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/code/code_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看测试代码生成详情
 */
Code.openCodeDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '测试代码生成详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/code/code_update/' + Code.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除测试代码生成
 */
Code.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/code/delete", function (data) {
            Feng.success("删除成功!");
            Code.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("codeId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询测试代码生成列表
 */
Code.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Code.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Code.initColumn();
    var table = new BSTable(Code.id, "/code/list", defaultColunms);
    table.setPaginationType("client");
    Code.table = table.init();
});

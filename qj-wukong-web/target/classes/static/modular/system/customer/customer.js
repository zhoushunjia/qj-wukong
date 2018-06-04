/**
 * 客户信息管理初始化
 */
var Customer = {
    id: "CustomerTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Customer.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'Id', visible: true, align: 'center', valign: 'middle'},
            {title: '客户姓名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '邮箱地址', field: 'email', visible: true, align: 'center', valign: 'middle'},
            {title: '手机号码', field: 'phone', visible: true, align: 'center', valign: 'middle'},
            {title: '详细描述', field: 'detailedDescription', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Customer.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Customer.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加客户信息
 */
Customer.openAddCustomer = function () {
    var index = layer.open({
        type: 2,
        title: '添加客户信息',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/customer/customer_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看客户信息详情
 */
Customer.openCustomerDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '客户信息详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/customer/customer_update/' + Customer.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除客户信息
 */
Customer.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/customer/delete", function (data) {
            Feng.success("删除成功!");
            Customer.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("customerId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询客户信息列表
 */
Customer.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Customer.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Customer.initColumn();
    var table = new BSTable(Customer.id, "/customer/list", defaultColunms);
    table.setPaginationType("client");
    Customer.table = table.init();
});

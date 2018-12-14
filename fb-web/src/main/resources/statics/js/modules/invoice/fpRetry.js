$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'invoice/fpkjlog/selectRunning',
        datatype: "json",
        colModel: [			
			{ label: '发票ID', name: 'fpid', index: 'fpid', width: 0, hidden: true, key: true },
			{ label: '发票流水号', name: 'fpqqlsh', index: 'fpkjZt', width: 10 },
			{ label: '纳税人识别号', name: 'xhfNsrsbh', index: 'fpkjMsg', width: 20 },
			{ label: '发票开具状态', name: 'fpkjZt', index: 'fpkjMsg', width: 15,
                formatter:function(cellvalue, options, rowObject){
			        var result = '';
			        if(cellvalue == 1000 || cellvalue == 1001){
                        result = '待附码(' + cellvalue + ')' ;
                    }else if(cellvalue == 2101){
                        result = '附码失败(' + cellvalue + ')';
                    }else if(cellvalue == 2100){
                        result = '待签章(' + cellvalue + ')';
                    }else if(cellvalue == 2001){
                        result = '签章失败(' + cellvalue + ')';
                    }
			        return result
                }
            },
			{ label: '发票开具描述', name: 'fpkjMsg', index: 'fpkjMsg', width: 40 },
			{ label: '反补次数', name: 'fbCs', index: 'fbCs', width: 15 }
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
        q: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{
                postData:{'fpqqlsh': vm.q.fpqqlsh, 'nsrsbh': vm.q.nsrsbh},
                page:page
            }).trigger("reloadGrid");
		}
	}
});
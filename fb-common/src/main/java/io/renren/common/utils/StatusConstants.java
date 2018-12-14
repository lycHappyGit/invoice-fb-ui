package io.renren.common.utils;

public enum StatusConstants {

    STATUS_DEFEAT("010000", "发票请求接收成功"),

    STATUS_DATABASE_FPQQPC("1000","发票请求成功"),

    STATUS_DATABASE_FPQQSK_START("1001","发票请求税控开始"),
    STATUS_DATABASE_FPQQFM_SUCCEED("2100","发票赋码成功"),
    STATUS_DATABASE_FPQQFM_FAILED("2101","发票赋码失败"),
    STATUS_DATABASE_FPQQSC_SUCCEED("2000","发票生成PDF成功"),
    STATUS_DATABASE_FPQQSC_FAILED("2001","发票生成PDF失败"),
    STATUS_DATABASE_FPTSJG_SUCCESS("3000","发票推送成功"),
    STATUS_DATABASE_FPTSJG_FAILED("3001","发票推送失败"),

    STATUS_DEFAULT_PUSH_STATUS("0","初始微推送"),
    STATUS_INVOICE_PUSH_FAILED("1","发票推送失败"),
    STATUS_INVOICE_PUSH_SUCCESS("2","发票推送成功");


    private String CODE;
    private String MSG;

    private StatusConstants(String CODE, String MSG) {
        this.CODE = CODE;
        this.MSG = MSG;
    }

    public String getCODE() {
        return CODE;
    }

    public String getMSG() {
        return MSG;
    }

}

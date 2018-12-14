package io.renren.common.utils;

public class FpztUtil {

    //待附码的状态
    public static StatusConstants[] tofm = {StatusConstants.STATUS_DATABASE_FPQQPC, StatusConstants.STATUS_DATABASE_FPQQSK_START, StatusConstants.STATUS_DATABASE_FPQQFM_FAILED};
    //待签章的状态
    public static StatusConstants[] toqz = {StatusConstants.STATUS_DATABASE_FPQQFM_SUCCEED, StatusConstants.STATUS_DATABASE_FPQQSC_FAILED};
    //待推送的状态
    public static StatusConstants[] tots = {StatusConstants.STATUS_DATABASE_FPQQSC_SUCCEED, StatusConstants.STATUS_DATABASE_FPTSJG_FAILED};

    /**
     * 判断状态属于哪个阶段
     * @return
     */
    public static boolean contancns(StatusConstants[] array, String fpzt){

        boolean flag = false;
        for(StatusConstants status: array){
            if(status.getCODE().equals(fpzt)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}

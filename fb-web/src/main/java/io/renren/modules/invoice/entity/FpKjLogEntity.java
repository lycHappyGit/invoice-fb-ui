package io.renren.modules.invoice.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 发票开具日志表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-04 18:33:27
 */
@TableName("fp_kj_log")
@Data
public class FpKjLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 日志ID
	 */
	@TableId
	private Integer logId;
	/**
	 * 发票ID
	 */
	private Integer fpid;
	/**
	 * 发票请求批次号
	 */
	private String fpqqpch;
	/**
	 * 发票请求流水号
	 */
	private String fpqqlsh;
	/**
	 * 批次内序号
	 */
	private Integer pcnxh;
	/**
	 * 销货方纳税人识别号
	 */
	private String xhfNsrsbh;
	/**
	 * 购货方纳税人识别号
	 */
	private String ghfNsrsbh;
	/**
	 * 销货方名称
	 */
	private String xhfMc;
	/**
	 * 购货方名称
	 */
	private String ghfMc;
	/**
	 * 发票代码
	 */
	private String fpDm;
	/**
	 * 发票号码
	 */
	private String fpHm;
	/**
	 * 开票日期
	 */
	private Date kprq;
	/**
	 * 发票开具状态1000待开，1001待调税控，2100赋码成功，2101赋码失败，2000签章成功，2001签章失败
	 */
	private String fpkjZt;
	/**
	 * 发票打印状态:1000初始，1001,待打印，2001打印失败，2000打印成功
	 */
	private String fpdyZt;
	/**
	 * 发票推送状态: 0.初始微推送 1.推送失败 2.推送成功
	 */
	private Integer fptsZt;
	/**
	 * 发票打印次数
	 */
	private Integer fpdyCs;
	/**
	 * 发票开票状态描述
	 */
	private String fpkjMsg;
	/**
	 * 发票打印状态描述
	 */
	private String fpdyMsg;
	/**
	 * 发票推送状态描述
	 */
	private String fptsMsg;
	/**
	 * 错误反补次数
	 */
	private Integer fbCs;
	/**
	 * 发送邮件状态
	 */
	private String fpyjzt;
	/**
	 * 发送信息状态
	 */
	private String fpxxzt;
	/**
	 * 上传状态
	 */
	private String sczt;
	/**
	 * 录入时间
	 */
	private Date lrrq;
	/**
	 * 修改时间
	 */
	private Date xgrq;
	/**
	 * 作废状态0未作废,1作废成功2作废失败
	 */
	private String zfzt;
	/**
	 * 备用字段1
	 */
	private String byzd1;
	/**
	 * 备用字段2
	 */
	private String byzd2;
	/**
	 * 备用字段3
	 */
	private String byzd3;
	/**
	 * 备用字段4
	 */
	private String byzd4;
	/**
	 * 备用字段5
	 */
	private String byzd5;
}

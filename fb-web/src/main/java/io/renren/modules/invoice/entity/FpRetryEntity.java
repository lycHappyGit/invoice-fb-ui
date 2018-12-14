package io.renren.modules.invoice.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 发票开具状态与发票ID的映射关系表，可用于反补
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-12-11 18:15:53
 */
@TableName("fp_retry")
@Data
public class FpRetryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 发票开具ID
	 */
	private Integer fpkjId;
	/**
	 * 发票开具状态
	 */
	private String fpkjZt;
}

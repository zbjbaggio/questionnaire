package net.airene.questionnaire.common.data.entity.system;

import lombok.Data;
import lombok.ToString;
import net.airene.questionnaire.common.data.entity.BaseEntity;

/**
 * 测试使用表 t_test_table
 *
 * @author YANQING
 * @date 2021-05-06
 */
@Data
@ToString(callSuper = true)
public class TestTable extends BaseEntity {

	/**  */
	private Integer aaaa;

	/**  */
	private String a;

	/**  */
	private String b;

}

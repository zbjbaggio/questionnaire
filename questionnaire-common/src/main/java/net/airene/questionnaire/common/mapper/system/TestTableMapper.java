package net.airene.questionnaire.common.mapper.system;

import net.airene.questionnaire.common.data.entity.system.TestTable;

import java.util.List;

/**
 * 测试使用 数据层
 *
 * @author YANQING
 * @date 2021-05-06
 */
public interface TestTableMapper {
	/**
     * 查询测试使用信息
     *
     * @param aaaa 测试使用ID
     * @return 测试使用信息
     */
	TestTable getTestTableById(Integer aaaa);

	/**
     * 查询测试使用列表
     *
     * @param testTable 测试使用信息
     * @return 测试使用集合
     */
	List<TestTable> selectTestTableList(TestTable testTable);

	/**
     * 新增测试使用
     *
     * @param testTable 测试使用信息
     * @return 结果
     */
	int insertTestTable(TestTable testTable);

	/**
	 * 批量新增测试使用
	 *
	 * @param testTable 测试使用信息
	 * @return 结果
	 */
	int batchInsertTestTable(List<TestTable> testTableList);

	/**
     * 修改测试使用
     *
     * @param testTable 测试使用信息
     * @return 结果
     */
	int updateTestTable(TestTable testTable);

	/**
     * 删除测试使用
     *
     * @param aaaa 测试使用ID
     * @return 结果
     */
	int deleteTestTableById(Integer aaaa);

	/**
     * 批量删除测试使用
     *
     * @param aaaas 需要删除的数据ID
     * @return 结果
     */
	int deleteTestTableByIds(Long[] aaaas);

}

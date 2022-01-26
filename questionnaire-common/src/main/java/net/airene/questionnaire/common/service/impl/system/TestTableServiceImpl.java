package net.airene.questionnaire.common.service.impl.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.common.data.entity.system.TestTable;
import net.airene.questionnaire.common.mapper.system.TestTableMapper;
import net.airene.questionnaire.common.service.system.TestTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 测试使用 服务层实现
 *
 * @author YANQING
 * @date 2021-05-06
 */
@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TestTableServiceImpl implements TestTableService {

	private final TestTableMapper testTableMapper;

	/**
     * 查询测试使用信息
     *
     * @param aaaa 测试使用ID
     * @return 测试使用信息
     */
    @Override
	public TestTable getTestTableById(Integer aaaa) {
	    return testTableMapper.getTestTableById(aaaa);
	}

	/**
     * 查询测试使用列表
     *
     * @param testTable 测试使用信息
     * @return 测试使用集合
     */
	@Override
	public List<TestTable> selectTestTableList(TestTable testTable) {
	    return testTableMapper.selectTestTableList(testTable);
	}

    /**
     * 新增测试使用
     *
     * @param testTable 测试使用信息
     * @return 结果
     */
	@Override
	public int insertTestTable(TestTable testTable) {
	    return testTableMapper.insertTestTable(testTable);
	}

	/**
     * 修改测试使用
     *
     * @param testTable 测试使用信息
     * @return 结果
     */
	@Override
	public int updateTestTable(TestTable testTable) {
	    return testTableMapper.updateTestTable(testTable);
	}

	/**
     * 删除测试使用对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	@Override
	public int deleteTestTableByIds(Long[] ids) {
		return testTableMapper.deleteTestTableByIds(ids);
	}

}

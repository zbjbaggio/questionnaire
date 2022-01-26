package net.airene.questionnaire.admin.controller.advice.system;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.admin.annotation.LogRecord;
import net.airene.questionnaire.common.controller.BaseController;
import net.airene.questionnaire.common.data.entity.system.TestTable;
import net.airene.questionnaire.common.data.page.TableDataInfo;
import net.airene.questionnaire.common.service.system.TestTableService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 测试使用 信息操作处理
 *
 * @author YANQING
 * @date 2021-05-06
 */
@Controller
@RequestMapping("/system/TestTable")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class TestTableController extends BaseController {

	private final TestTableService testTableService;

	/**
	 * 查询测试使用列表
	 */
	@RequiresPermissions("system:TestTable:list")
	@GetMapping("/list")
	@ResponseBody
	public TableDataInfo list(TestTable testTable) {
		startPage();
        List<TestTable> list = testTableService.selectTestTableList(testTable);
		return getDataTable(list);
	}

	/**
	 * 新增保存测试使用
	 */
	@RequiresPermissions("system:testTable:add")
	@PostMapping("/save")
	@LogRecord("测试使用保存")
	@ResponseBody
	public void save(TestTable testTable) {
		testTableService.insertTestTable(testTable);
	}

	/**
	 * 修改测试使用
	 */
	@GetMapping("/getDetail/{aaaa}")
	public TestTable getDetail(@PathVariable("aaaa") Integer aaaa) {
	    return testTableService.getTestTableById(aaaa);
	}

	/**
	 * 删除测试使用
	 */
	@RequiresPermissions("system:testTable:delete")
	@LogRecord("测试使用删除")
	@PostMapping("/delete")
	@ResponseBody
	public void delete(Long id) {
		Long[] ids = {id};
		testTableService.deleteTestTableByIds(ids);
	}

}

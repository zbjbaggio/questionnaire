package net.airene.questionnaire.api.controller.advice;

import net.airene.questionnaire.common.controller.BaseController;
import net.airene.questionnaire.common.data.entity.AllInOneInfo;
import net.airene.questionnaire.common.data.page.TableDataInfo;
import net.airene.questionnaire.common.service.AllInOneInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * 一体机 信息操作处理
 *
 * @author YANQING
 * @date 2021-06-01
 */
@RestController
@RequestMapping("/AllInOneInfo")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class AllInOneInfoController extends BaseController {

	private final AllInOneInfoService allInOneInfoService;

	/**
	 * 查询一体机列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(AllInOneInfo allInOneInfo) {
		startPage();
        List<AllInOneInfo> list = allInOneInfoService.listAllInOneInfo(allInOneInfo);
		return getDataTable(list);
	}

	/**
	 * 新增保存一体机
	 */
	@PostMapping("/save")
	public void save(AllInOneInfo allInOneInfo) {
		allInOneInfoService.insertAllInOneInfo(allInOneInfo);
	}

	/**
	 * 修改一体机
	 */
	@GetMapping("/getDetail/{id}")
	public AllInOneInfo getDetail(@PathVariable("id") Long id) {
	    return allInOneInfoService.getAllInOneInfoById(id);
	}

	/**
	 * 删除一体机
	 */
	@PostMapping("/delete")
	public void delete(Long id) {
		Long[] ids = {id};
		allInOneInfoService.deleteAllInOneInfoByIds(ids);
	}

}

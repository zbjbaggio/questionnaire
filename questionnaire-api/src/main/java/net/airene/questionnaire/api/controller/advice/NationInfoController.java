package net.airene.questionnaire.api.controller.advice;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.airene.questionnaire.common.controller.BaseController;
import net.airene.questionnaire.common.data.entity.NationInfo;
import net.airene.questionnaire.common.data.page.TableDataInfo;
import net.airene.questionnaire.common.service.NationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 民族 信息操作处理
 *
 * @author YANQING
 * @date 2021-08-27
 */
@RestController
@RequestMapping("/NationInfo")
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class NationInfoController extends BaseController {

	private final NationInfoService nationInfoService;

	/**
	 * 查询民族列表
	 */
	@GetMapping("/list")
	public TableDataInfo list(NationInfo nationInfo) {
		startPage();
        List<NationInfo> list = nationInfoService.listNationInfo(nationInfo);
		return getDataTable(list);
	}

	/**
	 * 新增保存民族
	 */
	@PostMapping("/save")
	public void save(NationInfo nationInfo) {
		nationInfoService.insertNationInfo(nationInfo);
	}

	/**
	 * 修改民族
	 */
	@GetMapping("/getDetail/{id}")
	public NationInfo getDetail(@PathVariable("id") Long id) {
	    return nationInfoService.getNationInfoById(id);
	}

	/**
	 * 删除民族
	 */
	@PostMapping("/delete")
	public void delete(Long id) {
		Long[] ids = {id};
		nationInfoService.deleteNationInfoByIds(ids);
	}

}

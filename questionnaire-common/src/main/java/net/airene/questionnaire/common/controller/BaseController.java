package net.airene.questionnaire.common.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.airene.questionnaire.common.data.page.PageDomain;
import net.airene.questionnaire.common.data.page.TableDataInfo;
import net.airene.questionnaire.common.data.page.TableSupport;
import net.airene.questionnaire.common.util.SqlUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class BaseController {

    protected void startPage() {
        PageDomain pageDomain = TableSupport.getPageDomain();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (pageNum != null && pageSize != null) {
            String orderBy = SqlUtils.escapeOrderBySql(pageDomain.getOrderBy());
            log.info("【pageHeler】参数:{}", pageDomain);
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    protected TableDataInfo getDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

}

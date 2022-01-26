package net.airene.questionnaire.common.data.page;

import net.airene.questionnaire.common.constant.PageConstants;
import net.airene.questionnaire.common.util.ServletUtils;

/**
 * 表格数据处理
 *
 */
public class TableSupport {
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain() {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getParameterToInt(PageConstants.PAGE_NUM));
        pageDomain.setPageSize(ServletUtils.getParameterToInt(PageConstants.PAGE_SIZE));
        pageDomain.setOrderByColumn(ServletUtils.getParameter(PageConstants.ORDER_BY_COLUMN));
        pageDomain.setIsAsc(ServletUtils.getParameter(PageConstants.IS_ASC));
        return pageDomain;
    }

}

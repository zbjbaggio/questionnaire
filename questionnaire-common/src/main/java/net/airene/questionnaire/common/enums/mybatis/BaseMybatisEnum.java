package net.airene.questionnaire.common.enums.mybatis;

public interface BaseMybatisEnum {

    /**
     * 数据库中值
     * @return
     */
    Integer getValue();

    /**
     * 对外显示值
     * @return
     */
    String getContent();

}

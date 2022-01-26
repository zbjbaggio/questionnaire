package net.airene.questionnaire.generator.service.impl;

import net.airene.questionnaire.generator.constants.GenConstant;
import net.airene.questionnaire.generator.utils.DateUtil;
import net.airene.questionnaire.generator.constants.Constants;
import net.airene.questionnaire.generator.domain.ColumnInfo;
import net.airene.questionnaire.generator.domain.TableInfo;
import net.airene.questionnaire.generator.mapper.GenMapper;
import net.airene.questionnaire.generator.service.GenService;
import net.airene.questionnaire.generator.utils.StringUtil;
import net.airene.questionnaire.generator.utils.VelocityInitializer;
import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.*;

/**
 * 代码生成 服务层处理
 */
@Service
@Slf4j
public class GenServiceImpl implements GenService {

    @Autowired
    private GenMapper genMapper;

    @Autowired
    private GenConstant genConstant;

    private Map<String, String> javaTypeMap = new HashMap<>();

    private String SRC;

    private String publicModuleSrc;

    /**
     * mybatis空间路径
     */
    private static final String MYBATIS_PATH = "main/resources/mapper" ;

    /**
     * html空间路径
     */
    //private static final String TEMPLATES_PATH = "main/resources/templates";

    public GenServiceImpl() {
        javaTypeMap.put("tinyint", "Integer");
        javaTypeMap.put("smallint", "Integer");
        javaTypeMap.put("mediumint", "Integer");
        javaTypeMap.put("int", "Integer");
        javaTypeMap.put("number", "Integer");
        javaTypeMap.put("integer", "integer");
        javaTypeMap.put("bigint", "Long");
        javaTypeMap.put("float", "Float");
        javaTypeMap.put("double", "Double");
        javaTypeMap.put("decimal", "BigDecimal");
        javaTypeMap.put("bit", "Boolean");
        javaTypeMap.put("char", "String");
        javaTypeMap.put("varchar", "String");
        javaTypeMap.put("varchar2", "String");
        javaTypeMap.put("tinytext", "String");
        javaTypeMap.put("text", "String");
        javaTypeMap.put("mediumtext", "String");
        javaTypeMap.put("longtext", "String");
        javaTypeMap.put("time", "Date");
        javaTypeMap.put("date", "Date");
        javaTypeMap.put("datetime", "Date");
        javaTypeMap.put("timestamp", "Date");
    }

    /**
     * 生成代码
     *
     * @param tableName 表名称
     * @return 数据
     */
    @Override
    public void generatorCode(String tableName) throws Exception {
        TableInfo table = genMapper.selectTableByName(tableName);
        if (Objects.isNull(table)) {
            throw new Exception("表未找到，请检查表名是否正确和备注是否填写！");
        }
        // 查询列信息
        List<ColumnInfo> columns = genMapper.selectTableColumnsByName(tableName);
        // 表名转换成Java属性名
        String className = tableToJava(table.getTableName());
        table.setClassName(className);
        table.setClassname(StringUtils.uncapitalize(className));
        // 列信息
        table.setColumns(transColumns(columns));
        // 设置主键
        table.setPrimaryKey(table.getColumnsLast());
        VelocityInitializer.initVelocity();
        VelocityContext context = getVelocityContext(table);
        // 获取模板列表
        List<String> templates = getTemplates();
        for (String template : templates) {
            // 渲染模板
            StringWriter sw = new StringWriter();
            Template tpl = Velocity.getTemplate(template, Constants.UTF8);
            tpl.merge(context, sw);
            String fileName = getFileName(template, table);
            File file = new File(fileName);
            if(file.exists()){
                throw new RuntimeException(fileName + "文件已存在");
            }
            FileOutputStream fop = new FileOutputStream(file);
            fop.write(sw.toString().getBytes());
            fop.flush();
            fop.close();
        }
    }

    private List<ColumnInfo> transColumns(List<ColumnInfo> columns) {
        // 列信息
        List<ColumnInfo> columsList = new ArrayList<>();
        for (ColumnInfo column : columns) {
            // 列名转换成Java属性名
            String attrName = StringUtil.convertToCamelCase(column.getColumnName());
            column.setAttrName(attrName);
            column.setAttrname(StringUtils.uncapitalize(attrName));
            column.setExtra(column.getExtra());

            // 列的数据类型，转换成Java类型
            String attrType = javaTypeMap.get(column.getDataType());
            column.setAttrType(attrType);

            columsList.add(column);
        }
        return columsList;
    }

    /**
     * 获取模板信息
     *
     * @return 模板列表
     */
    private VelocityContext getVelocityContext(TableInfo table) {
        String packageName = genConstant.getPackageName();
        String publicProjectModuleName = genConstant.getPublicProjectModuleName();
        String classPageName;
        classPageName = packageName + "." + getProjectName();
        if (StringUtil.isNotEmpty(publicProjectModuleName)) {
            int targetIndex = publicProjectModuleName.indexOf("-");
            String publicModulePageName = publicProjectModuleName.substring(targetIndex + 1);
            classPageName = packageName ;
        }
        // java对象数据传递到模板文件vm
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("tableName", table.getTableName());
        velocityContext.put("tableComment", replaceKeyword(table.getTableComment()));
        velocityContext.put("primaryKey", table.getPrimaryKey());
        velocityContext.put("className", table.getClassName());
        velocityContext.put("classname", table.getClassname());
        velocityContext.put("srcClassName", packageName + "." + getProjectName());
        velocityContext.put("moduleName", genConstant.getModuleName());
        velocityContext.put("columns", table.getColumns());
        velocityContext.put("basePackage", getBasePackage(packageName));
        velocityContext.put("package", packageName);
        velocityContext.put("classPageName", classPageName);
        velocityContext.put("author", genConstant.getAuthor());
        velocityContext.put("datetime", DateUtil.getDate());
        velocityContext.put("commonPackageName", genConstant.getCommonPackageName());
        velocityContext.put("controllerPackageName", genConstant.getControllerPackageName());
        velocityContext.put("datetime", DateUtil.getDate());
        return velocityContext;
    }

    private String getProjectName() {
        String path = this.getClass().getResource("/").getPath();
        int targetIndex = path.indexOf("/out");
        String filePath = path.substring(1, targetIndex);
        SRC = filePath + "/src/";
        targetIndex = filePath.lastIndexOf("/");
        filePath = filePath.substring(targetIndex);
        targetIndex = filePath.indexOf("-");
        filePath = filePath.substring(targetIndex + 1);
        return filePath;
    }

    /**
     * 获取模板信息
     *
     * @return 模板列表
     */
    private List<String> getTemplates() {
        List<String> templates = new ArrayList<String>();
        templates.add("vm/java/domain.java.vm");
        templates.add("vm/java/Mapper.java.vm");
        templates.add("vm/java/Service.java.vm");
        templates.add("vm/java/ServiceImpl.java.vm");
        templates.add("vm/java/Controller.java.vm");
        templates.add("vm/xml/Mapper.xml.vm");
/*        templates.add("vm/html/list.html.vm");
        templates.add("vm/html/add.html.vm");
        templates.add("vm/html/edit.html.vm");
        templates.add("vm/sql/sql.vm");*/
        return templates;
    }

    /**
     * 表名转换成Java类名
     */
    private String tableToJava(String tableName) {
        String autoRemovePrefix = genConstant.getAutoRemovePrefix();
        String tablePrefix = genConstant.getTablePrefix();
        if (Constants.AUTO_REMOVE_PREFIX.equals(autoRemovePrefix) && StringUtil.isNotEmpty(tablePrefix)) {
            tableName = tableName.replaceFirst(tablePrefix, "");
        }
        return StringUtil.convertToCamelCase(tableName);
    }

    /**
     * 获取文件名
     */
    private String getFileName(String template, TableInfo table) {
        // 大写类名
        String className = table.getClassName();
        String javaPath = getProjectPath() + "/";
        String mybatisPath = SRC + MYBATIS_PATH + "/" + className;
        String publicProjectModuleName = genConstant.getPublicProjectModuleName();
        String moduleName = genConstant.getModuleName();
        if (!StringUtil.isEmpty(moduleName)) {
            moduleName += "/";
        } else {
            moduleName = "";
        }
        if (template.contains("Controller.java.vm")) {
            return javaPath + genConstant.getControllerPackageName() +  "/controller/advice/" + moduleName +  className + "Controller.java" ;
        }
        //如果公共模块不是空的文件路径变为公共路径
        if (!StringUtil.isEmpty(publicProjectModuleName)) {
            javaPath = getPublicProjectPath();
            mybatisPath = publicModuleSrc + MYBATIS_PATH  + "/" + moduleName + className;
        }

        if (template.contains("domain.java.vm")) {
            return javaPath + genConstant.getCommonPackageName() + "/data/entity/" + moduleName + className + ".java" ;
        }

        if (template.contains("Mapper.java.vm")) {
            return javaPath + genConstant.getCommonPackageName() + "/mapper/" + moduleName + className + "Mapper.java" ;
        }

        if (template.contains("Service.java.vm")) {
            return javaPath + genConstant.getCommonPackageName() + "/service/" + moduleName + className + "Service.java" ;
        }

        if (template.contains("ServiceImpl.java.vm")) {
            return javaPath + genConstant.getCommonPackageName() + "/service/impl/" + moduleName + className + "ServiceImpl.java" ;
        }

        if (template.contains("Mapper.xml.vm")) {
            return mybatisPath + "Mapper.xml" ;
        }

        /*if (template.contains("list.html.vm")) {
            return htmlPath + "/" + classname + ".html";
        }
        if (template.contains("add.html.vm")) {
            return htmlPath + "/" + "add.html";
        }
        if (template.contains("edit.html.vm")) {
            return htmlPath + "/" + "edit.html";
        }
        if (template.contains("sql.vm")) {
            return classname + "Menu.sql";
        }*/
        return null;
    }

    /**
     * 获取模块名
     *
     * @return 模块名
     */
    private String getModuleName() {
        String packageName = genConstant.getPackageName();
        int lastIndex = packageName.lastIndexOf(".");
        int nameLength = packageName.length();
        String moduleName = StringUtil.substring(packageName, lastIndex + 1, nameLength);
        return moduleName;
    }

    private String getBasePackage(String packageName) {
        int lastIndex = packageName.lastIndexOf(".");
        String basePackage = StringUtil.substring(packageName, 0, lastIndex);
        return basePackage;
    }

    private String getProjectPath() {
        String filePath = getProjectName();
        String packageName = genConstant.getPackageName();
        StringBuffer projectPath = new StringBuffer();
        projectPath.append(SRC).append("main/java/");
        projectPath.append(packageName.replace(".", "/"));
        //projectPath.append("/").append(filePath).append("/");
        return projectPath.toString();
    }

    private String getPublicProjectPath() {
        String path = this.getClass().getResource("/").getPath();
        int targetIndex = path.indexOf("/out");
        String filePath = path.substring(1, targetIndex);
        targetIndex = filePath.lastIndexOf("/");
        String publicModuleName = genConstant.getPublicProjectModuleName();
        filePath = filePath.substring(0, targetIndex) + "/" + publicModuleName + "/src/";
        publicModuleSrc = filePath;
        String packageName = genConstant.getPackageName();
        StringBuffer projectPath = new StringBuffer();
        projectPath.append("main/java/");
        projectPath.append(packageName.replace(".", "/"));
        targetIndex = publicModuleName.indexOf("-");
        //String publicModulePageName = publicModuleName.substring(targetIndex + 1);
        String publicModulePageName = "";
        projectPath.append("/").append(publicModulePageName).append("/");
        return filePath + projectPath.toString();
    }


    private String replaceKeyword(String keyword) {
        return keyword.replaceAll("(?:表|信息|管理)", "");
    }

}

/*
package net.airene.questionnaire.common.util;

import net.airene.questionnaire.common.constant.Constants;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.util.Map;

*/
/**
 * 根据模板名称封装xml模板
 *//*

public class XmlUtils {

    public static String templateToString(Object object, String templateName) throws Exception {
        StringWriter sw = new StringWriter();
        Map<String, String> map;
        if (object instanceof Map) {
            map = (Map) object;
        } else {
            map = BeanUtils.describe(object);
        }
        VelocityContext context = new VelocityContext(map);
        Template tpl = Velocity.getTemplate(templateName, Constants.UTF8);
        tpl.merge(context, sw);
        return sw.toString();
    }
    
}
*/

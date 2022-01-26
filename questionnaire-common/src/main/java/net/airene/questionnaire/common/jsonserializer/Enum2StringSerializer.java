package net.airene.questionnaire.common.jsonserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.airene.questionnaire.common.enums.mybatis.BaseMybatisEnum;

import java.io.IOException;

/**
 * 枚举返回json格式字符串
 */
public class Enum2StringSerializer extends JsonSerializer {

    private final String JSON_STRING = "{\"value\":\"%s\",\"content\":\"%s\"}";

    @Override
    public void serialize(Object object, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (!(object instanceof BaseMybatisEnum)) {
            jsonGenerator.writeString("该类型不是BaseMybatisEnum枚举！");
        }
        final BaseMybatisEnum data = (BaseMybatisEnum)object;
        jsonGenerator.writeString(String.format(JSON_STRING, data.getValue(), data.getContent()));
    }

}

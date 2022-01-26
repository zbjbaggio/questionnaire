package net.airene.questionnaire.common.jsonserializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import net.airene.questionnaire.common.enums.mybatis.BaseMybatisEnum;

import java.io.IOException;

/**
 *
 */
public class Enum2ContentSerializer extends JsonSerializer {

    @Override
    public void serialize(Object o, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (!(o instanceof BaseMybatisEnum)) {
            jsonGenerator.writeString("该类型不是BaseMybatisEnum枚举！");
        }
        final BaseMybatisEnum data = (BaseMybatisEnum)o;
        jsonGenerator.writeString(data.getContent());
    }

}

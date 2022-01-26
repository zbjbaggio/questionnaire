package net.airene.questionnaire.common.handler.mybatis;

import net.airene.questionnaire.common.enums.mybatis.BaseMybatisEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

/**
 * mybatis自定义枚举类型
 *
 * @param <E>
 */

public class PrivateEnumTypeHandler<E extends Enum<E> & BaseMybatisEnum> extends BaseTypeHandler<E> {

    private Class<E> type;

    public PrivateEnumTypeHandler(){
        
    }

    public PrivateEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        } else {
            if (Objects.isNull(type.getEnumConstants())) {
                throw new IllegalArgumentException(type.getName() + " does not represent an enum type.");
            }
            this.type = type;
        }
    }

    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        if (!BaseMybatisEnum.class.isAssignableFrom(parameter.getClass())) {
            ps.setObject(i, parameter);
        } else {
            ps.setInt(i, parameter.getValue());
        }
    }

    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return loadEnum(rs.getInt(columnName));
    }

    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return loadEnum(rs.getInt(columnIndex));
    }

    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return loadEnum(cs.getInt(columnIndex));
    }

    private E loadEnum(Integer index) {
        if (Objects.isNull(index)) {
            return null;
        }
        E[] enums = type.getEnumConstants();
        for (E e : enums) {
            if (e.getValue() == index) {
                return e;
            }
        }
        throw new IllegalArgumentException(type.getName() + "  unknown enumerated type  index:" + index);
    }
}


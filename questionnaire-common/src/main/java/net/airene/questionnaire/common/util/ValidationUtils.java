package net.airene.questionnaire.common.util;

import net.airene.questionnaire.common.data.ValidationResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Slf4j
public final class ValidationUtils {

    private ValidationUtils() {
        throw new UnsupportedOperationException();
    }

    private static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> ValidationResult validateEntity(T obj, Class<?>... clazz) {
        ValidationResult result = new ValidationResult();
        if (obj == null) {
            result.setHasErrors(true);
            Map<String, String> errorMsg = new HashMap<>();
            errorMsg.put("", "参数不能为空！");
            result.setErrorMsg(errorMsg);
            return result;
        }
        Set<ConstraintViolation<T>> set = validator.validate(obj, clazz);
        if (CollectionUtils.isNotEmpty(set)) {
            result.setHasErrors(true);
            Map<String, String> errorMsg = new HashMap<>();
            for (ConstraintViolation<T> cv : set) {
                errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
            }
            result.setErrorMsg(errorMsg);
        }
        return result;
    }

}

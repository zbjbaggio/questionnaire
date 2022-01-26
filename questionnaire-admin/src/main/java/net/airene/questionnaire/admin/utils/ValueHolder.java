package net.airene.questionnaire.admin.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ValueHolder {

    private ThreadLocal<Long> userIdHolder = new ThreadLocal<>();

    public Long getUserIdHolder() {
        return userIdHolder.get();
    }

    public void setUserIdHolder(Long userIdHolder) {
        this.userIdHolder.set(userIdHolder);
    }

    public void removeUserIdHolder() {
        this.userIdHolder.remove();
    }


}

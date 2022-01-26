package net.airene.questionnaire.common.service.impl;

import net.airene.questionnaire.common.service.HotelCheckGuestService;
import net.airene.questionnaire.common.data.DTO.guest.GuestInfoDTO;
import net.airene.questionnaire.common.enums.PublicSecurityEnum;
import net.airene.questionnaire.common.service.GuestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor_ = {@Autowired})
public class GuestServiceImpl implements GuestService {

    @Override
    public void checkPhoto(GuestInfoDTO guestInfoDTO, Integer publicSecurityType) throws Exception {
        HotelCheckGuestService bean = (HotelCheckGuestService)ChanelContext.getBean(PublicSecurityEnum.getValue(publicSecurityType));
        bean.photoCheck(guestInfoDTO);
    }

    @Override
    public void confirm(GuestInfoDTO guestInfoDTO, Integer publicSecurityType) throws Exception {
        // TODO 增加
        HotelCheckGuestService bean = (HotelCheckGuestService)ChanelContext.getBean(PublicSecurityEnum.getValue(publicSecurityType));
        bean.inCheck(guestInfoDTO);
    }
}

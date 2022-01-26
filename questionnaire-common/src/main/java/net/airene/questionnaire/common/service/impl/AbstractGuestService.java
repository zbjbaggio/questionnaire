package net.airene.questionnaire.common.service.impl;

import net.airene.questionnaire.common.data.DTO.guest.GuestInfoDTO;
import net.airene.questionnaire.common.data.entity.AllInOneInfo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractGuestService {

    public abstract void inCheck(GuestInfoDTO guestInfoDTO, AllInOneInfo allInOneInfo) throws Exception;

    public abstract void outCheck(GuestInfoDTO guestInfoDTO) throws Exception;

    public abstract Object checkPhotoChannel(GuestInfoDTO guestInfoDTO, AllInOneInfo allInOneInfo) throws Exception;

    public Object checkPhoto(GuestInfoDTO guestInfoDTO, AllInOneInfo allInOneInfo) throws Exception{
        return checkPhotoChannel(guestInfoDTO, allInOneInfo);
    }

    public void confirm(GuestInfoDTO guestInfoDTO, AllInOneInfo allInOneInfo) throws Exception {
        //
        inCheck(guestInfoDTO, allInOneInfo);
    }
}

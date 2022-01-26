package net.airene.questionnaire.common.service;

import net.airene.questionnaire.common.data.DTO.guest.GuestInfoDTO;

public interface GuestService {

    void checkPhoto(GuestInfoDTO guestInfoDTO, Integer publicSecurityType) throws Exception;

    void confirm(GuestInfoDTO guestInfoDTO, Integer publicSecurityType) throws Exception;
}

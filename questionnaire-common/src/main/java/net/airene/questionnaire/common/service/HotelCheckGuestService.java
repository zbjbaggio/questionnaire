package net.airene.questionnaire.common.service;

import net.airene.questionnaire.common.data.DTO.enuo.EnuoResult;
import net.airene.questionnaire.common.data.DTO.guest.GuestInfoDTO;

/**
 * 旅业接口
 */
public interface HotelCheckGuestService {

    // 入住
    EnuoResult inCheck(GuestInfoDTO guestInfoDTO) throws Exception;

    // 退房
    void outCheck(GuestInfoDTO guestInfoDTO) throws Exception;

    // 换房

    // 证件照片验证接口
    EnuoResult photoCheck(GuestInfoDTO guestInfoDTO) throws Exception;
}

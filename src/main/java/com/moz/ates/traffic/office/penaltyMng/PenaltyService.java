package com.moz.ates.traffic.office.penaltyMng;

import com.moz.ates.traffic.common.entity.payment.MozFinePymntInfo;
import com.moz.ates.traffic.office.common.DataTableVO;

import java.util.List;

public interface PenaltyService {
    /**
     * @brief : 범칙금 등록
     * @details : 범칙금 등록
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : 
     */
    void registPenalty(MozFinePymntInfo finePymntInfo);
    
    /**
     * @brief : 범칙금 리스트 조회
     * @details : 범칙금 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : DataTableVO
     */
    DataTableVO getPenaltyListDatatable(MozFinePymntInfo finePymntInfo);

    List getPenaltyList(MozFinePymntInfo finePymntInfo);

    int getPenaltyListCnt(MozFinePymntInfo finePymntInfo);

    /**
     * @brief : 범칙금 상세 조회
     * @details : 범칙금 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : pymntId
     * @return : 
     */
    MozFinePymntInfo getPenaltyDetail(String pymntId);
    
    /**
     * @brief : 범칙금 수정
     * @details : 범칙금 수정
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : 
     */
    void updatePenalty(MozFinePymntInfo finePymntInfo);
}

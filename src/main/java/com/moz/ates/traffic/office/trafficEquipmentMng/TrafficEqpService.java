package com.moz.ates.traffic.office.trafficEquipmentMng;

import java.util.List;

import com.moz.ates.traffic.common.entity.equipment.MozTfcEnfEqpMaster;
import com.moz.ates.traffic.office.common.DataTableVO;

public interface TrafficEqpService {
    /**
     * @brief : 단속장비 아이디 중복 조회
     * @details : 단속장비 아이디 중복 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : 
     * @return : 
     */
	int getEqpDupliCnt(MozTfcEnfEqpMaster tfcEnfEqpMaster);
	
    /**
     * @brief : 단속장비 등록 
     * @details : 단속장비 등록 
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : 
     * @return : 
     */
	void registEqp(MozTfcEnfEqpMaster tfcEnfEqpMaster);

    /**
     * @brief : 단속장비 리스트 조회
     * @details : 단속장비 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : DataTableVO
     */
    DataTableVO getMngListDatatable(MozTfcEnfEqpMaster tfcEnfEqpMaster);

    List getMngList(MozTfcEnfEqpMaster tfcEnfEqpMaster);

    int getMngListCnt(MozTfcEnfEqpMaster tfcEnfEqpMaster);

    /**
     * @brief : 단속장비 상세 조회
     * @details : 단속장비 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfEqpId
     * @return : 
     */
    MozTfcEnfEqpMaster getEqpDetail(String tfcEnfEqpId);

    /**
     * @brief : 단속장비 정보 수정
     * @details : 단속장비 정보 수정
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfEqpMaster
     * @return : 
     */
    void updateEqp(MozTfcEnfEqpMaster tfcEnfEqpMaster);

//    DataTableVO getLogListDatatable(EqpLogVO eqpLogVO);
//
//    List getLogList(EqpLogVO eqpLogVO);
//
//    int getLogListCnt(EqpLogVO eqpLogVO);
}

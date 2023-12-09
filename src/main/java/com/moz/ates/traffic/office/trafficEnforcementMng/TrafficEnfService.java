package com.moz.ates.traffic.office.trafficEnforcementMng;

import com.moz.ates.traffic.common.entity.enforcement.MozTfcEnfMaster;
import com.moz.ates.traffic.common.entity.law.MozTfcLwInfo;
import com.moz.ates.traffic.office.common.DataTableVO;

import java.util.List;

public interface TrafficEnfService {
    DriverVO getDriverDetail(EnfSearchVO enfSearchVO);

    CarVO getCarDetail(EnfSearchVO enfSearchVO);

    /**
     * @brief : 교통단속 법률관리 리스트 조회
     * @details : 교통단속 법률관리 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcLwInfo
     * @return : 
     */
    DataTableVO getLawListDatatable(MozTfcLwInfo tfcLwInfo);
    
    List<MozTfcLwInfo> getLawList(MozTfcLwInfo tfcLwInfo);
    
    int getLawListCnt(MozTfcLwInfo tfcLwInfo);

    /**
     * @brief : 교통단속 법률관리 등록
     * @details : 교통단속 법률관리 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    void registLaw(MozTfcLwInfo tfcLwInfo);

    /**
     * @brief : 교통단속 법률관리 상세 조회
     * @details : 교통단속 법률관리 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcLawId
     * @return : 
     */
    MozTfcLwInfo getLawDetail(String tfcLawId);
    
    /**
     * @brief : 교통단속 법률관리 삭제
     * @details : 교통단속 법률관리 삭제
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : tfcLawId
     * @return : 
     */
    void deleteLaw(String lawId);
    
    /**
     * @brief : 교통단속 법률관리 수정
     * @details : 교통단속 법률관리 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : tfcLawId
     * @return : 
     */
    void updateLaw(MozTfcLwInfo tfcLwInfo);
    
    /**
     * @brief : 교통단속 정보 리스트 조회
     * @details : 교통단속 정보 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfMaster
     * @return : 
     */
    DataTableVO getInfoListDatatable(MozTfcEnfMaster tfcEnfMaster);

    List getInfoList(MozTfcEnfMaster tfcEnfMaster);

    int getInfoListCnt(MozTfcEnfMaster tfcEnfMaster);

    /**
     * @brief : 교통단속 정보 상세 조회
     * @details : 교통단속 정보 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcEnfId
     * @return : 
     */
    MozTfcEnfMaster getTrafficEnfDetail(String tfcEnfId);

    /**
     * @brief : 교통단속 정보 수정
     * @details : 교통단속 정보 수정
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcEnfMaster
     * @return : 
     */
    void updateInfo(MozTfcEnfMaster tfcEnfMaster);

//    DataTableVO getLogListDatatable(EnfHisVO enfHisVO);
//
//    List getLogList(EnfHisVO enfHisVO);
//
//    int getLogListCnt(EnfHisVO enfHisVO);
}

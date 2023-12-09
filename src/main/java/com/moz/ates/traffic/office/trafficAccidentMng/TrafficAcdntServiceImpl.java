package com.moz.ates.traffic.office.trafficAccidentMng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.ates.traffic.common.entity.accident.MozTfcAcdntMaster;
import com.moz.ates.traffic.common.repository.accident.MozTfcAcdntMasterRepository;
import com.moz.ates.traffic.office.common.DataTableVO;

@Service
public class TrafficAcdntServiceImpl implements TrafficAcdntService{
    
    @Autowired
    MozTfcAcdntMasterRepository tfcAcdntMasterRepository;

    /**
     * @brief : 교통사고 중복 체크
     * @details : 교통사고 중복 체크
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcAcdntMaster
     * @return : 
     */
    @Override
    public int getAcdntDupliCnt(MozTfcAcdntMaster tfcAcdntMaster) {
    	return tfcAcdntMasterRepository.selectAcdntDupliCnt(tfcAcdntMaster);
    }

    /**
     * @brief : 교통사고 정보 등록
     * @details : 교통사고 정보 등록
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcAcdntMaster
     * @return : 
     */
    @Override
    public void registAcdnt(MozTfcAcdntMaster tfcAcdntMaster) {
    	// TODO
    	tfcAcdntMaster.setCrtr("lim");
    	tfcAcdntMaster.setCrDt(tfcAcdntMaster.getAcdntDt());
    	tfcAcdntMasterRepository.insertAcdnt(tfcAcdntMaster);
    }

    @Override
    public List getMngList(MozTfcAcdntMaster tfcAcdntMaster) {
    	return tfcAcdntMasterRepository.selectMngList(tfcAcdntMaster);
    }

    @Override
    public int getMngListCnt(MozTfcAcdntMaster tfcAcdntMaster) {
    	return tfcAcdntMasterRepository.selectMngListCnt(tfcAcdntMaster);
    }

    /**
     * @brief : 교통사고 관리 리스트 조회
     * @details : 교통사고 관리 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcAcdntMaster
     * @return : 
     */
    @Override	
    public DataTableVO getMngListDatatable(MozTfcAcdntMaster tfcAcdntMaster) {
        return new DataTableVO(this.getMngList(tfcAcdntMaster),this.getMngListCnt(tfcAcdntMaster));
    }

    /**
     * @brief : 교통사고 정보 상세 조회
     * @details : 교통사고 정보 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcAcdntId
     * @return : 
     */
    @Override
    public MozTfcAcdntMaster getMngDetail(String tfcAcdntId) {
    	return tfcAcdntMasterRepository.selectMngDetail(tfcAcdntId);
    }

    /**
     * @brief : 교통사고 정보 수정
     * @details : 교통사고 정보 수정
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcAcdntMaster
     * @return : 
     */
    @Override
    public void upateAcdnt(MozTfcAcdntMaster tfcAcdntMaster) {
    	tfcAcdntMasterRepository.upateAcdnt(tfcAcdntMaster);
    }

//    @Override
//    public List getLogList(AcdntHisVO acdntHisVO) {
//        return sqlSession.selectList("TrafficAcdnt.selectLogList",acdntHisVO);
//    }
//
//    @Override
//    public int getLogListCnt(AcdntHisVO acdntHisVO) {
//        return sqlSession.selectOne("TrafficAcdnt.selectLogListCnt",acdntHisVO);
//    }
//
//    @Override
//    public DataTableVO getLogListDatatable(AcdntHisVO acdntHisVO) {
//        return new DataTableVO(this.getLogList(acdntHisVO),this.getLogListCnt(acdntHisVO));
//    }
}

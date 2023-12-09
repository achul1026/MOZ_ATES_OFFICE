package com.moz.ates.traffic.office.trafficEquipmentMng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.ates.traffic.common.entity.equipment.MozTfcEnfEqpMaster;
import com.moz.ates.traffic.common.repository.equipment.MozTfcEnfEqpMasterRepository;
import com.moz.ates.traffic.office.common.DataTableVO;

@Service
public class TrafficEqpServiceImpl implements TrafficEqpService {
    
    @Autowired
    MozTfcEnfEqpMasterRepository tfcEnfEqpMasterRepository;
    
    /**
     * @brief : 단속장비 아이디 중복 조회
     * @details : 단속장비 아이디 중복 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : 
     * @return : 
     */
    @Override
    public int getEqpDupliCnt(MozTfcEnfEqpMaster tfcEnfEqpMaster) {
    	return tfcEnfEqpMasterRepository.selectEqpDupliCnt(tfcEnfEqpMaster);
    }

    /**
     * @brief : 단속장비 등록 
     * @details : 단속장비 등록 
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : 
     * @return : 
     */
    @Override
    public void registEqp(MozTfcEnfEqpMaster tfcEnfEqpMaster) {
    	tfcEnfEqpMasterRepository.insertEqp(tfcEnfEqpMaster);
    }
    
    /**
     * @brief : 단속장비 리스트 조회
     * @details : 단속장비 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : DataTableVO
     */
    @Override
    public DataTableVO getMngListDatatable(MozTfcEnfEqpMaster tfcEnfEqpMaster) {
        return new DataTableVO(this.getMngList(tfcEnfEqpMaster),this.getMngListCnt(tfcEnfEqpMaster));
    }
    
    @Override
    public List getMngList(MozTfcEnfEqpMaster tfcEnfEqpMaster) {
    	return tfcEnfEqpMasterRepository.selectMngList(tfcEnfEqpMaster);
    }

    @Override
    public int getMngListCnt(MozTfcEnfEqpMaster tfcEnfEqpMaster) {
    	return tfcEnfEqpMasterRepository.selectMngListCnt(tfcEnfEqpMaster);
    }
    
    /**
     * @brief : 단속장비 상세 조회
     * @details : 단속장비 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfEqpId
     * @return : 
     */
    @Override
    public MozTfcEnfEqpMaster getEqpDetail(String tfcEnfEqpId) {
    	return tfcEnfEqpMasterRepository.selectEqpDetail(tfcEnfEqpId);
    }

    /**
     * @brief : 단속장비 정보 수정
     * @details : 단속장비 정보 수정
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfEqpMaster
     * @return : 
     */
    @Override
    public void updateEqp(MozTfcEnfEqpMaster tfcEnfEqpMaster) {
    	tfcEnfEqpMasterRepository.updateEqp(tfcEnfEqpMaster);
    }

//    @Override
//    public List getLogList(EqpLogVO eqpLogVO) {
//        return sqlSession.selectList("TrafficEqp.selectLogList", eqpLogVO);
//    }
//
//    @Override
//    public int getLogListCnt(EqpLogVO eqpLogVO) {
//        return sqlSession.selectOne("TrafficEqp.selectLogListCnt", eqpLogVO);
//    }
//
//    @Override
//    public DataTableVO getLogListDatatable(EqpLogVO eqpLogVO) {
//        return new DataTableVO(this.getLogList(eqpLogVO),this.getLogListCnt(eqpLogVO));
//    }
}

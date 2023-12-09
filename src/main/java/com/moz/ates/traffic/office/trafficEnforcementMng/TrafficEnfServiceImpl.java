package com.moz.ates.traffic.office.trafficEnforcementMng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.ates.traffic.common.entity.enforcement.MozTfcEnfMaster;
import com.moz.ates.traffic.common.entity.law.MozTfcLwInfo;
import com.moz.ates.traffic.common.entity.payment.MozFinePymntInfo;
import com.moz.ates.traffic.common.repository.enforcement.MozTfcEnfMasterRepository;
import com.moz.ates.traffic.common.repository.law.MozTfcLwInfoRepository;
import com.moz.ates.traffic.common.repository.payment.MozFinePymntInfoRepository;
import com.moz.ates.traffic.office.common.DataTableVO;

@Service
public class TrafficEnfServiceImpl implements TrafficEnfService{
    
    @Autowired
    MozTfcEnfMasterRepository tfcEnfMasterRepository;
    
    @Autowired
    MozFinePymntInfoRepository finePymntInfoRepository;
    
    @Autowired
    MozTfcLwInfoRepository tfcLwInfoRepository;

    @Override
    public DriverVO getDriverDetail(EnfSearchVO enfSearchVO) {

        //test
        DriverVO driverVO = new DriverVO();

        if("hs".equals(enfSearchVO.getName()) && "010".equals(enfSearchVO.getPhone())){
            driverVO.setName(enfSearchVO.getName());
            driverVO.setPhone(enfSearchVO.getPhone());
            driverVO.setDriverLicense("111-23-4555");
            driverVO.setAddress("moz africa city");
            driverVO.setBirth("920926");
            driverVO.setSex("m");
            driverVO.setEmail("mike.lim@bluedus.com");
        }

        return driverVO;
        // test end

//        return sqlSession.selectOne("TrafficEnf.selectDriverDetail",enfSearchVO);
    }

    @Override
    public CarVO getCarDetail(EnfSearchVO enfSearchVO) {

        //text
        CarVO carVO = new CarVO();
        if("9119".equals(enfSearchVO.getCarNum())){
            carVO.setCarNum(enfSearchVO.getCarNum());
            carVO.setCarDriverName("lim hs");
            carVO.setRegDt("2020-11-22");
            carVO.setCarType("승용차");
        }

        return carVO;
        // test end


//        return sqlSession.selectOne("TrafficEnf.selectCarDetail",enfSearchVO);
    }



    /**
     * @brief : 교통단속 법률관리 리스트 조회
     * @details : 교통단속 법률관리 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcLwInfo
     * @return : 
     */
    @Override
    public DataTableVO getLawListDatatable(MozTfcLwInfo tfcLwInfo) {
        return new DataTableVO(this.getLawList(tfcLwInfo),this.getLawListCnt(tfcLwInfo));
    }

    @Override
    public List<MozTfcLwInfo> getLawList(MozTfcLwInfo tfcLwInfo) {
    	return tfcLwInfoRepository.findAllLawListsByTfcLwInfo(tfcLwInfo);
    }
    
    @Override
    public int getLawListCnt(MozTfcLwInfo tfcLwInfo) {
    	return tfcLwInfoRepository.countLawListsByTfcLwInfo(tfcLwInfo);
    }
    
    /**
     * @brief : 교통단속 법률관리 등록
     * @details : 교통단속 법률관리 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    @Override
    public void registLaw(MozTfcLwInfo tfcLwInfo) {
    	tfcLwInfoRepository.insertMozTfcLwInfo(tfcLwInfo);
    }

    /**
     * @brief : 교통단속 법률관리 상세 조회
     * @details : 교통단속 법률관리 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcLawId
     * @return : 
     */
    @Override
    public MozTfcLwInfo getLawDetail(String tfcLawId) {
    	return tfcLwInfoRepository.findOneLawDetail(tfcLawId);
    }

    /**
     * @brief : 교통단속 법률관리 삭제
     * @details : 교통단속 법률관리 삭제
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : tfcLawId
     * @return : 
     */
    @Override
    public void deleteLaw(String tfcLawId) {
    	tfcLwInfoRepository.deleteMozTfcLwInfoByTfcLawId(tfcLawId);
    }

    /**
     * @brief : 교통단속 법률관리 수정
     * @details : 교통단속 법률관리 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : tfcLawId
     * @return : 
     */
    @Override
    public void updateLaw(MozTfcLwInfo tfcLwInfo) {
    	tfcLwInfoRepository.updateMozTfcLwInfoByTfcLawId(tfcLwInfo);
    }
    
    /**
     * @brief : 교통단속 정보 리스트 조회
     * @details : 교통단속 정보 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfMaster
     * @return : 
     */
    @Override
    public DataTableVO getInfoListDatatable(MozTfcEnfMaster tfcEnfMaster) {
        return new DataTableVO(this.getInfoList(tfcEnfMaster),this.getInfoListCnt(tfcEnfMaster));
    }

    @Override
    public List getInfoList(MozTfcEnfMaster tfcEnfMaster) {
    	return tfcEnfMasterRepository.findAllInfoList(tfcEnfMaster);
    }

    @Override
    public int getInfoListCnt(MozTfcEnfMaster tfcEnfMaster) {
    	return tfcEnfMasterRepository.countInfoList(tfcEnfMaster);
    }
    
    /**
     * @brief : 교통단속 정보 상세 조회
     * @details : 교통단속 정보 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcEnfId
     * @return : 
     */
    @Override
    public MozTfcEnfMaster getTrafficEnfDetail(String tfcEnfId) {
    	return tfcEnfMasterRepository.findOneMozTfcEnfMasterBytfcEnfId(tfcEnfId);
    }

    /**
     * @brief : 교통단속 정보 수정
     * @details : 교통단속 정보 수정
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcEnfMaster
     * @return : 
     */
    @Override
    public void updateInfo(MozTfcEnfMaster tfcEnfMaster) {
    	tfcEnfMasterRepository.updateMozTfcEnfMaster(tfcEnfMaster);
    	
    	MozFinePymntInfo finePymntInfo = new MozFinePymntInfo();
    	finePymntInfo.setTfcEnfId(tfcEnfMaster.getTfcEnfId());
    	finePymntInfo.setTotalPrice(tfcEnfMaster.getFinePymntInfo().getTotalPrice());
    	finePymntInfoRepository.updateFineTotalPrice(finePymntInfo);
    }




//    @Override
//    public List getLogList(EnfHisVO enfHisVO) {
//        return sqlSession.selectList("TrafficEnf.selectLogList", enfHisVO);
//    }
//
//    @Override
//    public int getLogListCnt(EnfHisVO enfHisVO) {
//        return sqlSession.selectOne("TrafficEnf.selectLogListCnt", enfHisVO);
//    }
//
//    @Override
//    public DataTableVO getLogListDatatable(EnfHisVO enfHisVO) {
//        return new DataTableVO(this.getLogList(enfHisVO),this.getLogListCnt(enfHisVO));
//    }

}

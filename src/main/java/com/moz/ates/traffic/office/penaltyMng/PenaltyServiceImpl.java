package com.moz.ates.traffic.office.penaltyMng;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.ates.traffic.common.entity.payment.MozFinePymntInfo;
import com.moz.ates.traffic.common.repository.payment.MozFinePymntInfoRepository;
import com.moz.ates.traffic.office.common.DataTableVO;

@Service
public class PenaltyServiceImpl implements PenaltyService {

    @Autowired
    MozFinePymntInfoRepository finePymntInfoRepository;

    /**
     * @brief : 범칙금 등록
     * @details : 범칙금 등록
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : 
     */
    @Override
    public void registPenalty(MozFinePymntInfo finePymntInfo) {
    	finePymntInfo.setCrtr("lim");
    	finePymntInfoRepository.insertFinePaymentInfo(finePymntInfo);
    }

    @Override
    public List getPenaltyList(MozFinePymntInfo finePymntInfo) {
    	return finePymntInfoRepository.selectPenaltyList(finePymntInfo);
    }

    @Override
    public int getPenaltyListCnt(MozFinePymntInfo finePymntInfo) {
    	return finePymntInfoRepository.selectPenaltyListCnt(finePymntInfo);
    }
    
    /**
     * @brief : 범칙금 리스트 조회
     * @details : 범칙금 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : DataTableVO
     */
    @Override
    public DataTableVO getPenaltyListDatatable(MozFinePymntInfo finePymntInfo) {
        return new DataTableVO(this.getPenaltyList(finePymntInfo),this.getPenaltyListCnt(finePymntInfo));
    }

    /**
     * @brief : 범칙금 상세 조회
     * @details : 범칙금 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : pymntId
     * @return : 
     */
    @Override
    public MozFinePymntInfo getPenaltyDetail(String pymntId) {
    	return finePymntInfoRepository.selectPenaltyDetail(pymntId);
    }
    
    /**
     * @brief : 범칙금 수정
     * @details : 범칙금 수정
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : 
     */
     @Override
 	public void updatePenalty(MozFinePymntInfo finePymntInfo) {
 		finePymntInfoRepository.updatePenalty(finePymntInfo);
 	}
}

package com.moz.ates.traffic.office.govPortal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.ates.traffic.common.entity.board.MozBrd;
import com.moz.ates.traffic.common.entity.board.MozComplaintsReg;
import com.moz.ates.traffic.common.entity.board.MozFaq;
import com.moz.ates.traffic.common.entity.board.MozObjReg;
import com.moz.ates.traffic.common.entity.payment.MozPlPymntInfo;
import com.moz.ates.traffic.common.repository.board.MozBrdRepository;
import com.moz.ates.traffic.common.repository.board.MozComplaintsRegRepository;
import com.moz.ates.traffic.common.repository.board.MozFaqRepository;
import com.moz.ates.traffic.common.repository.board.MozObjRegRepository;
import com.moz.ates.traffic.common.repository.payment.MozPlPymntInfoRepository;
import com.moz.ates.traffic.office.common.DataTableVO;

/**
 * className : PortalServiceImpl
 * author : Mike Lim
 * description : 포털 관련 impl
 */
@Service
public class PortalServiceImpl implements PortalService {
    
    @Autowired
     MozBrdRepository brdRepository;
    
    @Autowired
    MozFaqRepository faqRepository;

    @Autowired
    MozObjRegRepository objRegRepository;
    
    @Autowired
    MozComplaintsRegRepository complaintsRegRepository;
    
    @Autowired
    MozPlPymntInfoRepository plPymntInfoRepository;
    
    /**
     * @brief : 공지사항 등록
     * @details : 공지사항 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : brd
     * @return : 
     */
    @Override
    public void registNotice(MozBrd brd) {
    	brdRepository.insertNotice(brd);
    }
    
    /**
     * @brief : 공지사항 상세 화면
     * @details : 공지사항 상세 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : boardIdx
     * @return : 
     */
    @Override
    public MozBrd getNoticeDetail(String boardIdx) {
    	return brdRepository.selectNoticeDetail(boardIdx);
    }

    /**
     * @brief : 공지사항 수정 
     * @details : 공지사항 수정 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : brd
     * @return : 
     */
    @Override
    public void updateNotice(MozBrd brd) {
    	brdRepository.updateNotice(brd);
    }

    /**
     * @brief : 공지사항 리스트 조회
     * @details : 공지사항 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : brd
     * @return : DataTableVO
     */
    @Override
    public DataTableVO getNoticeListDatatable(MozBrd brd) {
        return new DataTableVO(this.getNoticeList(brd), this.getNoticeListCnt(brd));
    }
    
    @Override
    public List getNoticeList(MozBrd brd) {
    	return brdRepository.selectNoticeList(brd);
    }
    
    @Override
    public int getNoticeListCnt(MozBrd brd) {
    	return brdRepository.selectNoticeListCnt(brd);
    }

    /**
     * @brief : FAQ 리스트 조회
     * @details : FAQ 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faq
     * @return : DataTableVO
     */
    @Override
    public DataTableVO getFaqListDatatable(MozFaq faq) {
        return new DataTableVO(this.getFaqList(faq), this.getFaqListCnt(faq));
    }

    @Override
    public List getFaqList(MozFaq faq) {
    	return faqRepository.findAllMozFaq(faq);
    }
    
    @Override
    public int getFaqListCnt(MozFaq faq) {
    	return faqRepository.countMozFaq(faq);
    }

    /**
     * @brief : FAQ 등록 
     * @details : FAQ 등록 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faq
     * @return : 
     */
    @Override
    public void registFaq(MozFaq faq) {
    	// TODO
    	faq.setWrtrId("lim");
    	faqRepository.saveMozFaq(faq);
    }

    /**
     * @brief : FAQ 상세 조회
     * @details : FAQ 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faqIdx
     * @return : 
     */
    @Override
    public MozFaq getFaqDetail(String faqIdx) {
    	return faqRepository.findOneMozFaq(faqIdx);
    }

    /**
     * @brief : FAQ 수정
     * @details : FAQ 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faq
     * @return : 
     */
    @Override
    public void updateFaq(MozFaq faq) {
    	faqRepository.updateMozFaq(faq);
    }

    /**
     * @brief : 이의제기 리스트 조회
     * @details : 이의제기 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : objReg
     * @return : DataTableVO
     */
    @Override
    public DataTableVO getObjectionListDatatable(MozObjReg objReg) {
        return new DataTableVO(this.getObjectionList(objReg), this.getObjectionListCnt(objReg));
    }
    
    @Override
    public List getObjectionList(MozObjReg objReg) {
    	return objRegRepository.findAllMozObjReg(objReg);
    }

    @Override
    public int getObjectionListCnt(MozObjReg objReg) {
    	return objRegRepository.countMozObjReg(objReg);
    }

    /**
     * @brief : 이의제기 상세 조회
     * @details : 이의제기 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : objIdx
     * @return : 
     */
    @Override
    public MozObjReg getObjectionDetail(String objIdx) {
    	return objRegRepository.findOneMozObjReg(objIdx);
    }

    /**
     * @brief : 불만사항 리스트 조회
     * @details : 불만사항 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : complaintsReg
     * @return : DataTableVO
     */
    @Override
    public DataTableVO getComplaintListDatatable(MozComplaintsReg complaintsReg) {
        return new DataTableVO(this.getComplaintList(complaintsReg), this.getComplaintListCnt(complaintsReg));
    }
    
    @Override
    public List getComplaintList(MozComplaintsReg complaintsReg) {
    	return complaintsRegRepository.findAllMozComplaintReg(complaintsReg);
    }

    @Override
    public int getComplaintListCnt(MozComplaintsReg complaintsReg) {
    	return complaintsRegRepository.countMozComplaintReg(complaintsReg);
    }

    /**
     * @brief : 불만사항 상세 조회
     * @details : 불만사항 상세
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : complaintsIdx
     * @return : 
     */
    @Override
    public MozComplaintsReg getComplaintDetail(String complaintsIdx) {
    	return complaintsRegRepository.findOneComplaintDetail(complaintsIdx);
    }

    /**
     * @brief : 범칙금 납부처 등록 
     * @details : 범칙금 납부처 등록
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : 
     * @return : 
     */
    @Override
    public void registPenaltyPlace(MozPlPymntInfo plPymntInfo) {
    	//TODO
    	plPymntInfo.setCrtr("lim");
    	plPymntInfoRepository.saveMozPlPymntInfo(plPymntInfo);
    }

    /**
     * @brief : 범칙금 납부처 리스트 조회
     * @details : 범칙금 납부처 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : plPymntInfo
     * @return : 
     */
    @Override
    public DataTableVO getPenaltyPlaceListDatatable(MozPlPymntInfo plPymntInfo) {
        return new DataTableVO(this.getPenaltyPlaceList(plPymntInfo), this.getPenaltyPlaceListCnt(plPymntInfo));
    }
    
    @Override
    public List getPenaltyPlaceList(MozPlPymntInfo plPymntInfo) {
    	return plPymntInfoRepository.findAllPenaltyPlaceList(plPymntInfo);
    }

    @Override
    public int getPenaltyPlaceListCnt(MozPlPymntInfo plPymntInfo) {
    	return plPymntInfoRepository.countPenaltyPlaceList(plPymntInfo);
    }

    /**
     * @brief : 범칙금 납부처 상세 
     * @details : 범칙금 납부처 상세
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    @Override
    public MozPlPymntInfo getPenaltyPlaceDetail(String placePymntId) {
    	return plPymntInfoRepository.findOnePenaltyPlaceDetail(placePymntId);
    }

    /**
     * @brief : 범칙금 납부처 수정
     * @details : 범칙금 납부처 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    @Override
    public void updatePenaltyPlace(MozPlPymntInfo plPymntInfo) {
    	plPymntInfoRepository.updatePenaltyPlace(plPymntInfo);
    }

    /**
     * @brief : 공지사항 삭제
     * @details : 공지사항 삭제 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : boardIdx
     * @return : 
     */
    @Override
    public void deleteNotice(String boardIdx) {
    	brdRepository.deleteNotice(boardIdx);
    }

    /**
     * @brief : FAQ 삭제
     * @details : FAQ 삭제
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faqIdx
     * @return : 
     */
    @Override
    public void deleteFaq(String faqIdx) {
    	faqRepository.deleteMozFaq(faqIdx);
    }

    /**
     * @brief : 범칙금 납부처 삭제
     * @details : 범칙금 납부처 삭제 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    @Override
    public void deletePenaltyPlace(String placePymntId) {
    	plPymntInfoRepository.deletePenaltyPlace(placePymntId);
    }
}

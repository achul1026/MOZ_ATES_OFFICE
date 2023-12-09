package com.moz.ates.traffic.office.govPortal;

import com.moz.ates.traffic.common.entity.board.MozBrd;
import com.moz.ates.traffic.common.entity.board.MozComplaintsReg;
import com.moz.ates.traffic.common.entity.board.MozFaq;
import com.moz.ates.traffic.common.entity.board.MozObjReg;
import com.moz.ates.traffic.common.entity.payment.MozPlPymntInfo;
import com.moz.ates.traffic.office.common.DataTableVO;

import java.util.List;

/**
 * className : PortalService
 * author : Mike Lim
 * description : 포털 관련 서비스
 */
public interface PortalService {
	
    /**
     * @brief : 공지사항 등록
     * @details : 공지사항 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : brd
     * @return : 
     */
    void registNotice(MozBrd brd);

    /**
     * @brief : 공지사항 리스트 조회
     * @details : 공지사항 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : brd
     * @return : DataTableVO
     */
    DataTableVO getNoticeListDatatable(MozBrd brd);

    List getNoticeList(MozBrd brd);

    int getNoticeListCnt(MozBrd brd);

    /**
     * @brief : 공지사항 상세 화면
     * @details : 공지사항 상세 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : boardIdx
     * @return : 
     */
    MozBrd getNoticeDetail(String boardIdx);

    /**
     * @brief : 공지사항 수정 
     * @details : 공지사항 수정 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : brd
     * @return : 
     */
    void updateNotice(MozBrd brd);

    /**
     * @brief : FAQ 리스트 조회
     * @details : FAQ 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : faq
     * @return : DataTableVO
     */
    DataTableVO getFaqListDatatable(MozFaq faq);

    List getFaqList(MozFaq faq);

    int getFaqListCnt(MozFaq faq);
    
    /**
     * @brief : FAQ 등록 
     * @details : FAQ 등록 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faq
     * @return : 
     */
    void registFaq(MozFaq faq);
    
    /**
     * @brief : FAQ 상세 조회
     * @details : FAQ 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faqIdx
     * @return : 
     */
    MozFaq getFaqDetail(String faqIdx);

    /**
     * @brief : FAQ 수정
     * @details : FAQ 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faq
     * @return : 
     */
    void updateFaq(MozFaq faq);
    
    /**
     * @brief : 이의제기 리스트 조회
     * @details : 이의제기 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : objReg
     * @return : DataTableVO
     */
    DataTableVO getObjectionListDatatable(MozObjReg objReg);

    List getObjectionList(MozObjReg objReg);

    int getObjectionListCnt(MozObjReg objReg);

    /**
     * @brief : 이의제기 상세 조회
     * @details : 이의제기 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : objIdx
     * @return : 
     */
    MozObjReg getObjectionDetail(String objIdx);

    /**
     * @brief : 불만사항 리스트 조회
     * @details : 불만사항 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : complaintsReg
     * @return : DataTableVO
     */
    DataTableVO getComplaintListDatatable(MozComplaintsReg complaintsReg);

    List getComplaintList(MozComplaintsReg complaintsReg);

    int getComplaintListCnt(MozComplaintsReg complaintsReg);

    /**
     * @brief : 불만사항 상세 조회
     * @details : 불만사항 상세
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : complaintsIdx
     * @return : 
     */
    MozComplaintsReg getComplaintDetail(String complaintsIdx);
    
    /**
     * @brief : 범칙금 납부처 등록 
     * @details : 범칙금 납부처 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    void registPenaltyPlace(MozPlPymntInfo plPymntInfo);

    /**
     * @brief : 범칙금 납부처 리스트 조회
     * @details : 범칙금 납부처 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : plPymntInfo
     * @return : 
     */
    DataTableVO getPenaltyPlaceListDatatable(MozPlPymntInfo plPymntInfo);

    List getPenaltyPlaceList(MozPlPymntInfo plPymntInfo);
    
    int getPenaltyPlaceListCnt(MozPlPymntInfo plPymntInfo);

    /**
     * @brief : 범칙금 납부처 상세 
     * @details : 범칙금 납부처 상세
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    MozPlPymntInfo getPenaltyPlaceDetail(String placePymntId);

    /**
     * @brief : 범칙금 납부처 수정
     * @details : 범칙금 납부처 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    void updatePenaltyPlace(MozPlPymntInfo plPymntInfo);

    /**
     * @brief : 공지사항 삭제
     * @details : 공지사항 삭제 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : boardIdx
     * @return : 
     */
    void deleteNotice(String boardIdx);
    
    /**
     * @brief : FAQ 삭제
     * @details : FAQ 삭제
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faqIdx
     * @return : 
     */
    void deleteFaq(String faqIdx);

    /**
     * @brief : 범칙금 납부처 삭제
     * @details : 범칙금 납부처 삭제 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    void deletePenaltyPlace(String placePymntId);
}

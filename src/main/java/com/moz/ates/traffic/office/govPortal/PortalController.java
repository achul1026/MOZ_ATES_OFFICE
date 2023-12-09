package com.moz.ates.traffic.office.govPortal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.moz.ates.traffic.common.entity.board.MozBrd;
import com.moz.ates.traffic.common.entity.board.MozComplaintsReg;
import com.moz.ates.traffic.common.entity.board.MozFaq;
import com.moz.ates.traffic.common.entity.board.MozObjReg;
import com.moz.ates.traffic.common.entity.common.MozCmCd;
import com.moz.ates.traffic.common.entity.payment.MozPlPymntInfo;
import com.moz.ates.traffic.office.common.CommonCdService;
import com.moz.ates.traffic.office.common.DataTableVO;

@Controller
@RequestMapping(value = "portal")
public class PortalController {

    @Autowired
    private CommonCdService commonCdService;

    @Autowired
    private PortalService portalService;


    /**
     * @brief : 공지사항 리스트 화면
     * @details : 공지사항 리스트 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : brd
     * @return : 
     */
    @RequestMapping(value = "noticeList")
    public String noticeList(Model model, @ModelAttribute MozBrd brd){

        model.addAttribute("brd", brd);
        return "NoticeList";
    }

    /**
     * @brief : 공지사항 리스트 조회
     * @details : 공지사항 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : brd
     * @return : DataTableVO
     */
    @PostMapping(value = "noticeListAjax")
    @ResponseBody
    public DataTableVO noticeListAjax(@ModelAttribute MozBrd brd){

        return portalService.getNoticeListDatatable(brd);
    }

    /**
     * @brief : 공지사항 등록 화면
     * @details : 공지사항 등록 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "noticeRegist")
    public String noticeRegist(Model model){

        List<MozCmCd> cdList = commonCdService.getCdList("ntc");
        model.addAttribute("cdList", cdList);

        return "NoticeRegist";
    }

    /**
     * @brief : 공지사항 등록
     * @details : 공지사항 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : brd
     * @return : 
     */
    @RequestMapping(value = "noticeRegistAjax")
    @ResponseBody
    public Map<String,Object> noticeRegistAjax(MozBrd brd){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.registNotice(brd);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    /**
     * @brief : 공지사항 삭제
     * @details : 공지사항 삭제 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : boardIdx
     * @return : 
     */
    @RequestMapping(value = "noticeDeleteAjax")
    @ResponseBody
    public Map<String,Object> noticeDeleteAjax(@RequestParam("boardIdx")String boardIdx){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.deleteNotice(boardIdx);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    /**
     * @brief : 공지사항 상세 화면
     * @details : 공지사항 상세 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : boardIdx
     * @return : 
     */
    @RequestMapping(value = "noticeDetail")
    public String noticeDetail(Model model, @RequestParam("boardIdx")String boardIdx){

        MozBrd brd = portalService.getNoticeDetail(boardIdx);
        model.addAttribute("brd", brd);

        return "NoticeDetail";
    }

    /**
     * @brief : 공지사항 수정 화면
     * @details : 공지사항 수정 화면
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : boardIdx
     * @return : 
     */
    @RequestMapping(value = "noticeModify")
    public String noticeModify(Model model, @RequestParam("boardIdx")String boardIdx){

        List<MozCmCd> cdList = commonCdService.getCdList("ntc");
        model.addAttribute("cdList", cdList);

        MozBrd brd = portalService.getNoticeDetail(boardIdx);
        model.addAttribute("brd", brd);

        return "NoticeModify";
    }

    /**
     * @brief : 공지사항 수정 
     * @details : 공지사항 수정 
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : brd
     * @return : 
     */
    @RequestMapping(value = "noticeModifyAjax")
    @ResponseBody
    public Map<String,Object> noticeModifyAjax(@ModelAttribute MozBrd brd){
        Map<String, Object> result = new HashMap<>();
        try {
            portalService.updateNotice(brd);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    /**
     * @brief : FAQ 리스트 화면
     * @details : FAQ 리스트 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faq
     * @return : 
     */
    @RequestMapping(value = "faqList")
    public String faqList(Model model, @ModelAttribute MozFaq faq){

        model.addAttribute("faq", faq);
        return "FaqList";
    }

    /**
     * @brief : FAQ 리스트 조회
     * @details : FAQ 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faq
     * @return : DataTableVO
     */
    @PostMapping(value = "faqListAjax")
    @ResponseBody
    public DataTableVO faqListAjax(@ModelAttribute MozFaq faq){

        return portalService.getFaqListDatatable(faq);
    }

    /**
     * @brief : FAQ 등록 화면
     * @details : FAQ 등록 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "faqRegist")
    public String faqRegist(Model model){

        List<MozCmCd> cdList = commonCdService.getCdList("faq");
        model.addAttribute("cdList", cdList);

        return "FaqRegist";
    }

    /**
     * @brief : FAQ 등록 
     * @details : FAQ 등록 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faq
     * @return : 
     */
    @RequestMapping(value = "faqRegistAjax")
    @ResponseBody
    public Map<String,Object> faqRegistAjax(MozFaq faq){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.registFaq(faq);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    /**
     * @brief : FAQ 상세 조회
     * @details : FAQ 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : faqIdx
     * @return : 
     */
    @RequestMapping(value = "faqDetail")
    public String faqDetail(Model model, @RequestParam("faqIdx")String faqIdx){

        List<MozCmCd> cdList = commonCdService.getCdList("faq");
        model.addAttribute("cdList", cdList);

        MozFaq faq = portalService.getFaqDetail(faqIdx);
        model.addAttribute("faq", faq);

        return "FaqDetail";
    }

    /**
     * @brief : FAQ 수정 화면
     * @details : FAQ 수정 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faqIdx
     * @return : 
     */
    @RequestMapping(value = "faqModify")
    public String faqModify(Model model, @RequestParam("faqIdx")String faqIdx){

        List<MozCmCd> cdList = commonCdService.getCdList("faq");
        model.addAttribute("cdList", cdList);

        MozFaq faq = portalService.getFaqDetail(faqIdx);
        model.addAttribute("faq", faq);

        return "FaqModify";
    }

    /**
     * @brief : FAQ 수정
     * @details : FAQ 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faq
     * @return : 
     */
    @RequestMapping(value = "faqModifyAjax")
    @ResponseBody
    public Map<String,Object> faqModifyAjax(@ModelAttribute MozFaq faq){
        Map<String, Object> result = new HashMap<>();
        try {
            portalService.updateFaq(faq);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    /**
     * @brief : FAQ 삭제
     * @details : FAQ 삭제
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : faqIdx
     * @return : 
     */
    @RequestMapping(value = "faqDeleteAjax")
    @ResponseBody
    public Map<String,Object> faqDeleteAjax(@RequestParam("faqIdx")String faqIdx){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.deleteFaq(faqIdx);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    /**
     * @brief : 이의제기 리스트 화면
     * @details : 이의제기 리스트 화면  
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : objReg
     * @return : 
     */
    @RequestMapping(value = "objectionList")
    public String objectionList(Model model, @ModelAttribute MozObjReg objReg ){

        model.addAttribute("objReg", objReg);

        return "ObjectionList";
    }

    /**
     * @brief : 이의제기 리스트 조회
     * @details : 이의제기 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : objReg
     * @return : DataTableVO
     */
    @PostMapping(value = "objectionListAjax")
    @ResponseBody
    public DataTableVO objectionListAjax(@ModelAttribute MozObjReg objReg){

        return portalService.getObjectionListDatatable(objReg);
    }

    /**
     * @brief : 이의제기 상세 조회
     * @details : 이의제기 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : objIdx
     * @return : 
     */
    @RequestMapping(value = "objectionDetail")
    public String objectionDetail(Model model, @RequestParam("objIdx")String objIdx){

    	MozObjReg objReg = portalService.getObjectionDetail(objIdx);
        model.addAttribute("objReg", objReg);
        return "ObjectionDetail";
    }

//    @RequestMapping(value = "sendObjAnswer")
//    public Map<String, Object> sendObjAnswer(ObjectionVO objectionVO){
//        Map<String, Object> result = new HashMap<>();
//
//        Map<String, Object> emailValues = new HashMap<>();
//
//
//    }

    /**
     * @brief : 불만사항 리스트 화면
     * @details : 불만사항 리스트 화면  
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : complaintsReg
     * @return : 
     */
    @RequestMapping(value = "complaintList")
    public String complaintList(Model model, @ModelAttribute MozComplaintsReg complaintsReg){

        model.addAttribute("complaintsReg", complaintsReg);
        return "ComplaintList";
    }

    /**
     * @brief : 불만사항 리스트 조회
     * @details : 불만사항 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : complaintsReg
     * @return : DataTableVO
     */
    @PostMapping(value = "complaintListAjax")
    @ResponseBody
    public DataTableVO complaintListAjax(@ModelAttribute MozComplaintsReg complaintsReg){

        return portalService.getComplaintListDatatable(complaintsReg);
    }

    /**
     * @brief : 불만사항 상세 조회
     * @details : 불만사항 상세
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : complaintsIdx
     * @return : 
     */
    @RequestMapping(value = "complaintDetail")
    public String complaintDetail(Model model, @RequestParam("complaintsIdx")String complaintsIdx){

    	MozComplaintsReg complaintsReg = portalService.getComplaintDetail(complaintsIdx);
        model.addAttribute("complaintsReg", complaintsReg);
        return "ComplaintDetail";
    }
    
    /**
     * @brief : 범칙금 납부처 리스트 화면
     * @details : 범칙금 납부처 리스트 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : plPymntInfo
     * @return : 
     */
    @RequestMapping(value = "penaltyPlaceList")
    public String penaltyPlaceList(Model model,@ModelAttribute MozPlPymntInfo plPymntInfo){

        model.addAttribute("plPymntInfo", plPymntInfo);
        return "PenaltyPlaceList";
    }

    /**
     * @brief : 범칙금 납부처 리스트 조회
     * @details : 범칙금 납부처 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : plPymntInfo
     * @return : 
     */
    @PostMapping(value = "penaltyPlaceListAjax")
    @ResponseBody
    public DataTableVO penaltyPlaceListAjax(@ModelAttribute MozPlPymntInfo plPymntInfo){

        return portalService.getPenaltyPlaceListDatatable(plPymntInfo);
    }

    /**
     * @brief : 범칙금 납부처 등록 화면
     * @details : 범칙금 납부처 등록 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "penaltyPlaceRegist")
    public String penaltyPlaceRegist(Model model){

        return "PenaltyPlaceRegist";
    }

    /**
     * @brief : 범칙금 납부처 등록 
     * @details : 범칙금 납부처 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "penaltyPlaceRegistAjax")
    @ResponseBody
    public Map<String,Object> penaltyPlaceRegistAjax(MozPlPymntInfo plPymntInfo){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.registPenaltyPlace(plPymntInfo);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    /**
     * @brief : 범칙금 납부처 상세 
     * @details : 범칙금 납부처 상세
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    @RequestMapping(value = "penaltyPlaceDetail")
    public String penaltyPlaceDetail(Model model,@RequestParam("placePymntId")String placePymntId){

    	MozPlPymntInfo plPymntInfo = portalService.getPenaltyPlaceDetail(placePymntId);
        model.addAttribute("plPymntInfo", plPymntInfo);

        return "PenaltyPlaceDetail";
    }

    /**
     * @brief : 범칙금 납부처 수정 화면
     * @details : 범칙금 납부처 수정 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    @RequestMapping(value = "penaltyPlaceModify")
    public String penaltyPlaceModify(Model model,@RequestParam("placePymntId")String placePymntId){

    	MozPlPymntInfo plPymntInfo = portalService.getPenaltyPlaceDetail(placePymntId);
        model.addAttribute("plPymntInfo", plPymntInfo);

        return "PenaltyPlaceModify";
    }

    /**
     * @brief : 범칙금 납부처 수정
     * @details : 범칙금 납부처 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    @RequestMapping(value = "penaltyPlaceModifyAjax")
    @ResponseBody
    public Map<String,Object> penaltyPlaceModifyAjax(@ModelAttribute MozPlPymntInfo plPymntInfo){
        Map<String, Object> result = new HashMap<>();
        try {
            portalService.updatePenaltyPlace(plPymntInfo);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }

    /**
     * @brief : 범칙금 납부처 삭제
     * @details : 범칙금 납부처 삭제 
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : placePymntId
     * @return : 
     */
    @RequestMapping(value = "penaltyPlaceDeleteAjax")
    @ResponseBody
    public Map<String,Object> penaltyPlaceDeleteAjax(@RequestParam("placePymntId")String placePymntId){
        Map<String, Object> result = new HashMap<>();

        try {
            portalService.deletePenaltyPlace(placePymntId);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }



}

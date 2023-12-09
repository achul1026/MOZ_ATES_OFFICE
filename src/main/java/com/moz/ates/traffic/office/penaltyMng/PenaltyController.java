package com.moz.ates.traffic.office.penaltyMng;

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

import com.moz.ates.traffic.common.entity.common.MozCmCd;
import com.moz.ates.traffic.common.entity.payment.MozFinePymntInfo;
import com.moz.ates.traffic.office.common.CommonCdService;
import com.moz.ates.traffic.office.common.DataTableVO;

@Controller
@RequestMapping(value = "penalty")
public class PenaltyController {

    @Autowired
    private CommonCdService commonCdService;

    @Autowired
    private PenaltyService penaltyService;

    /**
     * @brief : 범칙금 리스트 화면
     * @details : 범칙금 리스트 화면
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : 
     */
    @RequestMapping(value = "mngList")
    public String mngList(Model model, @ModelAttribute MozFinePymntInfo finePymntInfo){

        model.addAttribute("finePymntInfo",finePymntInfo);
        return "PenaltyMngList";
    }

    /**
     * @brief : 범칙금 리스트 조회
     * @details : 범칙금 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : DataTableVO
     */
    @PostMapping(value = "mngListAjax")
    @ResponseBody
    public DataTableVO mngListAjax(@ModelAttribute MozFinePymntInfo finePymntInfo){
    	
        return penaltyService.getPenaltyListDatatable(finePymntInfo);
    }

    /**
     * @brief : 범칙금 등록 화면
     * @details : 범칙금 등록 화면
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "mngRegist")
    public String mngRegist(Model model){

        List<MozCmCd> cdList = commonCdService.getCdList("pay");
        model.addAttribute("cdList", cdList);

        return "PenaltyMngRegist";
    }

    /**
     * @brief : 범칙금 등록
     * @details : 범칙금 등록
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : 
     */
    @RequestMapping(value = "mngRegistAjax")
    @ResponseBody
    public Map<String,Object> mngRegistAjax(MozFinePymntInfo finePymntInfo){
        Map<String, Object> result = new HashMap<>();

        penaltyService.registPenalty(finePymntInfo);
//        try {
//            result.put("code", "1");
//        }catch (Exception e){
//            result.put("code", "0");
//        }

        return result;
    }

    /**
     * @brief : 범칙금 상세 조회
     * @details : 범칙금 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : pymntId
     * @return : 
     */
    @RequestMapping(value = "mngDetail")
    public String mngDetail(Model model, @RequestParam("pymntId")String pymntId){

    	MozFinePymntInfo finePymntInfo = penaltyService.getPenaltyDetail(pymntId);
        model.addAttribute("finePymntInfo",finePymntInfo);
        return "PenaltyMngDetail";
    }
    
    /**
     * @brief : 범칙금 수정 화면
     * @details : 범칙금 수정 화면
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : pymntId
     * @return : 
     */
    @RequestMapping(value = "mngModify")
    public String mngModify(Model model,@RequestParam("pymntId")String pymntId){

        List<MozCmCd> cdList = commonCdService.getCdList("pay");
        model.addAttribute("cdList", cdList);

        MozFinePymntInfo finePymntInfo = penaltyService.getPenaltyDetail(pymntId);
        model.addAttribute("finePymntInfo",finePymntInfo);
        return "PenaltyMngModify";
    }

    /**
     * @brief : 범칙금 수정
     * @details : 범칙금 수정
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : pymntId
     * @return : 
     */
    @RequestMapping(value = "mngModifyAjax")
    @ResponseBody
    public Map<String,Object> mngModifyAjax(MozFinePymntInfo finePymntInfo){
        Map<String, Object> result = new HashMap<>();
        try {
        	penaltyService.updatePenalty(finePymntInfo);
            
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }

        return result;
    }
}

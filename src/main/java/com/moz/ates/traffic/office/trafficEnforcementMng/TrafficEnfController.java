package com.moz.ates.traffic.office.trafficEnforcementMng;

import com.moz.ates.traffic.common.entity.enforcement.MozTfcEnfMaster;
import com.moz.ates.traffic.common.entity.law.MozTfcLwInfo;
import com.moz.ates.traffic.office.common.DataTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;



@Controller
@RequestMapping(value = "enf")
public class TrafficEnfController {

    @Autowired
    private TrafficEnfService trafficEnfService;


    /**
     * @brief : 운전자 정보 조회
     * @details : 운전자 정보 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : enfSearchVO
     * @return : 
     */
    @GetMapping(value = "searchDriver")
    public String searchDriver(Model model, @ModelAttribute EnfSearchVO enfSearchVO){
        DriverVO driverDetail = new DriverVO();

        System.out.println(enfSearchVO.toString());

        if(enfSearchVO.getName() != null){
            driverDetail = trafficEnfService.getDriverDetail(enfSearchVO);
        }

        model.addAttribute("driverDetail", driverDetail);
        model.addAttribute("enfSearchVO", enfSearchVO);
        return "SearchDriver";
    }

    /**
     * @brief : 차량 정보 조회 화면
     * @details : 차량 정보 조회 화면
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : enfSearchVO
     * @return : 
     */
    @GetMapping(value = "searchCar")
    public String searchCar(Model model, @ModelAttribute EnfSearchVO enfSearchVO){
        DriverVO driverDetail = new DriverVO();

        System.out.println(enfSearchVO.toString());

        if(enfSearchVO.getName() != null){ driverDetail = trafficEnfService.getDriverDetail(enfSearchVO);}

        model.addAttribute("driverDetail", driverDetail);
        model.addAttribute("enfSearchVO", enfSearchVO);
        return "SearchCar";
    }

    /**
     * @brief : 차량 정보 조회
     * @details : 차량 정보 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : enfSearchVO
     * @return : 
     */
    @PostMapping(value = "searchCarAjax")
    public String searchCarAjax(Model model, @ModelAttribute EnfSearchVO enfSearchVO){
        CarVO carDetail = new CarVO();

        if(enfSearchVO.getCarNum() != null) { carDetail = trafficEnfService.getCarDetail(enfSearchVO); }

        model.addAttribute("carDetail", carDetail);
        model.addAttribute("enfSearchVO", enfSearchVO);
        return "SearchCarAjax";
    }

    /**
     * @brief : 교통단속 정보 리스트 화면
     * @details : 교통단속 정보 리스트 화면
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfMaster
     * @return : 
     */
    @GetMapping(value = "infoList")
    public String infoList(Model model, @ModelAttribute MozTfcEnfMaster tfcEnfMaster){

        model.addAttribute("tfcEnfMaster", tfcEnfMaster);
        return "InfoList";
    }
    
    /**
     * @brief : 교통단속 정보 리스트 조회
     * @details : 교통단속 정보 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfMaster
     * @return : 
     */
    @PostMapping(value = "infoListAjax")
    @ResponseBody
    public DataTableVO infoListAjax(@ModelAttribute MozTfcEnfMaster tfcEnfMaster){

        return trafficEnfService.getInfoListDatatable(tfcEnfMaster);
    }

    /**
     * @brief : 교통단속 정보 상세 조회
     * @details : 교통단속 정보 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcEnfId
     * @return : 
     */
    @RequestMapping(value = "infoDetail")
    public String infoDetail(Model model, @RequestParam("tfcEnfId")String tfcEnfId){

    	MozTfcEnfMaster tfcEnfMaster = trafficEnfService.getTrafficEnfDetail(tfcEnfId);

        model.addAttribute("tfcEnfMaster", tfcEnfMaster);
        return "InfoDetail";
    }

    /**
     * @brief : 교통단속 정보 수정 화면
     * @details : 교통단속 정보 수정 화면
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcEnfId
     * @return : 
     */
    @GetMapping(value = "infoModify")
    public String infoModify(Model model, @RequestParam("tfcEnfId")String tfcEnfId){


    	MozTfcEnfMaster tfcEnfMaster = trafficEnfService.getTrafficEnfDetail(tfcEnfId);

        model.addAttribute("tfcEnfMaster", tfcEnfMaster);
        return "InfoModify";
    }

    /**
     * @brief : 교통단속 정보 수정
     * @details : 교통단속 정보 수정
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcEnfMaster
     * @param : imageFile
     * @param : totalPrice
     * @return : 
     */
    @PostMapping(value = "infoModifyAjax")
    @ResponseBody
    public Map<String, Object> infoModifyAjax(@ModelAttribute MozTfcEnfMaster tfcEnfMaster){
        Map<String, Object> result = new HashMap<>();

        try {
        	trafficEnfService.updateInfo(tfcEnfMaster);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }


        return result;
    }


    /**
     * @brief : 교통단속 법률관리 리스트 화면
     * @details : 교통단속 법률관리 리스트 화면
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcLwInfo
     * @return : 
     */
    @RequestMapping(value = "lawList")
    public String lawList(Model model, @ModelAttribute MozTfcLwInfo tfcLwInfo){

        model.addAttribute("tfcLwInfo", tfcLwInfo);
        return "LawList";
    }

    /**
     * @brief : 교통단속 법률관리 리스트 조회
     * @details : 교통단속 법률관리 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcLwInfo
     * @return : 
     */
    @RequestMapping(value = "lawListAjax")
    @ResponseBody
    public DataTableVO lawListAjax(@ModelAttribute MozTfcLwInfo tfcLwInfo){
    	System.out.println(trafficEnfService.getLawListDatatable(tfcLwInfo));
        return trafficEnfService.getLawListDatatable(tfcLwInfo);
    }


    /**
     * @brief : 교통단속 법률관리 등록 화면
     * @details : 교통단속 법률관리 등록 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "lawRegist")
    public String lawRegist(Model model){

        return "LawRegist";
    }

    /**
     * @brief : 교통단속 법률관리 등록
     * @details : 교통단속 법률관리 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    @PostMapping(value = "lawRegistAjax")
    @ResponseBody
    public Map<String, Object> lawRegistAjax(@ModelAttribute MozTfcLwInfo tfcLwInfo){
        Map<String, Object> result = new HashMap<>();

        try {
            trafficEnfService.registLaw(tfcLwInfo);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }


        return result;
    }

    /**
     * @brief : 교통단속 법률관리 상세 조회
     * @details : 교통단속 법률관리 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.08
     * @param : tfcLawId
     * @return : 
     */
    @GetMapping(value = "lawDetail")
    public String lawDetail(Model model, @RequestParam("lawId")String tfcLawId){

    	MozTfcLwInfo tfcLwInfo = trafficEnfService.getLawDetail(tfcLawId);
        model.addAttribute("tfcLwInfo", tfcLwInfo);

        return "LawDetail";
    }

    /**
     * @brief : 교통단속 법률관리 수정 화면
     * @details : 교통단속 법률관리 수정 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : tfcLawId
     * @return : 
     */
    @GetMapping(value = "lawModify")
    public String lawModify(Model model, @RequestParam("lawId")String tfcLawId){

    	MozTfcLwInfo tfcLwInfo = trafficEnfService.getLawDetail(tfcLawId);
        model.addAttribute("tfcLwInfo", tfcLwInfo);

        return "LawModfy";
    }

    /**
     * @brief : 교통단속 법률관리 수정
     * @details : 교통단속 법률관리 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : tfcLwInfo
     * @return : 
     */
    @PostMapping(value = "lawModifyAjax")
    @ResponseBody
    public Map<String, Object> lawModifyAjax(@ModelAttribute MozTfcLwInfo tfcLwInfo){
        Map<String, Object> result = new HashMap<>();

        try {
            trafficEnfService.updateLaw(tfcLwInfo);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }


        return result;

    }

    /**
     * @brief : 교통단속 법률관리 삭제
     * @details : 교통단속 법률관리 삭제
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : tfcLawId
     * @return : 
     */
    @PostMapping(value = "lawDeleteAjax")
    @ResponseBody
    public Map<String, Object> lawDeleteAjax(@RequestParam("lawId")String lawId){
        Map<String, Object> result = new HashMap<>();

        try {
            trafficEnfService.deleteLaw(lawId);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }


        return result;

    }



//    @GetMapping(value = "logList")
//    public String logList (Model model,@ModelAttribute EnfHisVO enfHisVO){
//
//        model.addAttribute("enfHisVO", enfHisVO);
//
//        return "LogList";
//    }
//
//
//    @RequestMapping(value = "logListAjax")
//    @ResponseBody
//    public DataTableVO logListAjax(@ModelAttribute EnfHisVO enfHisVO){
//
//        return trafficEnfService.getLogListDatatable(enfHisVO);
//    }


}

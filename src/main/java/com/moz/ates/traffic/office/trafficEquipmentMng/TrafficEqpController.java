package com.moz.ates.traffic.office.trafficEquipmentMng;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.moz.ates.traffic.common.entity.equipment.MozTfcEnfEqpMaster;
import com.moz.ates.traffic.office.common.DataTableVO;

@Controller
@RequestMapping(value = "eqp")
public class TrafficEqpController {

    @Autowired
    private TrafficEqpService trafficEqpService;

    /**
     * @brief : 단속장비 리스트 화면
     * @details : 단속장비 리스트 화면
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : 
     */
    @RequestMapping(value = "mngList")
    public String mngList(Model model, @ModelAttribute MozTfcEnfEqpMaster tfcEnfEqpMaster){
    	
        model.addAttribute("tfcEnfEqpMaster",tfcEnfEqpMaster);
        return "EqpMngList";
    }

    /**
     * @brief : 단속장비 리스트 조회
     * @details : 단속장비 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : finePymntInfo
     * @return : DataTableVO
     */
    @PostMapping(value = "mngListAjax")
    @ResponseBody
    public DataTableVO mngListAjax(@ModelAttribute MozTfcEnfEqpMaster tfcEnfEqpMaster){

        return trafficEqpService.getMngListDatatable(tfcEnfEqpMaster);
    }

    /**
     * @brief : 단속장비 등록 화면
     * @details : 단속장비 등록 화면
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "mngRegist")
    public String mngRegist(Model model){

        return "EqpMngRegist";
    }

    /**
     * @brief : 단속장비 등록 
     * @details : 단속장비 등록 
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "mngRegistAjax")
    @ResponseBody
    public Map<String,Object> mngRegistAjax(@ModelAttribute MozTfcEnfEqpMaster tfcEnfEqpMaster, @RequestParam("uploadFile") MultipartFile imageFile) throws IOException{
        Map<String, Object> result = new HashMap<>();

        int dupliCnt = trafficEqpService.getEqpDupliCnt(tfcEnfEqpMaster);
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid+"_"+imageFile.getOriginalFilename();
        String projectPath = System.getProperty("user.dir")+"/src/main/resources/static/images/";
        File makeFolder = new File(projectPath);       
        
        if(!makeFolder.exists()) {
        	makeFolder.mkdir();
        	System.out.println("폴더 생성 성공");
        }else {
        	System.out.println("해당 폴더가 존재 합니다");
        }
        String file_path = projectPath+fileName;
        File file = new File(file_path);
        FileOutputStream fo = new FileOutputStream(file);
        byte[] fileBytes = imageFile.getBytes();
        fo.write(fileBytes);
        fo.close();
        
        tfcEnfEqpMaster.setTfcEnfEqpImagepath(file_path);
        tfcEnfEqpMaster.setTfcEnfEqpImageorgn(fileName);
        
        if(dupliCnt > 0){
            result.put("code", "-1");
            result.put("msg", "중복된 장비번호 입니다.");
        }else{
            try {
            	trafficEqpService.registEqp(tfcEnfEqpMaster);
                result.put("code", "1");
            }catch (Exception e){
                result.put("code", "0");
                result.put("msg", "error");
            }
        }
        return result;
    }
    
    /**
     * @brief : 단속장비 상세 조회
     * @details : 단속장비 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfEqpId
     * @return : 
     */
    @RequestMapping(value = "mngDetail")
    public String mngDetail(Model model, @RequestParam("tfcEnfEqpId")String tfcEnfEqpId){
    	MozTfcEnfEqpMaster tfcEnfEqpMaster = trafficEqpService.getEqpDetail(tfcEnfEqpId);
        model.addAttribute("tfcEnfEqpMaster",tfcEnfEqpMaster);
        return "EqpMngDetail";
    }
    
    /**
     * @brief : 단속장비 수정 화면
     * @details : 단속장비 수정 화면
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfEqpId
     * @return : 
     */
    @RequestMapping(value = "mngModify")
    public String mngModify(Model model, @RequestParam("tfcEnfEqpId")String tfcEnfEqpId){

    	MozTfcEnfEqpMaster tfcEnfEqpMaster = trafficEqpService.getEqpDetail(tfcEnfEqpId);
    	model.addAttribute("tfcEnfEqpMaster",tfcEnfEqpMaster);
        return "EqpMngModify";
    }

    /**
     * @brief : 단속장비 정보 수정
     * @details : 단속장비 정보 수정
     * @author : KC.KIM
     * @date : 2023.08.04
     * @param : tfcEnfEqpMaster
     * @return : 
     */
    @PostMapping(value = "mngModifyAjax")
    @ResponseBody
    public Map<String, Object> mngModifyAjax(@ModelAttribute MozTfcEnfEqpMaster tfcEnfEqpMaster){
        Map<String, Object> result = new HashMap<>();

        try {
        	trafficEqpService.updateEqp(tfcEnfEqpMaster);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
        }


        return result;
    }

//    @RequestMapping(value = "logList")
//    public String logList(Model model,@ModelAttribute EqpLogVO eqpLogVO){
//
//        model.addAttribute("eqpLogVO", eqpLogVO);
//
//        return "EqpLogList";
//    }
//
//    @RequestMapping(value = "logListAjax")
//    @ResponseBody
//    public DataTableVO logListAjax(@ModelAttribute EqpLogVO eqpLogVO){
//
//        return trafficEqpService.getLogListDatatable(eqpLogVO);
//    }


}

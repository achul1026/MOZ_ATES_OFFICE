package com.moz.ates.traffic.office.user;

import com.moz.ates.traffic.common.entity.operator.MozWebOprtr;
import com.moz.ates.traffic.office.common.DataTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    /**
     * @brief : 관리자 등록 화면
     * @details : 관리자 등록 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : 
     * @return : 
     */
    @RequestMapping(value = "newUserRegist")
    public String newUserRegist(Model model){

        return "UserRegist";
    }
    
    /**
     * @brief : 관리자 등록
     * @details : 관리자 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : webOprtr
     * @return : 
     */
    @RequestMapping(value = "userRegistAjax")
    @ResponseBody
    public Map<String,Object> userRegistAjax(@ModelAttribute MozWebOprtr webOprtr, Principal principal){
        Map<String, Object> result = new HashMap<>();
        int dupliUserChk = userService.getDupliChk(webOprtr);

        if(dupliUserChk > 0){
            result.put("code", "-1");
            result.put("msg", "중복된 아이디가 있습니다.");
        }else{
            try {
                System.out.println(principal.getName());
                webOprtr.setCrtr(principal.getName());
                if(webOprtr.getOprtrAccountPw() != null && !webOprtr.getOprtrAccountPw().isEmpty()){
                	webOprtr.setOprtrAccountPw(passwordEncoder.encode(webOprtr.getOprtrAccountPw()));
                }
                userService.registUser(webOprtr);
                result.put("code", "1");
            }catch (Exception e){
                result.put("code", "0");
                result.put("msg", e.getMessage());
            }

        }
        return result;
    }

    /**
     * @brief : 관리자 리스트 화면
     * @details : 관리자 리스트 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : webOprtr
     * @return : 
     */
    @RequestMapping(value = "userList")
    public String userList(Model model,@ModelAttribute MozWebOprtr webOprtr){

        model.addAttribute("webOprtr", webOprtr);
        return "UserList";
    }

    /**
     * @brief : 관리자 리스트 조회
     * @details : 관리자 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : webOprtr
     * @return : DataTableVO
     */
    @PostMapping(value = "userListAjax")
    @ResponseBody
    public DataTableVO userListAjax(@ModelAttribute MozWebOprtr webOprtr){

        return userService.getUserListDatatable(webOprtr);
    }

    /**
     * @brief : 관리자 상세 조회
     * @details : 관리자 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : oprtrId
     * @return : 
     */
    @RequestMapping(value = "userDetail")
    public String mngDetail(Model model, @RequestParam("oprtrId")String oprtrId){

    	MozWebOprtr webOprtr = userService.getUserDetail(oprtrId);
        model.addAttribute("webOprtr", webOprtr);

        return "UserDetail";
    }
    
    /**
     * @brief : 관리자 수정 화면
     * @details : 관리자 수정 화면
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : oprtrId
     * @return : 
     */
    @RequestMapping(value = "userModify")
    public String mngModify(Model model, @RequestParam("oprtrId")String oprtrId){

    	MozWebOprtr webOprtr = userService.getUserDetail(oprtrId);
        model.addAttribute("webOprtr", webOprtr);

        return "UserModify";
    }
    
    /**
     * @brief : 관리자 수정
     * @details : 관리자 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : webOprtr
     * @return : 
     */
    @RequestMapping(value = "userModifyAjax")
    @ResponseBody
    public Map<String,Object> userModifyAjax(@ModelAttribute MozWebOprtr webOprtr){
        Map<String, Object> result = new HashMap<>();
        try {
            if(webOprtr.getOprtrAccountPw() != null && !webOprtr.getOprtrAccountPw().isEmpty()){
            	webOprtr.setOprtrAccountPw(passwordEncoder.encode(webOprtr.getOprtrAccountPw()));
            }
            userService.updateUser(webOprtr);
            result.put("code", "1");
        }catch (Exception e){
            result.put("code", "0");
            result.put("msg", e.getMessage());
        }

        return result;
    }




}

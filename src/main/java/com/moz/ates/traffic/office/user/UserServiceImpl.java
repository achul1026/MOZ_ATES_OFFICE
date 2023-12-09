package com.moz.ates.traffic.office.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moz.ates.traffic.common.entity.operator.MozWebOprtr;
import com.moz.ates.traffic.common.repository.operator.MozWebOprtrRepository;
import com.moz.ates.traffic.office.common.DataTableVO;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    MozWebOprtrRepository webOprtrRepository;
    
    /**
     * @brief : 아이디 중복 조회
     * @details : 아이디 중복 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : webOprtr
     * @return : 
     */
    @Override
    public int getDupliChk(MozWebOprtr webOprtr) {
    	return webOprtrRepository.selectDupliChk(webOprtr);
    }

    /**
     * @brief : 관리자 등록
     * @details : 관리자 등록
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : webOprtr
     * @return : 
     */
    @Override
    public void registUser(MozWebOprtr webOprtr) {
    	webOprtrRepository.insertUser(webOprtr);
    }
    
    /**
     * @brief : 관리자 리스트 조회
     * @details : 관리자 리스트 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : webOprtr
     * @return : DataTableVO
     */
    @Override
    public DataTableVO getUserListDatatable(MozWebOprtr webOprtr) {
        return new DataTableVO(this.getUserList(webOprtr), this.getUserListCnt(webOprtr));
    }

    @Override
    public List getUserList(MozWebOprtr webOprtr) {
    	return webOprtrRepository.selectUserList(webOprtr);
    }
    
    @Override
    public int getUserListCnt(MozWebOprtr webOprtr) {
    	return webOprtrRepository.selectUserListCnt(webOprtr);
    }
    
    /**
     * @brief : 관리자 상세 조회
     * @details : 관리자 상세 조회
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : oprtrId
     * @return : 
     */
    @Override
    public MozWebOprtr getUserDetail(String oprtrId) {
    	return webOprtrRepository.selectUserDetail(oprtrId);
    }

    /**
     * @brief : 관리자 수정
     * @details : 관리자 수정
     * @author : KC.KIM
     * @date : 2023.08.09
     * @param : webOprtr
     * @return : 
     */
    @Override
    public void updateUser(MozWebOprtr webOprtr) {
    	webOprtrRepository.updateUser(webOprtr);
    }

}

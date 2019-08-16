package com.ytd.dao;

import com.ytd.pojo.SysSwquenceJx;
import com.ytd.pojo.UserMain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface UserMainDao extends JpaRepository<UserMain,Integer>,JpaSpecificationExecutor<UserMain>{

    @Query(value = "Select * from user_main WHERE userId = ?1",nativeQuery = true)
    UserMain findByUserid(Integer userId);

    @Query(value = "Select * from user_main WHERE JxMobile = ?1",nativeQuery = true)
    List<UserMain> selectUserMainByJxMobile(String mobile);//查询手机号是否开过户

    @Query(value = "Select * from user_main WHERE IdCardNo = ?1",nativeQuery = true)
    List<UserMain> selectUserMainByIdCardNo(String idNo);//查询身份证是否开过户

    //修改主表
    //void sava(UserMain updateUserMain);




   /* @Modifying
    @Transactional
    @Query("UPDATE user_main u SET u.password=?2 #{userId},#{email},'',#{realName},#{idCardNo}," +
            "#{passwd},'',#{isPwdSet},#{mobile},#{jxMobile},#{city},#{registerTime},#{roles}" +
            ",0.00,#{currBal},0.00,0.00,3,#{portrait},0,0,0,0,#{weiboUId},#{weiboAccessToken}," +
            "#{qqUId},#{qqAccessToken},#{origin},#{staffId},#{userCode},#{referee},#{levelUpdateTime}," +
            "#{level},#{bindTime},#{loginKey},#{userKey},#{cashChl}" +
            "WHERE u.userName=?1")
    void toUpdateUserMain(UserMain updateUserMain);*/
}

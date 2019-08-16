package com.ytd.controller;


import com.alibaba.fastjson.JSON;
import com.ytd.pojo.UserMain;
import com.ytd.service.JxOperationService;
import com.ytd.service.UserMainService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;


@Controller
@CrossOrigin
@RequestMapping("/goUserMain")
public class UserMainController {

    private static final Logger logger = LoggerFactory.getLogger(UserMainController.class);
    @Autowired
    private UserMainService userMainService;
    @Autowired
    private JxOperationService jxOperationService;

   /* @Autowired
    private UserClient userClient;*/

    @RequestMapping("/Accountlist")
    public String list(){
        return "list";
    }

    /**
     * 跳转到我的账户页面
     *
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("/MyAccount")
    public String toOpenCount(String userId, HttpServletRequest request ,HttpSession session) {


        request.setAttribute("userId", userId);

        return "myAccount";
    }
    /*
    跳转到填写三码的页面
     */
    @RequestMapping("/toOpenCountHtml")
    public String toOpenCountHtml( HttpServletRequest request,HttpSession session) {

        Integer userId = (Integer) session.getAttribute("userId");
        request.setAttribute("userId", userId);
        //System.err.println(userId2+"-----"+userId);
        return "openCount";
    }


    /**
     * 注册页面
     *
     * @return
     */
    @RequestMapping("/toregister")
    public String toregister() {
        return "register";
    }

    /**
     * 信息校验是否注册，是否开户
     *
     * @param userId
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/toMyAccount")
    @ResponseBody
    public int toOpenAccount(Integer userId, HttpServletRequest request, HttpSession session) {
        session.setAttribute("userId", userId);
        //验证用户是否注册
        UserMain userMain = userMainService.selectUserMainByUserId(userId);//通过登录用户的userId查询一组对象

        request.setAttribute("useronemain", userMain);
        // 验证用户是否注册
        if (userMain == null) {
            logger.error("用户=" + userMain.getUserId() + "·银行开户 （合规），用户信息不存在，手机号=" + userMain.getMobile() + "", userMain.getUserId(), userMain.getMobile());
            // modelAndView.setViewName("register");
            return 2;
        }
        // 验证用户是否开过户
        if (!userMain.getUserCode().equals("")) {
            logger.error("用户=" + userMain.getUserId() + "·银行开户 （合规），已开通银行存管账户", userMain.getUserId(), userMain.getUserCode());
            return 0;//跳转到已经开过户的页面
        }

        return 1;
    }

    /**
     * 校验真实姓名、手机号、银行卡
     *开通银行存管账户
     * @param request
     * @param session
     */
    @RequestMapping("/toOpenAccount")
    @ResponseBody
    public int checkOpenAccount(HttpServletRequest request, HttpSession session, String realName, String idCardNo, String mobile) {
        Integer userId = (Integer) session.getAttribute("userId");
        //验证用户是否注册
        UserMain userMain = userMainService.selectUserMainByUserId(userId);//通过登录用户的userId查询一组对象
        Map< String, String > jxMap = new HashMap<>();

        jxMap.put("userId", userMain.getUserId().toString());
        jxMap.put("realName", realName);
        jxMap.put("idNo", idCardNo);
        jxMap.put("mobile", mobile);

        Map<String, Object> resultMap = userMainService.proOpenAccount(jxMap);

        if (resultMap.get("error") != null) {
            session.setAttribute("no", resultMap.get("error"));
            return 0;
        }
        session.setAttribute("resultMap",resultMap);

        return 1;


    }

    /**
     * 开户
     * @param session
     * @param request
     * @return
     */
    @RequestMapping("/checkOpenAccount")
    public String checkOpenAccount(HttpSession session,HttpServletRequest request){

        Map<String,Object> m = (Map<String, Object>) session.getAttribute("resultMap");
        request.setAttribute("resultMap",m);

        return "checkOpenCount";
    }


    /**
     * 江西银行开户加密·后台回调
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/getOpenAccount")
    public void  getResponseOpenAccount(HttpServletRequest request,HttpServletResponse response)throws IOException {
        Map<String, String> respMap = asynResponseMapHandle(request);
        userMainService.getAsynFinishOpenAccount(respMap);
        response.getWriter().write("success");
        response.getWriter().flush();
        response.getWriter().close();
    }

    /**
     * 后台回调参数处理
     * @param request
     * @return
     */

    private Map<String, String> asynResponseMapHandle(HttpServletRequest request){
        Map< String, String[] > temp = request.getParameterMap();
        Iterator<String> iter = temp.keySet().iterator();
        String temps = null;
        while (iter.hasNext()) {
            String key = iter.next();
            String value = temp.get(key)[0];
            temps = value;
        }
        Map< String, String > respMap = JSON.parseObject(temps,Map.class);
        return respMap;
    }

}

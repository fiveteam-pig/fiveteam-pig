package com.ytd.controller;

import com.alibaba.fastjson.JSON;
import com.ytd.service.ProRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.naming.ldap.PagedResultsResponseControl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 充值控制层
 */
@RequestMapping("/goRecharge")
public class rechargeController {

    /*@Autowired
    private ProRechargeService proRechargeService;
    *//**
     * 充值的页面
     * @return
     *//*
    @RequestMapping("/toRecharge")
    public String toRecharge(){
        return "Recharge/RechargeHtml";
    }*/

    /**
     * 充值校验
     * @param request
     * @param amount
     * @param session
     * @return
     */
    /*@RequestMapping("/proRecharge")
    @ResponseBody
    public String proRecharge(HttpServletRequest request, String amount, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userId"); //从session作用域里获取userId

        Map< String, String > jxMap = new HashMap<String, String>() ;
        jxMap.put("userId",userId.toString());
        jxMap.put("channel","000002"); //渠道
        jxMap.put("amount",request.getParameter("amount")); //金额
        Map< String, Object > resultMap = proRechargeService.proRecharge(jxMap) ;
       return JSON.toJSONString(resultMap.get("retCode"), (Boolean) resultMap.get("retMsg"));
    }*/

    /**
     * 充值
     * @return
     */
    @RequestMapping("/getRecharge")
    public String getRecharge(){

        return "Recharge/startRecharge";
    }

}

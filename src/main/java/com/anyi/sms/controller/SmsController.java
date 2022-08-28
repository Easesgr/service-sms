package com.anyi.sms.controller;

import cn.hutool.core.util.RandomUtil;
import com.anyi.sms.service.SmsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 安逸i
 * @version 1.0
 */
@RestController
@RequestMapping("/api/sms")
//@CrossOrigin //跨域
@Slf4j
public class SmsController {

    @Resource
    private SmsService smsService;

    @GetMapping("/send/{phone}")
    public String sendCode(@PathVariable String phone){
        String code = RandomUtil.randomNumbers(6);
        smsService.sendCode(phone,code);
        return "发送验证码成功";
    }
}

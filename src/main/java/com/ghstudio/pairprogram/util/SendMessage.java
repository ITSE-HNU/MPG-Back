package com.ghstudio.pairprogram.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ghstudio.pairprogram.config.HazelnutCloudConfig;
import com.ghstudio.pairprogram.exception.MessageSendFailedException;
import com.ghstudio.pairprogram.util.Response.MessageSendResponse;
import com.zhenzi.sms.ZhenziSmsClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class SendMessage {
    private static HazelnutCloudConfig hazelnutCloudConfig;

    @Resource
    private void setHazelnutCloudConfig(HazelnutCloudConfig config) {
        hazelnutCloudConfig = config;
    }

    /**
     * SendMessage 信息发送，使用榛子云
     *
     * @param phone          手机号码
     * @param templateParams 字符数组  第一个为 验证码  第二个为 有效时间
     * @return bool 返回请求状态是否成功
     * @throws MessageSendFailedException 信息发送异常
     */
    public static boolean sendMessage(String phone, String[] templateParams) throws MessageSendFailedException {
        ZhenziSmsClient client = new ZhenziSmsClient(hazelnutCloudConfig.getUrl(), hazelnutCloudConfig.getAppId(), hazelnutCloudConfig.getAppSecret());
        Map<String, Object> params = new HashMap<>();
        params.put("templateId", hazelnutCloudConfig.getTemplateId());
        params.put("number", phone);
        params.put("templateParams", templateParams);
        try {
            String response = client.send(params);

            ObjectMapper objectMapper = new ObjectMapper();
            MessageSendResponse result = objectMapper.readValue(response, MessageSendResponse.class);
            return result.getCode().equals("0");
        } catch (Exception e) {
            e.printStackTrace();
            throw new MessageSendFailedException();
        }
    }


    /**
     * generateVerificationCode 使用随机数生成六位数验证码
     *
     * @return String 验证码
     */
    public static String generateVerificationCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            code.append(random.nextInt(10));
        }
        return code.toString();
    }
}

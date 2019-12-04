package com.gyq.utils.ding;

import com.gyq.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author gaoyaqiu
 * @date 2019/7/22
 */
@Slf4j
public class DingMessageUtil {

    // 机器人
    private static final String HOOK_URL = "https://oapi.dingtalk.com/robot/send?access_token=60eb129979cd8766fb7657df478f898502f86fa4115b7427c64db5ce664de106";

    public static void sendToHook(String msg) {
        HttpClient httpclient = HttpClients.createDefault();
        HttpPost httppost = new HttpPost(HOOK_URL);
        httppost.addHeader("Content-Type", "application/json; charset=utf-8");

        Text text = new Text();
        text.setContent(msg);
        TextMsg textMsg = new TextMsg();
        textMsg.setMsgtype("text");
        textMsg.setText(text);

        String body = JsonUtil.object2Json(textMsg);
        log.info("发送参数：{}", body);
        StringEntity se = new StringEntity(body, "utf-8");
        httppost.setEntity(se);

        try {
            HttpResponse response = httpclient.execute(httppost);
            String result = EntityUtils.toString(response.getEntity(), "utf-8");
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                log.info("发送成功：{}", result);
            } else {
                log.warn("发送失败：{}", result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        sendToHook("hello 大佬");
    }

}
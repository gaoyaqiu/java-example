import com.gyq.utils.DateUtil;
import com.gyq.utils.HttpClientUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * @auther gaoyaqiu
 * @date 2018/3/19
 */
public class VoteTest {



    public static void main(String[] args) {

        CountDownLatch countDownLatch = new CountDownLatch(1);
        String url = "http://ekewka.wx.guiyekeji.com/app/index.php?i=4&c=entry&rid=46&id=1177&do=vote&m=sanlei_vote";
       // String url = "http://www.baidu.com";

        Map<String, Object> params = new HashMap<>();

        Map<String, String> headers = new HashMap<>();
        headers.put("Host", "ekewka.wx.guiyekeji.com");
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        headers.put("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 11_2_6 like Mac OS X) AppleWebKit/604.5.6 (KHTML, like Gecko) Mobile/15D100 MicroMessenger/6.6.5 NetType/WIFI Language/zh_CN");
        headers.put("Referer", "http://ekewka.wx.guiyekeji.com/app/index.php?i=4&c=entry&id=1177&rid=46&do=view&m=sanlei_vote&wxref=mp.weixin.qq.com&from=singlemessage&isappinstalled=0");
        headers.put("cookie", "PHPSESSID=ff79d158f6c2cc68e8cc5273e9fe447f");

        for (int i = 0; i < 50; i++) {

            new Thread(() -> {
                countDownLatch.countDown();
                System.out.println("请求时间:  " + DateUtil.getCurrentTimeMills());
                String result = HttpClientUtil.post_json(url, params, headers);
                System.out.println("result: " + result);

            }).start();
        }

        try {
            countDownLatch.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

package com.gyq.pattern.chainofresponsibility;

/**
 * 责任链模式(行为型设计模式).
 * <p>
 * 特点：类似过滤器，当一个请求进入时，一层层的过滤，过滤完就传递给下一个过滤器处理, 常用于过滤器、拦截器、事件处理等场景
 * 优点: 请求和接收者解耦， 可以动态增加或减少责任链上的对象或修改执行顺序
 * 缺点：调用者不清楚请求可能会被哪些责任链对象处理，是否有真的被处理，出错后不易排查
 * 案例：Servlet中的Filter
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class HandleMain {

    public static void main(String[] args) {
        // 创建责任对象
        PostHandler ad = new AdHandler();
        PostHandler yellow = new YellowHandler();
        PostHandler sensitiveWords = new SensitiveWordsHandler();

        // 形成责任链
        yellow.setSuccessor(sensitiveWords);
        ad.setSuccessor(yellow);

        Post post = new Post("我是正常内容，我是广告，我是涉黄，我是敏感词，我是正常内容");
        System.out.println("过滤前的内容为: " + post.getContent());

        ad.handleRequest(post);
        System.out.println("过滤后的内容为: " + post.getContent());

    }

}

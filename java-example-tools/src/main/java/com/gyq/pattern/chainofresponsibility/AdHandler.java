package com.gyq.pattern.chainofresponsibility;

/**
 * 广告处理器.
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class AdHandler extends PostHandler {
    @Override
    public void handleRequest(Post post) {
        String content = post.getContent();
        // 将内容中带广告字样的替换为*
        content = content.replace("广告", "***");
        post.setContent(content);

        System.out.println("过滤广告...");
        // 传递给下一个处理器
        next(post);
    }
}

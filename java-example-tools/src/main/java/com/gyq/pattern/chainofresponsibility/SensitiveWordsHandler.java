package com.gyq.pattern.chainofresponsibility;

/**
 * 敏感词处理器.
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class SensitiveWordsHandler extends PostHandler {
    @Override
    public void handleRequest(Post post) {
        String content = post.getContent();
        // 将内容中带敏感词字样的替换为*
        content = content.replace("敏感词", "***");
        post.setContent(content);

        System.out.println("过滤敏感词...");
        // 传递给下一个处理器
        next(post);
    }
}

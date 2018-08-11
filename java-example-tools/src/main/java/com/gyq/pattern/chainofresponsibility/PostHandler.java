package com.gyq.pattern.chainofresponsibility;

/**
 * 帖子处理器(所有责任链的父类)
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public abstract class PostHandler {

    /**
     * 保存责任链中下一个处理器
     */
    protected PostHandler successor;

    public void setSuccessor(PostHandler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Post post);

    protected final void next(Post post) {
        if (this.successor != null) {
            this.successor.handleRequest(post);
        }
    }
}

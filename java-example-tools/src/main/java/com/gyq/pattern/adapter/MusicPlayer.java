package com.gyq.pattern.adapter;

/**
 * 音乐播放器.
 *
 * @author gaoyaqiu
 * @date 2018/8/6
 */
public interface MusicPlayer {

    /**
     * 播放音乐.
     *
     * @param type 音乐格式
     * @param filename 文件名
     */
    void play(String type, String filename);
}

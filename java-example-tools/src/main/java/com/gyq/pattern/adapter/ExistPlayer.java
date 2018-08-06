package com.gyq.pattern.adapter;

/**
 * 模拟老系统已经开发好的播放功能.
 *
 * @author gaoyaqiu
 * @date 2018/8/6
 */
public class ExistPlayer {

    /**
     * 播放mp3格式音乐.
     *
     * @param filename
     */
    public void playMp3(String filename) {
        System.out.println("play mp3 " + filename);
    }

    /**
     * 播放wma格式音乐.
     *
     * @param filename
     */
    public void playWma(String filename) {
        System.out.println("play wma " + filename);
    }
}

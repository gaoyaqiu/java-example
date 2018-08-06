package com.gyq.pattern.adapter;

/**
 * @author gaoyaqiu
 * @date 2018/8/6
 */
public class PlayerAdapter implements MusicPlayer {

    /**
     * 使用老系统的播放功能
     */
    private ExistPlayer player;

    public PlayerAdapter() {
        this.player = new ExistPlayer();
    }

    @Override
    public void play(String type, String filename) {
        if ("mp3".equals(type)) {
            player.playMp3(filename);
        } else if ("wma".equals(type)) {
            player.playWma(filename);
        }
    }
}

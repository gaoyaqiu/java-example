package com.gyq.utils;

import net.coobird.thumbnailator.Thumbnails;

import java.io.IOException;

/**
 * 图片压缩.
 *
 * @auther gaoyaqiu
 */
public class ThumbnailsUtils {

    /**
     * 按指定大小压缩
     *
     * @param sourceFileName  源文件
     * @param targetFileName  目标文件
     * @param width           宽
     * @param height          高
     * @param keepAspectRatio 是否按照比例缩放的 true: 是, false: 否
     */
    public static void size(String sourceFileName, String targetFileName, int width, int height, boolean keepAspectRatio) throws IOException {
        Thumbnails.of(sourceFileName)
                .size(width, height)
                .keepAspectRatio(keepAspectRatio)
                .toFile(targetFileName);
    }

    /**
     * 按指定比率压缩.
     *
     * @param sourceFileName 源文件
     * @param targetFileName 目标文件
     * @param scale          比率值
     */
    public static void scale(String sourceFileName, String targetFileName, int scale) throws IOException {
        double d = (double) scale / 100;
        Thumbnails.of(sourceFileName)
                .scale(d)
                .toFile(targetFileName);

    }
}



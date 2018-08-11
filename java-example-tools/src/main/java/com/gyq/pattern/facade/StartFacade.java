package com.gyq.pattern.facade;

/**
 * 外观模式（也叫门面模式）.
 *
 * @author gaoyaqiu
 * @date 2018/8/11
 */
public class StartFacade {

    public void start() {
        new CPU().start();

        new Disk().start();

        new Memory().start();
    }
}

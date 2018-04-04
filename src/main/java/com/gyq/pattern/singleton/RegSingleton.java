package com.gyq.pattern.singleton;

import com.google.common.base.Strings;

import java.util.Map;

import static com.google.common.collect.Maps.newHashMap;

/**
 * 类似spring容器管理的登记式单例模式.
 *
 * @auther gaoyaqiu
 */
public class RegSingleton {

    protected RegSingleton() {
    }

    private static Map<String, RegSingleton> instance = newHashMap();

    static {
        RegSingleton regSingleton = new RegSingleton();
        instance.put(regSingleton.getClass().getName(), regSingleton);
    }

    public static RegSingleton getInstance(String name) {
        if (Strings.isNullOrEmpty(name)) {
            name = RegSingleton.class.getName();
        }

        if (!instance.containsKey(name)) {
            try {
                instance.put(name, (RegSingleton) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return instance.get(name);
    }
}

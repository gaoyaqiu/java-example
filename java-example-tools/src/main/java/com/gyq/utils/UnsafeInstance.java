package com.gyq.utils;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

/**
 * 线程交换场景（没什么卵用）
 *
 * @author qiu
 * @date 2020/5/3
 */
public class UnsafeInstance {

  public static Unsafe reflectGetUnsafe() {
    try {
      Field field = Unsafe.class.getDeclaredField("theUnsafe");
      field.setAccessible(true);
      return (Unsafe) field.get(null);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}

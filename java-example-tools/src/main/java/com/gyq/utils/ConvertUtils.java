package com.gyq.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Bean转换工具类.
 *
 * @author gaoyaqiu
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ConvertUtils {

    /**
     * 相同对象放入缓存提升copy效率.
     */
    private static Map<String, BeanCopier> beanCopierMap = new ConcurrentHashMap<>();

    /**
     * 只拷贝类型相同的属性.
     *
     * @param source 源对象
     * @param target 目标对象
     */
    public static <T> T copyProperties(Object source, Class<T> target) {
        if (null == source) {
            log.warn("source must not be null");
            return null;
        }

        T targetObject = null;
        try {
            targetObject = target.newInstance();
            // 缓存key
            String beanKey = source.getClass().getName() + target.getName();

            BeanCopier copier = null;
            if (!beanCopierMap.containsKey(beanKey)) {
                copier = BeanCopier.create(source.getClass(), target, false);
                beanCopierMap.put(beanKey, copier);
            } else {
                copier = beanCopierMap.get(beanKey);
            }
            copier.copy(source, targetObject, null);
        } catch (Exception e) {
            log.error("convert error ", e);
        }

        return targetObject;
    }

    public static <T> List<T> copyProperties(List<?> sourceList, Class<T> target) {
        if (CollectionUtils.isEmpty(sourceList)) {
            log.warn("sourceList must not be empty");
            return null;
        }

        List targetList = new ArrayList<>(sourceList.size());
        try {
            for (Object source : sourceList) {
                T targetObject = copyProperties(source, target);
                targetList.add(targetObject);
            }
        } catch (Exception e) {
            log.error("convert error ", e);
        }

        return targetList;
    }

    public static int size() {
        return beanCopierMap.size();
    }

}

package com.gyq.jpa.annoation.log;

import com.google.common.base.Strings;
import com.gyq.jpa.common.utils.JsonUtil;
import com.gyq.jpa.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Slf4j
@Aspect
@Component
@Configuration
public class LoggingAspectAnnotationDriven {

    @Before("@annotation(com.gyq.jpa.annoation.log.LogStyle)")
    public void beforeHandler(JoinPoint joinPoint) throws NoSuchMethodException {
        LogStyle LogStyle = this.getLogger(joinPoint);
        String desc = LogStyle.beforeDesc();
        if (!desc.equals("")) {
            desc = "[" + LogStyle.version() + "]-" + "[" + LogStyle.tag() + "]-" + logDescFormat(desc, joinPoint);
            log.info(desc);
        }
    }

    @AfterReturning(value = "@annotation(com.gyq.jpa.annoation.log.LogStyle)", returning = "result")
    public void afterReturningHandler(JoinPoint joinPoint, Object result) throws NoSuchMethodException {
        LogStyle LogStyle = this.getLogger(joinPoint);
        String desc = LogStyle.afterDesc();
        if (!desc.equals("")) {
            desc = "[" + LogStyle.version() + "]-" + "[" + LogStyle.tag() + "]-" + desc;
            log.info(desc, JsonUtil.object2Json(result));
        }
    }

    private LogStyle getLogger(JoinPoint joinPoint) throws SecurityException, NoSuchMethodException {
        Method proxyMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
        Method soruceMethod = joinPoint.getTarget().getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
        LogStyle LogStyle = soruceMethod.getAnnotation(LogStyle.class);
        if (LogStyle != null) {
            return LogStyle;
        }
        LogStyle = joinPoint.getTarget().getClass().getAnnotation(LogStyle.class);
        return LogStyle;
    }

    /**
     * 格式化日志描述
     *
     * @param desc
     * @param joinPoint
     * @return
     */
    private String logDescFormat(String desc, JoinPoint joinPoint) {
        if (!Strings.isNullOrEmpty(desc)) {
            String reg = "\\{[^\\}]*\\}";

            Pattern pa = Pattern.compile(reg);
            Matcher matcher = pa.matcher(desc);
            while (matcher.find()) {
                String oldStr = matcher.group();
                String str = oldStr.replace("{", "").replace("}", "");
                try {
                    String regNum = "\\d";
                    // 匹配规则中是否是数字例如{0},{1}
                    if (str.matches(regNum)) {
                        int i = Integer.parseInt(str);
                        if (joinPoint.getArgs().length > i) {
                            String className = String.valueOf(joinPoint.getArgs()[i]);

                            // 如果是bean对象,需要转换json
                            if (className.indexOf("com.gyq") != -1) {
                                Object obj = joinPoint.getArgs()[Integer.parseInt(str)];
                                desc = desc.replace(oldStr, JsonUtil.object2Json(obj));
                                continue;
                            }
                            // 如果是占位符
                            if (StringUtils.isInt(str)) {
                                desc = desc.replace(oldStr, String.valueOf(joinPoint.getArgs()[Integer.parseInt(str)]));
                            }
                        }
                    } else {
                        // 匹配bean属性参数例如{name}
                        Object obj = joinPoint.getArgs()[0];
                        Object val = PropertyUtils.getProperty(obj, str);
                        desc = desc.replace(oldStr, String.valueOf(val));
                    }
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    log.info("日志格式化错误", e);
                }
            }
        }

        return desc;
    }

}

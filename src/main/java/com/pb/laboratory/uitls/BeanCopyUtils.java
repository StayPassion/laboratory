package com.pb.laboratory.uitls;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class BeanCopyUtils {
    public BeanCopyUtils() {
    }

    public static <T> List<T> convertList(Object source, Class<T> c) {
        List<Object> list = (List) source;
        return list.stream().map((model) -> convert(model, c)).collect(Collectors.toList());
    }

    public static <T> T convert(Object source, Class<T> c) {
        try {
            T target = c.newInstance();
            BeanUtils.copyProperties(source, target);
            return target;
        } catch (Exception var3) {
            throw new RuntimeException("对象转换异常",var3);
        }
    }
}

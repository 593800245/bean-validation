package com.share.util;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.share.exception.MyCommonException;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 枚举工具类
 *
 * @author guozhe
 */
@Slf4j
public class EnumUtil {

    private EnumUtil() {

    }

    /**
     * 根据字符串获取对应的枚举
     *
     * @param enumType 转换的目标枚举类型
     * @param name     待转换的字符
     * @param message  目标枚举类型的描述，转换失败则抛出包含此信息的异常
     * @param <T>      转换的目标枚举类型
     * @return 字符串对应的枚举值s
     */
    public static <T extends Enum<T>> T getValue(Class<T> enumType, String name, String message) {
        T result;
        try {
            result = Enum.valueOf(enumType, name);
        } catch (NullPointerException e) {
            log.error(e.getMessage(), e);
            throw new MyCommonException(String.format("%s不能为空", message), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new MyCommonException(String.format("不支持的【%s】：【%s】，支持的值包括：【%s】", message, name, getEnumValuesString(enumType)), e);
        }
        return result;
    }

    /**
     * 获取某个枚举类的所有name
     *
     * @param enumType 枚举类型Class
     * @param <T>      枚举类型
     * @return 枚举类的所有name，以逗号分割
     */
    private static <T extends Enum<T>> String getEnumValuesString(Class<T> enumType) {
        List<String> values = Lists.newArrayList();
        for (T resultStatus : enumType.getEnumConstants()) {
            values.add(resultStatus.name());
        }
        return Joiner.on(", ").join(values);
    }

    /**
     * 获取某个枚举类型的所有name列表
     *
     * @param enumClass 枚举类型
     * @return 此类型的name列表
     */
    public static Set<String> listAllNames(Class<? extends Enum> enumClass) {
        return converterToName(enumClass.getEnumConstants());
    }

    /**
     * 把枚举值转换成name
     *
     * @param enums 枚举数组
     * @return 枚举数组的name列表
     */
    private static Set<String> converterToName(Enum[] enums) {
        return Arrays.stream(enums).map(Enum::name).collect(Collectors.toSet());
    }

}



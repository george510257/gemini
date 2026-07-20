package org.gls.gemini.framework.starter.core.contract;

import org.mapstruct.InheritConfiguration;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.MappingTarget;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 转换器接口
 *
 * @param <S> 源对象类型
 * @param <T> 目标对象类型
 */

public interface IConverter<S, T> {

    /**
     * 转换方法
     *
     * @param source 源对象
     * @return 目标对象
     */
    T convert(S source);

    /**
     * 反向转换方法
     *
     * @param target 目标对象
     * @return 源对象
     */
    @InheritInverseConfiguration(name = "convert")
    S reverseConvert(T target);

    /**
     * 更新目标对象从源对象
     *
     * @param source 源对象
     * @param target 目标对象
     */
    @InheritConfiguration(name = "convert")
    void updateTargetFromSource(S source, @MappingTarget T target);

    /**
     * 更新源对象从目标对象
     *
     * @param target 目标对象
     * @param source 源对象
     */
    @InheritConfiguration(name = "reverseConvert")
    void updateSourceFromTarget(T target, @MappingTarget S source);

    /**
     * 批量转换方法
     *
     * @param source 源对象列表
     * @return 目标对象列表
     */
    default List<T> convert(List<S> source) {
        if (source == null) {
            return null;
        }
        return source.stream().map(this::convert).toList();
    }

    /**
     * 批量反向转换方法
     *
     * @param target 目标对象列表
     * @return 源对象列表
     */
    default List<S> reverseConvert(List<T> target) {
        if (target == null) {
            return null;
        }
        return target.stream().map(this::reverseConvert).toList();
    }

    /**
     * 批量转换方法
     *
     * @param source 源对象集合
     * @return 目标对象集合
     */
    default Set<T> convert(Set<S> source) {
        if (source == null) {
            return null;
        }
        return source.stream().map(this::convert).collect(Collectors.toSet());
    }

    /**
     * 批量反向转换方法
     *
     * @param target 目标对象集合
     * @return 源对象集合
     */
    default Set<S> reverseConvert(Set<T> target) {
        if (target == null) {
            return null;
        }
        return target.stream().map(this::reverseConvert).collect(Collectors.toSet());
    }
}

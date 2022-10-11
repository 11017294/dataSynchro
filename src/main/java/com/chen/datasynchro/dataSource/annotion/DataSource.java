package com.chen.datasynchro.dataSource.annotion;

import com.chen.datasynchro.dataSource.DataSourceConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 *    表明方法所使用的数据源
 * </p>
 *
 * @author：MaybeBin
 * @Date: 2022-10-11 15-39
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {
    /**
     * 数据源名称
     */
    String value() default DataSourceConstants.DS_KEY_MASTER;
}

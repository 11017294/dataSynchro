package com.chen.datasynchro.dataSource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * <p>
 *  获取数据源
 * </p>
 *
 * @author：MaybeBin
 * @Date: 2022-10-11 11-18
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getContextKey();
    }

}

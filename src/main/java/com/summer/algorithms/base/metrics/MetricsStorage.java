package com.summer.algorithms.base.metrics;

import java.util.List;
import java.util.Map;

/**
 * 负责原始数据存储，
 * @author adminstor
 */
public interface MetricsStorage {
    /**
     * 保存采集数据
     * @param requestInfo 采集数据信息
     */
    void saveRequestInfo(RequestInfo requestInfo);

    /**
     * 查询接口请求数据
     * @param apiName 接口名称
     * @param startTimeInMillis 开始时间
     * @param endTimeInMillis 结束时间
     * @return 符合条件的数据
     */
    List<RequestInfo> getRequestInfos(String apiName, long startTimeInMillis, long endTimeInMillis);

    /**
     * 查询所有接口请求数据
     * @param startTimeInMillis 开始时间
     * @param endTimeInMillis 结束时间
     * @return 符合条件的数据
     */
    Map<String, List<RequestInfo>> getRequestInfos(long startTimeInMillis, long endTimeInMillis);
}

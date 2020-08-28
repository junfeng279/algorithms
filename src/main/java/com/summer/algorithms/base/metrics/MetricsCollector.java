package com.summer.algorithms.base.metrics;

import org.springframework.util.StringUtils;

/**
 * 负责提供API， 来采集接口请求的原始数据
 * @author adminstor
 */
public class MetricsCollector {
    /**
     * 基于接口而非实现变成
     */
    private MetricsStorage metricsStorage;

    public MetricsCollector(MetricsStorage metricsStorage) {
        this.metricsStorage = metricsStorage;
    }

    public void recordRequest(RequestInfo requestInfo){
        if(requestInfo==null || StringUtils.isEmpty(requestInfo.getApiName())){
            return;
        }
        metricsStorage.saveRequestInfo(requestInfo);
    }


}

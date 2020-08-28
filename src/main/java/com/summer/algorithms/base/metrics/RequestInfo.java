package com.summer.algorithms.base.metrics;

/**
 * 数据采集封装
 * @author adminstor
 */
public class RequestInfo {
    private String apiName;
    private double responseTime;
    private long timestamp;

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public double getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(double responseTime) {
        this.responseTime = responseTime;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}

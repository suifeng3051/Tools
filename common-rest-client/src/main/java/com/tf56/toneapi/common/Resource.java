package com.tf56.toneapi.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther wanghouda
 * @Date 2019/1/4
 * @Description
 */
public abstract class Resource {
    public static final String RESOURCE_URI = "/tone/open/";
    public static final String MAX_RESULTS = "maxResults";

    public static final int defaultMaxResults = Integer.MAX_VALUE;

    protected static <T extends Resource> List<T> getResourceArray(Class<T> type, Object r) {

        return JSON.parseArray(parseData(r), type);

    }

    public static String parseData(Object r) {
        if (r == null) {
            throw new RuntimeException("接口返回数据为null!");
        }
        if (!(r instanceof JSONObject)) {
            throw new RuntimeException("JSON payload is malformed");
        }

        JSONObject jsonObject = (JSONObject) r;
        if ("0".equals(jsonObject.get("code").toString())) {
            if(jsonObject.get("data")!=null){
                return jsonObject.get("data").toString();
            }else{
                return null;
            }
        } else {
            throw new RuntimeException("tone接口返回错误!"+jsonObject.toString());
        }

    }

    protected static <T extends Resource> T getResource(Class<T> type, Object r) {
        return JSON.parseObject(parseData(r), type);
    }

    /**
     * Retrieves all boards visible to the session user.
     *
     * @param restclient REST client instance
     * @return a list of boards
     */
    static <T extends Resource> List<T> list(RestClient restclient, Class<T> type, String url, Map<String, String> params) {

        JSON result;
        try {
            result = restclient.get(url, params);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to retrieve " + type.getSimpleName() + " : " + url, ex);
        }

        return getResourceArray(
                type,
                result
        );
    }

    /**
     * Retrieves all boards visible to the session user.
     *
     * @param restclient REST client instance
     * @return a list of boards
     */
    static <T extends Resource> T get(RestClient restclient, Class<T> type, String url, Map<String, String> params) {

        JSON result;
        try {
            result = restclient.get(url, params);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to retrieve " + type.getSimpleName() + " : " + url, ex);
        }

        return getResource(
                type,
                result
        );
    }

    /**
     * set maxResult attr default value
     *
     * @return a list of defaultParams
     */
    private static Map<String, String> getDefaultParams() {
        Map<String, String> defaultParams = new HashMap<String, String>();
        defaultParams.put(MAX_RESULTS, String.valueOf(defaultMaxResults));
        return defaultParams;
    }
}

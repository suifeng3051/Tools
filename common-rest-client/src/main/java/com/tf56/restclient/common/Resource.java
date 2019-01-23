package com.tf56.restclient.common;

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

    protected static <T extends Resource> List<T> getResourceArray(Class<T> type, Object r) {
        return JSON.parseArray(parseData(r), type);
    }

    /**
     * 从restful接口返回结果中解析出data对象
     *
     * 一般restful接口都会自定义一套标准返回结果格式，如：
     * code :返回结果编码
     * msg :返回结果消息
     * data :返回结果对象
     * {
     "code": 0,
     "data": {
        "dataId": "1",
        "dataName": "myResult"
        },
     "msg": "success"
     }
     * */
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
            throw new RuntimeException("restful接口返回错误!"+jsonObject.toString());
        }

    }

    /**
     * 将rest接口返回的data解析成自定义对象方法
     * @param type 自定义对象类型
     * @param r data 对象
     * @return 自定义对象
     */
    protected static <T extends Resource> T getResource(Class<T> type, Object r) {
        return JSON.parseObject(parseData(r), type);
    }

    /**
     * 调用restful接口，并将其解析成自定义结果对象列表
     *
     * @param restclient REST client instance
     * @return a list of Object
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
     * 调用restful接口，并将其解析成自定义结果对象
     *
     * @param restclient REST client instance
     * @return a list of Object
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
     * 设置默认接口返回结果数量
     *
     * @return a list of defaultParams
     */
    private static Map<String, String> getDefaultParams() {
        Map<String, String> defaultParams = new HashMap<String, String>();
        defaultParams.put(Constant.MAX_RESULTS, String.valueOf(Constant.DEFAULT_MAX_RESULT));
        return defaultParams;
    }
}

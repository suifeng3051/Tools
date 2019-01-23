package com.tf56.restclient.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 应用实体
 * @auther wanghouda
 * @Date 2018/12/11
 * @Description
 */
public class Application extends Resource{


    /**
     * 应用的唯一标识
     */
    private String appId;
    /**
     * 应用名称
     */
    private String appName;

    /**
     * 应用所属组织名称
     */
    private String departmentName;
    /**
     * owner的id
     */
    private String ownerId;
    /**
     * owner的姓名
     */
    private String ownerName;

    public static Application getByAppId(RestClient restclient, String appId)  {
        Map<String, String> params=new HashMap<>();
        params.put("appId",appId);
        return Resource.get(restclient,Application.class,Constant.RESOURCE_URI+Constant.INTERFACE_VERSION+"/app",params);
    }
    public static Application getByAppName(RestClient restclient, String appName) {
        Map<String, String> params=new HashMap<>();
        params.put("appName",appName);
        return Resource.get(restclient,Application.class,Constant.RESOURCE_URI+Constant.INTERFACE_VERSION+"/app",params);
    }
    public static List<Application> getOwnedAppList(RestClient restclient, String ownerInfo) {
        Map<String, String> params=new HashMap<>();
        params.put("ownerInfo",ownerInfo);
        return Resource.list(restclient,Application.class,Constant.RESOURCE_URI+Constant.INTERFACE_VERSION+"/apps",params);
    }
    public static List<Application> getRelatedAppList(RestClient restclient, String userInfo) {
        Map<String, String> params=new HashMap<>();
        params.put("userInfo",userInfo);
        return Resource.list(restclient,Application.class,Constant.RESOURCE_URI+Constant.INTERFACE_VERSION+"/apps",params);
    }

    public static String getVERSION() {
        return Constant.INTERFACE_VERSION;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }



}

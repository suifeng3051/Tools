package com.tf56.toneapi.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 应用实体
 * @auther wanghouda
 * @Date 2018/12/11
 * @Description
 */
public class ToneApplication extends Resource{
    private static final String VERSION="v1";

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
    /**
     * 团队成员信息
     */
    private String teamMembers;
    /**
     * 应用类型，war包还是jar包
     */
    private String appType;
    /**
     * 应用所属项目Id
     */
    private Integer projectId;
    /**
     * 应用所属项目名称
     */
    private String projectName;

    /**
     * 应用所处层次，mt层还是web层
     */
    private String applicationLevel;

    /**
     * 应用描述
     */
    private String appDescription;

    /**
     * 输入时间
     */
    private String inputDate;
    /**
     * 更新时间
     */
    private String updateDate;


    public static ToneApplication getByAppId(RestClient restclient,String appId)  {
        Map<String, String> params=new HashMap<>();
        params.put("appId",appId);
        return Resource.get(restclient,ToneApplication.class,Resource.RESOURCE_URI+VERSION+"/app",params);
    }
    public static ToneApplication getByAppName(RestClient restclient,String appName) {
        Map<String, String> params=new HashMap<>();
        params.put("appName",appName);
        return Resource.get(restclient,ToneApplication.class,Resource.RESOURCE_URI+VERSION+"/app",params);
    }
    public static List<ToneApplication> getOwnedAppList(RestClient restclient, String ownerInfo) {
        Map<String, String> params=new HashMap<>();
        params.put("ownerInfo",ownerInfo);
        return Resource.list(restclient,ToneApplication.class,Resource.RESOURCE_URI+VERSION+"/apps",params);
    }
    public static List<ToneApplication> getRelatedAppList(RestClient restclient,String userInfo) {
        Map<String, String> params=new HashMap<>();
        params.put("userInfo",userInfo);
        return Resource.list(restclient,ToneApplication.class,Resource.RESOURCE_URI+VERSION+"/apps",params);
    }

    public static String getVERSION() {
        return VERSION;
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

    public String getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String teamMembers) {
        this.teamMembers = teamMembers;
    }

    public String getAppType() {
        return appType;
    }

    public void setAppType(String appType) {
        this.appType = appType;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getInputDate() {
        return inputDate;
    }

    public void setInputDate(String inputDate) {
        this.inputDate = inputDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public String getApplicationLevel() {
        return applicationLevel;
    }

    public void setApplicationLevel(String applicationLevel) {
        this.applicationLevel = applicationLevel;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public void setAppDescription(String appDescription) {
        this.appDescription = appDescription;
    }

}

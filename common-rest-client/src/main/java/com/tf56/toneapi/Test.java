package com.tf56.toneapi;

import com.tf56.toneapi.common.Application;

import java.util.List;

/**
 * @auther wanghouda
 * @Date 2019/1/4
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        String restServerAddress="http://myserver.com";
        Application toneApplication= CommonRestClient.getInstance(restServerAddress).getByAppId("1");
        System.out.println(toneApplication);
        Application toneApplication2= CommonRestClient.getInstance(restServerAddress).getByAppName("myapp");
        System.out.println(toneApplication2);
        List<Application> list1= CommonRestClient.getInstance(restServerAddress).getOwnedAppList("wanghouda");
        System.out.println(list1);
        List<Application> list2= CommonRestClient.getInstance(restServerAddress).getRelatedAppList("wanghouda");
        System.out.println(list2);

    }
}

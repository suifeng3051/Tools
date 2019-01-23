package com.tf56.toneapi;

import com.tf56.toneapi.common.ToneApplication;

import java.util.List;

/**
 * @auther wanghouda
 * @Date 2019/1/4
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        String toneAddress="http://tone.tf56.lo";
        ToneApplication toneApplication=ToneClient.getInstance(toneAddress).getByAppId("36895");
        System.out.println(toneApplication);
        ToneApplication toneApplication2=ToneClient.getInstance(toneAddress).getByAppName("opensso");
        System.out.println(toneApplication2);
        List<ToneApplication> list1=ToneClient.getInstance(toneAddress).getOwnedAppList("王厚达/16538");
        System.out.println(list1);
        List<ToneApplication> list2=ToneClient.getInstance(toneAddress).getRelatedAppList("王厚达/16538");
        System.out.println(list2);

    }
}

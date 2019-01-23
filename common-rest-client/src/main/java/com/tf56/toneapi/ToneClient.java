package com.tf56.toneapi;

import com.tf56.toneapi.common.RestClient;
import com.tf56.toneapi.common.ToneApplication;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;

import java.net.URI;
import java.util.List;

/**
 * @auther wanghouda
 * @Date 2019/1/4
 * @Description
 */
public class ToneClient {
    public static final String TONE_ADDRESS="http://tone.tf56.lo";
    //配置项
    //@Value("${tone.host}")
    public static ToneClient toneClient;
    public RestClient restClient;
    public static ToneClient getInstance(String toneAddress){
        if(toneClient==null){
            toneClient=new ToneClient();
            PoolingClientConnectionManager connManager = new PoolingClientConnectionManager();
            connManager.setDefaultMaxPerRoute(20);
            connManager.setMaxTotal(40);
            HttpClient httpClient = new DefaultHttpClient(connManager);
            if(toneAddress==null){
                toneAddress=TONE_ADDRESS;
            }
            RestClient restClient = new RestClient(httpClient, null, URI.create(toneAddress));
            toneClient.setRestClient(restClient);
            return toneClient;
        }
       return toneClient;
    }

    public  ToneApplication getByAppId(String appId)  {
        return ToneApplication.getByAppId(restClient,appId);
    }
    public  ToneApplication getByAppName(String appName)  {
        return ToneApplication.getByAppName(restClient,appName);
    }
    public  List<ToneApplication> getOwnedAppList(String ownerInfo)  {
        return ToneApplication.getOwnedAppList(restClient,ownerInfo);
    }
    public  List<ToneApplication> getRelatedAppList(String userInfo)  {
        return ToneApplication.getRelatedAppList(restClient,userInfo);
    }

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }
}

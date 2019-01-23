package com.tf56.toneapi;

import com.tf56.toneapi.common.RestClient;
import com.tf56.toneapi.common.Application;
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
public class CommonRestClient {
    public static final String REST_SERVER_ADDRESS="http://myserver.com";
    //配置项
    //@Value("${tone.host}")
    public static CommonRestClient toneClient;
    public RestClient restClient;
    public static CommonRestClient getInstance(String restServerAddress){
        if(toneClient==null){
            toneClient=new CommonRestClient();
            PoolingClientConnectionManager connManager = new PoolingClientConnectionManager();
            connManager.setDefaultMaxPerRoute(20);
            connManager.setMaxTotal(40);
            HttpClient httpClient = new DefaultHttpClient(connManager);
            if(restServerAddress==null){
                restServerAddress=REST_SERVER_ADDRESS;
            }
            RestClient restClient = new RestClient(httpClient, null, URI.create(restServerAddress));
            toneClient.setRestClient(restClient);
            return toneClient;
        }
       return toneClient;
    }

    public Application getByAppId(String appId)  {
        return Application.getByAppId(restClient,appId);
    }
    public Application getByAppName(String appName)  {
        return Application.getByAppName(restClient,appName);
    }
    public  List<Application> getOwnedAppList(String ownerInfo)  {
        return Application.getOwnedAppList(restClient,ownerInfo);
    }
    public  List<Application> getRelatedAppList(String userInfo)  {
        return Application.getRelatedAppList(restClient,userInfo);
    }

    public RestClient getRestClient() {
        return restClient;
    }

    public void setRestClient(RestClient restClient) {
        this.restClient = restClient;
    }
}

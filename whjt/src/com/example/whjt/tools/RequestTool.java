package com.example.whjt.tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import com.alibaba.fastjson.JSONObject;
import com.example.whjt.Message;

@SuppressLint("NewApi")
public class RequestTool {
	
	public static void main(String[] args) {
//		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectDiskReads().detectDiskWrites().detectNetwork().penaltyLog().build());
		
//		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()  
//		.detectDiskReads()  
//		.detectDiskWrites()  
//		.detectNetwork()   // or .detectAll() for all detectable problems  
//		.penaltyLog()  
//		.build());  
//		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()  
//		.detectLeakedSqlLiteObjects()  
//		.detectLeakedClosableObjects()  
//		.penaltyLog()  
//		.penaltyDeath()  
//		.build());

		
		
		String json = RequestTool.request("http://localhost:8080/WMS1.0/query/code/13450");
		Message msg = JSONObject.parseObject(json, Message.class);
		System.out.println(msg.MSGTITLE);
	}
	
	public static String request(String url) {
		String json = "";
		HttpGet get = new HttpGet(url);
		DefaultHttpClient client = new DefaultHttpClient();
		try {
			HttpResponse response = client.execute(get);
			HttpEntity entity = response.getEntity();
			json = new String(EntityUtils.toByteArray(entity), "UTF-8");
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			get.abort();
		} catch (IOException e) {
			e.printStackTrace();
			get.abort();
		}
		return json;
	}
	
	public static String executeHttpGet(String urls) {
        String result = null;
        URL url = null;
        HttpURLConnection connection = null;
        InputStreamReader in = null;
        try {
            url = new URL(urls);
            connection = (HttpURLConnection) url.openConnection();
            in = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(in);
            StringBuffer strBuffer = new StringBuffer();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                strBuffer.append(line);
            }
            result = strBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
 
        }
        return result;
    }

}

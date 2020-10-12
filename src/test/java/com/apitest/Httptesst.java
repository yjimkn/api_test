package com.apitest;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class Httptesst {
  public static void main(String[] args) {
     String url ="http://cmp.test138.webdev.com/views/common/layout.html";
      String params="";
   Httptesst.posttestform(url,params);

   }

public static  void gettest(String url, String params){
    //创建一个请求
   HttpGet httpGet = new HttpGet(url);
   //添加请求头
   httpGet.setHeader("","");
   httpGet.setHeader("","");
   //点击发送请求
   HttpClient client = HttpClients.createDefault();
   //获取响应
   HttpResponse execute = null;
   try {
      execute = client.execute(httpGet);
   } catch (IOException e) {
      e.printStackTrace();
      System.out.println("获取响应失败");
   }
   //获取响应头
   Header[] allHeaders = execute.getAllHeaders();
   for(Header header :allHeaders){
      System.out.println(header);
   }
   //获取响应体
   HttpEntity entity = execute.getEntity();
   //强转Srint类型
   String s = null;
   try {
      s = EntityUtils.toString(entity);
   } catch (IOException e) {
      e.printStackTrace();
   }
   //获取状态码
   int statusCode = execute.getStatusLine().getStatusCode();
   System.out.println("body:"+s);
   System.out.println("状态码"+statusCode);

}
public static void posttest(String url,String params){
   HttpPost httpPost = new HttpPost(url);
   //添加请求头
   httpPost.addHeader("X-Lemonban-Media-Type","lemonban.v1");
   httpPost.addHeader("Content-Type","application/json");
   //添加参数
   try {
      new StringEntity(params);
   } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      System.out.println("参数错误");
   }
   //点击发送请求
   HttpClient client = HttpClients.createDefault();
   //创建代理服务器 可用fiddler抓包   HttpHost("代理地址",代理端口);
   //HttpHost proxy = new HttpHost("127.0.0.1",8889);
  // HttpResponse response = client.execute(proxy,httpPost);
   //获取响应
   HttpResponse execute = null;
   try {
      execute = client.execute(httpPost);
   } catch (IOException e) {
      e.printStackTrace();
      System.out.println("请求失败无法获取响应");
   }
   //获取响应头
   Header[] allHeaders = execute.getAllHeaders();
   for (Header header : allHeaders) {
      System.out.println(header);
   }
   //获取响应体
   HttpEntity entity = execute.getEntity();
   //强转Srint类型
   String s = null;
   try {
      s = EntityUtils.toString(entity);
   } catch (IOException e) {
      e.printStackTrace();
   }
   //获取状态码
   int statusCode = execute.getStatusLine().getStatusCode();
   System.out.println("body:" + s);
   System.out.println("状态码" + statusCode);
}
   public static void posttestform(String url,String params){
      HttpPost httpPostfrom = new HttpPost(url);
      //添加请求头
      httpPostfrom.addHeader("X-Lemonban-Media-Type","lemonban.v1");
      httpPostfrom.addHeader("Content-Type","application/x-www-form-urlencoded");
      //添加参数
      try {
         new StringEntity(params);
      } catch (UnsupportedEncodingException e) {
         e.printStackTrace();
         System.out.println("参数错误");
      }
      //点击发送请求
      HttpClient client = HttpClients.createDefault();
      //创建代理服务器 可用fiddler抓包   HttpHost("代理地址",代理端口);
      //HttpHost proxy = new HttpHost("127.0.0.1",8889);
      // HttpResponse response = client.execute(proxy,httpPost);
      //获取响应
      HttpResponse execute = null;
      try {
         execute = client.execute(httpPostfrom);
      } catch (IOException e) {
         e.printStackTrace();
         System.out.println("请求失败无法获取响应");
      }
      //获取响应头
      Header[] allHeaders = execute.getAllHeaders();
      for (Header header : allHeaders) {
         System.out.println(header);
      }
      //获取响应体
      HttpEntity entity = execute.getEntity();
      //强转Srint类型
      String s = null;
      try {
         s = EntityUtils.toString(entity);
      } catch (IOException e) {
         e.printStackTrace();
      }
      //获取状态码
      int statusCode = execute.getStatusLine().getStatusCode();
      System.out.println("body:" + s);
      System.out.println("状态码" + statusCode);
   }
public static void patchtest(String url,String params){
   HttpPatch httpPatch = new HttpPatch(url);
   //添加请求头
   httpPatch.addHeader("X-Lemonban-Media-Type","lemonban.v1");
   httpPatch.addHeader("Content-Type","application/json");
   //添加参数
   try {
      new StringEntity(params);
   } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
   }
   //点击发送请求
   HttpClient client = HttpClients.createDefault();
   //获取响应
   HttpResponse execute = null;
   try {
      execute = client.execute(httpPatch);
   } catch (IOException e) {
      e.printStackTrace();
   }
   //获取响应头
   Header[] allHeaders = execute.getAllHeaders();
   for (Header header : allHeaders) {
      System.out.println(header);
   }
   //获取响应体
   HttpEntity entity = execute.getEntity();
   //强转Srint类型
   String s = null;
   try {
      s = EntityUtils.toString(entity);
   } catch (IOException e) {
      e.printStackTrace();
   }
   //获取状态码
   int statusCode = execute.getStatusLine().getStatusCode();
   System.out.println("body:" + s);
   System.out.println("状态码" + statusCode);
}


}

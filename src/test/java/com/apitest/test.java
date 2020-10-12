package com.apitest;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.params.AbstractHttpParams;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class test {
@Test(dataProvider = "datas")
    public void tests(String url ,String params,String type,String contentype){
    if("json".equalsIgnoreCase(contentype)){
        if("post".equalsIgnoreCase(type)){
            Httptesst.posttest(url,params);
        }else if("get".equalsIgnoreCase(type)){
            Httptesst.gettest(url,params);
        }else if("path".equalsIgnoreCase(type)){
            Httptesst.patchtest(url,params);
        }
    }else if ("from".equalsIgnoreCase(contentype)){
        //params是json格式 通过fastjson转成map对象 再把map对象转成需要的字符串

        Map<String,String> map = JSONObject.parseObject(params,Map.class);
        //map转字符串
        String str="";
        Set<String> strings = map.keySet();
        for(String key:strings){
            String s = map.get(key);
            str=key+"="+s+"&";
        }
        //截取多出的&
     str =str.substring(0,str.length()-1);
        Httptesst.posttest(url,str);
    }

}
    @DataProvider(name="datas")
    public Object[][] datas(){
    Object[][] data=excel.read("E:\\tenzidonghua\\src\\main\\resources\\case.xls");
        return data;
    }
}

package apitest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class test {
@Test(dataProvider = "datas")
////    public void tests(String url ,String params,String type,String contentype){
////Httptesst.call(url,params,type,contentype);
////    }
public void tests(Case p){
    Httptesst.call(p.getApi_url(),p.getParam(),p.getApi_type(),p.getApi_contentType());
}


    @DataProvider(name="datas")
    public Object[][] datas(){
    //Object[][] data =excel.read("E:\\tenzidonghua\\API_2\\src\\main\\resources\\cases_v3.xlsx");
        String path="D:\\workspace\\Java\\Spring\\JAVAZ\\tenzidonghua\\API_2\\src\\main\\resources\\cases_v3.xlsx";

        List<Case> params = excel.getUrlAndParams(path);
        params.forEach(p->tests(p));
        return null;
    }



}

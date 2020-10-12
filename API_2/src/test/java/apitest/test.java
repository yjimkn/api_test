package apitest;

import com.alibaba.fastjson.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Set;

public class test {
@Test(dataProvider = "datas")
    public void tests(String url ,String params,String type,String contentype){
Httptesst.call(url,params,type,contentype);
    }


    @DataProvider(name="datas")
    public Object[][] datas(){
    //Object[][] data =excel.read("E:\\tenzidonghua\\API_2\\src\\main\\resources\\cases_v3.xlsx");
        return null;
    }
}

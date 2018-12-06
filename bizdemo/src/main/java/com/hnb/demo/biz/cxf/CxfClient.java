//package com.hnb.demo.biz.cxf;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import org.apache.cxf.endpoint.Client;
//import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
//
//
//public class CxfClient {
//   public static void main(String[] args) {
//      testWebService();
//   }
//   /**
//    * 动态调用方式
//    */
//   public static void testWebService() {
//       // 创建动态客户端
//      JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//      Client client = dcf.createClient("http://172.24.176.171:8088/GWFS_GridDataShareService/ws/dataShare?wsdl");
////    Client client = dcf.createClient("http://localhost:8099/ws/dataShare?wsdl");
//      try {
//
//         JSONObject param = new JSONObject();
//         param.put("origin","CENTRAL");
//         param.put("sequenceValue","08");
//         param.put("forecastDate","2017-11-04");
//         param.put("forecastValidStart","3");
//         param.put("forecastValidEnd","24");
//         param.put("forecastFileVersion","manual");
//         param.put("element","ER03,TMP");
//         param.put("maxLon",106.54);
//         param.put("maxLat",30.16);
//         param.put("minLon",105.80);
//         param.put("minLat",29.59);
//
//         //param.toJSONString()的字符串结构如下
//         //"{origin:\"CENTRAL\",sequenceValue:\"08\",forecastDate:\"2017-11-04\",forecastValidStart:\"3\"," +
//         //"forecastValidEnd:\"12\",forecastFileVersion:\"manual\",element:\"TMP\",maxLon:106.54,maxLat:30.16,minLon:105.80,minLat:29.59}"
//
//         // invoke("方法名",参数1,参数2,参数3....);
//         objects = client.invoke("QXTA_GWFS_getGridDataWithRect", param.toJSONString());
//
//         JSONObject result = (JSONObject) JSONObject.parse(JSON.toJSONString(objects[0]));
//         System.out.println("status:" + result.get("status"));
//         System.out.println("msg:" + result.get("msg"));
//         System.out.println("data:" + result.get("data"));
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//   }
//}

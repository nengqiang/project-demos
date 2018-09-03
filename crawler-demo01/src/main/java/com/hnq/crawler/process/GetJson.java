package com.hnq.crawler.process;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author henengqiang
 * @date 2018/9/1
 */
@Service
public class GetJson {

    public JSONObject getHttpJson(String url, int comeFrom) {
        try {
            URL realUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 请求成功
            if (connection.getResponseCode() == 200) {
                InputStream is = connection.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                // 10MB 的缓存
                byte[] buffer = new byte[10 * 1024 * 1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                String jsonStr = baos.toString();
                baos.close();
                is.close();
                // 转换成 json 数据处理
                return getJsonString(jsonStr, comeFrom);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getHttpjson(String url) {
        try {
            URL realUrl = new URL(url);
            HttpsURLConnection httpsConn = (HttpsURLConnection) realUrl.openConnection();
            httpsConn.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
            httpsConn.setRequestProperty("connection", "Keep-Alive");
            httpsConn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.62 Safari/537.36");
            httpsConn.setRequestProperty("Accept-Charset","utf-8");
            httpsConn.setRequestProperty("contentType", "utf-8");
            httpsConn.connect();
            if (httpsConn.getResponseCode() == 200) {
                InputStream is = httpsConn.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                // 10MB 的缓存
                byte[] buffer = new byte[10 * 1024 * 1024];
                int len = 0;
                while ((len = is.read(buffer)) != -1) {
                    baos.write(buffer, 0, len);
                }
                String jsonStr = baos.toString("UTF-8");
                baos.close();
                is.close();
                return new JSONObject(jsonStr);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private JSONObject getJsonString(String str, int comeFrom) {
        if (comeFrom == 1) {
            return new JSONObject(str);
        } else if (comeFrom == 2) {
            int indexStart = 0;
            // 字符处理
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    indexStart = 1;
                    break;
                }
            }
            StringBuilder strNew = new StringBuilder();
            // 分割字符串
            for (int i = indexStart + 1; i < str.length() - 1; i++) {
                strNew.append(str.charAt(i));
            }
            return new JSONObject(strNew.toString());
        }
        return null;
    }

}

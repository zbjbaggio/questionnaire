package net.airene.questionnaire.common.util;

import com.alibaba.fastjson.JSONObject;
import net.airene.questionnaire.common.constant.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

@Slf4j
public final class HttpClientUtils {

    private HttpClientUtils() {
        throw new UnsupportedOperationException();
    }

    //
    private static final int socketTimeout = 30000;

    // 传输超时时间，默认30秒
    private static final int connectTimeout = 30000;

    /**
     * 功能：post 发送 json（带日志）
     *
     * @param url
     * @param param
     * @param responseClazz
     * @param <T>
     * @return
     */
    public static <T> T post(String url, Object param, Class<T> responseClazz) {
        String requestJsonStr = JSONObject.toJSONString(param);
        Map<String, String> head = new HashMap<>();
        head.put("Content-Type", ContentTypeEnum.getHeaderContentType(ContentTypeEnum.JSON));
        String responseJsonStr = postAll(url, head, requestJsonStr, null);
        return JSONObject.parseObject(responseJsonStr, responseClazz);
    }

    public static <T> T post(String url, Map<String, String> head, Object param, Class<T> responseClazz) {
        String requestJsonStr = JSONObject.toJSONString(param);
        head.put("Content-Type", ContentTypeEnum.getHeaderContentType(ContentTypeEnum.JSON));
        String responseJsonStr = postAll(url, head, requestJsonStr, null);
        return JSONObject.parseObject(responseJsonStr, responseClazz);
    }

    public static <T> T postFormParams(String url, Map<String, String> head, Object params, Class<T> responseClazz) {
        if (Objects.isNull(head)) {
            head = new HashMap<>();
        }
        head.put("Content-Type", ContentTypeEnum.getHeaderContentType(ContentTypeEnum.FORM));
        String responseJsonStr = postAll(url, head, "", params);
        return JSONObject.parseObject(responseJsonStr, responseClazz);
    }

    /**
     * 功能：post 发送 xml str
     *
     * @param url
     * @param xmlStr
     * @return
     */
    public static String postXml(String url, String xmlStr) {
        Map<String, String> head = new HashMap<>();
        head.put("Content-Type", ContentTypeEnum.getHeaderContentType(ContentTypeEnum.XML));
        return postAll(url, head, xmlStr, null);
    }

    private static String postAll(String url, Map<String, String> head, String bodyStr, Object params){
        return postAll(url, head, bodyStr, params, true);
    }

    /**
     * 功能：post 发送 报文 公共方法
     *
     * @param url
     * @param bodyStr
     * @return
     */
    private static String postAll(String url, Map<String, String> map, String bodyStr, Object params, boolean disableLog)  {
        HttpPost httpPost = new HttpPost(url);
        doneParams(params, httpPost);
        if (StringUtils.isNotEmpty(bodyStr)) {
            StringEntity postEntity = new StringEntity(bodyStr, Constants.UTF8);
            httpPost.setEntity(postEntity);
        }
        setHead(httpPost, map);
        //设置请求器的配置
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();
        httpPost.setConfig(requestConfig);
        return http(url, httpPost, bodyStr, disableLog);
    }

    private static void doneParams(Object params, HttpPost httpPost) {
        if (Objects.nonNull(params)) {
            Map<String, String> paramsMap;
            try {
                if (params instanceof Map) {
                    paramsMap = (Map) params;
                } else {
                    paramsMap = BeanUtils.describe(params);
                }
                List<NameValuePair> nameValuePairs = new ArrayList<>();
                for (String k : paramsMap.keySet()) {
                    nameValuePairs.add(new BasicNameValuePair(k, paramsMap.get(k)));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            } catch (Exception e) {
                log.error("参数处理失败！", e);
            }
        }
    }

    private static void setHead(HttpPost httpPost, Map<String, String> map) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpPost.setHeader(entry.getKey(), entry.getValue());
        }
    }

    public static <T> T get(String url, Class<T> responseClazz) {
        String resp = get(url);
        return JSONObject.parseObject(resp, responseClazz);
    }

    /**
     * 未优化
     * 功能：get 发送 报文 公共方法
     *
     * @param url
     * @return
     */
    private static String get(String url) {
        HttpGet httpGet = new HttpGet(url);
        return http(url, httpGet, "", true);
    }

    private static String http(String url, HttpUriRequest httpUriRequest, String bodyStr, boolean disableLog) {
        if (disableLog) {
            log.info("【HttpClientUtil开始】请求地址：{}，参数为：{}，注意：【此日志记录为 HttpClient工具类自带打印】", url, bodyStr);
        }
        long startTime = System.currentTimeMillis();
        String result = null;
        CloseableHttpClient httpClient = HttpClients.custom().build();
        try {
            HttpResponse response = httpClient.execute(httpUriRequest);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, Constants.UTF8);
        } catch (Exception e) {
            log.error("{}http请求错误：", url, e);
        } finally {
            httpUriRequest.abort();
            try {
                httpClient.close();
            } catch (IOException e) {
                log.error("关闭HttpClient失败！", e);
            }
        }
        if (disableLog) {
            long endTime = System.currentTimeMillis();
            log.info("【HttpClientUtil结束】请求地址：{}，返回值：{}，注意：【此日志记录为 HttpClient工具类自带打印】【时间{}毫秒】", url, result, endTime - startTime);
        }
        return result;
    }

    public enum ContentTypeEnum {
        XML,
        JSON,
        FORM,
        MEDIA;
        /**
         * 获取contentType
         *
         * @param e contentType类型
         * @return
         */
        public static String getHeaderContentType(ContentTypeEnum e) {
            switch (e) {
                case XML:
                    return "application/xml;charset=utf-8";
                case FORM:
                    return "application/x-www-form-urlencoded;charset=utf-8";
                case MEDIA:
                    return "multipart/form-data";
                case JSON:
                default:
                    return "application/json;charset=utf-8";
            }
        }
    }
}

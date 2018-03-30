package com.gyq.utils;


import com.google.common.base.Strings;
import com.gyq.exception.BaseException;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.DefaultProxyRoutePlanner;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.*;
import java.net.UnknownHostException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * httpclient请求工具类.
 *
 * @auther gaoyaqiu
 */
public final class HttpClientUtil {

    private static CloseableHttpClient httpClient = null;

    // 不带证书认证的锁
    private final static Object syncHttpLock = new Object();

    // 配置超时时间(单位毫秒)
    private static final int TIME_OUT = 60 * 1000;

    // 连接池的最大连接数
    private final static int MAX_CONN = 300;

    // 最大重试次数
    private final static int MAX_RETRY_TIMES = 3;

    // 重试等待时间,默认1秒
    private static final int RETRY_SELLP_MILLIS = 1000;

    // 默认字符集
    private static final String CHARSET = "UTF-8";

   // private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);


    /**
     * 可接收的http请求方法
     */
    public static class HTTPMethod {
        public static final String METHOD_GET = "GET";

        public static final String METHOD_POST = "POST";

        public static final String METHOD_POST_JSON = "POST_JSON";

        // 微信接口post方法大多传输的字符串
        public static final String METHOD_POST_STRING = "POST_STRING";

        public static final String METHOD_PUT = "PUT";

        public static final String METHOD_DELETE = "DELETE";
    }


    /**
     * GET 方法
     * @param url 请求地址
     * @param params 请求参数
     * @return
     * @throws BaseException
     */
    public static String get(String url, Map<String, Object> params) throws BaseException {
        return sendHTTPRequest(url, params, null, HTTPMethod.METHOD_GET, null);
    }

    /**
     * GET 方法
     * @param url 请求地址
     * @param params 请求参数
     * @param headers 请求header参数
     * @return
     * @throws BaseException
     */
    public static String get(String url, Map<String, Object> params, Map<String, String> headers) throws BaseException {
        return sendHTTPRequest(url, params, headers, HTTPMethod.METHOD_GET, null);
    }

    public static String post(String url, Map<String, Object> params) throws BaseException {
        return sendHTTPRequest(url, params, null, HTTPMethod.METHOD_POST, null);
    }

    public static String post(String url, Map<String, Object> params, Long timeOut) throws BaseException {
        return sendHTTPRequest(url, params, null, HTTPMethod.METHOD_POST, timeOut);
    }

    /**
     * POST 请求 参数是String
     * @param url
     * @param str
     * @return
     * @throws BaseException
     */
    public static String post(String url, String str) throws BaseException {
        Map<String, Object> params = new HashMap<>();
        params.put("str", str);
        return sendHTTPRequest(url, params, null, HTTPMethod.METHOD_POST_STRING, null);
    }

    public static String post(String url, Map<String, Object> params, Map<String, String> headers) throws BaseException {
        return sendHTTPRequest(url, params, headers, HTTPMethod.METHOD_POST, null);
    }

    public static String post_json(String url, Map<String, Object> params, Map<String, String> headers) throws BaseException {
        return sendHTTPRequest(url, params, headers, HTTPMethod.METHOD_POST_JSON, null);
    }

    public static String put(String url, Map<String, Object> params) throws BaseException {
        return sendHTTPRequest(url, params, null, HTTPMethod.METHOD_PUT, null);
    }

    public static String put(String url, Map<String, Object> params, Map<String, String> headers) throws BaseException {
        return sendHTTPRequest(url, params, headers, HTTPMethod.METHOD_PUT, null);
    }

    public static String delete(String url, Map<String, Object> params) throws BaseException {
        return sendHTTPRequest(url, params, null, HTTPMethod.METHOD_DELETE, null);
    }

    public static String delete(String url, Map<String, Object> params, Map<String, String> headers) throws BaseException {
        return sendHTTPRequest(url, params, headers, HTTPMethod.METHOD_DELETE, null);
    }

    /**
     * post 方法 https 微信支付
     * @param url 请求地址
     * @param reqXml 请求参数xml字符串
     * @return
     * @throws BaseException
     */
    public static String post(String url, String reqXml, String keyFile, String key) throws BaseException {

        String responseContent = "";
        CloseableHttpClient httpsClient = null;
        try {
            httpsClient = getHttpsClientSSLAuth(keyFile, key);
            // 发起post请求
            HttpPost httpPost = new HttpPost(url);
          //  logger.debug("https post 请求参数: \n{}", reqXml);
            // 设置请求参数
            setConfig(null, httpPost, null);
            httpPost.setEntity(new ByteArrayEntity(reqXml.getBytes(CHARSET)));

            responseContent = sendHTTPRequest(httpsClient, httpPost);
        } catch (Exception e) {
          //  logger.error("https post 请求失败---{}", e);
            throw new BaseException(e);
        }finally {
            // 没用连接池,需要手动关闭连接
            if(null != httpsClient){
                try {
                    httpsClient.close();
                } catch (IOException e) {
                 //   logger.error("https post 关闭连接失败---{}");
                }
            }
        }

      //  logger.debug("https post 返回参数: \n{}", responseContent);
        return responseContent;
    }


    /**
     * 设置headers
     *
     * @param headers         请求头参数
     * @param httpRequestBase http请求对象
     */
    public static void setConfig(Map<String, String> headers, HttpRequestBase httpRequestBase, Long timeOut) {
        // 设置头部
        if (null != headers && !headers.isEmpty()) {
            // 遍历所有头部信息, 推入请求头部
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpRequestBase.setHeader(entry.getKey(), entry.getValue());
            }
        }

        // 设置http配置
        RequestConfig reqConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(timeOut != null ? timeOut.intValue() : TIME_OUT)
                .setConnectTimeout(timeOut != null ? timeOut.intValue() : TIME_OUT)
                .setSocketTimeout(timeOut != null ? timeOut.intValue() : TIME_OUT)
                .build();
        httpRequestBase.setConfig(reqConfig);
    }

    /**
     * 设置代理
     * @param hostOrIP
     * @param port
     */
    public static HttpClientBuilder proxy(String hostOrIP, int port){
        // 依次是代理地址，代理端口号，协议类型
        HttpHost proxy = new HttpHost(hostOrIP, port, "http");
        DefaultProxyRoutePlanner routePlanner = new DefaultProxyRoutePlanner(proxy);
        return HttpClients.custom().setRoutePlanner(routePlanner);
    }

    /**
     * 获取 httpClient 连接 (http)
     *
     * @return
     */
    public static CloseableHttpClient getClient() {
        if (httpClient == null) {
            // 防止多线程获取连接问题
            synchronized (syncHttpLock) {
                if (httpClient == null) {
                    httpClient = createHttpClient(MAX_CONN);
                }
            }
        }
        return httpClient;
    }

    /**
     * 创建httpclient
     * @param maxTotal
     * @return
     */
    public static CloseableHttpClient createHttpClient(int maxTotal) {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory
                .getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory
                .getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder
                .<ConnectionSocketFactory> create().register("http", plainsf)
                .register("https", sslsf).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(
                registry);
        // 将最大连接数增加
        cm.setMaxTotal(maxTotal);
        // 是路由的默认最大连接（该值默认为2），限制数量实际使用DefaultMaxPerRoute并非MaxTotal。
        // 设置过小无法支持大并发(ConnectionPoolTimeoutException: Timeout waiting for connection from pool)，路由是对maxTotal的细分。
        //（目前只有一个路由，因此让他等于最大值）
        cm.setDefaultMaxPerRoute(cm.getMaxTotal());

        // 请求重试处理
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception,
                                        int executionCount, HttpContext context) {
                if (executionCount >= 3) {
                   // logger.error("httpclient 请求重试{}次", executionCount);
                    return false;
                }
                if (exception instanceof NoHttpResponseException) {
                   // logger.error("httpclient 服务端丢弃连接");
                    return true;
                }
                // 不要重试SSL握手异常
                if (exception instanceof SSLHandshakeException) {
                    return false;
                }
                if (exception instanceof InterruptedIOException) {
                  //  logger.error("httpclient 请求超时");
                    return false;
                }
                if (exception instanceof UnknownHostException) {
                  //  logger.error("httpclient 目标服务器不可达");
                    return false;
                }
                if (exception instanceof ConnectTimeoutException) {
                  //  logger.error("httpclient 连接被拒绝");
                    return false;
                }
                if (exception instanceof SSLException) {
                  //  logger.error("httpclient SSL握手异常");
                    return false;
                }

                HttpClientContext clientContext = HttpClientContext
                        .adapt(context);
                HttpRequest request = clientContext.getRequest();
                // 如果请求是幂等的，就再次尝试
                if (!(request instanceof HttpEntityEnclosingRequest)) {
                    return true;
                }
                return false;
            }
        };

        CloseableHttpClient httpClient = HttpClients.custom()
                .setConnectionManager(cm)
                .setRetryHandler(httpRequestRetryHandler).build();

        return httpClient;
    }


    /**
     * 获取 http连接,带证书认证
     *
     * @param keyFile 证书文件
     * @param key 密钥
     * @return
     */
    private static CloseableHttpClient getHttpsClientSSLAuth(String keyFile, String key) throws BaseException {
        CloseableHttpClient httpsClient = null;
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        // 指定读取证书格式为PKCS12
        KeyStore keyStore  = null;
        FileInputStream instream = null;
        try {
            keyStore = KeyStore.getInstance("PKCS12");
            instream = new FileInputStream(new File(keyFile));
            keyStore.load(instream, key.toCharArray());
        }
        catch (KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
           // logger.error("getHttpsClientSSLAuth连接创建失败---{}", e);
            throw new BaseException(e);
        } finally {
            try {
                if(null != instream){
                    instream.close();
                }
            } catch (IOException e) {
             //   logger.error("getHttpsClientSSLAuth连接创建失败---{}", e);
                throw new BaseException(e);
            }
        }

        try {
            SSLContext sslcontext = SSLContexts.custom()
                    .loadKeyMaterial(keyStore, key.toCharArray())
                    .build();

            // Allow TLSv1 protocol only
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslcontext,
                    new String[] { "TLSv1" },
                    null,
                    SSLConnectionSocketFactory.getDefaultHostnameVerifier());

            httpsClient = httpClientBuilder.setSSLSocketFactory(sslsf).build();
        } catch (Exception e) {
            throw new BaseException(e);
        }

        return httpsClient;
    }


    /**
     * 发送http请求(https不带证书认证)
     * @param url 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return
     */
    public static String sendHTTPRequest(String url, Map<String, Object> params, Map<String, String> headers, String method, Long timeOut) throws BaseException {

        try {
            CloseableHttpClient httpClient = getClient();
            HttpRequestBase httpRequest = getHttpRequestMethod(url, params, headers, method, timeOut);

            return sendHTTPRequest(httpClient, httpRequest);
        } catch (BaseException e) {
           // logger.error("sendHTTPRequest请求失败---{}", e);
            throw e;
        } catch (Exception e) {
          //  logger.error("sendHTTPRequest请求失败---{}", e);
            throw new BaseException(e);
        }

    }

    /**
     * 得到请求方法对象
     * @param url
     * @param params
     * @param headers
     * @param method
     * @return
     * @throws UnsupportedEncodingException
     */
    public static HttpRequestBase getHttpRequestMethod(String url, Map<String, Object> params, Map<String, String> headers, String method, Long timeOut) throws UnsupportedEncodingException {
        HttpRequestBase httpRequest;
        if (method.equals(HTTPMethod.METHOD_GET)) {
            // 发起get请求
            HttpGet httpGet = new HttpGet(url.trim());
            setConfig(headers, httpGet, timeOut);

            httpRequest = httpGet;
        }else if (method.equals(HTTPMethod.METHOD_POST)) {
            // 发起post请求,参数是list
            HttpPost httpPost = new HttpPost(url);
            List<NameValuePair> pairs = new ArrayList<NameValuePair>();
            if (params != null && !params.isEmpty()) {
                pairs = new ArrayList<NameValuePair>(params.size());
                for (Map.Entry<String, Object> entry : params.entrySet()) {
                    String value = "";
                    if(null != entry.getValue()){
                        value = entry.getValue().toString();

                    }
                    pairs.add(new BasicNameValuePair(entry.getKey(), value));
                }
            }
            // 设置请求参数
            setConfig(headers, httpPost, timeOut);
            httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));

            httpRequest = httpPost;
        } else if (method.equals(HTTPMethod.METHOD_POST_STRING)) {
            // 发起post请求,参数是string
            HttpPost httpPost = new HttpPost(url);
            if (params != null && !params.isEmpty()) {
                String postEntity = params.get("str").toString();
                if(!Strings.isNullOrEmpty(postEntity)){
                    StringEntity entity = new StringEntity(postEntity, CHARSET);
                    httpPost.setEntity(entity);
                }
            }
            // 设置请求参数
            setConfig(headers, httpPost, timeOut);
            httpRequest = httpPost;
        } else if (method.equals(HTTPMethod.METHOD_POST_JSON)) {
            // 发起post请求,参数是json
            HttpPost httpPost = new HttpPost(url);

            if (params != null && !params.isEmpty()) {
                String postEntity = JsonUtils.object2Json(params);
                if(Strings.isNullOrEmpty(postEntity)){
                    StringEntity entity = new StringEntity(postEntity, CHARSET);
                    entity.setContentEncoding("UTF-8");
                    entity.setContentType("application/json");
                    httpPost.setEntity(entity);
                }
            }
            // 设置请求参数
            setConfig(headers, httpPost, timeOut);
            httpRequest = httpPost;
        }else if (method.equals(HTTPMethod.METHOD_PUT)) {
            // 发起put请求
            HttpPut httpPut = new HttpPut(url);
            httpPut.setEntity(new StringEntity(params.toString(), CHARSET));
            setConfig(headers, httpPut, timeOut);

            httpRequest = httpPut;
        } else if (method.equals(HTTPMethod.METHOD_GET)) {
            // 发起get请求
            HttpGet httpGet = new HttpGet(url);
            setConfig(headers, httpGet, timeOut);

            httpRequest = httpGet;
        } else if (method.equals(HTTPMethod.METHOD_DELETE)) {
            // 发起delete请求
            HttpDelete httpDelete = new HttpDelete(url);
            setConfig(headers, httpDelete, timeOut);

            httpRequest = httpDelete;
        } else {
          //  logger.info("请求外部接口: {} 异常, 方法不支持", url);
            //throw new BaseException("ERROR","不支持的请求方法");
            return null;
        }
        return httpRequest;
    }

    /**
     * 发送请求操作
     * @param httpClient
     * @param httpUriRequest
     * @return
     */
    public static String sendHTTPRequest(CloseableHttpClient httpClient, HttpUriRequest httpUriRequest) throws BaseException {
        CloseableHttpResponse response = null;
        String url = httpUriRequest.getURI().toString();
        String responseContent = "";
        try {
          //  logger.info("开始 请求外部接口: {} ", url);

            response = httpClient.execute(httpUriRequest);
            InputStream in = response.getEntity().getContent();
            responseContent = IOUtils.toString(in, CHARSET);
            in.close();
          //  logger.info("完成 请求外部接口: {}  ", url);
        } catch (IOException e) {
          //  logger.info("异常 请求外部接口: {} ", url);
            try {
                if(null != response){
                    response.close();
                }
            } catch (IOException e1) {
              //  logger.error("http连接关闭失败:{}---{}",url, e1);
            }
            throw new BaseException(e);
        } finally {
            try {
                if(null != response){
                    response.close();
                }
            } catch (IOException e) {
              //  logger.error("http连接关闭失败:{}---{}",url, e);
                throw new BaseException(e);
            }
        }
        return responseContent;
    }

    /**
     * 给微信第三方使用
     * @param httpClient
     * @param httpUriRequest
     * @return
     * @throws BaseException
     * @throws IOException
     */
    public static CloseableHttpResponse sendHTTPRequestWithResponse(CloseableHttpClient httpClient, HttpUriRequest httpUriRequest) throws BaseException, IOException {
        CloseableHttpResponse response = null;
        String url = httpUriRequest.getURI().toString();
      //  logger.info("开始 请求外部接口: {} ", url);

        response = httpClient.execute(httpUriRequest);

       // logger.info("完成 请求外部接口: {} ", url);
        return response;
    }


    /**
     *
     * @param retryTimes
     */
    public static void calc(int retryTimes){
        int sleepMillis = RETRY_SELLP_MILLIS * (1 << retryTimes);
        try {
          //  logger.error("请求外部地址出错，{}ms 后重试(第{}次)", sleepMillis, retryTimes + 1);
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e1) {
            throw new BaseException(e1);
        }
    }

    /**
     * 失败重试请求,最大3次
     * @param url 地址
     * @param postStr 请求的参数
     */
    public static void retryRequest(String url, String postStr) {
        // 重试次数
        int retryTimes = 0;
        do {
            String res = HttpClientUtil.post(url, postStr);
            if(!res.equals("success")){
                calc(retryTimes);
            }else{
                break;
            }
        } while (++retryTimes < MAX_RETRY_TIMES);

    }


}

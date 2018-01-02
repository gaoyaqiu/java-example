package com.gyq.utils;

import com.gyq.exception.HostException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.net.*;
import java.util.Enumeration;

/**
 * 获取真实本机网络的服务.
 *
 * @auther gaoyaqiu
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class IpUtils {
    /**
     * IP地址的正则表达式.
     */
    public static final String IP_REGEX = "((\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3})";

    private static volatile String cachedIpAddress;

    /**
     * 获取本机IP地址.
     *
     * 优先获取外网IP地址, 也有可能是链接着路由器的最终IP地址.
     * @return 本机IP地址
     */
    public static String getIp() {
        if (null != cachedIpAddress) {
            return cachedIpAddress;
        }
        Enumeration<NetworkInterface> netInterfaces;
        try {
            netInterfaces = NetworkInterface.getNetworkInterfaces();
        } catch (final SocketException ex) {
            throw new HostException(ex);
        }
        String localIpAddress = null;
        while (netInterfaces.hasMoreElements()) {
            NetworkInterface netInterface = netInterfaces.nextElement();
            Enumeration<InetAddress> ipAddresses = netInterface.getInetAddresses();
            while (ipAddresses.hasMoreElements()) {
                InetAddress ipAddress = ipAddresses.nextElement();
                if (isPublicIpAddress(ipAddress)) {
                    String publicIpAddress = ipAddress.getHostAddress();
                    cachedIpAddress = publicIpAddress;
                    return publicIpAddress;
                }
                if (isLocalIpAddress(ipAddress)) {
                    localIpAddress = ipAddress.getHostAddress();
                }
            }
        }
        cachedIpAddress = localIpAddress;
        return localIpAddress;
    }

    private static boolean isPublicIpAddress(final InetAddress ipAddress) {
        return !ipAddress.isSiteLocalAddress() && !ipAddress.isLoopbackAddress() && !isV6IpAddress(ipAddress);
    }

    private static boolean isLocalIpAddress(final InetAddress ipAddress) {
        return ipAddress.isSiteLocalAddress() && !ipAddress.isLoopbackAddress() && !isV6IpAddress(ipAddress);
    }

    private static boolean isV6IpAddress(final InetAddress ipAddress) {
        return ipAddress.getHostAddress().contains(":");
    }

    /**
     * 获取本机Host名称.
     *
     * @return 本机Host名称
     */
    public static String getHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (final UnknownHostException ex) {
            throw new HostException(ex);
        }
    }

    /**
     * 获取访问的IP或域名
     *
     * @param url 如：http://www.xxx.com/xxx.html
     * @return 返回 http://www.xxx.com
     */
    public static String getIp(String url) {
        URI uri = URI.create(url);

        URI effectiveURI = null;

        try {
            effectiveURI = new URI(uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), null, null, null);
        } catch (Throwable var4) {
            effectiveURI = null;
        }
        return effectiveURI.toString();
    }
}

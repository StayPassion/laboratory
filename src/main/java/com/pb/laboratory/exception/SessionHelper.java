package com.pb.laboratory.exception;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;

public class SessionHelper {
    private static final Logger log = LoggerFactory.getLogger(SessionHelper.class);

    private SessionHelper() {
    }

    public static String getCookie(String key) {
        Cookie[] cookies = getRequest().getCookies();
        if (ArrayUtils.isNotEmpty(cookies)) {
            Cookie[] var2 = cookies;
            int var3 = cookies.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Cookie cookie = var2[var4];
                if (cookie.getName().equalsIgnoreCase(key)) {
                    return cookie.getValue();
                }
            }
        }

        return "";
    }

    public static String getHeader(String key) {
        return getRequest().getHeader(key);
    }

    public static String getParameter(String key) {
        return getRequest().getParameter(key);
    }

    public static HttpServletRequest getRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(getRequestAttributes())).getRequest();
    }

    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes)Objects.requireNonNull(getRequestAttributes())).getResponse();
    }

    private static ServletRequestAttributes getRequestAttributes() {
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

    public static HttpSession getSession() {
        return getSession(true);
    }

    public static HttpSession getSession(boolean b) {
        return ((HttpServletRequest)Objects.requireNonNull(getRequest())).getSession(b);
    }

    public static String getSession(String name) {
        return (String)getSessionObject(name);
    }

    public static Object getSessionObject(String name) {
        return ((HttpSession)Objects.requireNonNull(getSession())).getAttribute(name);
    }

    public static JSONObject getSessionJson(String name) {
        return JSONObject.parseObject((String)Objects.requireNonNull(getSession(name)));
    }

    public static <T> T getSessionObject(String name, Class<T> t) {
        return JSON.parseObject((String)Objects.requireNonNull(getSession(name)), t);
    }

    public static void setSession(String name, Object obj) {
        ((HttpSession)Objects.requireNonNull(getSession())).setAttribute(name, obj);
    }

    public static void setSessionJson(String name, Object obj) {
        setSession(name, JSON.toJSONString(Objects.requireNonNull(obj)));
    }

//    /** @deprecated */
//    @Deprecated
//    public static <T> T getAttribute(String name, Class<T> t) {
//        try {
//            HttpSession session = getSession(true);
//            String json = (String)session.getAttribute(name);
//            if (String.class.isAssignableFrom(t)) {
//                return json;
//            } else {
//                JSONObject userJson = JSONObject.parseObject(json);
//                return JSON.toJavaObject(userJson, t);
//            }
//        } catch (Exception var5) {
//            log.error(var5.getMessage());
//            return null;
//        }
//    }

    /** @deprecated */
    @Deprecated
    public static JSONObject getAttribute(String name) {
        try {
            HttpSession session = getSession(true);
            String json = (String)session.getAttribute(name);
            return JSONObject.parseObject(json);
        } catch (Exception var3) {
            log.error(var3.getMessage());
            return null;
        }
    }

    /** @deprecated */
    @Deprecated
    public static <T> void setAttribute(String name, T t) {
        HttpSession session = getSession(true);

        try {
            ObjectMapper mapper = new ObjectMapper();
            session.setAttribute(name, mapper.writeValueAsString(t));
        } catch (Exception var4) {
            log.error("设置session出错：" + var4.getMessage());
            session.setAttribute(name, "");
        }

    }

    public static String getRemoteIpAddress() {
        HttpServletRequest request = (HttpServletRequest)Objects.requireNonNull(getRequest());
        String ipAddress = request.getHeader("x-forwarded-for");
        if (!StringUtils.isBlank(ipAddress) && !"unknown".equalsIgnoreCase(ipAddress)) {
            String[] ips = ipAddress.split(",");
            String[] var3 = ips;
            int var4 = ips.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String ip = var3[var5];
                if (ip.indexOf(".") > 0) {
                    ipAddress = ip.trim();
                    break;
                }
            }
        } else {
            ipAddress = request.getHeader("X-Real-IP");
        }

        if (StringUtils.isBlank(ipAddress) || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }
}

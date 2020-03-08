package core.utils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public final class Cookies {

    public static final int UNTIL_BROWSER_OPEN = -1;
    public static final int MINUTE = 60;
    public static final int HOUR = MINUTE * 60;
    public static final int DAY = HOUR * 24;
    public static final int WEEK = DAY * 7;
    public static final int MONTH = DAY * 30;
    public static final int YEAR = DAY * 365;
    public static final int MAXIMUM = Integer.MAX_VALUE;

    private Cookies() {
    }

    private static String getEncoded(String string) {
        try {
            return URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return string;
        }
    }

    private static String getDecoded(String string) {
        try {
            return URLDecoder.decode(string, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return string;
        }
    }

    public static void save(String name, String value, int age, ServletResponse response) {
        name = getEncoded(name);
        value = getEncoded(value);
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(name, value);
        cookie.setMaxAge(age);
        ((HttpServletResponse) response).addCookie(cookie);
    }

    public static void saveWithPath(String name, String value, int age, String path, ServletResponse response) {
        name = getEncoded(name);
        value = getEncoded(value);
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(name, value);
        cookie.setMaxAge(age);
        cookie.setPath(path);
        ((HttpServletResponse) response).addCookie(cookie);
    }

    public static void saveWithDomain(String name, String value, int age, String domain, ServletResponse response) {
        name = getEncoded(name);
        value = getEncoded(value);
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(name, value);
        cookie.setMaxAge(age);
        cookie.setDomain(domain);
        ((HttpServletResponse) response).addCookie(cookie);
    }

    public static void save(String name, String value, int age, String path, String domain, ServletResponse response) {
        name = getEncoded(name);
        value = getEncoded(value);
        javax.servlet.http.Cookie cookie = new javax.servlet.http.Cookie(name, value);
        cookie.setMaxAge(age);
        cookie.setPath(path);
        cookie.setDomain(domain);
        ((HttpServletResponse) response).addCookie(cookie);
    }

    public static void delete(String name, ServletRequest request, ServletResponse response) {
        name = getEncoded(name);
        javax.servlet.http.Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        if (cookies != null) {
            for (javax.servlet.http.Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    c.setMaxAge(0);
                    c.setValue(null);
                    ((HttpServletResponse) response).addCookie(c);
                    return;
                }
            }
        }
    }

    public static String get(String name, ServletRequest request) {
        name = getEncoded(name);
        javax.servlet.http.Cookie[] cookies = ((HttpServletRequest) request)
                .getCookies();
        if (cookies != null) {
            for (javax.servlet.http.Cookie c : cookies) {
                if (c.getName() != null && c.getName().trim().length() != 0
                        && c.getName().equals(name) && c.getValue() != null
                        && c.getValue().trim().length() != 0) {
                    return getDecoded(c.getValue());
                }
            }
        }
        return null;
    }

    public static Map<String, String> getAll(ServletRequest request) {
        Map<String, String> map = new HashMap<>();
        javax.servlet.http.Cookie[] cookies = ((HttpServletRequest) request).getCookies();
        if (cookies != null) {
            for (javax.servlet.http.Cookie c : cookies) {
                map.put(getDecoded(c.getName()), getDecoded(c.getValue()));
            }
        }
        return map;
    }

}

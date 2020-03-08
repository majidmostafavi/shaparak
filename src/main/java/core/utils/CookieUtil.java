package core.utils;


import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class CookieUtil {

    public synchronized static String fetchCookie(HttpServletRequest request, String key) {
        try {
            Cookie[] cookieArray = request.getCookies();
            if (cookieArray != null) {
                for (Cookie cookie : cookieArray) {
                    if (cookie.getName().equalsIgnoreCase(key.trim()))
                        return cookie.getValue();
                }
            }
        } catch (Exception e) {
            return "";
        }
        return "";
    }

    public synchronized static boolean removeCookie(FacesContext context, String key) {
        try {
            context.getExternalContext().addResponseCookie(key, "", null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public synchronized static boolean removeCookieList(FacesContext context, List<String> keyList) {
        try {
            for (String key : keyList) {
                context.getExternalContext().addResponseCookie(key, "", null);
            }
            return true;
        } catch (Exception e) {
            return true;
        }
    }

    public synchronized static boolean setCookie(FacesContext context, String key, String value) {
        try {
            context.getExternalContext().addResponseCookie(key, value, null);
            return true;
        } catch (Exception ioe) {
            ioe.printStackTrace();
            return false;
        }
    }

    public synchronized static boolean setCookieList(FacesContext context, NejatCache<String, String> keyValues) {
        try {

            Iterator<Map.Entry<String, String>> it = keyValues.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, String> entry = it.next();
                context.getExternalContext().addResponseCookie(entry.getKey(), entry.getValue(), null);
            }
            return true;
        } catch (Exception ioe) {
            return false;
        }
    }
}

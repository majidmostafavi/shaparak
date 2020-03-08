package core.utils;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JsfServletUtils {

    public static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    public static ExternalContext getExternalContext() {
        return getFacesContext().getExternalContext();
    }

    public static ServletContext getServletContext() {
        return (ServletContext) getExternalContext().getContext();
    }

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest) getExternalContext().getRequest();
    }

    public static HttpServletResponse getResponse() {
        return (HttpServletResponse) getExternalContext().getResponse();
    }

    public static String getViewId() {
        return getFacesContext().getViewRoot().getViewId();
    }

    public static String getLocalIp() {
        return getRequest().getLocalAddr();
    }

    public static int getLocalPort() {
        return getRequest().getLocalPort();
    }

    public static String getClientIp() {
        String ip = getRequest().getHeader("X-Forwarded-For");
        if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.trim().length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = getRequest().getRemoteAddr();
        }
        return ip;
    }


    public static String getClientInfo() {
        return getRequest().getHeader("user-agent");
    }

    public static String getRequestParameter(String parameterName) {
        return getRequest().getParameter(parameterName);
    }

    public static void sendError(int errorCode) throws IOException {
        getResponse().sendError(errorCode);
    }
}

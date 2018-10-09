package com.mytomcat;

/**
 * Desc：servlet配置
 * 我们在servlet开发中，
 * 会在web.xml中通过<servlet></servlet>
 * 和<servlet-mapping></servlet-mapping>
 * 来进行指定哪个URL交给哪个servlet进行处理。
 * Author Jonas
 * 2018/9/27 16:11
 */
public class ServletMapping {

    private String servletName;

    private String url;

    private String clazz;

    public ServletMapping(String servletName, String url, String clazz) {
        this.servletName = servletName;
        this.url = url;
        this.clazz = clazz;
    }

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}

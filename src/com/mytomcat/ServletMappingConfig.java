package com.mytomcat;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc：servlet配置
 * 我们在servlet开发中，
 * 会在web.xml中通过<servlet></servlet>
 * 和<servlet-mapping></servlet-mapping>
 * 来进行指定哪个URL交给哪个servlet进行处理。
 * Author Jonas
 * 2018/9/27 16:18
 */
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "com.mytomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld", "/world", "com.mytomcat.HelloWorldServlet"));
    }

}

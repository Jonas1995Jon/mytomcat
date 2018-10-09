package com.mytomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc：这里，你能够看到Tomcat的处理流程：
 *把URL对应处理的Servlet关系形成，解析HTTP协议，
 * 封装请求/响应对象，利用反射实例化具体的Servlet进行处理即可。
 * Author Jonas
 * 2018/9/27 16:24
 */
public class MyTomcat {

    private int port = 8080;

    private Map<String, String> urlServletMap = new HashMap<String, String>();

    public MyTomcat(int port){
        this.port = port;
    }

    public void start(){

        //初始化URL与对应处理的Servlet的关系
        initServletMapping();

        ServerSocket serverSocket = null;

        try {

            serverSocket = new ServerSocket(port);

            System.out.println("MyTomcat is start...");

            while (true){
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);

                //请求分发
                dispatch(myRequest, myResponse);

                socket.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

    }

    private void initServletMapping() {

        for(ServletMapping servletMapping : ServletMappingConfig.servletMappingList){
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }

    }

    private void dispatch(MyRequest myRequest, MyResponse myResponse) {

        String clazz = urlServletMap.get(myRequest.getUrl());

        //反射
        try {

            Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);

            MyServlet myServlet = myServletClass.newInstance();

            myServlet.service(myRequest, myResponse);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

}

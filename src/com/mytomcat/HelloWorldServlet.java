package com.mytomcat;

import java.io.IOException;

/**
 * Desc：com.mytomcat.HelloWorldServlet
 * 具体的Servlet实现，只是为了后续的测试！
 * Author Jonas
 * 2018/9/27 16:08
 */
public class HelloWorldServlet extends MyServlet {
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {

        try {
            myResponse.write("get world...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {

        try {
            myResponse.write("post world...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

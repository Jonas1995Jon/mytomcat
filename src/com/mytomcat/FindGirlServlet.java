package com.mytomcat;

import java.io.IOException;

/**
 * Desc：com.mytomcat.FindGirlServlet
 * 具体的Servlet实现，只是为了后续的测试！
 * Author Jonas
 * 2018/9/27 16:03
 */
public class FindGirlServlet extends MyServlet{
    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {

        try {
            myResponse.write("get girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {

        try {
            myResponse.write("post girl...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

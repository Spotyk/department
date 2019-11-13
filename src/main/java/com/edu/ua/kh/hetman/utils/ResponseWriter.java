package com.edu.ua.kh.hetman.utils;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseWriter {
    public void responseWrite(String string, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.getWriter().println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

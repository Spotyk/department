package com.edu.ua.kh.hetman.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseWriter {
    private static final Logger LOGGER = Logger.getLogger(ResponseWriter.class);

    public void responseWrite(String string, HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.getWriter().println(string);
        } catch (IOException e) {
            LOGGER.error("Can`t get writer.", e);
        }
    }
}

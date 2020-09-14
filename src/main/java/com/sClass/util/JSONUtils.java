package com.sClass.util;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JSONUtils {

    public static void writeToResponse(Object o, HttpServletResponse response) {
        try {
            //转为json格式字符串
            String json = JSONObject.toJSONStringWithDateFormat(o, "yyyy-MM-dd");
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

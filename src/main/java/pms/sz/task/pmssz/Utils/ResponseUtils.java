package pms.sz.task.pmssz.Utils;

import pms.sz.task.pmssz.Exception.JsonResponseInfo;

import java.util.HashMap;

public class ResponseUtils {

    public static JsonResponseInfo JsonReturn(Integer code, String msg , Object data)
    {
        return  new JsonResponseInfo(code,msg,data);
    }

    public static JsonResponseInfo success(Object data)
    {
        return  new JsonResponseInfo(0,"ok",data);
    }

    public static JsonResponseInfo error(Integer code, String msg)
    {
        return  new JsonResponseInfo (code, msg , new HashMap<>());
    }

    public static JsonResponseInfo ExceptionReturn(Integer code, String msg)
    {
        return new JsonResponseInfo(code,msg,new HashMap<>());
    }
}
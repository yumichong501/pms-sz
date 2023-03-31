package pms.sz.task.pmssz.Exception;

public class JsonResponseInfo<T> {

    private Integer code;
    private String msg;
    private T data;

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public Integer getCode()
    {
        return this.code;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public T getData()
    {
        return data;
    }
    public JsonResponseInfo(Integer code,String msg)
    {
        this.code = code;
        this.msg = msg;
    }
    public JsonResponseInfo(Integer code,String msg,T data)
    {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


}

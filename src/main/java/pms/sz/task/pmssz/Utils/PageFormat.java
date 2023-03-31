package pms.sz.task.pmssz.Utils;

import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.Map;

public class PageFormat {

    public Map formatPages(PageInfo pageInfo)
    {
        Map pagination = new HashMap();
        pagination.put("total",pageInfo.getTotal());
        pagination.put("totalPage",pageInfo.getPages());
        pagination.put("page",pageInfo.getPageNum());
        pagination.put("pageSize",pageInfo.getPageSize());

        Map returnList = new HashMap();
        returnList.put("pagination",pagination);
        returnList.put("list",pageInfo.getList());

        return returnList;
    }

}

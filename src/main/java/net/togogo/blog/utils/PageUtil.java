package net.togogo.blog.utils;

/**
 * 分页工具类
 */
public class PageUtil {

    /**
     * 生成分页代码
     * @param targetUrl  目标访问路径
     * @param totalNum  总记录数
     * @param currentPage 当前页码
     * @param pageSize  每页显示数量
     * @param param 查询条件参数
     * @return
     */
    public static String getPageintion(String targetUrl,Long totalNum,
                                       Integer currentPage,Integer pageSize,String param){

//        计算总页数
//        long totalPage = (long) Math.ceil(totalNum / pageSize);
        long totalPage = totalNum%pageSize ==0 ?totalNum/pageSize:totalNum/pageSize +1;

//        判断总页数
        if (totalPage == 0){
            return "未查询到数据";
        }else {
            StringBuffer pageCode = new StringBuffer();
            pageCode.append("<ul class=\"pagination\">");

//            如果当前页面大于1
            if (currentPage >1){
//                大于1 则上一页和首页按钮可以点击跳转
                pageCode.append("<li><a href='"+targetUrl+"?page=1&'"+param+">首页</a></li>");
                pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage-1)+"&'"+param+">上一页</a></li>");
            }else {
//                等于1 则不能点击
                pageCode.append("<li class='disabled'><a>首页</a></li>");
                pageCode.append("<li class='disabled'><a>上一页</a></li>");
            }

//            动态生成页码按钮（随着当前页面，页码按钮随之变化）
            for(int i = currentPage - 2;i<=currentPage+2;i++){
                if (i<1 || i > totalPage){
                    continue;
                }else if (i == currentPage){
                    pageCode.append("<li class='active'><a href='"+targetUrl+"?page="+i+"&'"+param+">"+i+"</a></li>");
                }else {
                    pageCode.append("<li><a href='"+targetUrl+"?page="+i+"&'"+param+">"+i+"</a></li>");
                }
            }

//            如果当前页面小于totalpage
            if (currentPage  < totalPage){
//                小于totalpage 则上一页和首页按钮可以点击跳转
                pageCode.append("<li><a href='"+targetUrl+"?page="+(currentPage+1)+"&'"+param+">下一页</a></li>");
                pageCode.append("<li><a href='"+targetUrl+"?page="+totalPage+"&'"+param+">尾页</a></li>");
            }else {
//                等于totalpage 则不能点击
                pageCode.append("<li class='disabled'><a>下一页</a></li>");
                pageCode.append("<li class='disabled'><a>尾页</a></li>");
            }

            pageCode.append("</ul>");

            return pageCode.toString();
        }
    }
}

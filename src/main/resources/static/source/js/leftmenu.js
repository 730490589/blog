$(function () {

//    加载博客类别
    $.ajax({
        url:"/blogtype/typeList",
        type:"get",
        dataType:"json",
        success:function (data) {
            $(data).each(function () {
                var  li = "<li><span><a href='/index.html?typeId="+this.id+"'>"+this.typeName+"("+ this.blogCount + ")</a></span></li>"
                $("#blogTypeList").append(li)
            })
        }
    })

    //    按日期加载博客
    $.ajax({
        url:"/blog/blogDateList",
        type:"get",
        dataType:"json",
        success:function (data) {
            $(data).each(function () {
                var  li = " <li><span><a href='/index.html?releaseDateStr="+this.releaseDateStr+"'>"+this.releaseDateStr+"("+this.blogCount+")</a></span></li>"
                $("#dateList").append(li)
            })
        }
    })

})
package com.micomecy.zuul.fliter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @program: parent
 * @Date: 2019.2.21 上午 11:35
 * @Author: MicoMecy
 */
@Component
public class MyFilter extends ZuulFilter {
    /**
     * 返回一个字符串代表过滤器的类型,在zuul中定义了四种不同声明周期的过滤器类型
     * pre 路由之前
     * routine 路由之时
     * post 路由之后
     * error 错误调用
     * @return
     */
    @Override
    /**

     */
    public String filterType() {
        return "pre";
    }



    /**
     * 过滤顺序
     * 优先级为0 数字越大优先级越低
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 可以写判断逻辑 是否需要执行该过滤器
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器具体的逻辑,可以很复杂,包括去查Sql NoSql判断是否有权限
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(request.getRequestURL().toString()+" "+request.getMethod());

        Object accessToken = request.getParameter("token");
        if (accessToken==null){
            System.out.println("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (IOException e) {}
            return null;
        }
        System.out.println("ok");
        return null;
    }
}

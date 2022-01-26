package net.airene.questionnaire.api.filter;

import net.airene.questionnaire.common.util.IpVerifyUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * A {@link Filter} that adds cross-origin resource sharing (CORS) headers to the response.
 * <p>
 * Created by matthias.wendt on 19.05.15.
 */
@Component
public class CORSFilter implements Filter {

    private final String MESSAGE = "message";

    /**
     * Adds CORS headers to the response. Then calls {@link FilterChain#doFilter} on the rest of the chain.
     *
     * @param request  the servlet request.
     * @param response the servlet response.
     * @param chain    the filter chain.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        MDC.put(MESSAGE, "ip:" + IpVerifyUtils.getIp(httpServletRequest) + " sessionId:" + httpServletRequest.getSession().getId() + " uuid:" + UUID.randomUUID().toString());
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        servletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        servletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        servletResponse.setHeader("Access-Control-Max-Age", "3600");
        servletResponse.setHeader("Access-Control-Allow-Headers", "Origin, x-requested-with, Content-Type, Accept, Authorization, token");
        chain.doFilter(request, response);
        MDC.remove(MESSAGE);
    }

    /**
     * No effect.
     *
     * @param config the filter config.
     */
    @Override
    public void init(FilterConfig config) {

    }

    /**
     * No effect.
     */
    @Override
    public void destroy() {

    }

}

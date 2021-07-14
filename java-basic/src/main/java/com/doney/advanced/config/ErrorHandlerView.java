package com.doney.advanced.config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.View;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class ErrorHandlerView implements View {
    private static final MediaType TEXT_HTML_UTF8 = new MediaType("text", "html", StandardCharsets.UTF_8);

    private static final Log logger = LogFactory.getLog(ErrorHandlerView.class);

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        if (response.isCommitted()) {
            String message = getMessage(model);
            logger.error(message);
            return;
        }
        response.setContentType(TEXT_HTML_UTF8.toString());
        StringBuilder builder = new StringBuilder();
        Date timestamp = (Date) model.get("timestamp");
        Object message = model.get("message");
        Object trace = model.get("trace");
        if (response.getContentType() == null) {
            response.setContentType(getContentType());
        }
        builder.append("<html><body><h1>Whitelabel Error Page</h1>")
                .append("<p>这是老子的错误</p>")
                 .append("<p>This application has no explicit mapping for /error, so you are seeing this as a fallback.</p>")
                .append("<div id='created'>").append(timestamp).append("</div>")
                .append("<div>There was an unexpected error (type=").append(htmlEscape(model.get("error")))
                .append(", status=").append(htmlEscape(model.get("status"))).append(").</div>");
        if (message != null) {
            builder.append("<div>").append(htmlEscape(message)).append("</div>");
        }
        if (trace != null) {
            builder.append("<div style='white-space:pre-wrap;'>").append(htmlEscape(trace)).append("</div>");
        }
        builder.append("</body></html>");
        response.getWriter().append(builder.toString());
    }

    private String htmlEscape(Object input) {
        return (input != null) ? HtmlUtils.htmlEscape(input.toString()) : null;
    }

    private String getMessage(Map<String, ?> model) {
        Object path = model.get("path");
        String message = "Cannot render error page for request [" + path + "]";
        if (model.get("message") != null) {
            message += " and exception [" + model.get("message") + "]";
        }
        message += " as the response has already been committed.";
        message += " As a result, the response may have the wrong status code.";
        return message;
    }

    @Override
    public String getContentType() {
        return "text/html";
    }
}

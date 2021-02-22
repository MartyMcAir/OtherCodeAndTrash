package com;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.apache.commons.text.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.OutputStream;

public class MyHttpHandler implements HttpHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String requestParamValue = null;

        if ("GET".equals(httpExchange.getRequestMethod())) {
            requestParamValue = handleGetRequest(httpExchange);
        } else if ("POST".equals(httpExchange)) {
//            requestParamValue = handlePostRequest(httpExchange);
        }

        handleResponse(httpExchange, requestParamValue);
    }

    private String handleGetRequest(HttpExchange httpExchange) {
        return httpExchange.
                getRequestURI()
                .toString()
                .split("\\?")[1]
                .split("=")[1];
    }

    private void handleResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
        OutputStream outputStream = httpExchange.getResponseBody();
        StringBuilder htmlBuilder = new StringBuilder();

        htmlBuilder.append("").
                append("").
                append("<h1>").
                append("Hello ")
                .append(requestParamValue)
                .append("</h1>")
                .append("")
                .append("");

        // encode HTML content
        // org.apache.commons.lang3.StringEscapeUtils' is deprecated !!!
        String htmlResponse = StringEscapeUtils.escapeHtml4(htmlBuilder.toString());

        // this line is a must
        httpExchange.sendResponseHeaders(200, htmlResponse.length());

        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
    }
}
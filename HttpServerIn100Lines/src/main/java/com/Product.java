package com;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.text.StringEscapeUtils;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Product {

    private static class MyHttpHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String requestParamValue=null;

            if("GET".equals(httpExchange.getRequestMethod())) {
                requestParamValue = handleGetRequest(httpExchange);
            } else if("POST".equals(httpExchange)) {
                System.out.println("no post");
                // requestParamValue = handlePostRequest(httpExchange);
            }

            handleResponse(httpExchange,requestParamValue);
        }

        private String handleGetRequest(HttpExchange httpExchange) {
            return httpExchange.
                    getRequestURI()
                    .toString()
                    .split("\\?")[1]
                    .split("=")[1];
        }

        private void handleResponse(HttpExchange httpExchange, String requestParamValue)  throws  IOException {
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
            String htmlResponse = StringEscapeUtils.escapeHtml4(htmlBuilder.toString());

            // this line is a must
            httpExchange.sendResponseHeaders(200, htmlResponse.length());

            outputStream.write(htmlResponse.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Привет!");
        HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 8001), 0);

        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        server.createContext("/test", new MyHttpHandler());
        server.setExecutor(threadPoolExecutor);
        server.start();
        //logger.info(" Server started on port 8001");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._iNet_UrlQuery;

import java.io.*;
import java.net.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

/**
 *
 * @author MartyMcAir
 */
public class clsUrlQuery {

    public void postReadWriteFileQuery() throws IOException {
// путь к Файлу от куда будут браться байты для записи, в др файл через php скрипт
        Path p = Paths.get("C:\\z_n\\new_test_folder\\readableText.txt");
        byte[] btArr = Files.readAllBytes(p);

        // путь строка запуска php скрипта 
        // _ в нём указан файл куда будут записаны байты
        URL v_url = new URL("http://localhost/www/testForJava/index.php");
        HttpURLConnection con = (HttpURLConnection) v_url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setRequestMethod("POST");

        String vMark = "----------------startEnd";
        con.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + vMark);
        try (PrintStream out = new PrintStream(con.getOutputStream())) {
            out.print("------------------startEnd\n");
            out.print("Content-Disposition: form-data; "
                    + "name=\"file_name\"; filename=\"nevagno.txt\"\n");
            out.print("Content-Type: text/plain\n\n");
            out.write(btArr); // записываем полученные байты в файл указанный в php
            out.print("\n------------------startEnd--");
        }

        con.connect();
        try (Reader rd = new InputStreamReader(con.getInputStream(), "utf-8");
                BufferedReader bufIn = new BufferedReader(rd);) {
            String line;
            while ((line = bufIn.readLine()) != null) {
                System.out.println(line); // получаем ответ от php
            }
        }
        if (con != null) {
            con.disconnect();
        }
    }

    public void postQuery() throws UnsupportedEncodingException, MalformedURLException, IOException {
        String str = "color=" + URLEncoder.encode("красный", "utf-8") + "&color2="
                + URLEncoder.encode("черный", "utf-8");
        byte[] btArr = str.getBytes();
        URL v_url = new URL("http://localhost/www/testForJava/index.php");
        HttpURLConnection con = (HttpURLConnection) v_url.openConnection();
        con.setDoInput(true);
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        try (OutputStream out = con.getOutputStream();) {
            out.write(btArr);
        }
        con.connect();

        try (Reader rd = new InputStreamReader(con.getInputStream(), "utf-8");
                BufferedReader bufIn = new BufferedReader(rd); // AutoCloseable..
                ) {
            String line;
            while ((line = bufIn.readLine()) != null) {
                System.out.println(line);
            }
        }
        if (con != null) {
            con.disconnect();
        }
    }

    public void queryGetTest() throws MalformedURLException, UnsupportedEncodingException, IOException {
        String str = "http://localhost/www/testForJava/index.php?variable="
                + URLEncoder.encode("значение1", "utf-8") + "&variable2="
                + URLEncoder.encode("значение2", "utf-8");
        URL v_url = new URL(str);
        HttpURLConnection con = (HttpURLConnection) v_url.openConnection();
        con.setDoInput(true);
        con.setRequestMethod("GET");
        con.connect();

        try (Reader rd = new InputStreamReader(con.getInputStream(), "utf-8");
                BufferedReader bufIn = new BufferedReader(rd); // AutoCloeseable..
                ) {
            int n, z = 1;
//            while((n=rd.read())!=-1){ // по символьное чтение
//               System.out.print((char) n); 
//            }
            String line;
            while ((line = bufIn.readLine()) != null) {
                System.out.println("строка #" + z + " " + line);
                z++;
            }
        }
        if (con != null) {
            con.disconnect();
        }
    }

    public void getQuery() throws UnsupportedEncodingException, MalformedURLException, IOException {
        String str = "http://localhost/www/testForJava/index.php?color="
                + URLEncoder.encode("желтый", "utf-8") + "&color2="
                + URLEncoder.encode("черный", "utf-8");
        URL v_url = new URL(str);
        HttpURLConnection con = (HttpURLConnection) v_url.openConnection();
        con.setDoInput(true);
        con.setRequestMethod("GET");
        con.connect();

        if (con.getResponseCode() >= 200 && con.getResponseCode() < 300) {
            try (Reader rd = new InputStreamReader(con.getInputStream(), "utf-8");
                    BufferedReader bufIn = new BufferedReader(rd); // AutoCloseable..
                    ) {
                String line = "";
                while ((line = bufIn.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            System.out.println("статус запроса _ con.getResponseCode(): "
                    + con.getResponseCode());
        }
        if (con != null) {
            con.disconnect();
        }
    }

    public void setServHead() throws MalformedURLException, IOException {
        URL v_url = new URL("http://localhost/www/testForJava/");
        HttpURLConnection con = (HttpURLConnection) v_url.openConnection();
        // через метод getHeaderFields() изменений не видно
        con.setRequestProperty("Server", "Nginx");
        System.out.println(con.getRequestProperty("Server")); // Nginx
        System.out.println(con.getRequestProperties()); // {Server=[Nginx]}
    }

    public void getServInfByIndex() throws MalformedURLException, IOException {
        URL v_url = new URL("http://localhost/www/testForJava/");
        URLConnection con = v_url.openConnection();
        String header = "";
        int n = 0;
        while (true) {
            header = con.getHeaderField(n);
            if (header == null) {
                break;
            }
            System.out.print(con.getHeaderFieldKey(n));
            System.out.println(": " + header);
            n++;
        }
    }

    public void getServerInfo() throws MalformedURLException, IOException {
        // объявляем URL переменную и присваиваем ей новый объект URL класса
        // с отправкой в его конструктор нужного нам http или другого адреса
        URL v_url = new URL("http://localhost/www/testForJava/index.php");
        // Объявляем URLConnection переменную и присваиваем ей
        // возвращаемый объект URLConnection с помощью метода 
        // openConnection() взятого из созданного объекта URL класса 
        URLConnection con = v_url.openConnection();
        // Объявляем переменную Map Интерфейса 
        //с соотвтствующими значениями в <> ромбовидных скобках
        // и присваиваем ей полученный Map из метода getHeaderFields()
        // взтый из уже созданного "Connection"
        Map<String, List<String>> map = con.getHeaderFields();

        // keySet() - множество ключей без значений
        // кажд след. элемент цикла записывается в переменную String key
        // (String - т.е. с соответствующим типом, который будет обрабатываться далее)
        for (String key : map.keySet()) {
            // get(key) - получаем значение элемента с указанным key ключом
            // и преобразуем его в строку .toString()
            System.out.println(key + " :" + map.get(key).toString());
        }
    }

    public void getFromInternet() throws MalformedURLException, IOException {
        URL v_url = new URL("http://localhost/www/testForJava/index.php");
        URLConnection con = v_url.openConnection();
        con.setConnectTimeout(50); // 50 millisec 5sec? // IllegalArgumentException
//        con.setReadTimeout(5); // 50 millisec 5sec? // SocketTimeoutException

        try (Reader rd = new InputStreamReader(con.getInputStream(), "utf-8");
                BufferedReader bufIn = new BufferedReader(rd); // AutoCloseable ..
                ) {
            String str;
            while ((str = bufIn.readLine()) != null) {
                System.out.print(str); // Hello!
            }
        } catch (SocketTimeoutException e) {
            System.out.println("Тайм аут прошёл, сервер не отвечает");
            System.out.println("e.getMessage(): " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void urlToUriDeCode() throws MalformedURLException, URISyntaxException, UnsupportedEncodingException {
//        URL v_url = new URL("http://localhost:80/index.php?query#metka");
        URL v_url = new URL("http://localhost:80/index.php/?s=строка");
        URI v_uri = v_url.toURI();
        URL v_url2 = v_uri.toURL();

        // http://localhost:80/index.php/?s=%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B0
        System.out.println(v_uri.toASCIIString());
        System.out.println(v_uri.getQuery()); // s=строка
        System.out.println(v_uri.getRawQuery()); // s=строка

        String str = "%D1%81%D1%82%D1%80%D0%BE%D0%BA%D0%B0";
        System.out.println("URLDecoder.decode(str, \"utf-8\") _" + str + ": "
                + URLDecoder.decode(str, "utf-8")); // строка
    }

    public void urlMethods() throws MalformedURLException {
        URL var_url = new URL("http", "localhost", 80, "/index.php?query_find#metka");
        // http://localhost:80/index.php?query_find#metka
        System.out.println(".toExternalForm(): " + var_url.toExternalForm());
        System.out.println(".getProtocol(): " + var_url.getProtocol()); // http
        System.out.println(".getHost(): " + var_url.getHost()); // localhost
        System.out.println(".getAuthority(): " + var_url.getAuthority()); // localhost:80
        System.out.println(".getPort(): " + var_url.getPort()); // 80
        System.out.println(".getPath(): " + var_url.getPath()); // /index.php
        System.out.println(".getQuery(): " + var_url.getQuery()); // query_find
        System.out.println(".getRef(): " + var_url.getRef()); // metka  

        System.out.println("\nСравнение адресов");
        URL v_url1 = new URL("http://localhost:80/index.php");
        URL v_url2 = new URL("http://localhost:80/index.php?query_find");
        URL v_url3 = new URL("http://localhost:80/index.php?query_find#metka");
        URL v_url4 = new URL("http://localhost:80/index.php#metka");

        URL v_url5 = new URL("http://localhost:80/index.php?query_find#metka");
        URL v_url6 = new URL("http://localhost:80/index.php?#metka");

        System.out.println("url1.sameFile(v_url2): " + v_url1.sameFile(v_url2)); // false
        System.out.println("url1.sameFile(v_url3): " + v_url1.sameFile(v_url3)); // false
        System.out.println("url1.sameFile(v_url4): " + v_url1.sameFile(v_url4)); // true

        System.out.println("url3.sameFile(v_url5): " + v_url3.sameFile(v_url5)); // true
        System.out.println("url4.sameFile(v_url6): " + v_url4.sameFile(v_url6)); // false
        System.out.println("url4.equals(v_url6): " + v_url4.equals(v_url6)); // false
    }

    public void uriMethods() throws URISyntaxException, MalformedURLException {
//        URI var_uri = new URI("http://localhost/index.php");
//        URI var_uri = new URI("http", "localhost", "/index.p", "metka");
//        URI var_uri = new URI("http",  "user_info", "localhost", 80,
//                "/index.p", "query_find_is" ,"metka")
//        URI var_uri = new URI("http", "localhost", "/index.p", "metka");
        URI var_uri = new URI("http", "authority:80", "/index.p",
                "query_find", "metka");
        System.out.println(var_uri.toURL()); // http://authority:80/index.p?query_find#metka
        System.out.println(var_uri.getRawSchemeSpecificPart()); ////authority:80/index.p?query_find#metka

        System.out.println("\n.getScheme(): " + var_uri.getScheme()); // http
        System.out.println(".getHost(): " + var_uri.getHost()); // authority
        System.out.println(".getAuthority(): " + var_uri.getAuthority()); // authority:80

        System.out.println("\n.getPath(): " + var_uri.getPath()); // /index.php
        System.out.println(".getQuery(): " + var_uri.getQuery()); // /index.php
        System.out.println("getFragment(): " + var_uri.getFragment()); // metka

        System.out.println(".getPort(): " + var_uri.getPort()); // 80

        URI v_uri2 = new URI("/index.php");
        System.out.println("\n.isAbsolute() ?: " + var_uri.isAbsolute()); // true
        System.out.println("\"/index.php\" _ .isAbsolute() ?: "
                + v_uri2.isAbsolute()); // 80

        URI v_uri3 = new URI("http://localhosr/testy/../index.php");
        System.out.println(v_uri3.toString()); // http://localhosr/../index.php
        System.out.println(v_uri3.normalize()); // http://localhosr/../index.php
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MartyMcAir
 */
public class clsSiteParse {

    public static void main(String[] args) throws IOException, Exception {
//        System.out.println(getPage() );
        Document page = getPage();
        // css query language
        //Element table = page.select("table[class = memberSummary]").first();
        Elements table = page.select("table[class = memberSummary]");
        //System.out.println(table);
        Elements names = table.select("th[class = colSecond]");
        Elements values = table.select("span[class = memberNameLink]");
        //System.out.println(values);

        for (Element name : values) {
            String method = name.select("span[class = memberNameLink]").text();
            Elements method3 = name.select("span[class = memberNameLink]");
            String method2 = name.select("th[scope = row]").text();
            Elements docs = name.select("span[class = memberNameLink]");
            Elements code = name.select("code");
            //Elements th = name.select("th class=\"colSecond\" scope=\"row\" ");
//            Elements td = name.select("tr class=[altColor]");
            String docs2 = name.select("span[class = memberNameLink]").text();

            System.out.println(method); // append append append
//            System.out.println(method3); // <span class="memberNameLink"><a href="../../java/lang/StringBuilder.ht
//            System.out.println(method2); // пусто
//            System.out.println(docs.toString().substring(73)); // <span class="memberNameLink"><a href="../../java/lang/StringBuilder.
//            System.out.println(docs);
//            System.out.println(code); // nothing
//            System.out.println(td); // nothing
//            System.out.println(docs2); // append append append
//            System.out.println( getArgs(docs) );
        }

    }

    private static Pattern pattern = Pattern.compile("\\d{2}\\.\\d{2}");

    private static final String TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
    private static Pattern pattern2 = Pattern.compile(TAG_PATTERN);
//    private static final String LINK_PATTERN = "\s*(?i)href\s*=\s*(\"([^\"]*\")|'[^']*'|([^'\">\s]+))";
    // <span class="memberNameLink"><a href="../../java/lang/StringBuilder.html#append(boolean)">append</a></span>
    //append(boolean)append(boolean)

    private static final Pattern pattern3 = Pattern.compile("<a>(.+?)</a>");
    //final Matcher matcher3 = pattern3.matcher("<a>String I want to extract</a>");

    private static String getArgs(Elements str) throws Exception {
        Matcher match = pattern3.matcher(str.text());
        if (match.find()) {
            return match.group();
        }
        throw new Exception("Can't find2");
    }

    private static String getArgs(String str) throws Exception {
        Matcher match = pattern3.matcher(str);
        if (match.find()) {
            return match.group();
        }
        throw new Exception("Can't find");
    }

    private static Document getPage() throws MalformedURLException, IOException {
        String url = "https://docs.oracle.com/javase/10/docs/api/java/security/SecureRandom.html";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

}

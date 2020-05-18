/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._a_bk_basicsofjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MartyMcAir
 */
public class clsRegularExpression {
    public static void main(String[] args) {
        // test st st null 
        // text xt null xt 
        //Pattern p = Pattern.compile("([a-z]+((st)|(xt)))", Pattern.DOTALL);

        // test text
        Pattern p = Pattern.compile("([a-z]+(?:(?:st)|(?:xt)))", Pattern.DOTALL);
        Matcher m = p.matcher("test text");
        while (m.find()) {
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.print(m.group(i + 1) + " ");
            }
            System.out.println();
        }

        // unicross   mail.ru
        Pattern p1 = Pattern.compile("(?<name>[a-z0-9_.-]+)@(?<host>(?:[a-z0-9-]+\\.)+[a-z]{2,6})");
        Matcher m1 = p1.matcher("unicross@mail.ru");
        while (m1.find()) {
            System.out.println(m1.group("name"));
            System.out.println(m1.group("host"));
        }

        // <b>Text1</b>   <i>Text3</i>
        Pattern p2 = Pattern.compile("<(?<tag>[a-zA-Z]+)>(?<text>.*?)</(\\k<tag>)>", Pattern.DOTALL);
        Matcher m2 = p2.matcher("<b>Text1</b>Text2<i>Text3</i>");
        while (m2.find()) {
            System.out.println(m2.group());
            System.out.println((m2.group(1)) + " -> " + m2.group(2));
            System.out.println(m2.group("tag") + " >> " + m2.group("text"));
        }

        System.out.println("\n");
        Pattern p3 = Pattern.compile("([a-z]+((st)|(xt)))", Pattern.DOTALL);
        Matcher m3 = p3.matcher("test text");
        while (m.find()) {
            for (int i = 0; i < m3.groupCount(); i++) {
                System.out.println(m3.group(i + 1) + " ");
            }
            System.out.println();
        }

        Pattern p4 = Pattern.compile("<(?<tag>[a-zA-Z]+)>(?<text>.*?)</(\\k<tag>)>", Pattern.DOTALL);
        Matcher m4 = p4.matcher("<b>Text1</b>Text2<i>Text3</i>");
        while (m4.find()) {
            System.out.print(m4.group() + " ");
            System.out.println(m4.start() + "..." + m4.end());
            System.out.print(m4.group(1) + " ");
            System.out.print(m4.start(1) + "..." + m4.end(1));
            System.out.print(" -> " + m4.group(2) + " ");
            System.out.println(m4.start(2) + "..." + m4.end(2));
            System.out.print(m4.group("tag") + " ");
            System.out.print(m4.start("tag") + "..." + m4.end("tag"));
            System.out.print(" >> " + m4.group("text") + " ");
            System.out.println(m4.start("text") + "..." + m4.end("text"));
        }
    }

    public static void showExample() {
        Pattern p = Pattern.compile("<b>.*</b>", Pattern.DOTALL);
        Matcher m = p.matcher("<b>Text1</b>Text2<b>Text3</b>");
        while (m.find()) {
            System.out.println(m.group());
        }

        Pattern p1 = Pattern.compile("<b>.*?</b>", Pattern.DOTALL);
        Matcher m1 = p1.matcher("<b>Text1</b>Text2<b>Text3</b>");
        while (m1.find()) {
            System.out.println(m1.group());
        }

        System.out.println("new");
        Pattern p2 = Pattern.compile("<b>(.*?)</b>", Pattern.DOTALL);
        Matcher m2 = p2.matcher("<b>Text1</b>Text2<b>Text3</b>");
        while (m2.find()) {
            System.out.println(m2.group(0)); // Указываем индекс в скобках
            System.out.println(m2.group(1));
        }
        // индекс соответствует содержимому круглых скобок в выражении т.е. (.*?)

    }
}

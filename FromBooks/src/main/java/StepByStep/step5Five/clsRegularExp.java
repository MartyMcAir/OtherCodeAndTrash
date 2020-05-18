/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step5Five;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MartyMcAir
 */
public class clsRegularExp {

    public static void main(String[] args) {
        clsRegularExp cls = new clsRegularExp();
//        cls.simpleCreate();
//        cls.searchInTegsV1();
//        cls.searchInTegsV2();
//        cls.searchInText();
        cls.searchEmail();
        
    }

    void searchEmail() {
        String str = "testtest383dhs@gmail.com";
        String regular = "(?<name>[a-z0-9_.-]+)@(?<host>(?:[a-z0-9-]+\\.)+[a-z]{2,6})";
        // тоже работатет
        String regularMy = "(?<name>[a-z0-9]+)@(?<host>(?:[a-z0-9]+\\.)+[a-z]{2,6})";
        String regularDescript = "(?<name>[a-z0-9_.-]+)" // ?<..> сообщает имя
                // _.- хз
                // @ далее нужное идет в скобках ?<> сообщает имя
                // (?: хз далее идёт + \\ двойное перекрытие для обозначения 
                // точки после @собаки
                + "@(?<host>(?:[a-z0-9-]+\\.)"
                + "+[a-z]{2,6})"; // + a-z от 2 до 6 символов после точки
        
        Pattern p = Pattern.compile(regularMy, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        while(m.find()){
            System.out.println("name: "+m.group("name"));
            System.out.println("host: "+m.group("host"));
        }
    }
    void searchInText() {
        String str = "text numbertext 123 689 01 3314 3142";
        System.out.println("\"123\".matches(\"[1-3]{3}\"): " + "123".matches("[1-3]{3}"));
        System.out.println("\"awz\".matches(\"[a-z]{3}\"): " + "awz".matches("[a-z]{3}"));
        System.out.println("поиск в строке: " + str);

        String regular = "[a-z]{4}";
        System.out.println("[a-z]{4}: ");
        Pattern p = Pattern.compile(regular, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);
        while (m.find()) {
            System.out.println(m.group());
        }


        System.out.println("\n[^13]{3}+[^a-z] ^-знак инвертирования не 1 и не 3"
                + "\n и не a-z: ");
        String regular2 = "[^13]{3}+[^a-z]";
        Pattern p2 = Pattern.compile(regular2, Pattern.CASE_INSENSITIVE);
        Matcher m2 = p2.matcher(str);
        while (m2.find()) {
            System.out.println(m2.group());
        }
        
        System.out.println("\n[a-z]{4}: ");
        String regular1 = "[a-z]{4}";
        Pattern p1 = Pattern.compile(regular1, Pattern.CASE_INSENSITIVE);
        Matcher m1 = p1.matcher(str);
        while (m1.find()) {
            System.out.println(m1.group());
        }

    }

    void searchInTegsV2() {
        String strIn = "<th class=\"colSecond\" scope=\"row\"><code>"
                + "<span class=\"memberNameLink\">"
                + "<a href=\"../../../java/util/regex/Pattern.html#compile(java.lang.String)\">"
                + "compile</a>"
                + "</span>"
                + "?(<a href=\"../../../java/lang/String.html\" title=\"class in java.lang\">"
                + "String</a>&nbsp;regex)"
                + "</code></th>";
        System.out.println(".*? - комбинация означает любой символ цифра знак и т.д."
                + " в любом кол-ве");

        String strInStep1 = "<th class=\"colSecond\" scope=\"row\">Step 1</th>";
        String strInStep1_1 = "<th>Step 1</th>";
        String regularStep1 = "<th>(.*?)</th>";
        // любая буква в любом регистре любая цифра
        String regularStep1_1 = "<th [0–9а–яА–ЯёЁa–zA–Z]>(.*?)</th>";
        // xz
        String regularStep1_2 = "<th wsw[0–9а–яА–ЯёЁa–zA–Z]wsw>(.*?)</th>";
        String regularStep1_3 = "<th .*?>(.*?)</th>";

        System.out.println("Необходимо получить на выходе: compile?(String regex)"
                + "\n Step1 <th .*?>");
        Pattern p = Pattern.compile(regularStep1_3, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(strInStep1);
        while (m.find()) {
            System.out.println("find: " + m.group(1));
        }

        System.out.println("\nStep2 <span .*?>: ");
        String Step2 = "<span class=\"memberNameLink\">Step 2</span>";
        Pattern p2 = Pattern.compile("<span .*?>(.*?)</span>", Pattern.CASE_INSENSITIVE);
        Matcher m2 = p2.matcher(Step2);
        while (m2.find()) {
            System.out.println("find: " + m2.group(1));
        }

        System.out.println("\nStep3 <th .*?><span .*? > </span></th>: ");
        String regularStep3 = "<a .*?>(.*?)</a>";
        String regularStep3_3 = "<th .*?><code><span .*? ><a .*?>(.*?)</a></span></code></th>";
        String regularStep3_4 = "<th .*?><code><span .*? ><a .*?>(.*?)</a></span>.*?</code></th>";
        String regularStep3_5 = "<th .*?><code><span .*? >(.*?)</span>.*?</code></th>";
        String regularStep3_6 = "<th .*?><code><span .*? >(.*?)</span></code></th>";
        Pattern p3 = Pattern.compile(regularStep3_4, Pattern.CASE_INSENSITIVE);
        Matcher m3 = p3.matcher(strIn);
        while (m3.find()) {
            System.out.println("find groupCount(): " + m3.groupCount());
            System.out.println("find: " + m3.group(1));
        }
    }

    void searchInTegsV1() {
        String strIn = "<b>Text1 b</b> <b>Text2 b</b> <i>Text3 i</i>"
                + " <b1>Text4 b1</b1> <b>Text5 b</b> <i1>Text6 i1</i1>"
                + " <b2>Text7 b2</b2> <b3>Text8 b3</b3> <i2>Text9 i2</i1>";
        System.out.println("поиск в строке: \n" + strIn + "\n");

        System.out.println("Получаем текст вместе с тэгами_ <b>.*</b>: ");
        Pattern p2 = Pattern.compile("<b>.*</b>", Pattern.CASE_INSENSITIVE);
        Matcher m2 = p2.matcher(strIn);
        while (m2.find()) {
            System.out.println("m2.groupCount(): " + m2.groupCount());
            System.out.println(m2.group());
        }

        System.out.println(".*? - комбинация означает любой символ цифра знак и т.д."
                + " в любом кол-ве");

        System.out.println("\nПолучаем тэги по отдельности, благодаря "
                + "указанию знака-? _ <b>.*?</b>: ");
        Pattern p3 = Pattern.compile("<b>.*?</b>", Pattern.CASE_INSENSITIVE);
        Matcher m3 = p3.matcher(strIn);
        while (m3.find()) {
            System.out.println(m3.group());
        }

        System.out.println("\nПолучаем только текст внутри тэгов, благодаря "
                + "уточнению т.е. скобкам-() _ <b>(.*?)</b>: ");
        Pattern p4 = Pattern.compile("<b>(.*?)</b>", Pattern.CASE_INSENSITIVE);
        Matcher m4 = p4.matcher(strIn);
        while (m4.find()) {
            // Указываем индекс в скобках
//            System.out.println("m4.group(0): "+m4.group(0)); // <b>Text1 b</b>
            System.out.println(m4.group(1)); // Text1 b
        }

        System.out.println("\nПолучаем только текст и только с тэгов b1 и b2 _ "
                + "<b[0-2]>(.*?)</b[0-2]>: ");
        Pattern p5 = Pattern.compile("<b[0-2]>(.*?)</b[0-2]>", Pattern.CASE_INSENSITIVE);
        Matcher m5 = p5.matcher(strIn);
        while (m5.find()) {
            System.out.println(m5.group(1)); // Text1 b
        }

        System.out.println("\nПолучаем текс с любых произвольных тэгов, кроме "
                + "не правильных типо b1 b2 i1 i2..: \n"
                + "<(?<tag>[a-zA-Z]+)>(?<text>.*?)</(\\k<tag>)>");
        // так разделять регулярки нельзя иначе работать не будет
//        Pattern p = Pattern.compile("< ( ? <tag> [a-zA-Z] +) > "
//                + "(? <text> .*?) "
//                + "</ (\\k <tag> ) >", 
//                Pattern.CASE_INSENSITIVE);
        Pattern p = Pattern.compile("<(?<tag>[a-zA-Z]+)>(?<text>.*?)</(\\k<tag>)>",
                Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(strIn);
        System.out.println("m.groupCount(): " + m.groupCount());

        while (m.find()) {
//            System.out.println(m.group()); // <b>Text b1</b>
//            System.out.println("(m.group(1)) _ : "+(m.group(1))); // b1
//            System.out.println("(m.group(2)) _: "+(m.group(2))); // Text b1

            System.out.println("m.group(\"text\") _: " + m.group("text")); // Text b1
//            System.out.println("m.group(\"tag\") _ : "+m.group("tag")); // b
        }  // <b>Text1</b>   <i>Text3</i>
    }

    void simpleCreate() {
        System.out.println("Сравнение на соответствие данных регулярному "
                + "выражению, через метод matches() класса String _ где {2} -"
                + "указывает на кол-во символов, а по умолчанию 1: ");
        System.out.println("\"3\".matches(\"[0-9]{2}\")? : "
                + "3".matches("[0-9]{2}"));

        System.out.println("Через метод matches() класса Pattern: ");
        System.out.println("Pattern.matches(\"[0-9]\", \"3\"); ?: "
                + Pattern.matches("[0-9]", "3"));

        System.out.println("\nЧерез метод compile() класса Pattern с указанием "
                + "дополнительных параметров Pattern.UNICODE_CHARACTER_CLASS "
                + "\n -Unicode символы и классы как в System.out.printf() т.е. "
                + "d-double (13 13.3), f-float(13,3), s-String..: ");
        Pattern p = Pattern.compile("[0-9]", Pattern.UNICODE_CHARACTER_CLASS);
        Matcher m = p.matcher("3");
        System.out.println("m.matches()?: " + m.matches());

        System.out.println("\n{3} -скобки указывают на кол-во даннных символов, "
                + "а знак \"-\" в [] обозначает от и до от 0-9 или от a до z: ");
        System.out.println("\"02\".matches(\"[0-9]{3}\")?: " + "02".matches("[0-9]{3}"));
        System.out.println("\"aw\".matches(\"[a-z]{2}\")?: " + "aw".matches("[a-z]{2}"));

        System.out.println("\nУказываем модификаторы сравнения внутри самого "
                + "регулярного выражения, где в (?iU) U указывает на UNICODE_CASE\n"
                + ", i -указывает на CASE_INSENSITIVE (игнор Регистра). "
                + "Так же ^ -указывает на началов выражения и +$ -его конец _ "
                + "\n без ^ и +$ не работает");
        System.out.println("\"АБВ\".matches(\"[а-яё]\"): " + "АБВ".matches("[а-яё]"));
        System.out.println("\"АБВ\".matches(\"(?iU)^[а-яё]+$\")): "
                + "АбВ".matches("(?iU)^[а-яё]+$"));
        System.out.println("\"АБВ\".matches(\"(?iU)^[а-яё]+$\")): "
                + "А".matches("(?iU)^[а-яё]+$"));

        System.out.println("\nИнверсия с помощью знака-^, т.е.[^0-3]-означает "
                + "не 0 ии не1 и не 2 и не 3");
        System.out.println("\"469\".matches(\"[^0-3]{3}: "
                + "469".matches("[^0-3]{3}")); // true
        System.out.println("\"888\".matches(\"[^0-3]{3}: "
                + "888".matches("[^0-3]{3}")); // true
        System.out.println("\"808\".matches(\"[^0-3]{3}: "
                + "808".matches("[^0-3]{3}")); // false
        System.out.println("\"818\".matches(\"[^0-3]{3}: "
                + "818".matches("[^0-3]{3}"));  // false
        System.out.println("\"838\".matches(\"[^0-3]{3}: "
                + "838".matches("[^0-3]{3}"));  // false
    }

}

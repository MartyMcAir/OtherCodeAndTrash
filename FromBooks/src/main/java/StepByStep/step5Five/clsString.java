/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step5Five;

import java.util.Arrays;
import java.util.Locale;

/**
 *
 * @author MartyMcAir
 */
public class clsString {

    public static void main(String[] args) {
        clsString cls = new clsString();
//        cls.strBasis();
//        cls.strOth();
//        cls.findStr();
        String[] arr = {"Iron Man", "Spider Man", "Super Man",
            "Tanos", "ManSpider", "drStrange",};
        String search = "Man";
//        cls.searchInStringArr(arr, search);
        cls.sBuilderBase();
    }

    void sBuilderBase() {
        String str = " Iron Man, Spider Man; Hulk ";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        System.out.println("str: " + str);
        System.out.println("Длина строки sb.length(): " + sb.length());

        sb.append("time");
        System.out.println("Длина строки после добавления через sb.append(\"time\"): "
                + sb.length());
        System.out.println("sb: " + sb);
        System.out.println("Все символы задом наперед sb.reverse(): " + sb.reverse());

        sb.reverse();
        System.out.println("\nstr: " + str);
        System.out.println("Возвращает отрезок строки по индексу от и до "
                + "sb.subSequence(2, 5): " + sb.subSequence(1, 5));
        System.out.println("Вставка строки в строку по индексу sb.insert(6, \"pure\"): "
                + sb.insert(6, "pure"));
        System.out.println("Удаление участка строки по индексу от и до sb.delete(6, 9): "
                + sb.delete(6, 9));
    }

    void searchInStringArr(String[] arr, String need_str) {
        System.out.println("Ищем в массиве arr: " + Arrays.toString(arr)
                + "\n искомое слово: " + need_str);

        int findCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains(need_str)) {
                findCount++;
                System.out.println("найдено #" + findCount + "в элементе массива №: "
                        + i + "_ начиная с индексса: " + arr[i].indexOf(need_str));
            }
        }
    }

    void findStr() {
        String strCont = "CodeMagic codeMa gic";
        System.out.println("Содержится ли в строке srCont: _ " + strCont
                + " _ strCont.contains(\"Magic\") ?: _ " + strCont.contains("Magic"));
        System.out.println("Начинается ли строка srCont: " + strCont
                + " _ strCont.startsWith(\"Code\") ?: _ " + strCont.startsWith("Code"));
        System.out.println("Заканчивается ли строка srCont: " + strCont
                + " _ strCont.endsWith(\"gic\") ?: _ " + strCont.endsWith("gic"));
        System.out.println("Индекс начала нужного значения строки srCont: " + strCont
                + " _ strCont.indexOf(\"gic\") ?: _ " + strCont.indexOf("gic"));
        System.out.println("Индекс нужного значения в конце строки srCont: " + strCont
                + " _ strCont.lastIndexOf(\"gic\") ?: _ " + strCont.lastIndexOf("gic"));

    }

    void strOth() {
        String str1 = "yellow";
        String str2 = "red";
        String str3 = "green";
        String names = " Hello, SpiderMan";

        System.out.println("Получаем символ в строке по индексу str1: "
                + str1 + "str1.charAt(1): " + str1.charAt(1));

        System.out.println("names: " + names);
        System.out.println("Заменяем в строке на свою подстроку names.replace"
                + "(\"SpiderMan\", \"IronMan\"): "
                + names.replace("SpiderMan", "IronMan"));

        System.out.println("Убираем служебн символы и пробелы в начл и конце строки"
                + "\n names.trim():" + names.trim());
    }

    void strBasis() {
        String str = "String";
        String str8 = "concat_String";
        String str2 = new String();
        String longStr = "word1.word2.word3.word4.word5";

        String[] arr = "word1.word2.word3.word4.word5".split("[\\s,.]+");
        System.out.println(Arrays.toString(arr)); // [word1, word2, word3, word4, word5] 
        arr = "word1.word2.word3.word4.word5".split("[\\s,.]+", 3);
        System.out.println(Arrays.toString(arr)); // [word1, word2, word3.word4.word5]

        String[] splitComplete = longStr.split("[\\s,.]+", 4);

        System.out.println("строку в массив строк longStr.split(\"[\\\\s,.]+\"): "
                + Arrays.toString(splitComplete));

        char[] ch = {'a', 'b', 'c'};
        str2 = new String(ch);
        String strSpl = "abc.def ghi.jk;hyf";

        System.out.println("\nмассив Символов в строку str2 = new String(ch): " + str2);
        System.out.println("массив Символов в строку String.valueOf(ch): "
                + String.valueOf(ch));
        String[] splitComplete2 = strSpl.split("[\\s,.]+", 4);
        System.out.println("Строку в массив (если в строке нет разделителей "
                + "(space od dot)\n, то деление на массив элементов невыйдет): "
                + Arrays.toString(splitComplete2));
        String str3 = str2 + str;

        String[] strArr = {str, str2, str3, "str4", "str5"};
        System.out.println("Массив строк в который входят ссылки на обычные строки "
                + "и строку совмещенную с другими конкатенацией \nт.е. через+: "
                + Arrays.toString(strArr));

        System.out.println("Объединение массива строк в одну строку "
                + "String.join(\"; \", strArr):\n " + String.join(" * ", strArr));
        System.out.println("Объеинение 2х строк str8.concat(str): " + str8.concat(str));

        byte[] btArr = str2.getBytes();
        String btArrToStr = new String(btArr);
        System.out.println("строку в массив байтов и назад: " + btArrToStr);

        System.out.println("\nФорматирование строк String.format(\"%6d\", 33): "
                + String.format("%6d", 33));
        System.out.println("String.format(\"'%10.2f'\", 10.5): "
                + String.format("'%10.2f'", 10.5)); // '     10,50'
        System.out.printf("String.format(new Locale(\"en\", \"US\"): "
                + String.format(new Locale("en", "US"),
                        "'%10.2f'", 10.5)); // '     10.50'

        String oneStr = "yellow";
        String twoStr = "yellow";
        String twoStr2 = "yellowww";
        System.out.println("\n\nСравнение строк oneStr.equals(twoStr): "
                + oneStr.equals(twoStr));
        System.out.println("Сравнение строк twoStr2 больше twoStr вернет полж число "
                + "\n twoStr2.compareTo(twoStr): "
                + twoStr2.compareTo(twoStr));

        System.out.println("\noneStr.toUpperCase(): "
                + oneStr.toUpperCase());
        System.out.println("oneStr.toLowerCase(): "
                + oneStr.toLowerCase());
        System.out.println("str.isEmpty() ?: " + str.isEmpty());
        System.out.println("str: " + str + " _ str.length() ?: " + str.length());
        System.out.println("возвращает строку по индексу от и до "
                + "str.substring(2, str.length()) ?: "
                + str.substring(2, str.length()));
    }
}

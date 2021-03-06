package stepik;

public class StepicUnicode {
    // https://stepik.org/lesson/12760/step/3?unit=3108
    // Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\"
    // (обратный слэш) на расстоянии a.
    // непонял условия и как что к чему..
    public static void main(String[] args) {
        System.out.println(charExpression(32)); // |
        System.out.println(charExpression(29)); // y
    }

    // дошло когда, почитал комметы. Логика: просто берем символ, от которого надо считать расстояние в char перменную
    // (и если надо экранируем в случае со спец символом т.е. в нашем случае это \ - а значит спец символ
    // требует экранирования т.е. в перменнной это '\\')...
    //А потом прибавляем к нашей char переменной входной агрумент int a (т.е. прибавляем расстояние на a..),
    //  результ берем в скобки и кастуем в (char) и это в return всё..

    // ОО дошло п*!
    public static char charExpression(int a) {
//        return '?' - 1;
        char c = '\\';
        return (char) (c + a);
    }

    // В условиях заблуждение. Задан формат - символ минус число. А в решении надо символ плюс число делать
    // откройте таблицу аски, найдите число нужное и прибавьте его к "а", а потом кастаните в char,
    // а если вообще не понимаете что происходит, постарайтесь сделать это в  IJ

    // int a=29, c;
    //char b;
    //c= (int) '\\';
    //c=c+a;
    //b= (char) c;
    //System.out.print(b);

    // or
    //     char c = '\\';
    //    return (char) (((int)c)+a) ;
}

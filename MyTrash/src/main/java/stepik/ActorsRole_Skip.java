package stepik;

// https://stepik.org/lesson/12762/step/10?unit=3110
public class ActorsRole_Skip {
    public static void main(String[] args) {
        String[] roles = {
                "Городничий", "Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String[] textLines = {
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};

        System.out.println(printTextPerRole(roles, textLines));
    }


    // вывод верен, а не принимает _ my resolve
    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sb = new StringBuilder();
        String current = "";
        for (int i = 0; i < roles.length; i++) {
            current = roles[i];
            sb.append(current + ":\n");
            for (int j = 0; j < textLines.length; j++) {
                if (textLines[j].contains(current)) {
                    sb.append(j + 1).append(")").append(textLines[j].replaceAll(current + ":", ""));
                    sb.append("\n");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static String printTextPerRoleFromComment(String[] roles, String[] textLines) {
        StringBuffer res = new StringBuffer("");
        for (int i = 0; i < roles.length; i++) {
            res.append(roles[i] + ":" + "\n");
            for (int j = 0; j < textLines.length; j++) {
                //  поменял условие на: startsWith(...) и все заработало. in stepik..
                if (roles[i].equals(textLines[j].substring(0, roles[i].length())) && textLines[j].charAt(roles[i].length()) == ':') {
                    res.append(j + 1 + ") " + textLines[j].substring(roles[i].length() + 2) + "\n");
                }
            }
            res.append("\n");
        }
        return res.toString();
    }

    // Возможно, уже не актуально, но проблема заключается в лишнем пробеле после двоеточия вот здесь:
    //sbuf.append('\n'+roles[l]+": "+'\n'+text);
    private String printTextPerRole2(String[] roles, String[] textLines) {
        int ind, k;
        String bufrole = new String();
        String buftext = new String();
        String result = new String();
        int l,j,i = 0;
        StringBuffer sbuf = new StringBuffer();
        StringBuffer text = new StringBuffer();
        for (l = 0; l < roles.length ; l++) {
            for (k = 0; k<textLines.length; k++) {
                ind = textLines[k].indexOf(":");
                bufrole = textLines[k].substring(0, ind);
                buftext = textLines[k].substring(ind + 1);
                if (bufrole.equals(roles[l])) {
                    text.append((k+1)+")"+buftext+'\n');
                }
            }
            sbuf.append('\n'+roles[l]+": "+'\n'+text);
            text.delete(0,text.length());
        }
        return sbuf.toString();
    }

    // Условие задачи немного пугает, точнее сильно пугает) поэтому его нужно разбить на шаги и все становится просто
    //
    //1) Взять из списка ролей 1ю роль, сформировать строку вида Роль + : + \n
    //result.append(roles[i]+ ":" + "\n");
    //2) Найти строку начинающуюся (startWith) с Роль:,
    //вырезать "Роль:", что осталось пронумеровать и прилепить к результирующей строке
    //[i]+")" + textString + \n
    //3) Искать следующее вхождение роли и повторить п.2
    //4) Если такой роли больше нет, перейти к следующей и повторить п.2 и п.3
    //5) Если больше ролей нет вообще - вернуть то, что получилось


    // Логика такова:
    //
    //Задаю StringBuilder
    //Для каждой строки в списке ролей:
    //--Стрингбилдер=Стрингбилдер+название роли, двоеточие
    //--Для каждой строки в списке реплик
    //----Если начинается с "РОЛЬ: "
    //------Стрингбилдер=Стрингбилдер+абзац,номер строки(по индексу+1)+строка(где "РОЛЬ :" заменена на "")
    //--Если это не последняя строка
    //----Стрингбилдер=Стрингбилдер+2 абзаца
    //возвращение Стрингбилдера в виде строки.

    //  по самому не экономичному пути по памяти:
    //1. проверим не пустые ли роли:
    //2. создадим новый массив из StringBuilder
    //3. создадим цикл в котором подготовим массив с разбивкой по ролям:
    //4. самое интересное собрать строки. Нужно понять что replicRoles[i] и roles[] ссылаются на одну роль и этим пользуемся
    //5. собрать воедино в строку и вернуть ее

    // 2) Для перебора и формирования своего StringBuilder можно использовать вложенный цикл for 1 - по ролям и
    // 2 - й по строкам.
    //Для условия, помогающего определить есть ли в строке конкретная роль отлично подходит метод startsWith
    //3) Вывод полученного  StringBuilder в return через ИМЯ.toString()

    // Делайте только через StringBuilder, добавляя в него строки методом append(), используя регулярные выражения
    // и не применяя конкатинацию ("+" в этой задаче - зло!). Перебирайте массив ролей и
    // массив сценария двумя вложенными циклами. Основное условие реализуйте через метод startWith()
    // проверяя начинается ли строка сценария с role.concat(":") (двоеточие - ОБЯЗАТЕЛЬНО!).
    // Выводим  StringBuilder используя метод toString().

    // 1) Взять из списка ролей 1ю роль, сформировать строку вида Роль + : + \n
    //result.append(roles[i]+ ":" + "\n");
    //2) Найти строку начинающуюся (startWith) с Роль:,
    //вырезать "Роль:", что осталось пронумеровать и прилепить к результирующей строке
    //[i]+")" + textString + \n
    //3) Искать следующее вхождение роли и повторить п.2
    //4) Если такой роли больше нет, перейти к следующей и повторить п.2 и п.3
    //5) Если больше ролей нет вообще - вернуть то, что получилось

    // НЕ используйте trim()
    //тесты 2 и 3 чувствительны к количеству нужных пробелов в начале  и конце строки

    // Была проблема Failed test #4. Time limit exceeded
    //Я хранил res как String и к нему применял оператор +=
    //Когда заменил String на StringBuider и += на res.append тест прошел.

    // Рекомендации:
    //1). Используйте StringBuilder и его методы append() и toString() для скорости выполнения.
    //2). Используйте методы String:  startsWith() для поиска реплик данной роли в элементе textLines и replaceFirst()
    // для устранения имени роли в тексте реплики, так как есть подозрение, что конструкция "Роль:"
    // может встречаться ДВАЖДЫ внутри элемента textLines (вывод из фразы: "... имя персонажа может встречаться в
    // строке более одного раза, в том числе с двоеточием;")

    // if ((textLines[j].startsWith(rol+':'))
    // For Test
    // roles:
    //A
    //AA
    //AAA
    //textLines:
    //AAA: 1A
    //AA: 2AA
    //A: 3AAA
}

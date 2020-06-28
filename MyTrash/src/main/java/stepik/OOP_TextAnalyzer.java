package stepik;

public class OOP_TextAnalyzer {
    // https://stepik.org/lesson/14513/step/9?unit=4147
    public static void main(String[] args) {
        // инициализация анализаторов для проверки в порядке данного набора анализаторов
        String[] spamKeywords = {"spam", "bad"};
        int commentMaxLength = 40;

        TextAnalyzer[] textAnalyzers1 = {new SpamAnalyzer(spamKeywords), new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(commentMaxLength)};
        TextAnalyzer[] textAnalyzers2 = {new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(commentMaxLength), new NegativeTextAnalyzer()};
        TextAnalyzer[] textAnalyzers3 = {new TooLongTextAnalyzer(commentMaxLength),
                new SpamAnalyzer(spamKeywords), new NegativeTextAnalyzer()};


        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3};

        String[] tests = {   // тестовые комментарии
                "This comment is so good.", // OK
                "This comment is so bad....",                          // SPAM
                "Very negative comment !!!!=(!!!!;",                   // NEGATIVE_TEXT
                "This comment is so Loooooooooooooooooooooooooooong.", // TOO_LONG

                "Very BAAAAAAAAAAAAAAAAAAAAAAAAD comment with :|;",    // NEGATIVE_TEXT or TOO_LONG
                "The comment is a spam, maybeeeeeeeeeeeeeeeeeeeeee!",  // SPAM or TOO_LONG
                "Negative bad :( spam.",                               // SPAM or NEGATIVE_TEXT
                "Very bad, very neg =(, very .................."      // SPAM or NEGATIVE_TEXT or TOO_LONG
        };


        OOP_TextAnalyzer testObject = new OOP_TextAnalyzer();
        int numberOfAnalyzer; // номер анализатора, указанный в идентификаторе textAnalyzers{№}

        for (int i = 0; i < tests.length; i++) { // перебираем комменты
            numberOfAnalyzer = 1;
            System.out.print("test #" + (i + 1) + ": ");
            System.out.println(tests[i]);

            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(numberOfAnalyzer + ": ");
                System.out.println(testObject.checkLabels(analyzers, tests[i]));
                numberOfAnalyzer++;
            }
        }
    }

    interface TextAnalyzer {
        Label processText(String text);
    }

    enum Label {
        SPAM, NEGATIVE_TEXT, TOO_LONG, OK
    }

    ///
    public static Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (int i = 0; i < analyzers.length; i++) {
            Label label = analyzers[i].processText(text);
            if (label != Label.OK) return label;
        }
        return Label.OK;
    }

    ///

    abstract static class KeywordAnalyzer implements TextAnalyzer {
        abstract protected String[] getKeywords();

        abstract protected Label getLabel();

        @Override
        public Label processText(String text) {
            String[] keywords = getKeywords();
            for (String item : keywords) {
                if (text.contains(item))
                    return getLabel();
            }
            return Label.OK;
        }
    }

    static class SpamAnalyzer extends KeywordAnalyzer {
        private String[] keywords;

        public SpamAnalyzer(String[] keywords) {
            this.keywords = keywords;
        }

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.SPAM;
        }
    }

    static class NegativeTextAnalyzer extends KeywordAnalyzer {
        private String[] keywords = {":(", "=(", ":|"};

        @Override
        protected String[] getKeywords() {
            return keywords;
        }

        @Override
        protected Label getLabel() {
            return Label.NEGATIVE_TEXT;
        }
    }

    static class TooLongTextAnalyzer implements TextAnalyzer {
        private int maxLength;

        public TooLongTextAnalyzer(int maxLength) {
            this.maxLength = maxLength;
        }

        @Override
        public Label processText(String text) {
            if (text.length() > maxLength) return Label.TOO_LONG;
            return Label.OK;
        }
    }


    // Поэтому даю совет: TooLongTextAnalyzer имплементирует интерфейс TextAnalyzer напрямую,
    // а SpamAnalyzer и NegativeTextAnalyzer наследуются от абстрактного класса KeywordAnalyzer,
    // тем самым также имплементируя TextAnalyzer, но посредством наследования от KeywordAnalyzer,
    // который уже имплементировал данный интерфейс ранее.

    //На всякий случай, чтобы сразу было понятно:
    //KeywordAnalyzer - abstract getKeywords(), abstract getLabel(), processText(String text)
    //NegativeTextAnalyzer - keywords, NegativeTextAnalyzer(), getKeywords(), getLabel()
    //SpamAnalyzer - keywords, SpamAnalyzer(String[] keywords), getKeywords(), getLabel()
    //TooLongTextAnalyzer - maxLength, TooLongTextAnalyzer(int maxLength), processText(String text)


    // KeywordAnalyzer должен выполнять интерфейс TextAnalyzer
    //SpamAnalyzer и NegativeTextAnalyzer должны просто наследовать  KeywordAnalyzer,
    // тогда они автоматом унаследуют и требования интерфейса, у них implemetnts писать не придётся.


    // class Main // Наш главный класс, все остальные будут его подклассами
    //{
    //    public Label checkLabels (...) {...} // наш главный метод
    //    abstract class KeywordAnalyzer {...}
    //    enum Label { SPAM, NEGATIVE_TEXT, TOO_LONG, OK }
    //    class NegativeTextAnalyzer {...}
    //    class SpamAnalyzer {...}
    //    class TooLongTextAnalyzer {...}
    //    interface TextAnaluzer {...}
    //    public static void main(String[] args) {
    //    // здесь тестируем. Можно взять хороший тест от Кирилла Колесников в комментариях ниже
    //    }
    //}
}

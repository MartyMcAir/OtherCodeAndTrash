package stepik;

public class Palindrome {
    // https://stepik.org/lesson/12761/step/10?unit=3109
    public static void main(String[] args) {
        String[] arrPalindromeWords = {"тот", "мам", "Madam, I'm Adam!"};

        System.out.println("madam, i'm adam!".equals("!mada m'i ,madam"));
        System.out.println("!mada m'i ,madam".replaceAll("[~!@#$%^&*()_'+`=,./\\<> ]", ""));

        for (String item : arrPalindromeWords)
            System.out.println("word is: " + item + ", is palindrome? :" + isPalindrome(item));
    }

    public static boolean isPalindrome(String word) {
        if (word.isEmpty() | word.length() <= 1) return true;

        // or [^A-Za-z0-9]
        String res = word.trim().toLowerCase().replaceAll("[~!@#$%^&*()_'+`=,./\\<> ]", "");
        StringBuilder sb = new StringBuilder();
        sb.append(res);

        return res.equals(sb.reverse().toString());
    }
}

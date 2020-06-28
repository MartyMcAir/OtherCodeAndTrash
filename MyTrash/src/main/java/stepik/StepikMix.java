package stepik;

public class StepikMix {
    public static void main(String[] args) {
        // https://stepik.org/lesson/12759/step/5?unit=3107
        // Укажите пары эквивалентных булевских операторов.
        boolean on = true, off = false;
        System.out.println((on | on) + " ___" + (on || on));
        System.out.println((on ^ on) + " ___" + (on != on));

    }
}

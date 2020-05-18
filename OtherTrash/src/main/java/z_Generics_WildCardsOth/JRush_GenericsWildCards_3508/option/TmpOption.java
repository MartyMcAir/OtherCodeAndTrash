package z_Generics_WildCardsOth.JRush_GenericsWildCards_3508.option;

/*
extends vs super
*/
public abstract class TmpOption {
    // писать - в super
    //читать - из extends
    //пару лекций назад есть примеры

    // java.lang.Object
    // java.lang.Throwable
    // java.lang.Exception
    // java.lang.RuntimeException
    // java.lang.NullPointerException
    public static void main(String[] args) {
//        Run_V1();
//        BoundedType();
//        tmp();

        System.out.println(getDoubleValue(new OptionInteger(123)));
        System.out.println(getDoubleValue(new OptionNumber<>(3.14)));

        OptionInteger n1 = new OptionInteger(123);
        setInteger(n1);
        OptionNumber<Number> n2 = new OptionNumber<>(123.33);
        setInteger(n2);

        System.out.println(n1.getValue());  // 123
        System.out.println(n2.getValue());   // 123.33

    }

    static void setInteger(OptionValue<? super Integer> opt) {
        opt.setValue(33);
    }

    static double getDoubleValue(OptionNumber<? extends Number> opt) {
        return opt.getValue().doubleValue();
    }

}

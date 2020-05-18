package bekKentJunit;

public class Franc extends Money { // класс без подчистки
//    public int amount;

    public Franc(int amount) {
        this.currency = "CHF";
        this.amount = amount;
    }

    public Franc times(int multiplier) {
        return new Franc(amount *= multiplier);
    }

//    public String getCurrency() {
//        return currency;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Franc)) return false;
//
//        Franc dollar = (Franc) o;
//        return amount == dollar.amount;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(amount);
//    }
}

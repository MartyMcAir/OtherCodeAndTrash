package bekKentJunit;

import java.util.Objects;

// from Book //Экстремальное программирование: разработка через тестирование //Бек Кент
public class Money {
    protected int amount; // protected - доступ для наследующих
    protected String currency = "USD"; // default

    public Money() {
    }

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    static Money dollar(int amount) { // фабричный метод
//        return new Dollar(amount);
        return new Money(amount, "USD");
    }

    public Money times(int multiplier, String currency) {
//        return new Dollar(amount *= multiplier);
        return new Money(amount *= multiplier, currency);
    }

    public Money times(int multiplier) {
//        return new Dollar(amount *= multiplier);
        return new Money(amount *= multiplier, currency);
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Money)) return false;

        // проверка на то, что текущ объект и поступивший одной  той же валюты
        if (!getClass().equals(o.getClass())) return false;

        Money money = (Money) o;
        return amount == money.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    public Money plus(Money addend) {
        return new Money(amount + addend.amount, currency);
    }
}

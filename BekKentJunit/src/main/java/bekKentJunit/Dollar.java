package bekKentJunit;

public class Dollar extends Money {

    public Dollar(int amount) {
        this.currency = "USD";
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount *= multiplier);
        // круг
//        return Money.dollar(amount *= multiplier); // юзаем фабричный метод создания объекта
    }
}

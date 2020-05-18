package z_Generics_WildCardsOth.JRush_GenericsWildCards_3508.option;

public class OptionValue<V> {
    private V value;

    public OptionValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

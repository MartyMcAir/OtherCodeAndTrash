package z_Generics_WildCardsOth.JRush_GenericsWildCards_3508.supMidChi1;

public class Container<T extends SuperClazz> {
    private T t;
    private String containerName;

    public Container(String containerName) {
        this.containerName = containerName;
    }

    public T getT() {
        return t;
    }

    @Override
    public String toString() { // return "t=" + t.getClass() + '\''; // NullPointerException
        return containerName;
    }
}

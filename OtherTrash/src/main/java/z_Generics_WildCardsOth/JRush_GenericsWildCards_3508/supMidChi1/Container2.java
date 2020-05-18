package z_Generics_WildCardsOth.JRush_GenericsWildCards_3508.supMidChi1;

import z_Generics_WildCardsOth.JRush_GenericsWildCards_3508.supMidChi1.SuperClazz;

//    public static class Container2<T super SuperClazz> { // Unexpected token
public class Container2<T extends SuperClazz> {
    private T t;
    private String containerName;

    public Container2(String containerName) {
        this.containerName = containerName;
    }

    @Override
    public String toString() { // return "t=" + t.getClass() + '\''; // NullPointerException
        return containerName;
    }
}

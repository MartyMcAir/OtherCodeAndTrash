package z_Generics_WildCardsOth.JRush_GenericsWildCards_3508;

import java.util.List;

public class TestClass {
    //  должен работать с одним и тем же типом;
    public <T> void one(List<T> destination, List<T> source) {
        System.out.println(destination.get(0).getClass());
        System.out.println(source.get(0).getClass());
    }

    // должен добавлять любых наследников типа T в список, умеющий хранить только тип T;
//        public <T> void two(List<? super T> destination, List<? extends T> source) {
//        public <T> void two(List<? super Object> destination, List<? extends T> source) {
    public <T> void two(List<? super Object> destination, List<? extends T> source) {
        destination.add(source);
//            source.add(destination);
    }

    // должен добавлять объекты типа T в любой список, параметризированный любым родительским классом;
    public <T> void three(List<? extends T> destination, List<? super T> source) {

    }

    // должен добавлять любых наследников типа T в  список, умеющий хранить только тип T;
    public <T> void four(List destination, List source) {

    }
}

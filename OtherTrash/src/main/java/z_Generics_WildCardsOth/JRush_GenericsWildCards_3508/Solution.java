package z_Generics_WildCardsOth.JRush_GenericsWildCards_3508;

import java.util.List;

/* 
extends vs super
*/
public abstract class Solution {
    //  должен работать с одним и тем же типом;
//    public abstract <T> void one(List destination, List source);
    public abstract <T> void one(List<T> destination, List<T> source);

    // destination - то куда кидают, source - то что кидают в destination
    // должен добавлять любых наследников типа T в список, умеющий хранить только тип T;
//    public abstract <T> void two(List destination, List source);
    public abstract <T> void two(List<T> destination, List<? extends T> source);

    // должен добавлять объекты типа T в любой список, параметризированный любым родительским классом;
//    public abstract <T> void three(List destination, List source);
//    public abstract <T> void three(List<? super T> destination, List<? extends T> source); // My Wrong
    public abstract <T> void three(List<? super T> destination, List<T> source);

    // должен добавлять любых наследников типа T в список, параметризированный любым родительским классом.
//    public abstract <T> void four(List destination, List source);
//    public abstract <T, K extends T> void four(List<K> destination, List<T> source); // My Wrong
    public abstract <T> void four(List <? super T> destination, List <? extends T> source);

}

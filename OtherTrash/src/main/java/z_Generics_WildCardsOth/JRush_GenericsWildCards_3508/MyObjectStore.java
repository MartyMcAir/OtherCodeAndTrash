package z_Generics_WildCardsOth.JRush_GenericsWildCards_3508;

import java.util.Collection;
import java.util.Map;
import java.util.function.Predicate;

public interface MyObjectStore<K, V> {
    void put(K key, V value);

    /**
     * Читает значение из хранилища по заданному ключу.
     *
     * @param key Ключ.
     * @return Значение либо null.
     */
//    @Nullable
    V get(K key);

    /**
     * Кладёт все пары ключ-значение в хранилище.
     *
     * @param entries Набор пар ключ-значение.
     */
    void putAll(Map<K, V> entries);

    /**
     * Читает все значения из хранилища по заданным
     * ключам.
     *
     * @param keys Набор ключей.
     * @return Пары ключ-значение.
     */
    Map<K, V> getAll(Collection<K> keys);

    /**
     * Читает из хранилища все значения, удовлетворяющие
     * заданному условию (предикату).
     *
     * @param p Предикат для проверки значений.
     * @return Значения, удовлетворяющие предикату.
     */
    Collection<V> getAll(Predicate<V> p);
}

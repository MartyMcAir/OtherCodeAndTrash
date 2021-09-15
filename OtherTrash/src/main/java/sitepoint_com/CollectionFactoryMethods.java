package sitepoint_com;

import java.util.List;
import java.util.Map;

// Well, as great as it might seem, this is non-trivial and there are good reasons not to do it.
// What’s the next best thing? Factory methods! Thanks to JEP 269 we can do this now:
public class CollectionFactoryMethods {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c");
        Map<String, Integer> mapImmediate = Map.of(
                "one", 1,
                "two", 2,
                "three", 3);
    }
}
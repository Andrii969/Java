package util;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends Student & QueryItem> {
    // Here, I'm saying that any type that uses this class, must be a Student or subtype of the Student class,
    // and it also must implement the QueryItem interface. You can use multiple types to set a more restrictive
    // upper bound with the use of an ampersand between types.

    // You use extends for either a class or an interface or both.
    // If you do extend a class as well as an interface or two, the class must be the FIRST type listed.

    private List<T> items;

    public QueryList(List<T> items) {
        this.items = items;
    }

    public static <S extends QueryItem> List<S> getMatches(List<S> items, String field, String value) {
        List<S> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public List<T> getMatches(String field, String value) {
        List<T> matches = new ArrayList<>();
        for (var item : items) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}

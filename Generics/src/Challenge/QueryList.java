package Challenge;

import java.util.ArrayList;
import java.util.List;

public class QueryList <T extends Student & QueryItem> extends ArrayList<T>{
    // extends ArrayList - means I won't have to manage all the elements -> the ArrayList's functionality will handle all of that

//    private List<T> items;

    public QueryList() { // WHY DO WE NEED IT ???

    }

    public QueryList(List<T> items) {
        super(items); // passing items as its arguments (instead of assigning the argument to items)
//        this.items = items;
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

    public QueryList<T> getMatches(String field, String value) {

        QueryList<T> matches = new QueryList<>();
        for (var item : this) {
            if (item.matchFieldValue(field, value)) {
                matches.add(item);
            }
        }
        return matches;
    }
}


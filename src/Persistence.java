import clojure.lang.IPersistentList;
import clojure.lang.PersistentList;

import java.util.Arrays;

/**
 * @author toandv
 * @github https://github.com/toandv
 * @since 10/3/2016.
 */
public class Persistence {
    public static void main(String[] args) {
        IPersistentList l = PersistentList.create(Arrays.asList(1, 2, 3));
        l.cons(4);
        l.pop();
    }
}

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author toandv
 * @github https://github.com/toandv
 * @since 10/15/2016.
 */
public class DataFlow {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> a = new FutureTask<Integer>(() -> 1);
        FutureTask<Integer> b = new FutureTask<Integer>(() -> 2);

        //a.
        a.run();
        int v = a.get();
        System.out.println(v);

    }
}

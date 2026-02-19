import java.util.Vector;
import java.util.function.Predicate;

public class VectorUtils {

    public static <T> void swap(Vector<T> vec, int i, int j) {
        T temp = vec.get(i);
        vec.set(i, vec.get(j));
        vec.set(j, temp);
    }

    public static <T extends Comparable<T>> T findMax(Vector<T> vec) {
        if (vec.isEmpty()) return null;
        T max = vec.get(0);
        for (T t : vec)
            if (t.compareTo(max) > 0) max = t;
        return max;
    }

    public static <T> int countMatches(Vector<T> vec, T target) {
        int count = 0;
        for (T t : vec)
            if (t.equals(target)) count++;
        return count;
    }

    public static <T> Vector<T> filter(Vector<T> vec, Predicate<T> condition) {
        Vector<T> result = new Vector<>();
        for (T t : vec)
            if (condition.test(t))
                result.add(t);
        return result;
    }

    public static <T extends Number> double sumNumbers(Vector<T> numbers) {
        double sum = 0;
        for (T n : numbers)
            sum += n.doubleValue();
        return sum;
    }

    public static <T extends Number> double averageNumbers(Vector<T> numbers) {
        if (numbers.isEmpty()) return 0.0;
        return sumNumbers(numbers) / numbers.size();
    }
}

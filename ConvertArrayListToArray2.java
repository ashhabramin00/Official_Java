import java.util.ArrayList;
import java.util.List;

public class ConvertArrayListToArray2 {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>();
        intList.add(10);
        intList.add(20);
        intList.add(30);

        Integer[] intArray = new Integer[intList.size()];
        intArray = intList.toArray(intArray);

        for(Integer i : intArray)
            System.out.println(i);
    }
}
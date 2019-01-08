public class TestDynamicArray {
    public static void main(String[] args) {
        DynamicArray<Integer> arr = new DynamicArray<>();

        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
            System.out.println(arr);
        }

        // Increase capacity test
        arr.addLast(20);
        System.out.println(arr);

        int j = 6;
        while(j != 0) {
            arr.delete(0);
            j--;
        }
        System.out.println(arr);
    }
}
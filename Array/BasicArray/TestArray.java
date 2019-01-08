public class TestArray
{
    public static void main(String[] args) {
        MyArray int_arr = new MyArray();
        System.out.println(int_arr);

        int_arr.addLast(1);
        System.out.println(int_arr);

        int_arr.addFirst(2);
        System.out.println(int_arr);

        int_arr.addLast(3);
        int_arr.addLast(4);
        int_arr.addLast(5);
        System.out.println(int_arr);
        
        int_arr.add(2, 0);
        System.out.println(int_arr);
    }

}
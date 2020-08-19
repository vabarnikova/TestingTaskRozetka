public class TestClass {

    public static void main(String[] args) {
//        System.out.println(reverseString("My s"));
        int[] arrayOfInts = new int[]{1, 3, 4, 55, 66, 22};
        int[] arrayOfInts2 = new int[]{1, 3, 4, 55, 66, 22, 44};
        System.out.println(swap(arrayOfInts));
        System.out.println(swap(arrayOfInts2));
    }
//1, 3, 4, 55, 66, 22
//1, 3, 4, 55, 66, 22, 44
// empty array
// 1
// 1 2

    public static int[] swap(int[] array) {
        if (array.length % 2 == 0) {
            int middle = array[array.length / 2 - 1];
            array[array.length / 2 - 1] = array[array.length - 1];
            array[array.length - 1] = middle;
        } else {

            int middle = array[array.length / 2];
            array[array.length / 2] = array[array.length - 1];
            array[array.length - 1] = middle;
        }
        return array;
    }

    public static String reverseString(String stringToReverse) {
        char[] originalCharArray;
        originalCharArray = stringToReverse.toCharArray();
        char[] resultCharArray = new char[originalCharArray.length];

        int k = 0;
        for (int i = originalCharArray.length - 1; i >= 0; i--) {
            resultCharArray[k] = originalCharArray[i];
            k++;
        }
        return new String(resultCharArray);
    }

    public static String reverseString2(String stringToReverse) {
        char k = 'c';
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(k);
        return new StringBuilder(stringToReverse).reverse().toString();
    }
}

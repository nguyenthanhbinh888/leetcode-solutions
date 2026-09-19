package D14_09_2926;
public class LeetCode836 {

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        return rec1[0] < rec2[2]
            && rec1[2] > rec2[0]
            && rec1[1] < rec2[3]
            && rec1[3] > rec2[1];
    }

    public static void main(String[] args) {

        int[] rec1 = {0, 0, 2, 2};
        int[] rec2 = {1, 1, 3, 3};

        boolean result = isRectangleOverlap(rec1, rec2);

        System.out.println(result);
    }
}
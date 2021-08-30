package top.atstudy.basic.suanfa.sort;

/**
 * #### 插入排序
 * 1、每次保证前n项有序
 * 时间复杂度（平均）：O(n^2^)
 * 时间复杂度（最好）：O(n)
 * 时间复杂度（最坏）：O(n^2^)
 * 空间复杂度：
 */
public class Insertion extends Example {

    public Insertion() {
        super(false);
    }

    public Insertion(boolean show) {
        super(show);
    }

    @Override
    protected void sort(Comparable[] a) {
        //将a[]按升序排
        int N = a.length;
        for (int i = 1; i < N; i++) {
            //将a[i]插入到a[0], a[1], ... a[i-1] 中
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);

                show(a, j, j - 1, true);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};

//        Integer[] a = {19, 18, 17, 16, 15, 14, 13, 12, 11, 10};

        Insertion insertion = new Insertion(true);
        System.out.println(insertion.isSorted(a));
        insertion.show(a, null, null, false);
        System.out.println(" === ");
        //排序
        insertion.sort(a);

        //输出
        System.out.println(insertion.isSorted(a));
        insertion.show(a, null, null, false);

    }
}

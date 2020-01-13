package top.atstudy.basic.suanfa.sort;

/**
 * 插入排序
 * 1、每次保证前n项有序
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
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);

                show(a, j, j-1, true);
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = {19, 18, 17, 16, 15, 14, 13, 12, 11, 10};

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

package top.atstudy.basic.suanfa.sort;

/**
 * 选择排序
 * 1、每次找出剩下元素中最小元素
 */
public class Selection extends Example {

    public Selection() {
        super(false);
    }

    public Selection(boolean show) {
        super(show);
    }

    @Override
    protected void sort(Comparable[] a) {
        //将a[]按升序排列
        int N = a.length;
        for (int i = 0; i < N; i++) {
            //将a[i] 与a[i+1 ... N] 中最小的交换
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);

            //打印
            show(a, i, min, true);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
//        Integer[] a = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};

        Selection selection = new Selection(true);
        System.out.println(selection.isSorted(a));
        selection.show(a, null, null, false);
        System.out.println(" === ");
        //排序
        selection.sort(a);

        //输出
        System.out.println(selection.isSorted(a));
        selection.show(a, null, null, false);


    }
}

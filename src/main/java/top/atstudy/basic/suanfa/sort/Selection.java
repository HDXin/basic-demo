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
            for (int j = i+1; j < N; j++) {
                if(less(a[j], a[min])){
                    min = j;
                }
            }
            exch(a, i, min);

            //打印
            show(a, i, min, true);
        }
    }

    public static void main(String[] args) {
        Integer[] a = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};

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

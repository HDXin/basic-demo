package top.atstudy.basic.suanfa.sort;

/**
 * 希尔排序
 */
public class Shell extends Example {

    public Shell() {
        super(false);
    }

    public Shell(boolean show) {
        super(show);
    }

    @Override
    protected void sort(Comparable[] a) {

        int N = a.length;
        int h = 1;
        while (h < N/3){
            h = 3*h +1;
        }

        while (h >= 1){
            //将数组变为 h 有序
            for (int i = h; i < N; i++) {
                //将 a[i] 插入到 a[i-h], a[i-2*h], a[i-3*h] ... 之中
                for (int j = i; j >= h; j -= h) {
                    boolean flag = false;
                    if(less(a[j], a[j-h])){
                        exch(a, j, j-h);
                        flag = true;
                    }
                    show(a, j, j-h, flag);
                }
            }
            h = h/3;
        }
    }

    public static void main(String[] args) {

//        for (int i = 60; i > 10; i--) {
//            System.out.print(i + ", ");
//        }
        Integer[] a = {60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};

        Shell shell = new Shell(true);
        System.out.println(shell.isSorted(a));
        shell.show(a, null, null, false);
        System.out.println(" === ");
        //排序
        shell.sort(a);

        //输出
        System.out.println(shell.isSorted(a));
        shell.show(a, null, null, false);

    }
}

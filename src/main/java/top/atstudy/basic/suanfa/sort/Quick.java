package top.atstudy.basic.suanfa.sort;

/**
 * 快速排序
 */
public class Quick extends Example {

    public Quick() {super(false);}

    public Quick(boolean show) {
        super(show);
    }

    @Override
    protected void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi){

        if(hi <= lo){
            return ;
        }

        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    /**
     * 将数组切分为 a[lo .. i-1] a[i] a[i+1 .. hi]
     */
    private int partition(Comparable[] a, int lo, int hi){
        //左右扫描指针
        int i = lo, j = hi + 1;
        //切分元素
        Comparable v = a[lo];
        while (true){
            //扫描左右，检查扫描是否结束并交换元素
            while (less(a[++i], v)){
                //打印比较项
                show(a, lo, i, false);
                if(i == hi){
                    break;
                }
            }
            while (less(v, a[--j])){
                //打印比较项
                show(a, lo, j, false);
                if(j == lo){
                    break;
                }
            }
            if(i >= j){
                break;
            }
            exch(a, i, j);

            //打印交换值
            show(a, i, j, true);
        }
        exch(a, lo, j);
        show(a, lo, j, true);

        return j;
    }


    public static void main(String[] args) {

//        for (int i = 60; i > 10; i--) {
//            System.out.print(i + ", ");
//        }
//        Integer[] a = {60, 59, 58, 57, 56, 55, 54, 53, 52, 51, 50, 49, 48, 47, 46, 45, 44, 43, 42, 41, 40, 39, 38, 37, 36, 35, 34, 33, 32, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        Integer[] a = {20, 19, 18, 17, 16, 15, 14, 13, 12, 11};

        Quick quick = new Quick(true);
        System.out.println(quick.isSorted(a));
        quick.show(a, null, null, false);
        System.out.println(" === ");
        //排序
        quick.sort(a);

        //输出
        System.out.println(quick.isSorted(a));
        quick.show(a, null, null, false);

    }

}

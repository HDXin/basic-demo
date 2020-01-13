package top.atstudy.basic.suanfa.sort;

import java.util.Random;

public class DemoTest {

    private int aa;

    public static void main(String[] args) {

        Integer[] a = getRandom(10000);
        Integer nums = 1;

        /**
         * 选择排序
         */
//        System.out.println("选择：" + selectionTest(a, nums));

        /**
         * 插入排序
         */
//        System.out.println("插入：" + insertionTest(a, nums));

        /**
         * 希尔排序
         */
        System.out.println("希尔：" + shellTest(a, nums));

        /**
         * 快速排序
         */
        System.out.println("快速：" + quickTest(a, nums));

    }

    /**
     * 快速排序
     * @param a
     * @param nums
     * @return
     */
    private static long quickTest(Integer[] a, int nums){
        Long[] times = new Long[nums];
        for (int i = 0; i < nums; i++) {
            times[i] = quickTest(a);
        }

        return avg(times);
    }

    /**
     * 希尔排序
     * @param a
     * @param nums
     * @return
     */
    private static long shellTest(Integer[] a, int nums){

        Long[] times = new Long[nums];
        for (int i = 0; i < nums; i++) {
            times[i] = shellTest(a);
        }

        return avg(times);
    }

    /**
     * 插入排序
     * @param a
     * @param nums
     * @return
     */
    private static long insertionTest(Integer[] a, int nums){

        Long[] times = new Long[nums];
        for (int i = 0; i < nums; i++) {
            times[i] = insertionTest(a);
        }

        return avg(times);
    }

    /**
     * 选择排序
     * @param a
     * @param nums
     * @return
     */
    private static long selectionTest(Integer[] a, int nums){

        Long[] times = new Long[nums];
        for (int i = 0; i < nums; i++) {
            times[i] = selectionTest(a);
        }

        return avg(times);
    }

    /**
     * 快速排序
     * @param a
     * @return
     */
    private static long quickTest(Integer[] a){
        Integer[] aa = a.clone();
        long start = System.currentTimeMillis();
        Quick quick = new Quick();
        quick.sort(aa);
        long end = System.currentTimeMillis();

        return end - start;
    }

    /**
     * 希尔排序
     * @param a
     * @return
     */
    private static long shellTest(Integer[] a){
        Integer[] aa = a.clone();
        long start = System.currentTimeMillis();
        Shell shell = new Shell();
        shell.sort(aa);
        long end = System.currentTimeMillis();

        return end - start;
    }

    /**
     * 插入排序
     * @param a
     * @return
     */
    private static long insertionTest(Integer[] a){
        Integer[] aa = a.clone();
        long start = System.currentTimeMillis();
        Insertion insertion = new Insertion();
        insertion.sort(aa);
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     *
     * 选择排序
     * @param a
     * @return
     */
    private static long selectionTest(Integer[] a){
        Integer[] aa = a.clone();
        long start = System.currentTimeMillis();
        Selection selection = new Selection();
        selection.sort(aa);
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * 平均值
     * @param times
     * @return
     */
    private static long avg(Long[] times){
        Long sum = 0L;
        for(Long time:times){
            sum += time;
        }
        System.out.print(sum + "/" + times.length + " ");
        return sum/times.length;
    }

    /**
     * 随机int
     * @param nums
     * @return
     */
    private static Integer[] getRandom(int nums){

        Integer[] a = new Integer[nums];
        for (int i = 0; i < nums; i++) {
            a[i] = new Random().nextInt(nums);
        }
        return a;
    }

}

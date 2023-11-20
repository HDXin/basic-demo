package top.atstudy.basic.suanfa.sort;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class DemoTest {

    private int aa;

    public static void main(String[] args) {

        testSort(10000, 1);

    }

    /**
     * @param size 列表大小
     * @param nums 排序次数
     */
    private static void testSort(Integer size, int nums) {

        Long[] seletions = new Long[nums];
        Long[] insertions = new Long[nums];
        Long[] shells = new Long[nums];
        Long[] quicks = new Long[nums];

        for (int i = 0; i < nums; i++) {
            Integer[] randoms = getRandom(size);
            // 选择排序
            seletions[i] = selectionTest(randoms);

            // 插入排序
            insertions[i] = insertionTest(randoms);

            // 希尔排序
            shells[i] = shellTest(randoms);

            // 快速排序
            quicks[i] = quickTest(randoms);
        }

        /**
         * 选择排序
         */
        System.out.println("选择：" + avg(seletions));

        /**
         * 插入排序
         */
        System.out.println("插入：" + avg(insertions));

        /**
         * 希尔排序
         */
        System.out.println("希尔：" + avg(shells));

        /**
         * 快速排序
         */
        System.out.println("快速：" + avg(quicks));

    }

    /**
     * 快速排序
     *
     * @param a
     * @param nums
     * @return
     */
    private static long quickTest(Integer[] a, int nums) {
        Long[] times = new Long[nums];
        for (int i = 0; i < nums; i++) {
            times[i] = quickTest(a);
        }

        return avg(times);
    }

    /**
     * 希尔排序
     *
     * @param a
     * @param nums
     * @return
     */
    private static long shellTest(Integer[] a, int nums) {

        Long[] times = new Long[nums];
        for (int i = 0; i < nums; i++) {
            times[i] = shellTest(a);
        }

        return avg(times);
    }

    /**
     * 插入排序
     *
     * @param a
     * @param nums
     * @return
     */
    private static long insertionTest(Integer[] a, int nums) {

        Long[] times = new Long[nums];
        for (int i = 0; i < nums; i++) {
            times[i] = insertionTest(a);
        }

        return avg(times);
    }

    /**
     * 选择排序
     *
     * @param a
     * @param nums
     * @return
     */
    private static long selectionTest(Integer[] a, int nums) {

        Long[] times = new Long[nums];
        for (int i = 0; i < nums; i++) {
            times[i] = selectionTest(a);
        }

        return avg(times);
    }

    /**
     * 快速排序
     *
     * @param a
     * @return
     */
    private static long quickTest(Integer[] a) {
        Integer[] aa = a.clone();
        long start = System.currentTimeMillis();
        Quick quick = new Quick();
        quick.sort(aa);
        long end = System.currentTimeMillis();

        return end - start;
    }

    /**
     * 希尔排序
     *
     * @param a
     * @return
     */
    private static long shellTest(Integer[] a) {
        Integer[] aa = a.clone();
        long start = System.currentTimeMillis();
        Shell shell = new Shell();
        shell.sort(aa);
        long end = System.currentTimeMillis();

        return end - start;
    }

    /**
     * 插入排序
     *
     * @param a
     * @return
     */
    private static long insertionTest(Integer[] a) {
        Integer[] aa = a.clone();
        long start = System.currentTimeMillis();
        Insertion insertion = new Insertion();
        insertion.sort(aa);
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * 选择排序
     *
     * @param a
     * @return
     */
    private static long selectionTest(Integer[] a) {
        Integer[] aa = a.clone();
        long start = System.currentTimeMillis();
        Selection selection = new Selection();
        selection.sort(aa);
        long end = System.currentTimeMillis();
        return end - start;
    }

    /**
     * 平均值
     *
     * @param times
     * @return
     */
    private static long avg(Long[] times) {
        Long sum = 0L;
        for (Long time : times) {
            sum += time;
        }
        System.out.print(sum + "/" + times.length + " ");
        return sum / times.length;
    }

    /**
     * 随机int
     *
     * @param nums
     * @return
     */
    private static Integer[] getRandom(int nums) {
        List<Integer> a = new ArrayList(nums);
        while (a.size() < nums) {
            int temp = RandomUtil.randomInt(0, 1000_000_000);
            if (!CollUtil.contains(a, temp)) {
                a.add(temp);
            }
        }
        return a.toArray(new Integer[nums]);
    }

//    /**
//     * 随机int
//     *
//     * @param nums
//     * @return
//     */
//    private static Integer[] getRandom(int nums) {
//        List<Integer> a = new ArrayList(nums);
//        for (int i = 0; i < nums; i++) {
//            a.add(0, i);
//        }
//        return a.toArray(new Integer[nums]);
//    }


}

package top.atstudy.basic.suanfa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/16 22:06
 */
public class Suanfa {


    public static int[] twoSum1(int[] nums, int target) {
        List<Integer> arr = new ArrayList<>(nums.length);
        for(int i=0; i<nums.length; i++){
            Integer temp = target - nums[i];
            if(arr.contains(temp))
                return new int[]{arr.indexOf(temp), i};

            arr.add(nums[i]);
        }

        return null;
    }

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i=0; i<nums.length; i++){
            Integer temp = target - nums[i];
            if(map.containsKey(temp))
                return new int[]{map.get(temp), i};

            map.put(nums[i], i);
        }

        return null;
    }


    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] temp = twoSum2(nums, target);
        System.out.println("");
    }
}

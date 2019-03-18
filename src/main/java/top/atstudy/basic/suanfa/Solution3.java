package top.atstudy.basic.suanfa;

import java.util.*;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/16 23:24
 */

public class Solution3 {

    public static void main(String[] args) {

        String str = "abcabcbb";
        System.out.println(" ===>> " + lengthOfLongestSubstring(str));


    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Byte, Integer> map = new HashMap<>();
        byte[] sb = s.getBytes();
        Integer index = 0;
        for(int i=0; i<sb.length; i++){

            if(map.containsKey(sb[i])){
                Integer newIndex = map.get(sb[i]);

                index = index > newIndex ? index:newIndex;
            }

            map.put(sb[i], i);
        }

        return sb.length - index - 1;
    }
}
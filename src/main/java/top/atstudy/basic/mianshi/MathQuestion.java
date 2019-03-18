package top.atstudy.basic.mianshi;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/12 16:57
 */
public class MathQuestion {

    public static void main(String[] args) {

        String str = "aabbccaabb";
        print(str.getBytes());

    }

    /**
     * 输出 a ... b 字符串
     * @param arr
     */
    private static void print(byte[] arr){
        for(int i=0;i<arr.length; i++){
            if(arr[i] != 97)
                continue;

            for(int j=i; j<arr.length; j++){
                if(arr[j] != 98)
                    continue;

                for(int z=i; z<=j; z++){
                    System.out.print((char)arr[z]);
                }

                System.out.println(" ");
            }
        }
    }





}

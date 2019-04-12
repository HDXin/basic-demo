package top.atstudy.basic.thread.newstructure.exchanger;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/4/12 15:29
 */
public class Fat {
    private volatile double d;
    private static int counter = 0;
    private final int id = counter++;
    public Fat(){
        for(int i=1; i<10000; i++){
            d += (Math.PI + Math.E) / (double)i;
        }
    }
    public void operation(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Fat id: " + id;
    }
}

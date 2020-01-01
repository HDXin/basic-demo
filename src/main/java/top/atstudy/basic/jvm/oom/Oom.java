package top.atstudy.basic.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/12 20:01
 */
public class Oom {


    public static void main(String[] args) {

        List<OomObject> oomObjectList = new ArrayList<>();

        int i = 0;
        while (true){
            oomObjectList.add(new OomObject());
            System.out.println(" ==>> " + i++);
        }

    }

    static class OomObject{

    }




}

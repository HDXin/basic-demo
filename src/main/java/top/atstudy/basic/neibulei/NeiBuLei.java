package top.atstudy.basic.neibulei;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/3/13 21:24
 */
public class NeiBuLei {

    public class Inner{
        public NeiBuLei create(){
            return NeiBuLei.this;
        }
    }

    public Inner create(){
        return new Inner();
    }

    public static void main(String[] args) {

//        NeiBuLei n = new NeiBuLei();
//        Inner in = n.create();
//
//        NeiBuLei n2 = new NeiBuLei();
//        Inner in2 = n2.new Inner();


        Person.Student s = new Person.Student();
        s.run();

    }


}

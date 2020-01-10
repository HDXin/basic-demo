package top.atstudy.basic.thread.park02.subject;

public class Client {

    public static void main(String[] args) {

        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("=====");
        subject.setState(10);
        System.out.println("=====");
        subject.setState(10);
        System.out.println("=====");
        subject.setState(15);


    }

}

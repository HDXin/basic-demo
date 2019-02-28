package top.atstudy.basic.serializable;

import org.junit.Test;

import java.io.*;

/**
 * @author huangdexin @ harley
 * @email huangdexin@kuaicto.com
 * @date 2019/2/26 11:52
 */
public class SerializableTest {

    @Test
    public void save() throws IOException {
        Person person = new Person(1234L, "zhangsan", "15689895757");
        System.out.println("Person Serial：" + person.toString());
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }

    @Test
    public void get() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Student student = (Student) ois.readObject();
        ois.close();
        System.out.println("Student Deserial：" + student.toString());
    }


}

package top.atstudy.basic.designmode.proxy.jdk;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DemoProxyClient {

    public static void main(String[] args) {

        //
//        demo();

        //
        demo2();

        //
//        demo3();

        //
//        demo4();

//        demo5();

    }

    public static void demo5() {

        Auth auth = new AuthImpl();

        Auth proxy = new $Proxy0(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("hiahia");
                return method.invoke(auth, args);
            }
        });

        System.out.println(proxy.add(1, 2));

    }

    public static void demo4() {

        try {
            String path = "E:\\tmp\\proxy\\$Proxy2.class";
            byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Auth.class, Auth2.class});

            FileOutputStream fos = new FileOutputStream(new File(path));

            fos.write(classFile, 0, classFile.length);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void demo3() {
        Auth2 auth = new AuthImpl();
        Auth2 proxy = (Auth2) Proxy.newProxyInstance(auth.getClass().getClassLoader(), auth.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Object result = method.invoke(auth, args);

                return result;
            }
        });

        System.out.println(proxy.getClass().getName());


        int result = proxy.add(1, 2);
        System.out.println(result);
    }

    public static void demo2() {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");//打开保存proxy动态生成文件的开关

        // 原目标类
        Auth auth = new AuthImpl();

        // 初次代理
        final Auth temp = auth;
        auth = (Auth) Proxy.newProxyInstance(auth.getClass().getClassLoader(), new Class[]{Auth.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("abc before ... ");
                Object result = method.invoke(temp, args);
                System.out.println("abc after ... ");

                return result;
            }
        });

        // 再次代理
        final Auth temp2 = auth;
        auth = (Auth) Proxy.newProxyInstance(auth.getClass().getClassLoader(), new Class[]{Auth.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                System.out.println(" 1111 before ... ");
                Object result = method.invoke(temp2, args);
                System.out.println(" 1111 after ... ");

                return result;
            }
        });
        int result = auth.add(1, 2);
        System.out.println("===>> 1 + 2 = " + result);
    }


    /**
     *
     */
    public static void demo() {
        System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");//打开保存proxy动态生成文件的开关

        MyInvocationHandler invocation = new MyInvocationHandler();
        Auth auth = new AuthImpl();
        Auth proxy = (Auth) invocation.bind(auth);

        int result = proxy.add(2, 3);
        System.out.println(" ===>> 2 + 3 = " + result);

    }

}

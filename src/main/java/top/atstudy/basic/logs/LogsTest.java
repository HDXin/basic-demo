package top.atstudy.basic.logs;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.*;

public class LogsTest {

    public static void main(String[] args) throws IOException {

//        demo();

//        demo2();

//        demo3();

        // JUL
//        demo4();

        // JCL
        demo5();


    }

    /**
     * JCL 测试
     */
    private static void demo5(){

        // 获取 log 日志记录器对象
        Log log = LogFactory.getLog(LogsTest.class);
        // 日志记录输出
        log.info(" ===>> hello JCL ... ");


    }

    /**
     * 加载自定义配置文件
     */
    private static void demo4() throws IOException {

        // 读取配置文件，通过类加载器
        InputStream is = LogsTest.class.getClassLoader().getResourceAsStream("logging-test.properties");

        // 创建LogManager
        LogManager logManager = LogManager.getLogManager();

        // 通过LogManager加载配置文件
        logManager.readConfiguration(is);

        // 创建日志记录器
        Logger logger = Logger.getLogger("top.atstudy.basic.logs.LogsTest");


        logger.severe(" == severe");
        logger.warning(" == warning");
        logger.info(" == info");
        logger.config(" == config");
        logger.fine(" == fine");
        logger.finer(" == finer");
        logger.finest(" == finest");

    }

    private static void demo3(){
        Logger logger = Logger.getLogger("top.atstudy.basic.logs.LogsTest");
//        Logger logger2 = Logger.getLogger("top.atstudy.basic");
        Logger logger3 = Logger.getLogger("top");
//        System.out.println(logger.getParent() == logger2);
        System.out.println(logger.getParent() == logger3);

    }

    private static void demo2() throws IOException {
        Logger logger = Logger.getLogger("top.atstudy.basic.logs.LogsTest");

        //关闭系统默认设置
        logger.setUseParentHandlers(false);

        //自定义配置日志级别
        //创建ConsolHandler 控制台输出
        ConsoleHandler consoleHandler = new ConsoleHandler();

        //创建简单格式转换对象
        SimpleFormatter simpleFormatter = new SimpleFormatter();

        //进行关联
        consoleHandler.setFormatter(simpleFormatter);
        logger.addHandler(consoleHandler);

        //配置日志具体级别
        logger.setLevel(Level.ALL);
        consoleHandler.setLevel(Level.ALL);

        //创建 fileHandler 文件输出
        FileHandler fileHandler = new FileHandler("logs/jul.log");
        logger.addHandler(fileHandler);

        logger.severe(" == severe");
        logger.warning(" == warning");
        logger.info(" == info");
        logger.config(" == config");
        logger.fine(" == fine");
        logger.finer(" == finer");
        logger.finest(" == finest");


    }

    private static void demo(){
        Logger logger = Logger.getLogger("top.atstudy.basic.logs.LogsTest");
        logger.log(Level.INFO, " ====>> 测试日志: {0}, {1}", new String[]{"呵呵", "哈哈"});

        logger.severe(" == severe");
        logger.warning(" == warning");
        logger.info(" == info");
        logger.config(" == config");
        logger.fine(" == fine");
        logger.finer(" == finer");
        logger.finest(" == finest");
    }

}

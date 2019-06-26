package top.atstudy.basic.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IDUtil {

    private static String MACHINE_CODE = "13";
    private static final Integer SIZE = 6;
    private static volatile Integer INDEX = 1;
    private static final String FORMAT = "%0" + SIZE + "d";
    private static String ORIGINATIONO = "2015-03-09 00:00:00";
    private static final long seconds = 1000 * 60 * 60 * 24;

    private static final IDUtil instance = new IDUtil();
    private IDUtil(){}
    public static IDUtil instance(){
        return instance;
    }

    public static IDUtil instance(String code){
        MACHINE_CODE = code;
        return instance();
    }

    public Long next() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date offset = sdf.parse(ORIGINATIONO);

        Date now = new Date();
        Long v = now.getTime() - offset.getTime();

        //每天
        long days = v/seconds;
        String str = String.format(FORMAT, INDEX++);
        StringBuilder sb = new StringBuilder(days + "");
        sb.append(MACHINE_CODE).append(str);

        return Long.parseLong(sb.toString());
    }


    public static void main(String[] args) throws ParseException {

        for (int i=0; i<33; i++){
            Long id = IDUtil.instance().next();
            System.out.println(" ===>> id: " + id);
        }

    }


}

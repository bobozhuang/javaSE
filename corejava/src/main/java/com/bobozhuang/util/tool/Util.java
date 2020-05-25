package main.java.com.bobozhuang.util.tool;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * description：
 * author Hubery
 * date 2020-04-15
 * version v0.0.1
 * since v0.0.1
 **/
public class Util {
    private static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private Util() {
    }

    /**
     * 判断输入的字符串是否是空
     *
     * @param inStr
     *            输入字符串
     *
     * @return
     *
     */
    public static boolean isNullOrEmpty(String inStr) {
        return (inStr == null || inStr.trim().length() == 0);
    }
    public static boolean isNullOrEmpty(Object obj) {
        if (obj instanceof Object[]) {
            Object[] o = (Object[]) obj;
            for (int i = 0; i < o.length; i++) {
                Object object = o[i];
                if ((object == null) || (("").equals(object))) {
                    return true;
                }
            }
        } else {
            if ((obj == null) || (("").equals(obj))) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断输入日期与当前日期之间相差的月份
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long getDifferMonth(String endDate) {

        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddhhmmss");

        long monthday = 0;

        try {

            Calendar starCal = Calendar.getInstance();
            starCal.setTime(new Date());

            int sYear = starCal.get(Calendar.YEAR);
            int sMonth = starCal.get(Calendar.MONTH)+1;
            int sDay = starCal.get(Calendar.DATE);

            Date endDate1 = fmt.parse(endDate);
            Calendar endCal = Calendar.getInstance();
            endCal.setTime(endDate1);

            int eYear = endCal.get(Calendar.YEAR);
            int eMonth = endCal.get(Calendar.MONTH)+1;
            int eDay = endCal.get(Calendar.DATE);

            monthday = ((eYear - sYear) * 12 + (eMonth - sMonth));

            if (sDay < eDay) {

                monthday = monthday + 1;
            }

            return monthday;

        } catch (ParseException e) {

            e.printStackTrace();
        }

        return monthday;

    }

    /**
     * 根据ukey编号获取其对应的ukey类型
     * @param ukeyId ukey编号
     * @return
     */
    public static String getUkeyType(String ukeyId){
        if(ukeyId != null && ukeyId.length() == 16){
            char ch_certType = ukeyId.charAt(6);
            char ch_ukeyType = ukeyId.charAt(5);
            if(ch_certType == '0'){
                if(ch_ukeyType == 'A'){
                    return "04";
                }else {
                    return "02";
                }
            }else if(ch_certType == '8'){
                if(ch_ukeyType == 'A'){
                    return "03";
                }else {
                    return "01";
                }
            }
        }
        return null;
    }

    /**
     * 获取主机ip
     * @return
     */
    public static String[] getLocalAddresses() {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            String hostName = localHost.getHostName();
            InetAddress[] allByName = InetAddress.getAllByName(localHost.getHostName());
            String[] ipAdd = new String[allByName.length];

            for(int var3 = 0; var3 < allByName.length; ++var3) {
                ipAdd[var3] = allByName[var3].getHostAddress();
            }

            return ipAdd;
        } catch (UnknownHostException var4) {
            /*
            InetAddress.getLocalHost().getHostAddress() 获取ip异常
                异常信息：

                java.net.UnknownHostException: 【hostName】: 【hostName】: Name or service not known

                原因:

                在系统的 /etc/Hostname中配置了“【hostName】” 作为主机名，
                而在/etc/hosts文件中没有 相应的“【hostName】”。

                解决方案:

                修正对应关系 删除Hostname 或者 在 hosts 文件添加相应记录
             */
            return null;
        }
    }

    public static Calendar bocmDatetimeToCal(String var0) {
        int var1 = Integer.parseInt(var0.substring(0, 4));
        int var2 = Integer.parseInt(var0.substring(4, 6)) - 1;
        int var3 = Integer.parseInt(var0.substring(6, 8));
        int var4 = Integer.parseInt(var0.substring(8, 10));
        int var5 = Integer.parseInt(var0.substring(10, 12));
        int var6 = Integer.parseInt(var0.substring(12));
        Calendar var7 = Calendar.getInstance();
        var7.clear();
        var7.set(var1, var2, var3, var4, var5, var6);
        return var7;
    }

    public static Calendar bocmDateToCal(String var0) {
        int var1 = Integer.parseInt(var0.substring(0, 4));
        int var2 = Integer.parseInt(var0.substring(4, 6)) - 1;
        int var3 = Integer.parseInt(var0.substring(6, 8));
        Calendar var4 = Calendar.getInstance();
        var4.clear();
        var4.set(var1, var2, var3, 0, 0, 0);
        return var4;
    }

    public static final String bytes2HexStr(byte[] var0) {
        StringBuffer var1 = new StringBuffer(var0.length * 2);

        for(int var2 = 0; var2 < var0.length; ++var2) {
            var1.append(a[var0[var2] >>> 4 & 15]);
            var1.append(a[var0[var2] & 15]);
        }

        return var1.toString();
    }

    public static final String bytes2HexStr(byte[] var0, int var1, int var2) {
        StringBuffer var3 = new StringBuffer(var2 * 4 + 5);
        int var4 = var1 + var2;

        for(int var5 = var1; var5 < var4; ++var5) {
            var3.append("\\x");
            var3.append(a[var0[var5] >>> 4 & 15]);
            var3.append(a[var0[var5] & 15]);
        }

        return var3.toString();
    }


}

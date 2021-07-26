package main.java.com.bobozhuang.exam.chap03;

/**
 * description： 数字字符串 通过竖式 进行 +、-、* 运算
 *              假设num1  , num2 分别为被加数 、加数，则最终结果只可能是以下情况：
 *
 *              num1  非负数    num2  非负数
 *              num1  负数        num2  负数            、
 *              num1  非负数    num2  负数
 *              num1  负数        num2  非负数
 *              上面四种情况可以转为：
 *
 *              plusAdd(num1,num2)
 *              - plusAdd(- num1,- num2)
 *              plusMinus(num1,- num2)
 *              plusMinus(num2,- num2)
 *
 *              减法类似。
 *
 * author Hubery
 * date 2020-11-26
 * version v0.0.1
 * since v0.0.1
 **/
public class AddString {

    public static void main(String[] args) {

        String str = plusAdd("123456", "11111").toString();
        System.out.println(str);
        String str2 = plusMinus("12341231231", "1234").toString();
        System.out.println(str2);
    }

    //两个非负数相加
    private static StringBuffer plusAdd(String strNum1, String strNum2) {
        //把两个数字字符串倒置，并存入字符数组
        char[] num1 = new StringBuffer(strNum1).reverse().toString().toCharArray();
        char[] num2 = new StringBuffer(strNum2).reverse().toString().toCharArray();
        int maxLength = Math.max(num1.length, num2.length);
        int minLength = Math.min(num1.length, num2.length);
        //n位和m位的非负整数相加的和，要么是max（n，m）位，要么是max（n，m）+1位。
        StringBuffer value = new StringBuffer();

        /*--------------计算和数开始------------------------*/
        int i, jinWei = 0;
        for (i = 0; i < minLength; i++) {      //这里 - '0' 应该就是自动装箱
            int asdf = jinWei + num1[i];
            int asdf1 = num1[i] - '0';
            int temp = jinWei + num1[i] - '0' + num2[i] - '0';
            value.append((char) (temp % 10 + '0'));
            jinWei = temp / 10;
        }
        if (maxLength == num1.length)
            jinWei = oneBitAdd(jinWei, num1, i, maxLength, value);
        else
            jinWei = oneBitAdd(jinWei, num2, i, maxLength, value);
        if (jinWei != 0)
            value.append((char) (jinWei + '0'));
        /*--------------计算和数结束------------------------*/
        return deleteZero(value).reverse();
    }

    /**
     * 功能：较大的非负整数bigNumStr减去较小的非负整数smallNumStr
     */
    private static StringBuffer plusMinus(String bigNumStr, String smallNumStr) {
        //把两个数字字符串倒置，并存入字符数组
        char[] num1 = new StringBuffer(bigNumStr).reverse().toString().toCharArray();
        char[] num2 = new StringBuffer(smallNumStr).reverse().toString().toCharArray();
        StringBuffer value = new StringBuffer();

        /*--------------计算减法开始------------------------*/
        int i, temp, jieWei = 0;
        for (i = 0; i < smallNumStr.length(); i++) {
            temp = num1[i] - jieWei - num2[i];
            jieWei = oneBitMinus(temp, value, i);
        }
        //处理较大数比较小数多出来的位
        for (; i < bigNumStr.length(); i++) {
            temp = num1[i] - '0' - jieWei;
            jieWei = oneBitMinus(temp, value, i);
        }
        /*--------------计算减法结束------------------------*/
        return deleteZero(value).reverse();
    }

    //两个正整数相乘----plusMulti()
    private  StringBuffer plusMulti(StringBuffer str1,StringBuffer str2) {
        //新建两个StringBuffer，存储两数的前后倒置。
        StringBuffer num1 = new StringBuffer(str1.substring(0)).reverse();
        StringBuffer num2 = new StringBuffer(str2.substring(0)).reverse();
        StringBuffer array = new StringBuffer();
        //n位数和m位数相乘，得到的结果的位数只能是n+m或者n+m-1。
        int len = str1.length() + str2.length();
        for(int i = 0;i<len-1;i++){
            array.append('0');
        }
        //标志n+m位
        array.append('+');

        //模拟竖式计算
        for(int i = 0,j,jinWei = 0 ; i < str2.length() ; i++){
            jinWei = 0; //进位归位
            for(j = 0 ; j < str1.length() ; j++){
                int temp = (num2.charAt(i)-'0')*(num1.charAt(j)-'0') + jinWei + array.charAt(i+j) - '0';
                array.setCharAt(i+j,(char)(temp%10 + '0'));
                jinWei = temp /10;
            }
            if(jinWei !=0)
                array.setCharAt(i+j, (char)(jinWei +'0'));
        }
        if(array.charAt(len -1) == '+')
            array.setLength(len-1);
        return  array.reverse();
    }

    /**
    * 两个非负数相除，除数不为0
    * 返回：没有前后倒置的正确的结果
    */
   private StringBuffer plusDivide(String str1,String str2){
       StringBuffer division = new StringBuffer();
       StringBuffer remain   = new StringBuffer();

       int end = 0;
       boolean  flag = false;
       while(end < str1.length()){
           remain.append(str1.charAt(end));
           if(Str1ThanStr2(remain.toString(),str2)){//能整除
               flag = true;
               int fullNum = Greatst(remain,str2);
               StringBuffer fullNumStr2 = plusMulti(new StringBuffer(str2),new StringBuffer(""+fullNum));
               division.append(""+fullNum);
               remain = plusMinus(remain.toString(),fullNumStr2.toString());
           }
           else if(flag)//不够除，补0
               division.append("0");
           if(remain.toString().equals("0"))
               remain.setLength(0);
           end++;
       }
       if(division.length() == 0){
           return division.append('0');
       }
       return division;
   }

    /**
     * 一位减法
     */
    private static int oneBitMinus(int flag, StringBuffer value, int num) {
        int jieWei;
        if (flag < 0) {
            value.append((char) (10 + flag + '0'));
            jieWei = 1;
        } else {
            jieWei = 0;
            value.append((char) (flag + '0'));
        }
        return jieWei;
    }

    /**
     * 进位加上字符数组一部分
     *
     * @return
     */
    private static int oneBitAdd(int jinWei, char[] array, int beginIndex, int endIndex, StringBuffer value) {
        int temp;
        for (int i = beginIndex; i < endIndex; i++) {
            temp = jinWei + array[i] - '0';
            jinWei = temp / 10;
            value.append((char) (temp % 10 + '0'));
        }
        return jinWei;
    }

    /**
     * 删去多余的0
     */
    private static StringBuffer deleteZero(StringBuffer str) {
        int num = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '0')
                num++;
            else
                break;
        }
        if (num != str.length())
            str.setLength(str.length() - num);
        else
            str = new StringBuffer("0");
        return str;
    }

    /**
     * 判断str1、str2的大小
     * 返回：str1>= str2 -----true
     *      str1< str2 -----false
     */
    private static boolean Str1ThanStr2(String str1,String str2){
        boolean flag;//1 代表str1大些；2代表str2大些
        //判断两个非负数，谁大。
        if(str1.length() == str2.length()){
            if(str1.compareTo(str2)<0)
                flag = false;
            else
                flag =true;
        }
        else{
            if(str1.length() >str2.length())
                flag = true;
            else
                flag = false;
        }
        return flag;
    }
    /*
     * 找出最大
     */
    private  int Greatst(StringBuffer str1,String str2){
        for(int i = 1;i<10;i++){
            StringBuffer num2 = new StringBuffer(str2);
            for(int j =0;j<i;j++){//(i +1)倍
                num2 = plusAdd(num2.toString(),str2);
            }
            if(!Str1ThanStr2(str1.toString(),num2.toString())){
                return i;
            }
        }
        return -1;
    }
}

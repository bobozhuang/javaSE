package main.java.com.bobozhuang.exam.chap03;

/**
 * description：     java 进行超大整数的加减乘除四则运算（自己部分实现BigInteger）
 *
 *          Add     加
 *          Minus   减
 *          Multi   乘
 *          Divide  除
 *
 * author Hubery
 * date 2020-11-27
 * version v0.0.1
 * since v0.0.1
 **/
public class MyBigInteger {
    private StringBuffer data;


    public MyBigInteger(){
        data = new StringBuffer("0");
    }
    public MyBigInteger(String str){
        data = new StringBuffer(str);
    }
    public MyBigInteger(StringBuffer str){
        data = new StringBuffer(str);
    }

    public int length(){
        return data.length();
    }
    public String toString(){
        return data.toString();
    }

    public boolean equals(Object obj){
        return data == ((MyBigInteger)obj).data;
    }

    /**
     * 功能：进行两个非负整数的相加
     */
    private  StringBuffer plusAdd(String strNum1,String strNum2){
        //把两个数字字符串倒置，并存入字符数组
        char [] num1 = new StringBuffer(strNum1).reverse().toString().toCharArray();
        char [] num2 = new StringBuffer(strNum2).reverse().toString().toCharArray();
        int maxLength = Math.max(num1.length,num2.length);
        int minLength = Math.min(num1.length,num2.length);
        //n位和m位的非负整数相加的和，要么是max（n，m）位，要么是max（n，m）+1位。
        StringBuffer value = new StringBuffer();

        /*--------------计算和数开始------------------------*/
        int i,jinWei=0;
        for(i=0;i<minLength;i++){
            int temp = jinWei + num1[i] - '0'  +num2[i] - '0';
            value.append((char)(temp%10 + '0'));
            jinWei = temp/10;
        }
        if(maxLength == num1.length)
            jinWei = oneBitAdd(jinWei,num1,i,maxLength,value);
        else
            jinWei = oneBitAdd(jinWei,num2,i,maxLength,value);
        if(jinWei != 0)
            value.append((char)(jinWei +'0'));
        /*--------------计算和数结束------------------------*/
        return deleteZero(value).reverse();
    }
    /**
     * 进位加上字符数组一部分
     * @return
     */
    private int oneBitAdd(int jinWei,char []array,int beginIndex,int endIndex,StringBuffer value){
        int temp;
        for(int i = beginIndex;i<endIndex;i++){
            temp = jinWei + array[i] - '0';
            jinWei = temp/10;
            value.append((char)(temp%10+'0'));
        }
        return jinWei;
    }

    /**
     * 功能：较大的非负整数bigNumStr减去较小的非负整数smallNumStr
     */
    private  StringBuffer plusMinus(String bigNumStr,String smallNumStr){
        //把两个数字字符串倒置，并存入字符数组
        char [] num1 = new StringBuffer(bigNumStr).reverse().toString().toCharArray();
        char [] num2 = new StringBuffer(smallNumStr).reverse().toString().toCharArray();
        StringBuffer value = new StringBuffer();

        /*--------------计算减法开始------------------------*/
        int i,temp,jieWei = 0;
        for(i = 0;i<smallNumStr.length();i++){
            temp = num1[i]  - jieWei - num2[i];
            jieWei = oneBitMinus(temp,value,i);
        }
        //处理较大数比较小数多出来的位
        for(;i<bigNumStr.length();i++){
            temp = num1[i] - '0' - jieWei;
            jieWei = oneBitMinus(temp,value,i);
        }
        /*--------------计算减法结束------------------------*/
        return deleteZero(value).reverse();
    }
    /**
     * 删去多余的0
     */
    private StringBuffer deleteZero(StringBuffer str){
        int num=0;
        for(int i = str.length()-1;i>=0;i--){
            if(str.charAt(i) == '0')
                num++;
            else
                break;
        }
        if(num != str.length())
            str.setLength(str.length()-num);
        else
            str = new StringBuffer("0");
        return str;
    }
    /**
     * 一位减法
     */
    private int oneBitMinus(int flag,StringBuffer value,int num){
        int jieWei;
        if(flag <0){
            value.append((char)(10 +flag + '0'));
            jieWei = 1;
        }
        else{
            jieWei = 0;
            value.append((char)(flag + '0'));
        }
        return jieWei;
    }

    /**
     * 名称：内部调用的减法。
     * 功能：两个非负数相减。
     * 结果：返回运算结果的前后倒置。
     */
    private  StringBuffer innerMinus(String str1,String str2){
        StringBuffer temp;
        if(Str1ThanStr2(str1,str2))//若str1更大
            temp =  plusMinus(str1,str2);
        else{
            temp = plusMinus(str2,str1);
            if(!temp.toString().equals("0"))
                temp.reverse().append('-').reverse();
        }
        return temp;
    }
    /**
     * 判断正负
     * true -- 非负      false -- 负
     */
    public boolean isNoNegative(MyBigInteger t){
        if(t.data.charAt(0) == '-')
            return false;
        return true;
    }

    /**
     * 对外开放的加法接口
     * 计算str1 + str2
     */
    public MyBigInteger Add(MyBigInteger str){
        //两数都非负
        if(isNoNegative(this) && isNoNegative(str))
            data = plusAdd(data.toString(),str.data.toString());
        else if(!isNoNegative(this) && !isNoNegative(str)){
            StringBuffer temp = plusAdd(data.substring(1),str.data.substring(1));
            if(!temp.toString().equals("0"))
                data =  temp.reverse().append('-').reverse();
            else
                data = temp;
        }
        else if(!isNoNegative(this) && isNoNegative(str))
            data = innerMinus(str.data.toString(),data.substring(1));
        else
            data = innerMinus(data.toString(),str.data.substring(1));
        return this;
    }
    /**
     * 对外开放的减法。
     * 计算str1 - str2
     */
    public MyBigInteger Minus(MyBigInteger t){
        //两数都为正。
        if(isNoNegative(this) && isNoNegative(t))
            data = innerMinus(this.data.toString(),t.data.toString());
            //两数都为负时，需要对innerMinus得到的结果逆转正负。
        else if(!isNoNegative(this) && !isNoNegative(t))
            data = innerMinus(t.data.substring(1),data.substring(1));
            //this 为负，t为非负。
        else if(!isNoNegative(this) && isNoNegative(t)){
            StringBuffer temp = plusAdd(data.substring(1),t.data.toString());
            if(!temp.toString().equals("0"))
                data = temp.reverse().append('-').reverse();
            else
                data = temp;
        }
        //this 为非负，str为负。
        else
            data = plusAdd(data.toString(),t.data.substring(1).toString());
        return this;
    }

    /**
     * 内部使用的两个正整数乘法
     */
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
     * 对外开放的乘法
     */
    public MyBigInteger Multi(MyBigInteger t){
        //两数至少有一个为0
        if(data.toString().equals("0") || t.data.toString().equals("0"))
            data = new StringBuffer("0");
        else{
            //两数都是正数
            if(isNoNegative(this) && isNoNegative(t))
                data = plusMulti(data,t.data).reverse();
                //两数都是负数
            else if(!isNoNegative(this) && !isNoNegative(t))
                data = plusMulti(new StringBuffer(data.substring(1)),new StringBuffer(t.data.substring(1)));

                //两数一正一负
            else if(isNoNegative(this) && !isNoNegative(t))
                data =     plusMulti(data,new StringBuffer(t.data.substring(1))).reverse().append('-').reverse();
            else
                data = plusMulti(new StringBuffer(data.substring(1)),t.data).reverse().append('-').reverse();
        }
        return this;
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
     * 对外开放的减法
     */
    public MyBigInteger Divide(MyBigInteger t){
        if(t.data.toString().equals("0"))
            System.out.println("除零异常");
        else{
            if(isNoNegative(this) && isNoNegative(t))
                data = plusDivide(data.toString(),t.data.toString());
            else if(!isNoNegative(this) && !isNoNegative(t)){
                data = plusDivide(data.substring(1),t.data.substring(1));
            }
            else{
                StringBuffer temp;
                if(!isNoNegative(this) && isNoNegative(t))
                    temp = plusDivide(data.substring(1),t.data.toString());
                else
                    temp = plusDivide(data.toString(),t.data.substring(1));
                if(temp.toString().equals("0"))
                    data = temp;
                else
                    data = temp.reverse().append('-').reverse();
            }
        }
        return this;
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


    public static void main(String[] args) {
        MyBigInteger a1 = new MyBigInteger("175");
        MyBigInteger a2 = new MyBigInteger("231");
        MyBigInteger a3 = new MyBigInteger("143");
        MyBigInteger a4 = new MyBigInteger("-1978654");
        MyBigInteger b = new MyBigInteger("-54");
        MyBigInteger b1 = new MyBigInteger("0");
        //175 + 231 - 143
        System.out.println(a1.Add(a2).Minus(a3));
        //(175 + 231 - 143)*(-1978654)
        System.out.println(a1.Multi(a4));
        //(175 + 231 - 143)*(-1978654)/(-54)
        System.out.println(a1.Divide(b));
        //0
        System.out.println(a1.Multi(b1));
    }
}
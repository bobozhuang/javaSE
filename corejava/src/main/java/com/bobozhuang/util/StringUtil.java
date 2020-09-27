package main.java.com.bobozhuang.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class StringUtil {

	/**
	 * 判断对象是否为空
	 * @param obj
	 * @return
	 */
	public static boolean isObjectEmpty(Object obj) {
		return null == obj
				|| ((obj instanceof String) && isStringEmpty((String) obj));
	}

	/**
	 * 如果字符串的长度为0也认为空
	 * @param str
	 * @return
	 */
	public static boolean isStringEmpty(String str) {
		return null == str || str.trim().length() == 0;
	}


	/**
	 * 字符串拼接
	 * @param value1
	 * @param value2
	 * @return
	 */
	public static String contactString(Object value1, Object value2) {
		StringBuffer buffer = new StringBuffer();

		if (!isObjectEmpty(value1))
			buffer.append(value1);
		if (!isObjectEmpty(value2))
			buffer.append(value2);

		return buffer.toString();
	}

	/**
	 * 对象转字符串
	 * @param object
	 * @return
	 */
	public static String parseObjectToString(Object object) {
		if (object == null) {
			return null;
		}
		if (object instanceof String) {
			return (String) object;
		} else {
			return object.toString();
		}
	}

	/**
	 * 通过多个参数的方式构建字符串
	 * @param args
	 * @return
	 */
	public static String buildString(Object... args) {
		if (args == null)
			return null;

		StringBuffer buffer = new StringBuffer();

		for (Object object : args) {
			if (object != null) {
				buffer.append(object);
			}
		}

		return buffer.toString();
	}

	/**
	 * 对象转BigDecimal
	 * @param value
	 * @return
	 */
	public static BigDecimal parseBigDecimal(Object value) {

		if (value instanceof BigDecimal) {
			try {
				return (BigDecimal) value;
			} catch (Exception e) {
				return null;
			}
		} else {
			try {
				return new BigDecimal(value.toString());
			} catch (Exception e) {
				return null;
			}
		}

	}

	/**
	 * 对象转 Integer
	 * @param value
	 * @return
	 */
	public static Integer parseInteger(Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof Integer) {
			try {
				return (Integer) value;
			} catch (Exception e) {
				return null;
			}
		} else {
			try {
				return new Integer(value.toString());
			} catch (Exception e) {
				return null;
			}
		}

	}

	/**
	 * 对象转 Long
	 * @param value
	 * @return
	 */
	public static Long parseLong(Object value) {
		if (value == null) {
			return null;
		}
		if (value instanceof Long) {
			try {
				return (Long) value;
			} catch (Exception e) {
				return null;
			}
		} else {
			try {
				return new Long(value.toString());
			} catch (Exception e) {
				return null;
			}
		}

	}

	/**
	 * 多个字符串替换，通过截取的方式，通过找到下标，将下标之前和下标+长度之后的截取，再进行拼接
	 * @param str
	 * @param replaced
	 * @param replaceWith
	 * @return
	 */
	public static String replace(String str, String replaced, String replaceWith) {
		if (str == null) {
			return null;
		}
		if (replaced == null || replaceWith == null) {
			return str;
		}
		StringBuffer buf = new StringBuffer();

		int pos = str.indexOf(replaced);
		if (pos > -1) {
			String left = str.substring(0, pos);
			String right = str.substring(pos + replaced.length());
			buf.append(left);
			buf.append(replaceWith);
			buf.append(replace(right, replaced, replaceWith));
		} else {
			buf.append(str);
		}

		return buf.toString();
	}

	/**
	 * 字符串转 boolean
	 * @param str
	 * @return
	 */
	public final static boolean toBoolean(String str) {
		return toBoolean(str, false);
	}

	public final static boolean toBoolean(String str, boolean defaultValue) {
		if (isStringEmpty(str)) {
			return defaultValue;
		} else
			return new Boolean(str.trim()).booleanValue();

	}

	public static final int toInt(String str) {
		return toInt(str, 0);
	}

	public static final int toInt(String str, int defaultValue) {
		if (isStringEmpty(str)) {
			return defaultValue;
		}
		try {
			return Integer.parseInt(str.trim());
		} catch (Throwable t) {
			return defaultValue;
		}
	}

	/**
	 * 将字符串填充到len长,不足len长前面加0,超过截断
	 * 
	 * @param object
	 * @param len
	 *            是指字节长度
	 * @return
	 */
	public static String formatLeftStr(Object object, int len) {
		String str = (object == null) ? "" : object.toString().trim();
		while (str.getBytes().length > len) {
			str = str.substring(0, str.length() - 1);
		}

		int strLen = str.getBytes().length;

		str = repeat("0", len - strLen) + str;
		return str;
	}

	/**
	 * 将字符串填充到len长,不足len长前面加指定,超过则从右侧开始 截断
	 * 
	 * @param str
	 * @param len
	 *            是指字节长度
	 * @param padChar
	 *            填充字符 为空时不填充
	 * @return
	 */
	public static String formatRightStr(Object object, int len, String padChar) {
		String str = (object == null) ? "" : object.toString().trim();
		if (str.getBytes().length > len) {
			str = str.substring(str.length() - len, str.length());
		}
		int strLen = str.getBytes().length;
		if (padChar != null) {
			str = repeat(padChar, len - strLen) + str;
		}
		return str;
	}

	public static String repeat(String str, int num) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < num; i++) {
			buf.append(str);
		}
		return buf.toString();
	}

	/**
	 *
	 * @param bigd
	 * @return
	 */
	public static String BigDel2Str(BigDecimal bigd) {
		return bigd.toPlainString().indexOf('.') != -1 ? bigd.toPlainString()
				.substring(0, bigd.toPlainString().indexOf('.')) : bigd
				.toPlainString().substring(0, bigd.toPlainString().length());
	}

	public static void main(String[] args) {
		BigDecimal b = new BigDecimal(100.01);
		String s = BigDel2Str(b);
		System.out.println(s);
	}
	
	public static String byteToString(byte[] in) throws Exception {
		InputStream is=null;
		try {
			is = byteToInputStream(in);  
        return InputStreamTOString(is);  
		} finally {
			try {
				if(is!=null){
					is.close();
				}
			} catch (IOException ex) {
				throw new Exception("transaction error",ex);
			}
		}
    } 
	
	public static InputStream byteToInputStream(byte[] in) throws Exception {
        ByteArrayInputStream is = new ByteArrayInputStream(in);
        return is;  
    } 
	
	public static String InputStreamTOString(InputStream in) throws Exception {

        ByteArrayOutputStream outStream = null;
		try {
			outStream = new ByteArrayOutputStream();
	        byte[] data = new byte[4096];  
	        int count = -1;  
	        while((count = in.read(data,0,4096)) != -1)  
	            outStream.write(data, 0, count);  
	        return new String(outStream.toByteArray(),"ISO-8859-1");
		} finally {
			try {
				if(outStream!=null){
					outStream.close();
				}
			} catch (IOException ex) {
				throw new Exception("transaction error",ex);
			}
		}
    }
	
	public static String toStringAndTrim(Object object) {
		if (object == null) {
			return "";
		} else {
			return object.toString().trim();
		}
	}
	
	/**
	 * 把二进制的串转化为十六进制的字符串
	 * Creation date: (00-6-9 17:06:35)
	 * @return java.lang.String
	 * @param inbuf byte[]
	 */
	public static String byteToHex(byte[] inbuf) {

		int i;
		String byteStr;
		StringBuffer strBuf = new StringBuffer();

		for (i = 0; i < inbuf.length; i++) {

			byteStr = Integer.toHexString(inbuf[i] & 0x00ff);
			if (byteStr.length() != 2) {
				strBuf.append('0').append(byteStr);
			} else {
				strBuf.append(byteStr);
			}

		}

		return new String(strBuf);
	}

	public static String substring(String str, int length) {
		if(str == null) {
			return null;
		}
		if(str.length() >= length) {
			return str.substring(0, length);
		}else {
			return str;
		}
	}

    public static boolean isNullOrEmpty(Object obj) {
        if (obj instanceof Object[]) {
            Object[] o = (Object[])((Object[])obj);
            return o == null || o.length == 0;
        } else if (obj instanceof String) {
            return obj == null || "".equals(((String)obj).trim());
        } else if (obj instanceof List) {
            List objList = (List)obj;
            return objList == null || objList.isEmpty();
        } else if (obj instanceof Map) {
            Map objMap = (Map)obj;
            return objMap == null || objMap.isEmpty();
        } else {
            return obj == null || "".equals(obj);
        }
    }
}

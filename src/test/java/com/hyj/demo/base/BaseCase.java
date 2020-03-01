package com.hyj.demo.base;

import com.hyj.demo.model.po.Aoo;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.*;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class BaseCase {
	@Test
	public void testSum() {
		new Aoo2().test();
	}
	@Data
	class Aoo2{
		private int ws;
		public void test(){
			System.out.println(this);
		}
	}

	@Test
	public void testInt() {
		Integer a = -128;
		Integer b = -128;
		Integer c = 128;
		Integer d = 128;
		System.out.println(a == b);
		System.out.println(c == d);
	}

	@Test
	public void testEq() {
		Aoo aoo1 = new Aoo();
		aoo1.setName("a1");
		aoo1.setId(1L);
		aoo1.setName("ss");
		Aoo aoo2 = new Aoo();
		aoo2.setId(2L);
		aoo2.setName("a2");

		System.out.println(aoo1.equals(aoo2));

//        HashMap hashMap=new HashMap();
//        hashMap.put(aoo1,aoo1);

	}

	/**
	 * +=操作符会进行隐式自动类型转换,此处a+=b隐式的将加操作的结果类型强制转换为持有结果的类型,而a=a+b则不会自动进行类型转换
	 */
	@Test
	public void testByte() {
		byte a = 127;
		byte b = 127;
//        b = a + b; // error : cannot convert from int to byte
		b += a; // ok

		short s1 = 1;

	}

	@Test
	public void testReturn0() {
		System.out.println(testReturn());
	}

	public int testReturn() {
		int res = 2;
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			return res;
		} finally {
			res++;
		}
	}

	/**
	 * 强引用 软引用 弱引用 虚引用
	 */
	@Test
	public void testReference() {
		WeakReference<String> sr = new WeakReference<String>(new String("hello"));

		System.out.println(sr.get());
		System.gc();                //通知JVM的gc进行垃圾回收
		System.out.println(sr.get());
	}

	/**
	 * Math.round表示四舍五入，四舍五入的原理是在参数上加0.5然后做向下取整
	 */
	@Test
	public void MathRound() {
		System.out.println(Math.round(-1.5));

	}

	@Test
	public void sort1() {
		int[] numbers = new int[]{1, 5, 8, 2, 3, 9, 4};
		bubbleSort(numbers, numbers.length);
		for (int number : numbers) {
			System.out.println(number);
		}
	}

	/**
	 * 冒泡排序
	 *
	 * @param a
	 * @param n
	 */
	public void bubbleSort(int a[], int n) {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					int tmp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = tmp;
				}
			}
		}
	}

	@Test
	public void testMath() {
		System.out.println(Math.round(-1.51));
		System.out.println(Math.floor(-1.51 + 0.5));
	}

	@Test
	public void testStr() {
		String a1 = "1";
		String a2 = new String("1");
		String a3 = new String("1");
		System.out.println(a1 == a2);
		System.out.println(a2 == a3);
		StringBuilder stringBuilder = new StringBuilder("ss");

	}

	/**
	 * 编译期无法确定
	 * 这里面虽然将s1用final修饰了，但是由于其赋值是通过方法调用返回的，那么它的值只能在运行期间确定
	 * 因此s0和s2指向的不是同一个对象，故上面程序的结果为false。
	 */
	@Test
	public void testStr2() {
		String s0 = "ab";
		final String s1 = getS1();
		String s2 = "a" + s1;
		System.out.println((s0 == s2)); //result = false
	}

	public String getS1() {
		return "b";
	}

	@Test
	public void testStr3() {
		String s0 = "ab";
		String s1 = new String("ab").intern();
		System.out.println(s0 == s1);
	}

	@Test
	public void testStr4() {
		String str = "sswwww     fff";
		str = str.replace("$$companyId$$", "");
		str = str.replaceAll("\\s*", "");
		System.out.println(str);
	}

	@Test
	public void testDate() {
		String start_date = null;
		String end_date = null;
		Date curr_date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		end_date = simpleDateFormat.format(curr_date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(curr_date);
		calendar.add(Calendar.DATE, -1);
		curr_date = calendar.getTime();
		start_date = simpleDateFormat.format(curr_date);

		System.out.println(start_date);
		System.out.println(end_date);
	}

	@Test
	public void testStrUrl() {
		String s = null;
		String url_prd = "http://10.0.14.128:9001";
		String url_pre = "http://10.0.14.119:8080";
		String url_test = "http://10.0.14.119:8080/WP_LZLJ_SOA/APP_BIGDATA_SERVICES/Proxy_Services/LZLJ_392_BI_MonthlyQuotaChange_PS";
		if (url_test.startsWith(url_pre)) {
			s = url_test.replace(url_pre, url_prd);
		}
		System.out.println(s);
	}

	@Test
	public void testStringBuilder() {
		StringBuilder stringBuilder = new StringBuilder();
	}


	@Test
	public void testTrim() {
		String lrbReq = "H:\\work\\tmp\\sap\\请求和相应参数\\esb-563-req.txt";
		String str = getReq(lrbReq);
		System.out.println(str);
		System.out.println(trimXml(str));
	}

	public static String trimXml(String xml) {
		Pattern p = Pattern.compile(">(\\s*|\n|\t|\r)<");
		Matcher m = p.matcher(xml);
		return m.replaceAll("><");
	}


	private static String getReq(String fileName) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileName));
			String str = null;
			StringBuilder stringBuilder = new StringBuilder();
			while ((str = bufferedReader.readLine()) != null) {
				stringBuilder.append(str);
			}
			return stringBuilder.toString();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}


	@Test
	public void testFileWriter() throws IOException {
		//创建输出流对象
		File f = new File("H:\\work\\tmp\\test\\a.txt");
		if (!f.exists()) {
			new File(f.getParent()).mkdirs();
//            f.createNewFile();
		}
		FileWriter fw = new FileWriter("H:\\work\\tmp\\test\\a.txt");
		//写一个字符串数据
		fw.write("IO流很舒服");
		//因为数据没有直接写入文件，而是写到了内存缓冲区，所以需要用flush()方法进行刷新缓冲区，使数据进入文件中
		fw.flush();
		//释放资源
		fw.close();

	}

	@Test
	public void testCacl() {
		int a = 38860;
		System.out.println(a / 290);
	}

	@Test
	public void testLoop() {
		int i = 0;
		outer:
		while (true) { // outer:定义了一个label标记
			i++;
			inner:
			for (int j = 0; j < 10; j++) {// inner:定义了一个label标记
				i += j;
				if (j == 3)
					continue inner; // j==3时，跳转到inner标记点
				break outer; // 结束循环，跳到outer标记点，不再继续for循环
			}
			continue outer; // 继续循环，跳到outer标记点，继续while循环
		}
	}


	@Test
	public void testSortInt() {
		int[] arr = {0, 3, 2, 4, 1};
		Arrays.sort(arr);

		for (int i : arr) {
			System.out.println(i);
		}
	}

	@Test
	public void testInt2() {
		Integer a = -129;
		Integer b = -129;
		Integer c = -129;
		System.out.println(a == b);
		System.out.println(b == c);
		int a2 = -129;
		int b2 = -129;
		System.out.println(a2 == b2);
	}

	@Test
	public void testStr5() {
//        String s1 = "china";
//        String s2 = "china";

		String ss1 = new String("china");
		String s3 = "china";
		String ss2 = new String("china");
		String ss3 = new String("china");
//        System.out.println(s1==s2);
		System.out.println(ss1 == s3);
	}

	static String base = "string";

	public static void main(String[] args) throws Throwable {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            list.add(str.intern());
            System.out.println(str);
        }
//		for (Integer i = 0; i < Integer.MAX_VALUE; i++) {
//			System.out.println(i);
//		}
	}
}

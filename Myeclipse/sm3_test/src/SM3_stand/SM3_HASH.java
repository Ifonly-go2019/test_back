package SM3_stand;


public class SM3_HASH {
	public static int[] abcdefgh = { 0x7380166f, 0x4914b2b9, 0x172442d7,
			0xda8a0600, 0xa96f30bc, 0x163138aa, 0xe38dee4d, 0xb0fb0e4e };

	public static int H1, H2, H3, H4, H5, H6, H7, H8;

	// 摘要数据存储数组
	public static int[] digestInt = new int[8];

	// 计算过程中的临时数据存储数组

	public static int[] X = new int[68];

	public static int[] Y = new int[64];

	public static final int T1 = 0x79cc4519; // 0 to 15

	public static final int T2 = 0x7a879d8a; // 16 to 63

	// 计算摘要
	public static int process_input_bytes(byte[] bytedata) {
		// 初试化常量
		System.arraycopy(abcdefgh, 0, digestInt, 0, abcdefgh.length);
		// 格式化输入字节数组，补10及长度数据
		byte[] newbyte = byteArrayFormatData(bytedata);
		// 获取数据摘要计算的数据单元个数
		int MCount = newbyte.length / 64;
		// 循环对每个数据单元进行摘要计算
		// 初始化
		for (int i = 0; i < 68; i++) {
			X[i] = 0;
		}

		H1 = 0x7380166f;
		H2 = 0x4914b2b9;
		H3 = 0x172442d7;
		H4 = 0xda8a0600;
		H5 = 0xa96f30bc;
		H6 = 0x163138aa;
		H7 = 0xe38dee4d;
		H8 = 0xb0fb0e4e;
		for (int i = 0; i < 64; i++) {
			Y[i] = 0;
		}

		for (int pos = 0; pos < MCount; pos++) {
			// 将每个单元的数据转换成16个整型数据，并保存到tmpData的前16个数组元素中
			for (int j = 0; j < 16; j++) {
				X[j] = byteArrayToInt(newbyte, (pos * 64) + (j * 4));
			}
			// 摘要计算函数
			processBlock();
		}
		return 20;
	}

	// 格式化输入字节数组格式
	public static byte[] byteArrayFormatData(byte[] bytedata) {
		// 补0数量
		int zeros = 0;
		// 补位后总位数
		int size = 0;
		// 原始数据长度
		int n = bytedata.length;
		// 模64后的剩余位数
		int m = n % 64;
		// 计算添加0的个数以及添加10后的总长度
		if (m < 56) {
			zeros = 55 - m;
			size = n - m + 64;
		} else if (m == 56) {
			zeros = 63;
			size = n + 8 + 64;
		} else {
			zeros = 63 - m + 56;
			size = (n + 64) - m + 64;
		}
		// 补位后生成的新数组内容
		byte[] newbyte = new byte[size];
		// 复制数组的前面部分
		System.arraycopy(bytedata, 0, newbyte, 0, n);
		// 获得数组Append数据元素的位置
		int l = n;
		// 补1操作
		newbyte[l++] = (byte) 0x80;
		// 补0操作
		for (int i = 0; i < zeros; i++) {
			newbyte[l++] = (byte) 0x00;
		}
		// 计算数据长度，补数据长度位共8字节，长整型
		long N = (long) n * 8;
		byte h8 = (byte) (N & 0xFF);
		byte h7 = (byte) ((N >> 8) & 0xFF);
		byte h6 = (byte) ((N >> 16) & 0xFF);
		byte h5 = (byte) ((N >> 24) & 0xFF);
		byte h4 = (byte) ((N >> 32) & 0xFF);
		byte h3 = (byte) ((N >> 40) & 0xFF);
		byte h2 = (byte) ((N >> 48) & 0xFF);
		byte h1 = (byte) (N >> 56);
		newbyte[l++] = h1;
		newbyte[l++] = h2;
		newbyte[l++] = h3;
		newbyte[l++] = h4;
		newbyte[l++] = h5;
		newbyte[l++] = h6;
		newbyte[l++] = h7;
		newbyte[l++] = h8;
		return newbyte;
	}

	public static int FF1(int x, int y, int z) {
		return (x ^ y ^ z);
	}

	public static int FF2(int x, int y, int z) {
		return (x & y) | (x & z) | (y & z);
	}

	public static int GG1(int x, int y, int z) {
		return (x ^ y ^ z);
	}

	public static int GG2(int x, int y, int z) {
		return ((x & y) | ((~x) & z));
	}

	/*
	 * 
	 * 置换函数P1，P2
	 */
	public static int P0(int x) {
		return (((x << 9) | (x >>> 23)) ^ ((x << 17) | (x >>> 15)) ^ x);
	}

	public static int P1(int x) {
		return (((x << 15) | (x >>> 17)) ^ ((x << 23) | (x >>> 9)) ^ x);
	}

	// 单元摘要计算函数
	public static void processBlock() {

		byte[] temptest = new byte[272];
		for (int t = 16; t <= 67; t++) {
			X[t] = P1((X[t - 16]) ^ X[t - 9]
					^ ((X[t - 3] << 15) | (X[t - 3] >>> 17)))
					^ ((X[t - 13] << 7) | (X[t - 13] >>> 25)) ^ X[t - 6];

		}
		for (int i = 0; i < X.length; i++) {
			intToByteArray(X[i], temptest, i * 4);
		}
		// String temstr=byteArrayToHexString(temptest);

		byte[] temptest1 = new byte[256];
		for (int t = 0; t <= 63; t++) {
			Y[t] = X[t] ^ X[t + 4];
		}
		for (int i = 0; i < Y.length; i++) {
			intToByteArray(Y[i], temptest1, i * 4);
		}

		// String temstr1=byteArrayToHexString(temptest1);

		int a = H1;
		int b = H2;
		int c = H3;
		int d = H4;
		int e = H5;
		int f = H6;
		int g = H7;
		int h = H8;

		// int t = 0;
		// int tempint[]=new int[8];
		for (int i = 0; i < 16; i++) {
			// System.out.println("第"+i+" 轮:\n");

			int ss1 = 0, ss2 = 0, tt1 = 0, tt2 = 0;
			ss1 = ((a << 12) | (a >>> 20)) + e
					+ ((T1 << i) | (T1 >>> (32 - i)));
			ss1 = (ss1 << 7) | (ss1 >>> 25);
			ss2 = ss1 ^ ((a << 12) | (a >>> 20));
			tt1 = FF1(a, b, c) + d + ss2 + Y[i];
			tt2 = GG1(e, f, g) + h + ss1 + X[i];
			d = c;
			c = (b << 9) | (b >>> 23);
			b = a;
			a = tt1;
			h = g;
			g = (f << 19) | (f >>> 13);
			f = e;
			e = P0(tt2);

			/*
			 * tempint[0]=a; tempint[1]=b; tempint[2]=c; tempint[3]=d;
			 * tempint[4]=e; tempint[5]=f; tempint[6]=g; tempint[7]=h; byte[]
			 * temptest2 = new byte[32]; for (int j = 0; j < tempint.length;
			 * j++) { intToByteArray(tempint[j], temptest2, j * 4); } String
			 * temstr2=byteArrayToHexString(temptest2);
			 * System.out.println(temstr2);
			 */

		}
		for (int i = 16; i < 64; i++) {
			// System.out.println("第"+i+" 轮:\n");
			int ss1 = 0, ss2 = 0, tt1 = 0, tt2 = 0;
			ss1 = ((a << 12) | (a >>> 20)) + e
					+ ((T2 << i) | (T2 >>> (32 - i)));
			ss1 = (ss1 << 7) | (ss1 >>> 25);
			ss2 = ss1 ^ ((a << 12) | (a >>> 20));
			tt1 = FF2(a, b, c) + d + ss2 + Y[i];
			tt2 = GG2(e, f, g) + h + ss1 + X[i];
			d = c;
			c = (b << 9) | (b >>> 23);
			b = a;
			a = tt1;
			h = g;
			g = (f << 19) | (f >>> 13);
			f = e;
			e = P0(tt2);

			/*
			 * tempint[0]=a; tempint[1]=b; tempint[2]=c; tempint[3]=d;
			 * tempint[4]=e; tempint[5]=f; tempint[6]=g; tempint[7]=h;
			 * 
			 * byte[] temptest2 = new byte[32]; for (int j = 0; j <
			 * tempint.length; j++) { intToByteArray(tempint[j], temptest2, j *
			 * 4); } String temstr2=byteArrayToHexString(temptest2);
			 * System.out.println(temstr2);
			 */
		}
		H1 ^= a;
		digestInt[0] = H1;
		H2 ^= b;
		digestInt[1] = H2;
		H3 ^= c;
		digestInt[2] = H3;
		H4 ^= d;
		digestInt[3] = H4;
		H5 ^= e;
		digestInt[4] = H5;
		H6 ^= f;
		digestInt[5] = H6;
		H7 ^= g;
		digestInt[6] = H7;
		H8 ^= h;
		digestInt[7] = H8;

		//
		// reset the offset and clean out the word buffer.
		//

		for (int i = 0; i < 16; i++) {
			X[i] = 0;
		}
	}

	// 4字节数组转换为整数
	public static int byteArrayToInt(byte[] bytedata, int i) {
		/*
		 * return ((bytedata[i] & 0xff) << 24) | ((bytedata[i + 1] & 0xff) <<
		 * 16) | ((bytedata[i + 2] & 0xff) << 8) | (bytedata[i + 3] & 0xff);
		 */
		int num = 0;
		int temp;
		temp = (0x000000ff & (bytedata[i + 3])) << 0;
		num = num | temp;
		temp = (0x000000ff & (bytedata[i + 2])) << 8;
		num = num | temp;
		temp = (0x000000ff & (bytedata[i + 1])) << 16;
		num = num | temp;
		temp = (0x000000ff & (bytedata[i])) << 24;
		num = num | temp;

		return num;

	}

	// 整数转换为4字节数组
	public static void intToByteArray(int intValue, byte[] byteData, int i) {
		byteData[i] = (byte) (intValue >>> 24);
		byteData[i + 1] = (byte) (intValue >>> 16);
		byteData[i + 2] = (byte) (intValue >>> 8);
		byteData[i + 3] = (byte) intValue;
	}

	// 将字节转换为十六进制字符串
	public static String byteToHexString(byte ib) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] ob = new char[2];
		ob[0] = Digit[(ib >>> 4) & 0X0F];
		ob[1] = Digit[ib & 0X0F];
		String s = new String(ob);
		return s;
	}

	// 将字节数组转换为十六进制字符串
	public static String byteArrayToHexString(byte[] bytearray) {
		String strDigest = "";
		for (int i = 0; i < bytearray.length; i++) {
			strDigest += byteToHexString(bytearray[i]);
		}
		return strDigest;
	}

	// 计算摘要，返回相应的字节数组
	public static byte[] getDigestOfBytes(byte[] byteData) {
		process_input_bytes(byteData);
		byte[] digest = new byte[32];
		for (int i = 0; i < digestInt.length; i++) {
			intToByteArray(digestInt[i], digest, i * 4);
		}
		return digest;
	}

	// 把真正的BYTE数组转化为字节的ASCII表示的字符串，如"E435C14F"
	public static String byteToString(byte In[]) {
		char[] r1 = new char[In.length * 2 + 1];
		for (int n = 0; n < In.length; n++) {
			int tmp1 = (int) ((((int) In[n] + 256) % 256) >> 4);
			int tmp2 = (int) ((((int) In[n] + 256) % 256) & 0x0f);

			if (tmp1 >= 0xa)
				r1[n * 2] = (char) (tmp1 - 0xa + 'A');
			else
				r1[n * 2] = (char) (tmp1 + '0');

			if (tmp2 >= 0xa)
				r1[n * 2 + 1] = (char) (tmp2 - 0xa + 'A');
			else
				r1[n * 2 + 1] = (char) (tmp2 + '0');

		}
		String s = new String(r1);
		return s;
	}

	// 把字节的ASCII表示的字符串，如"E435C14F" ，转化为真正的BYTE数组
	public static byte[] StringToByte(String in) {
		byte[] r1 = new byte[in.length() / 2];

		for (int n = 0; n < in.length() / 2; n++) {
			char a = in.charAt(2 * n);
			char b = in.charAt(2 * n + 1);

			if (a >= 'A') {
				a = (char) (a - 'A' + 10);
			} else
				a = (char) (a - '0');
			if (b >= 'A') {
				b = (char) (b - 'A' + 10);
			} else
				b = (char) (b - '0');

			r1[n] = (byte) ((a << 4) + b);
		}
		return r1;
	}

	// 计算sha-1摘要，返回相应的十六进制字符串
	public static String getDigestOfString(byte[] byteData) {
		return byteArrayToHexString(getDigestOfBytes(byteData));
	}

	public static void main(String[] args) {
		String sig = "abc";
		byte[] data = sig.getBytes();
		int A = 0x7380166f;
		int M = 0x4914b2b9;
		
		int C1 = SM3_HASH.P0(A);
		int C2 = SM3_HASH.P0(M);
		int C3 = SM3_HASH.P0((A^M));
		int C4 = C1 ^ C2;
		System.out.println(C1+":"+C2+":"+C3+":"+C4);
		
		String digest = new SM3_HASH().getDigestOfString(data);
		System.out.println(digest);
	}
	/*
	 * public static void main(String[] args) { //String data =
	 * "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd";
	 * byte[] data={(byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte)
	 * 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte)
	 * 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte)
	 * 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte)
	 * 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte)
	 * 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte)
	 * 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte)
	 * 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte)
	 * 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte)
	 * 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte)
	 * 0x63,(byte) 0x64, (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64 }; /*
	 * byte[] data={(byte) 0xF4,(byte) 0xA3,(byte) 0x84,(byte) 0x89, (byte)
	 * 0xE3,(byte) 0x2B,(byte) 0x45,(byte) 0xB6, (byte) 0xF8,(byte) 0x76,(byte)
	 * 0xE3,(byte) 0xAC, (byte) 0x21,(byte) 0x68,(byte) 0xCA,(byte) 0x39, (byte)
	 * 0x23,(byte) 0x62,(byte) 0xDC,(byte) 0x8F, (byte) 0x23,(byte) 0x45,(byte)
	 * 0x9C,(byte) 0x1D, (byte) 0x11,(byte) 0x46,(byte) 0xFC,(byte) 0x3D, (byte)
	 * 0xBF,(byte) 0xB7,(byte) 0xBC,(byte) 0x9A, (byte) 0x6D,(byte) 0x65,(byte)
	 * 0x73,(byte) 0x73, (byte) 0x61,(byte) 0x67,(byte) 0x65,(byte) 0x20, (byte)
	 * 0x64,(byte) 0x69,(byte) 0x67,(byte) 0x65, (byte) 0x73,(byte) 0x74};
	 */
	// byte[]
	// data=Hex.decode("F4A38489E32B45B6F876E3AC2168CA392362DC8F23459C1D1146FC3DBFB7BC9A6D65737361676520646967657374");
	// String sig="ALICE123@YAHOO.COM";
	// byte[] data=sig.getBytes();
	/*
	 * byte[] data=Hex.decode("0090414C494345313233405941484F4F2E434F4D"
	 * +"787968B4FA32C3FD2417842E73BBFEFF2F3C848B6831D7E0EC65228B3937E498"
	 * +"63E4C6D3B23B0C849CF84241484BFE48F61D59A5B16BA06E6E12D1DA27C5249A"
	 * +"421DEBD61B62EAB6746434EBC3CC315E32220B3BADD50BDC4C4E6C147FEDD43D"
	 * +"0680512BCBB42C07D47349D2153B70C4E5D7FDFCBFA36EA1A85841B9E46E09A2"
	 * +"0AE4C7798AA0F119471BEE11825BE46202BB79E2A5844495E97C04FF4DF2548A"
	 * +"7C0240F88F1CD4E16352A73C17B7F16F07353E53A176D684A9FE0C6BB798E857");
	 * 
	 * System.out.println(data);
	 * 
	 * System.out.println(data.length);
	 */

	/*
	 * String digest = new SM3_HASH().getDigestOfString(data);
	 * 
	 * System.out.println(digest); }
	 */

}
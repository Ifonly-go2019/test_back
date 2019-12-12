package sm3;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.math.BigInteger;
import java.util.Vector;
import javax.swing.border.TitledBorder;
import javax.swing.event.EventListenerList;
import class_type.*;


public class SM3_Attack extends DifferentialAnalysis {
	
	public static int[] abcdefgh = { 0x7380166f, 0x4914b2b9, 0x172442d7,
		0xda8a0600, 0xa96f30bc, 0x163138aa, 0xe38dee4d, 0xb0fb0e4e };
	
	public  static  int NO_TRACE= -1;
	public static sm3_type t= new sm3_type();
	
	public SM3_Attack(sm3_type tt){
		 t=tt;
	}	
	
	public static final String SM3ROUND = "sm3round";
	public static final String SM3STEP = "sm3step";
	public static final String SM3X1 = "sm3x1";
	public static final String SM3Y1 = "sm3y1";
	public static final String SM3X2 = "sm3x2";
	public static final String SM3D2 = "sm3d2";
	public static final String SM3Y2 = "sm3y2";
	public static final String SM3H2 = "sm3h2";
	public static final String SM3C3 = "sm3c3";
	public static final String SM3D3 = "sm3d3";
	public static final String SM3G3 = "sm3g3";
	public static final String SM3H3 = "sm3h3";

	public static String sm3x1 = "";
	public static String sm3y1 = "";
	public static String sm3x2 = "";
	public static String sm3d2 = "";
	public static String sm3y2 = "";
	public static String sm3h2 = "";
	public static String sm3c3 = "";
	public static String sm3d3 = "";
	public static String sm3g3 = "";
	public static String sm3h3 = "";
    public static int[] X = new int[68];
    public static int H1, H2, H3, H4, H5, H6, H7, H8;
    public static int[] Y = new int[64];    
    public static final int T1 = 0x79cc4519; // 0 to 15
    public static final int T2 = 0x7a879d8a; // 16 to 63
  
    public int round, step;
    
    
    // 摘要数据存储数组
    public static int[] digestInt = new int[8];
	protected EventListenerList listenerList = new EventListenerList();
	
	public void addActionListener(ActionListener l) {
		listenerList.add(ActionListener.class, l);
	}
	public int analyze(sm3_type t) {
		//round = Integer.parseInt(t.getSm3round()); 
		if (round == 1) {
			
			if (sm3x1.equals("") || sm3y1.equals("")) {
				System.out.print("***************************ERROR***************************");
				System.out.print("ERROR: attack the second round, please set the first round.");
				System.out.print("***********************************************************");
				return NO_TRACE;
			}
		}
		return super.analyze(t);
	}

	
	public float[] select(sm3_type t) {
		float[] selected = new float[dataLength];
		byte[] data = t.getData();//保存明文密文
		if (data == null)
			return null;

		byte[] mdata = new byte[32];

		System.arraycopy(data, 0, mdata, 0, 32);

		System.arraycopy(abcdefgh, 0, digestInt, 0, abcdefgh.length);
		// 格式化输入字节数组，补10及长度数据

		byte[] tempdata = new byte[3];

		tempdata[0] = 0x61;
		tempdata[1] = 0x62;
		tempdata[2] = 0x63;

		byte[] newbyte = SM3_HASH.byteArrayFormatData(mdata);
		// 获取数据摘要计算的数据单元个数11
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
		for (int pos = 0; pos < MCount; pos++)
	    {
	        for (int j = 0; j < 16; j++) 
	        {
	            X[j] = (int) SM3.byteArrayTolong(newbyte, (pos * 64) + (j * 4));
	        }

	  }
		// for (int pos = 0; pos < MCount; pos++) {
		// 将每个单元的数据转换成16个整型数据，并保存到tmpData的前16个数组元素中
		//for (int j = 0; j < 16; j++) {
			// X[j] = byteArrayToInt(newbyte, (pos * 64) + (j * 4));
			//X[j] = byteArrayToInt(mdata, (0 * 64) + (j * 4));
			
			// X[j] = 0x61626364;
		//}
		// 摘要计算函数
		processBlock(selected);
		return selected;

	}
	
	public void processBlock(float[] selected) {

		byte[] temptest = new byte[272];
		for (int t = 16; t <= 67; t++) {
			X[t] = SM3_HASH.P1((X[t - 16]) ^ X[t - 9]
					^ ((X[t - 3] << 15) | (X[t - 3] >>> 17)))
					^ ((X[t - 13] << 7) | (X[t - 13] >>> 25)) ^ X[t - 6];

		}
		for (int i = 0; i < X.length; i++) {
			SM3_HASH.intToByteArray(X[i], temptest, i * 4);
		}
//	 String temstr=byteArrayToHexString(temptest);

		byte[] temptest1 = new byte[256];
		for (int t = 0; t <= 63; t++) {
			Y[t] = X[t] ^ X[t + 4];
		}
		for (int i = 0; i < Y.length; i++) {
			SM3_HASH.intToByteArray(Y[i], temptest1, i * 4);
		}
		int a = H1;
		int b = H2;
		int c = H3;
		int d = H4;
		int e = H5;
		int f = H6;
		int g = H7;
		int h = H8;
		if (round == 0) { // first round
			int ss1 = 0, ss2 = 0, tt1 = 0, tt2 = 0;
			ss1 = ((a << 12) | (a >>> 20)) + e
					+ ((T1 << 0) | (T1 >>> (32 - 0)));
			ss1 = (ss1 << 7) | (ss1 >>> 25);
			ss2 = ss1 ^ ((a << 12) | (a >>> 20));
			int realx = SM3_HASH.FF1(a, b, c) + d + ss2;// 588B5DAB
			int realy = SM3_HASH.GG1(e, f, g) + h + ss1;// 5F057B3B
			if (step == 0) {
				if (sm3x1.equals("")) {
					for (int i = 0; i < 65536; i++) {
						long TT1 = i + Y[0];
						selected[i] = hw((TT1) & 0xff) + hw((TT1 >> 8) & 0xff);
					}
				} else {
					int intsm3x1 = Integer.parseInt(sm3x1, 16);
					for (int i = 0; i < 65536; i++) {
						long TT1 = (i * 65536 + intsm3x1) + Y[0];
						selected[i] = hw((TT1) & 0xff) + hw((TT1 >> 8) & 0xff)
								+ hw((TT1 >> 16) & 0xff)
								+ hw((TT1 >> 24) & 0xff);
					}
				}
			} else {
				if (sm3y1.equals("")) {
					for (int i = 0; i < 65536; i++) {
						long TT1 = i + X[0];
						selected[i] = hw((TT1) & 0xff) + hw((TT1 >> 8) & 0xff);
					}
				} else {
					int intsm3y1 = Integer.parseInt(sm3y1, 16);
					for (int i = 0; i < 65536; i++) {
						long TT1 = (i * 65536 + intsm3y1) + X[0];
						selected[i] = hw((TT1) & 0xff) + hw((TT1 >> 8) & 0xff)
								+ hw((TT1 >> 16) & 0xff)
								+ hw((TT1 >> 24) & 0xff);
					}
				}
			}

		} else if (round == 1) {
			int x1 = Integer.parseInt(sm3x1, 16);
			int y1 = Integer.parseInt(sm3y1, 16);

			int round1TT1 = x1 + Y[0];
			int round1TT2 = y1 + X[0];
			a = round1TT1;
			e = SM3_HASH.P0(round1TT2);

			int ss1 = 0, ss2 = 0, tt1 = 0, tt2 = 0;
			ss1 = ((a << 12) | (a >>> 20)) + e
					+ ((T1 << 1) | (T1 >>> (32 - 1)));
			ss1 = (ss1 << 7) | (ss1 >>> 25);
			ss2 = ss1 ^ ((a << 12) | (a >>> 20));

			if (step == 0) { // 5AE564FD 172442d7
				int len = sm3x2.length();
				if (len % 2 != 0) {
					len += 1;
				}
				for (int H = 0; H < 256; H++) {
					long HH = (H << sm3x2.length() * 4)
							+ ((sm3x2.length() == 0) ? 0 : Integer.parseInt(
									sm3x2, 16));
					for (int L = 0; L < 256; L++) {
						long LL = (L << sm3d2.length() * 4)
								+ ((sm3x2.length() == 0) ? 0 : Integer
										.parseInt(sm3d2, 16));

						int TT11 = (int) (a ^ (int) HH) + (int) LL + ss2
								+ (int) Y[1];

						if (len == 0) {
							selected[H * 256 + L] = hw((TT11) & 0xFF);
						} else if (len == 2) {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF);
						} else if (len == 4) {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF)
									+ hw((TT11 >> 16) & 0xFF);
						} else {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF)
									+ hw((TT11 >> 16) & 0xFF)
									+ hw((TT11 >> 24) & 0xFF);
						}
					}
				}
			} else {
				int len = sm3y2.length();
				if (len % 2 != 0) {
					len += 1;
				}
				int realfg = (int) (f ^ g);
				for (int H = 0; H < 256; H++) { // 6C3F8135 E38DEE4D
					long HH = (H << sm3y2.length() * 4)
							+ ((sm3y2.length() == 0) ? 0 : Integer.parseInt(
									sm3y2, 16));
					for (int L = 0; L < 256; L++) {
						long LL = (L << sm3h2.length() * 4)
								+ ((sm3h2.length() == 0) ? 0 : Integer
										.parseInt(sm3h2, 16));

						int TT11 = (int) (e ^ (int) HH) + (int) LL + ss1
								+ (int) X[1];

						if (len == 0) {
							selected[H * 256 + L] = hw((TT11) & 0xFF);
						} else if (len == 2) {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF);
						} else if (len == 4) {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF)
									+ hw((TT11 >> 16) & 0xFF);
						} else {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF)
									+ hw((TT11 >> 16) & 0xFF)
									+ hw((TT11 >> 24) & 0xFF);
						}
					}
				}

			}
		} else {
			long x1 = Long.parseLong(sm3x1, 16);
			long y1 = Long.parseLong(sm3y1, 16);

			long round1TT1 = x1 + Y[0];
			long round1TT2 = y1 + X[0];
			int a2 = (int) round1TT1;
			int e2 = SM3_HASH.P0((int) round1TT2);

			long x2 = Long.parseLong(sm3x2, 16);
			long d2 = Long.parseLong(sm3d2, 16);
			long y2 = Long.parseLong(sm3y2, 16);
			long h2 = Long.parseLong(sm3h2, 16);

			int ss1 = 0, ss2 = 0;
			ss1 = ((a2 << 12) | (a2 >>> 20)) + e2
					+ ((T1 << 1) | (T1 >>> (32 - 1)));
			ss1 = (ss1 << 7) | (ss1 >>> 25);
			ss2 = ss1 ^ ((a2 << 12) | (a2 >>> 20));

			int round2TT1 = (int) (a2 ^ (int) x2) + (int) d2 + ss2 + (int) Y[1];
			int round2TT2 = (int) (e2 ^ (int) y2) + (int) h2 + ss1 + (int) X[1];
			int b3 = a2;
			int a3 = round2TT1;
			int f3 = e2;
			int e3 = SM3_HASH.P0(round2TT2);

			ss1 = ((a3 << 12) | (a3 >>> 20)) + e3
					+ ((T1 << 2) | (T1 >>> (32 - 2))); // FFFFFFFFDBC00130
			ss1 = (ss1 << 7) | (ss1 >>> 25);
			ss2 = ss1 ^ ((a3 << 12) | (a3 >>> 20));// FFFFFFFFE3C9C328

			if (step == 0) {
				int len = sm3c3.length();
				if (len % 2 != 0) {
					len += 1;
				}

				for (int H = 0; H < 256; H++) {
					long HH = (H << sm3c3.length() * 4)
							+ ((sm3c3.length() == 0) ? 0 : Integer.parseInt(
									sm3c3, 16));
					for (int L = 0; L < 256; L++) {
						long LL = (L << sm3d3.length() * 4)
								+ ((sm3d3.length() == 0) ? 0 : Integer
										.parseInt(sm3d3, 16));

						int TT11 = (int) (a3 ^ b3 ^ (int) HH) + (int) LL + ss2 // 2CDEE7
																				// 29657292
								+ (int) Y[2];

						if (len == 0) {
							selected[H * 256 + L] = hw((TT11) & 0xFF);
						} else if (len == 2) {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF);
						} else if (len == 4) {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF)
									+ hw((TT11 >> 16) & 0xFF);
						} else {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF)
									+ hw((TT11 >> 16) & 0xFF)
									+ hw((TT11 >> 24) & 0xFF);
						}
					}
				}
			} else {
				int len = sm3g3.length();
				if (len % 2 != 0) {
					len += 1;
				}
				int realfg = (int) (f ^ g);
				for (int H = 0; H < 256; H++) { // 6C3F8135 E38DEE4D
					long HH = (H << sm3g3.length() * 4)
							+ ((sm3g3.length() == 0) ? 0 : Integer.parseInt(
									sm3g3, 16));
					for (int L = 0; L < 256; L++) {
						long LL = (L << sm3h3.length() * 4)
								+ ((sm3h3.length() == 0) ? 0 : Integer
										.parseInt(sm3h3, 16));

						int TT11 = (int) (e3 ^ f3 ^ (int) HH) + (int) LL + ss1 // FFFFFFFF85E54B79
																				// FFFFFFFFC550B189
								+ (int) X[2];

						if (len == 0) {
							selected[H * 256 + L] = hw((TT11) & 0xFF);
						} else if (len == 2) {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF);
						} else if (len == 4) {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF)
									+ hw((TT11 >> 16) & 0xFF);
						} else {
							selected[H * 256 + L] = hw((TT11) & 0xFF)
									+ hw((TT11 >> 8) & 0xFF)
									+ hw((TT11 >> 16) & 0xFF)
									+ hw((TT11 >> 24) & 0xFF);
						}
					}
				}
			}

		}
	}

	BigInteger toUnsignedBigInteger(byte[] ba, int offset, int length) {
		if (ba == null)
			return BigInteger.ZERO;
		byte[] in = new byte[length + 1];
		System.arraycopy(ba, offset, in, 1, length);
		return new BigInteger(in);
	}

	public static int hw(long i) {
		int result = 0;
		while (i > 0) {
			if ((i & 1) != 0)
				result++;
			i >>>= 1;
		}
		return result;
	}
	public static int byteArrayToInt(byte[] bytedata, int i) {
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
    
	
	public void report(int key, Vector<float[]> best, int fragmentOffset,
			int fragmentEnd) {
		super.report(key, best, fragmentOffset, fragmentEnd);
		int bestkey = (int) best.get(0)[0];

		if (round == 0) {
			if (step == 0) {
				sm3x1 = Integer.toString(bestkey, 16) + sm3x1;
				sm3x1 = sm3x1.toUpperCase();
			} else {
				sm3y1 = Integer.toString(bestkey, 16) + sm3y1;
				sm3y1 = sm3x1.toUpperCase();
			}
		} else if (round == 1) {
			if (step == 0) {
				sm3x2 = Integer.toString(bestkey, 16).substring(0, 2) + sm3x2;
				sm3x2 = sm3x2.toUpperCase();
				sm3d2 = Integer.toString(bestkey, 16).substring(2, 4) + sm3d2;
				sm3d2 = sm3d2.toUpperCase();
			} else {
				sm3y2 = Integer.toString(bestkey, 16).substring(0, 2) + sm3y2;
				sm3y2 = sm3y2.toUpperCase();
				sm3h2 = Integer.toString(bestkey, 16).substring(2, 4) + sm3h2;
				sm3h2 = sm3h2.toUpperCase();
			}
		} else if (round == 2) {
			if (step == 0) {
				sm3c3 = Integer.toString(bestkey, 16).substring(0, 2) + sm3c3;
				sm3c3 = sm3c3.toUpperCase();
				sm3d3 = Integer.toString(bestkey, 16).substring(2, 4) + sm3d3;
				sm3d3 = sm3d3.toUpperCase();
			} else {
				sm3g3 = Integer.toString(bestkey, 16).substring(0, 2) + sm3g3;
				sm3g3 = sm3g3.toUpperCase();
				sm3h3 = Integer.toString(bestkey, 16).substring(2, 4) + sm3h3;
				sm3h3 = sm3h3.toUpperCase();
			}
		}
	}

	
}

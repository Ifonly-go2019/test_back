package SM3_stand;



import java.lang.Math;
import java.math.BigInteger;
import java.util.Vector;

import sm3.SM3_HASH;



public class select {

	public float[] selects(Trace t) {
		float[] selected = new float[dataLength];
		byte[] data = t.getData();
		if (data == null)
			return null;

		byte[] mdata = new byte[32];

		System.arraycopy(data, 0, mdata, 0, 32);

		System.arraycopy(abcdefgh, 0, digestInt, 0, abcdefgh.length);
		// ��ʽ�������ֽ����飬��10����������

		byte[] tempdata = new byte[3];

		tempdata[0] = 0x61;
		tempdata[1] = 0x62;
		tempdata[2] = 0x63;

		byte[] newbyte = SM3_HASH.byteArrayFormatData(mdata);
		// ��ȡ����ժҪ��������ݵ�Ԫ����
		int MCount = newbyte.length / 64;
		// ѭ����ÿ�����ݵ�Ԫ����ժҪ����
		// ��ʼ��
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
		// ��ÿ����Ԫ������ת����16���������ݣ������浽tmpData��ǰ16������Ԫ����
		//for (int j = 0; j < 16; j++) {
			// X[j] = byteArrayToInt(newbyte, (pos * 64) + (j * 4));
			//X[j] = byteArrayToInt(mdata, (0 * 64) + (j * 4));
			
			// X[j] = 0x61626364;
		//}
		// ժҪ���㺯��
		processBlock(selected);
		return selected;

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

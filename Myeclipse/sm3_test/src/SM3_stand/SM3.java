package SM3_stand;




public class SM3
{
	public  static  long[] abcdefgh =
	{
	        0x7380166fl,
	        0x4914b2b9l,
	        0x172442d7l,
	        0xda8a0600l,
	        0xa96f30bcl,
	        0x163138aal,
	        0xe38dee4dl,
	        0xb0fb0e4el
   };
	
public static  long      H1, H2, H3, H4, H5, H6, H7, H8;

public static  long[] digestlong = new long[8];

public  static  long[]   X = new long[68];

public  static  long[]   Y = new long[64];


public  static final long    T1 = 0x79cc4519l; //0 to 15

public  static final long    T2 = 0x7a879d8al; //16 to 63

public static  long process_input_bytes(byte[] bytedata) 
{
		System.arraycopy(abcdefgh, 0, digestlong, 0, abcdefgh.length);
		byte[] newbyte = byteArrayFormatData(bytedata);
		long MCount = newbyte.length / 64;
		for (int i = 0; i < 68; i++)
		{
		    X[i] = 0;
		}
		
		H1 = 0x7380166fl;    
		H2 = 0x4914b2b9l;
		H3 = 0x172442d7l;
		H4 = 0xda8a0600l;
		H5 = 0xa96f30bcl;
		H6 = 0x163138aal;
		H7 = 0xe38dee4dl;
		H8 = 0xb0fb0e4el;
		for (int i = 0; i < 64; i++)
		{
		    Y[i] = 0;
		}
		
		for (int pos = 0; pos < MCount; pos++)
		{
			for (int j = 0; j < 16; j++)
			{
			    X[j] = byteArrayTolong(newbyte, (pos * 64) + (j * 4));
			}
			 processBlock();
		}
		return 20;
}

public static  byte[] byteArrayFormatData(byte[] bytedata) 
{
		int zeros = 0;
		int size = 0;
		int n = bytedata.length;
		int m = n % 64;
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
		byte[] newbyte = new byte[size];
		System.arraycopy(bytedata, 0, newbyte, 0, n);
		int l = n;
		newbyte[l++] = (byte) 0x80;
		for (int i = 0; i < zeros; i++) {
		    newbyte[l++] = (byte) 0x00;
		}
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




public static  long FF1( long    x, long    y,long    z)
{
       return (x ^ y ^ z)&0x00000000FFFFFFFFL;
}



private static long FF2( long    x, long    y, long    z)
{
       return (x&y)|(x&z)|(y&z)&0x00000000FFFFFFFFL;
}


public static long  GG1(long    x,long    y, long    z)
{
       return (x ^ y ^ z)&0x00000000FFFFFFFFL;
}
      
public static long GG2(long    x,long    y,long    z)
{
      return ((x&y)|((~x)&z))&0x00000000FFFFFFFFL;
}    
   
  
public static long  P0(
       long    x)
   {
       return (  (ROL(x,9) ^ ROL(x,17) ^ x)& 0x00000000FFFFFFFFL);
   }

public static long P1(
           long    x)
       {
           return ((ROL(x,15) ^ ROL(x,23) ^ x) &0x00000000FFFFFFFFL);
       }


public static  long  ROL(long x,int y)
{
	 long temp=0L;
	 long a=0L;
	 long b=0L;
	 
	 a=(((x) & 0xFFFFFFFFL) << (y%32) )&0x00000000FFFFFFFFL ;//48244000 --1210335232
	 
	 b=( (x) & 0xFFFFFFFFL) >> (32 - (y%32))&0x00000000FFFFFFFFL ;
	 
	 temp=a|b;
	 
	 return temp;
}


public static  long  ROR(long x,int y)
{
	 long temp=0L;
	 long a=0L;
	 long b=0L;
	 
	 a=(((x) & 0xFFFFFFFFL) >> (y%32) )&0x00000000FFFFFFFFL ;//48244000 --1210335232
	 
	 b=( (x) & 0xFFFFFFFFL) << (32 - (y%32))&0x00000000FFFFFFFFL ;
	 
	 temp=a|b;
	 
	 return temp;
}


public static   void processBlock()
{
    
	   byte[] temptest = new byte[272];
	   
       for (int t = 16; t <= 67; t++)
       {
         
    	   
    	   
    	  
         /* if(t==28)
          {
        	  
        	int a=4;
        	System.out.print("begin\n");
        	System.out.printf("%x\n", X[t - 16]);
        	System.out.printf("%x\n", X[t - 3]);
        	System.out.printf("%x\n", X[t - 13]);
        	System.out.printf("%x\n", X[t - 6]);
        	System.out.printf("%x\n", ROL(X[t - 3],15));
        	System.out.printf("%x\n", ROL(X[t - 13],7));
         
        	
          }
         */ 
    	   
    	   
    	   
          
          
          
    	  X[t] = P1( X[t - 16]^X[t - 9]^ROL(X[t - 3],15) ) ^ROL(X[t - 13],7)^ X[t-6]&0x00000000FFFFFFFF;
      
       }
       for (int i = 0; i < X.length; i++)
       {
           longToByteArray(X[i], temptest, i * 4);
       }
    //String  temstr=byteArrayToHexString(temptest);

       byte[] temptest1 = new byte[256];
       
       for (int t = 0; t <= 63; t++)
       {
         Y[t]=X[t]^X[t+4]&0xFFFFFFFF;
       }
       for (int i = 0; i < Y.length; i++)
       {
           longToByteArray(Y[i], temptest1, i * 4);
       }
    
    // String  temstr1=byteArrayToHexString(temptest1);
  
       long     a = H1;
       long     b = H2;
       long     c = H3;
       long     d = H4;
       long     e = H5;
       long     f = H6;
       long     g = H7;
       long     h = H8;

       //long t = 0; 
      // long templong[]=new long[8];
       
       for(int mm=0;mm<68;mm++)
       {
    	   
    	 // System.out.printf("%x\n", X[mm]);
    	   
       }
       
       for(int tt=0;tt<64;tt++)
       {
    	   
    	// System.out.printf("%x\n", Y[tt]);
    	   
       }
       for(int i = 0; i < 16; i ++)
       {
    
           long ss1=0,ss2=0,tt1=0,tt2=0;
           
           ss1=((ROL(a,12))+e+(ROL(T1,i)))&0x00000000FFFFFFFFL;
           
           ss1=ROL(ss1,7)&0x00000000FFFFFFFFL;
           
           ss2=(ss1^(ROL(a,12)))&0x00000000FFFFFFFFL;
           
           tt1=(FF1(a,b,c)+d+ss2+Y[i])&0x00000000FFFFFFFFL;
           
           tt2=(GG1(e,f,g)+h+ss1+X[i])&0x00000000FFFFFFFFL;
           
           d=c;
           
           c=ROL(b,9);
           
           b=a;
           
           a=tt1;
           
           h=g;
           
           g=ROL(f,19);
           
           f=e;
           
           e=P0(tt2); 
           
          /* if(i==15)
           {
             System.out.printf("%x\n", a);
             System.out.printf("%x\n", b);
             System.out.printf("%x\n", c);
             System.out.printf("%x\n", d);
             System.out.printf("%x\n", e);
             System.out.printf("%x\n", f);
             System.out.printf("%x\n", g);
           }
           */
     /*    templong[0]=a;
           templong[1]=b;
           templong[2]=c;
           templong[3]=d;
           templong[4]=e;
           templong[5]=f;
           templong[6]=g;
           templong[7]=h;
           byte[] temptest2 = new byte[32];
           for (long j = 0; j < templong.length; j++) {
               longToByteArray(templong[j], temptest2, j * 4);
           }
        String  temstr2=byteArrayToHexString(temptest2);
        System.out.prlongln(temstr2);*/
           
           
       }
       for(int i = 16; i < 64; i ++)
       {
    	   
           long ss1=0,ss2=0,tt1=0,tt2=0;
           if(i==33)
           {   
        	   long aa=ROL(T2,i);
           
        	   ss1=0;
           }
    	   
           ss1=(ROL(a,12)+e+ROL(T2,i))&0x00000000FFFFFFFFL;
           
           
           ss1=ROL(ss1,7)&0x00000000FFFFFFFFL;
           
           
           ss2=(ss1^(ROL(a,12)))&0x00000000FFFFFFFFL;
           
           
           tt1=(FF2(a,b,c)+d+ss2+Y[i])&0x00000000FFFFFFFFL;
           
           
           tt2=(GG2(e,f,g)+h+ss1+X[i])&0x00000000FFFFFFFFL;
           
           
           
           d=c;
           
           c=ROL(b,9);
           
           b=a;
           
           a=tt1;
           
           h=g;
           
           g=ROL(f,19);
           
           f=e;
           
           e=P0(tt2);
           
           System.out.printf("%d\n",i);
           { 
		       System.out.printf("%x\n", a);
		       System.out.printf("%x\n", b);
		       System.out.printf("%x\n", c);
		       System.out.printf("%x\n", d);
		       System.out.printf("%x\n", e);
		       System.out.printf("%x\n", f);
		       System.out.printf("%x\n", g);
           }
               System.out.printf("\n");
           
    
       }
       

       
       

       
       
       
       
       H1 ^= a;
       digestlong[0]=H1;
       H2 ^= b;
       digestlong[1]=H2;
       H3 ^= c;
       digestlong[2]=H3;
       H4 ^= d;
       digestlong[3]=H4;
       H5 ^= e;
       digestlong[4]=H5;
       H6 ^= f;
       digestlong[5]=H6;
       H7 ^= g;
       digestlong[6]=H7;
       H8 ^= h;
       digestlong[7]=H8;

       //
       // reset the offset and clean out the word buffer.
       //
     
       for (int i = 0; i < 16; i++)
       {
           X[i] = 0;
       }
   }
   
public  static   long byteArrayTolong(byte[] bytedata, int i)
{
/*return ((bytedata[i] & 0xff) << 24) | ((bytedata[i + 1] & 0xff) << 16) |
((bytedata[i + 2] & 0xff) << 8) | (bytedata[i + 3] & 0xff);*/
long num = 0;
long temp;
temp = (0x000000ff & (bytedata[i+3]))<<0;
num = num | temp;
temp = (0x000000ff & (bytedata[i+2]))<<8;
num = num | temp;
temp = (0x000000ff & (bytedata[i+1]))<<16;
num = num | temp;
temp = (0x000000ff & (bytedata[i]))<<24;
num = num | temp;

return num;


}


public static  void longToByteArray(long longValue, byte[] byteData, int i) {
byteData[i] = (byte) ((longValue&0x00000000FFFFFFFFL) >> 24);
byteData[i + 1] = (byte) ((longValue&0x00000000FFFFFFFFL) >> 16);
byteData[i + 2] = (byte) ((longValue&0x00000000FFFFFFFFL)  >> 8);
byteData[i + 3] = (byte) (longValue&0x00000000FFFFFFFFL);
}

public  static String byteToHexString(byte ib) {
char[] Digit = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C',
        'D', 'E', 'F'
    };
char[] ob = new char[2];
ob[0] = Digit[(ib >>> 4) & 0X0F];
ob[1] = Digit[ib & 0X0F];
String s = new String(ob);
return s;
}

public  static String byteArrayToHexString(byte[] bytearray) {
String strDigest = "";
for (int i = 0; i < bytearray.length; i++) {
    strDigest += byteToHexString(bytearray[i]);
}
return strDigest;
}

public static  byte[] getDigestOfBytes(byte[] byteData)
{
process_input_bytes(byteData);
byte[] digest = new byte[32];
for (int i = 0; i < digestlong.length; i++) 
{
    longToByteArray(digestlong[i], digest, i * 4);
}
return digest;
}

public static String byteToString(byte In[])
{
	char []r1 = new char[In.length * 2 + 1];
	for (int n = 0;n<In.length;n++)
	{
		long tmp1 = (long)((((long)In[n]+256)%256) >> 4);
		long tmp2 = (long)((((long)In[n]+256)%256) & 0x0f);
		
		if (tmp1>=0xa)
			r1[n*2] = (char)(tmp1 - 0xa + 'A' );
		else 
			r1[n*2] = (char)(tmp1 + '0');
		
		if (tmp2>=0xa)
			r1[n*2+1] = (char)(tmp2 - 0xa + 'A' );
		else 
			r1[n*2+1] = (char)(tmp2 + '0');
		
	}
	String s = new String(r1);
	return s;
}

public static  byte[] StringToByte(String in)
{
	byte []r1 = new byte[in.length()/2];
	
	for (int n=0;n<in.length()/2;n++)
	{
		char a = in.charAt(2*n);
		char b = in.charAt(2*n+1);
				
		if (a>='A')
		{
			a = (char) (a-'A'+10);			
		}
		else
			a = (char) (a-'0');
		if (b>='A')
		{
			b = (char) (b-'A'+10);			
		}
		else
			b = (char) (b-'0');
		
		r1[n] = (byte) ((a<<4)+b);
	}
	return r1;
}

public static  String getDigestOfString(byte[] byteData) {
return byteArrayToHexString(getDigestOfBytes(byteData));
}


public static void main(String[] args){
	
	
	byte[] data={(byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64,
		       (byte) 0x61,(byte) 0x62,(byte) 0x63,(byte) 0x64
};
	/*  String sig="abc";
	  
	  long tt=0x7a879d8al;
	  
      tt=SM3.ROL(tt,33);
      
	  byte[] data=sig.getBytes();
	*/  
	  String digest = SM3.getDigestOfString(data);
	  System.out.println(digest);
}
/*public static void main(String[] args) {
//String data = "abcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcdabcd";
 
 */



 /* byte[] data={(byte) 0xF4,(byte) 0xA3,(byte) 0x84,(byte) 0x89,
			   (byte) 0xE3,(byte) 0x2B,(byte) 0x45,(byte) 0xB6,
			   (byte) 0xF8,(byte) 0x76,(byte) 0xE3,(byte) 0xAC,
			   (byte) 0x21,(byte) 0x68,(byte) 0xCA,(byte) 0x39,
			   (byte) 0x23,(byte) 0x62,(byte) 0xDC,(byte) 0x8F,
			   (byte) 0x23,(byte) 0x45,(byte) 0x9C,(byte) 0x1D,
			   (byte) 0x11,(byte) 0x46,(byte) 0xFC,(byte) 0x3D,
			   (byte) 0xBF,(byte) 0xB7,(byte) 0xBC,(byte) 0x9A,
			   (byte) 0x6D,(byte) 0x65,(byte) 0x73,(byte) 0x73,
			   (byte) 0x61,(byte) 0x67,(byte) 0x65,(byte) 0x20,
			   (byte) 0x64,(byte) 0x69,(byte) 0x67,(byte) 0x65,
			   (byte) 0x73,(byte) 0x74};	*/
  //byte[] data=Hex.decode("F4A38489E32B45B6F876E3AC2168CA392362DC8F23459C1D1146FC3DBFB7BC9A6D65737361676520646967657374");
  //String sig="ALICE123@YAHOO.COM";
  //byte[] data=sig.getBytes();
  /*byte[] data=Hex.decode("0090414C494345313233405941484F4F2E434F4D"
		  +"787968B4FA32C3FD2417842E73BBFEFF2F3C848B6831D7E0EC65228B3937E498"
		   +"63E4C6D3B23B0C849CF84241484BFE48F61D59A5B16BA06E6E12D1DA27C5249A"
		   +"421DEBD61B62EAB6746434EBC3CC315E32220B3BADD50BDC4C4E6C147FEDD43D"
		  +"0680512BCBB42C07D47349D2153B70C4E5D7FDFCBFA36EA1A85841B9E46E09A2"
		   +"0AE4C7798AA0F119471BEE11825BE46202BB79E2A5844495E97C04FF4DF2548A"
		  +"7C0240F88F1CD4E16352A73C17B7F16F07353E53A176D684A9FE0C6BB798E857");
  
 System.out.prlongln(data);
 
 System.out.prlongln(data.length);*/
 
 /*String digest = new SM3_HASH().getDigestOfString(data);

 System.out.prlongln(digest);
}*/

}
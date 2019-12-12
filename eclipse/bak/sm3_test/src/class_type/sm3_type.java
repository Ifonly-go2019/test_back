package class_type;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.io.BufferedReader;

import com.riscure.signalanalysis.Data;
import com.riscure.signalanalysis.Trace;
import com.riscure.signalanalysis.TraceSet;
import com.riscure.signalanalysis.inspector.HostData;
import com.riscure.functions.Strings;




public class sm3_type {
	 	public static final int HIGH = 1;
	    public static final int HIGH_AND_LOW = 0;
	    public static final int LOW = 2;
	    private boolean aggregatesValid;
	    public byte[] data;
	    public String dataString;
	    private Trace fastHigh;
	    private Trace fastLow;
	    private boolean hasIllegalValues;
	    private boolean isReal;
	    private float max;
	    private float min;	
	    public float[] sample;
	    public float sampleFrequency;
	    private Data samples;
	    public int shifted;
	    public String title;
	    public TraceSet ts;
	    
         
	    
	    
	    
	    private String sm3x1 = "";
	    private String sm3y1 = "";
		private String sm3x2 = "";
		private String sm3d2 = "";
		private String sm3y2 = "";
		private String sm3h2 = "";
		private String sm3c3 = "";
		private String sm3d3 = "";
		private String sm3g3 = "";
		private String sm3h3 = "";
	
		
		private int sm3round ;
		private int Sm3step ;
		private int firstSampleIndex ;
		private int  SamplenumberIndex;
	    public int tracefirst;
	    public int tracenumber;
	  
		
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public int getFirstSampleIndex() {
			return firstSampleIndex;
		}
		public void setFirstSampleIndex(int firstSampleIndex) {
			this.firstSampleIndex = firstSampleIndex;
		}
		public int getSamplenumberIndex() {
			return SamplenumberIndex;
		}
		public void setSamplenumberIndex(int samplenumberIndex) {
			SamplenumberIndex = samplenumberIndex;
		}
		public String getSm3x1() {
			return sm3x1;
		}
		public void setSm3x1(String sm3x1) {
			this.sm3x1 = sm3x1;
		}
		public String getSm3y1() {
			return sm3y1;
		}
		public void setSm3y1(String sm3y1) {
			this.sm3y1 = sm3y1;
		}
		public String getSm3x2() {
			return sm3x2;
		}
		public void setSm3x2(String sm3x2) {
			this.sm3x2 = sm3x2;
		}
		public String getSm3d2() {
			return sm3d2;
		}
		public void setSm3d2(String sm3d2) {
			this.sm3d2 = sm3d2;
		}
		public String getSm3y2() {
			return sm3y2;
		}
		public void setSm3y2(String sm3y2) {
			this.sm3y2 = sm3y2;
		}
		public String getSm3h2() {
			return sm3h2;
		}
		public void setSm3h2(String sm3h2) {
			this.sm3h2 = sm3h2;
		}
		public String getSm3c3() {
			return sm3c3;
		}
		public void setSm3c3(String sm3c3) {
			this.sm3c3 = sm3c3;
		}
		public String getSm3d3() {
			return sm3d3;
		}
		public void setSm3d3(String sm3d3) {
			this.sm3d3 = sm3d3;
		}
		public String getSm3g3() {
			return sm3g3;
		}
		public void setSm3g3(String sm3g3) {
			this.sm3g3 = sm3g3;
		}
		public String getSm3h3() {
			return sm3h3;
		}
		public void setSm3h3(String sm3h3) {
			this.sm3h3 = sm3h3;
		}
		public int getTracefirst() {
			return tracefirst;
		}
		public void setTracefirst(int tracefirst) {
			this.tracefirst = tracefirst;
		}
		public int getTracenumber() {
			return tracenumber;
		}
		public void setTracenumber(int tracenumber) {
			this.tracenumber = tracenumber;
		}
		
		
		
		
		
		
		public int getSm3round() {
			return sm3round;
		}
		public void setSm3round(int sm3round) {
			this.sm3round = sm3round;
		}
		public int getSm3step() {
			return Sm3step;
		}
		public void setSm3step(int sm3step) {
			Sm3step = sm3step;
		}
		
		
		public void setSample(int i, float f) {
	        forceSample();
	        this.sample[i] = f;
	    }

	    public void setSample(float[] fArr) {
	        this.samples = HostData.createFloat(fArr);
	    }

	    public float[] getSample() {
	        return this.samples.getFloatData();
	    }

	    public float getSample(int i) {
	        float[] sample = getSample();
	        int i2 = this.shifted + i;
	        if (i2 < 0 || i2 >= sample.length) {
	            return 0.0f;
	        }
	        return sample[i2];
	    }
	    public Data getSampleData() {
	        return this.samples;
	    }
	    public String getDataString() {
	        return this.dataString;
	    }
	    public byte[] getData() {
	        return this.data;
	    }
	    public int getNumberOfSamples() {
	        return this.samples.getN();
	    }

	    
	    public void forceSample() {
	        if (this.samples.getN() > 0) {
	            this.sample = getSample();
	            if (!TraceSet.a) {
	                return;
	            }
	        }
	        this.sample = null;
	    }
	    
	    public void setData(byte[] bArr) {
	        this.data = bArr;
	        computeDataString();
	    }

	    private void computeDataString() {
	        boolean z = TraceSet.a;
	        if (this.data != null) {
	            StringBuffer stringBuffer = new StringBuffer(this.data.length * 3);
	            int i = HIGH_AND_LOW;
	            while (i < this.data.length) {
	                String toHexString = Integer.toHexString(this.data[i] & 255);
	                if (!z) {
	                    if (toHexString.length() == HIGH) {
	                        stringBuffer.append("0");
	                    }
	                    stringBuffer.append(toHexString.toUpperCase() + Strings.DEFAULT_SEPARATOR);
	                    i += HIGH;
	                    if (z) {
	                        break;
	                    }
	                }
	                return;
	            }
	            this.dataString = stringBuffer.toString();
	        }
	    }

	    
	    
	    
	    
	    
	  
	    
	    
	    
	    

	    
	    
	    
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	

	
	
}

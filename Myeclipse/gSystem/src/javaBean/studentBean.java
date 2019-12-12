package javaBean;

public class studentBean {
      private String sNo;
      private String sName;
      private String sPwd;
      private String sGender;
      private String sMajor;
      private String sDepart;
      private String sNoc;
      
      
	public String getsNoc() {
		return sNoc;
	}
	public void setsNoc(String sNoc) {
		this.sNoc = sNoc;
	}
	public String getsPwd() {
		return sPwd;
	}
	public void setsPwd(String sPwd) {
		this.sPwd = sPwd;
	}
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	
	public String getsGender() {
		return sGender;
	}
	public void setsGender(String sGender) {
		this.sGender = sGender;
	}
	public String getsMajor() {
		return sMajor;
	}
	public void setsMajor(String sMajor) {
		this.sMajor = sMajor;
	}
	public String getsDepart() {
		return sDepart;
	}
	public void setsDepart(String sDepart) {
		this.sDepart = sDepart;
	}
	
	public studentBean(){
		
	}
	
	
}

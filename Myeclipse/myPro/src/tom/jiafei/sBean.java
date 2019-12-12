package tom.jiafei;

import tools.MyTools;

public class sBean {
    String sName;
    String    sNumber;
    
    
    
	public sBean(){
		
	}
	
	
	public String getsName() {
		return sName;
	}






	public void setsName(String sName) {
		this.sName = MyTools.toChinese(sName) ;
	}






	public String getsNumber() {
		return sNumber;
	}






	public void setsNumber(String sNumber) {
		this.sNumber = sNumber;
	}






	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

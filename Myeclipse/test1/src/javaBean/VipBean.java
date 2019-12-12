package javaBean;

public class VipBean {
    private String tittle;
    private String userSpeaking;
    private String Name;
    private String VipTime;
    
    public String getVipTime() {
		return VipTime;
	}


	public void setVipTime(String vipTime) {
		VipTime = vipTime;
	}


	public VipBean(){
    	super();
    }


	public String getTittle() {
		return tittle;
	}


	public void setTittle(String tittle) {
		this.tittle = tittle;
	}


	public String getUserSpeaking() {
		return userSpeaking;
	}


	public void setUserSpeaking(String userSpeaking) {
		this.userSpeaking = userSpeaking;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}
	
	
	
}

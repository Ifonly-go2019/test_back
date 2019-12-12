package 单例模式;

public  class SingleModel {
	       
	       
	       /** 用来保存(指向)唯一的实例*/ 
	       private static SingleModel me=null;
           
	       
	       public int count=0;	
           private SingleModel() {//证明之前是public 
        	   count++;
           }
       	public static SingleModel getInstance() {
    		if(null == me)//如果为空则唯一一次实例化 
    			me = new SingleModel();
    		return me;
    	
    }

	public static void main(String[] args) {
//	    SingleModel single1=new SingleModelDemo();
//	    System.out.println(single1.count);
//	    SingleModel single2=new SingleModelDemo();
//	    System.out.println(single2.count);
//	    SingleModel single3=new SingleModelDemo();
//	    System.out.println(single3.count);
//	    SingleModel single4=new SingleModelDemo();
//	    System.out.println(single4.count);
////	      证明每一次new都创建了一个新的内存
	   
		/** 
		 * 获得本类唯一的一个实例--单例模式的核心方法
		 * */
		

}
}

package ����ģʽ;

public  class SingleModel {
	       
	       
	       /** ��������(ָ��)Ψһ��ʵ��*/ 
	       private static SingleModel me=null;
           
	       
	       public int count=0;	
           private SingleModel() {//֤��֮ǰ��public 
        	   count++;
           }
       	public static SingleModel getInstance() {
    		if(null == me)//���Ϊ����Ψһһ��ʵ���� 
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
////	      ֤��ÿһ��new��������һ���µ��ڴ�
	   
		/** 
		 * ��ñ���Ψһ��һ��ʵ��--����ģʽ�ĺ��ķ���
		 * */
		

}
}

package 单例模式;
/** 演示日历的常用方法*/
import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();//不能new，只能通过单例模式实例化
		/**由此看出calendar是一个抽象类，一般由子类GregorianCalendar实现 */
		System.out.println(cal.getClass().getSuperclass());//getclass()获得当前类的全称  getsuperclass()获得父类的名称
        //使用日历打印当前 的时间	
		int year =cal.get(Calendar.YEAR);
		int month =cal.get(Calendar.MONTH)+1;//默认少一天
		int day =cal.get(Calendar.DATE);
		int hour= cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int milliSecond = cal.get(Calendar.MILLISECOND);
        System.out.println("当前时间:");
        String strTime = String.format("%d-%d-%d %d-%d-%d:%s", year,month,day,hour,minute,second,milliSecond);
        System.out.println(strTime);
		
	}

}

package ����ģʽ;
/** ��ʾ�����ĳ��÷���*/
import java.util.Calendar;

public class CalendarDemo {

	public static void main(String[] args) {
		Calendar cal=Calendar.getInstance();//����new��ֻ��ͨ������ģʽʵ����
		/**�ɴ˿���calendar��һ�������࣬һ��������GregorianCalendarʵ�� */
		System.out.println(cal.getClass().getSuperclass());//getclass()��õ�ǰ���ȫ��  getsuperclass()��ø��������
        //ʹ��������ӡ��ǰ ��ʱ��	
		int year =cal.get(Calendar.YEAR);
		int month =cal.get(Calendar.MONTH)+1;//Ĭ����һ��
		int day =cal.get(Calendar.DATE);
		int hour= cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		int milliSecond = cal.get(Calendar.MILLISECOND);
        System.out.println("��ǰʱ��:");
        String strTime = String.format("%d-%d-%d %d-%d-%d:%s", year,month,day,hour,minute,second,milliSecond);
        System.out.println(strTime);
		
	}

}

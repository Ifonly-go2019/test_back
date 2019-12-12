package serverlet;

import java.awt.image.SampleModel;
import java.io.IOException;

import test.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import analysis.Correlation;
import sm3.SM3_Attack;
import class_type.sm3_type;

/**
 * Servlet implementation class sm3_test
 */
@WebServlet("/sm3_test")
public class sm3_test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sm3_test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long startTime=System.currentTimeMillis();
		
		float[][] arr_trace=null;
		byte[][]  arr_data=null;
		int keyid=0;
		int step=0;
		String[] returnnews=new String[4];
		
		String sm3step = request.getParameter("step");
		String sm3step_final = request.getParameter("step_final");
		String sm3firstsample= request.getParameter("Sfirst");
		String sm3numbersamples= request.getParameter("samples");
		String sm3Tfirst= request.getParameter("Tfirst");
		String sm3traces = request.getParameter("traces");
		String sm3round = request.getParameter("rounds");
		
		String sm3x1 = request.getParameter("x1");
		String sm3y1 = request.getParameter("y1");
		String sm3x2 = request.getParameter("x2");
		String sm3d2 = request.getParameter("d2");
		String sm3y2 = request.getParameter("y2");
		String sm3h2 = request.getParameter("h2");
		String sm3c3 = request.getParameter("c3");
		String sm3d3 = request.getParameter("d3");
		String sm3g3 = request.getParameter("g3");
		String sm3h3 = request.getParameter("h3");
		
		int round=Integer.parseInt(sm3round)-1;
		int firstsample=Integer.parseInt(sm3firstsample);
		
			 step=Integer.parseInt(sm3step_final)-1;
		
		int numbersamples=Integer.parseInt(sm3numbersamples);
		int Tfirst=Integer.parseInt(sm3Tfirst);
		int traces=Integer.parseInt(sm3traces);

		
		
		sm3_type t = new sm3_type();
		
		t.setSm3h3(sm3h3);
		t.setSm3g3(sm3g3);
		t.setSm3d3(sm3d3);
		t.setSm3c3(sm3c3);
		t.setSm3h2(sm3h2);
		t.setSm3y2(sm3y2);
		t.setSm3d2(sm3d2);
		t.setSm3x2(sm3x2);
		t.setSm3y1(sm3y1);
		t.setSm3x1(sm3x1);
		
		
		t.setSm3round(round);
		t.setSm3step(step);
		t.setFirstSampleIndex(firstsample);
		t.setSamplenumberIndex(numbersamples);
		t.setTracefirst(Tfirst);
		t.setTracenumber(traces);
		
		
		
		
		
		
		
		SM3_Attack a=new SM3_Attack(t);	
//		float[] arr = {
//				(float) 48.496529,(float) 95.812386,(float) 128.601456,(float) 87.116928
//		};//trace
//		byte[] test={91,76,67,51,119,124,(byte) 220,44,0,24,(byte) 213,(byte) 197,(byte) 172,(byte) 224,90,(byte) 252,41,(byte) 161,(byte) 210,103,21,(byte) 225,(byte) 139,(byte) 153,5,3,(byte) 212,32,(byte) 184,80,(byte) 225,(byte) 146};
//		//data
//		t.setSample(arr);
//		t.setData(test);
		
		
		
		
		System.out.println("sm3round: "+t.getSm3round());
		System.out.println("step: "+t.getSm3step());
		System.out.println("sm3first_trace:"+Tfirst);
		System.out.println("sm3_traces:"+traces);
		System.out.println("sm3_firstsample:"+firstsample);
		System.out.println("numberofsamples: "+numbersamples);
		System.out.println("x1"+sm3x1);
		System.out.println("y1"+sm3y1);
		System.out.println("x2"+sm3x2);
		System.out.println("d2"+sm3d2);
		System.out.println("y2"+sm3y2);
		System.out.println("h2"+sm3h2);
		System.out.println("c3"+sm3c3);
		System.out.println("d3"+sm3d3);
		System.out.println("a3"+sm3g3);
		System.out.println("h3"+sm3h3);
	
	
		//a.analyze(t);
		//a.select(t);
		//Test1 RT=new Test1();
		ReadTxt RT=new ReadTxt();
		ReadCSV RV=new ReadCSV();
		try {
			 arr_trace=RV.initTrace();
			  //arr_data=RT.initdata();
			 arr_data=RT.initarr();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		float[] arr1 = new float[t.getSamplenumberIndex()];
		byte[] arr2 =new byte[32];
		
		//数据赋予
		for(int r=t.getTracefirst();r<t.getTracefirst()+t.getTracenumber();r++)
		{
			for(int i=t.getFirstSampleIndex(),i2=0;i<t.getFirstSampleIndex()+t.getSamplenumberIndex();i++,i2++)
			{
				//从txt读取的数组赋给一维数组
				arr1[i2] = arr_trace[r][i];	
			}
			for(int k1=0;k1<32;k1++)
			{
				arr2[k1] = arr_data[r][k1];
			}
			
			t.setSample(arr1);			
			t.setData(arr2);
			
			a.analyze(t,keyid);
			keyid++;
			
		}
		a.finishProcess(round,step,returnnews);

		
		if(t.getSm3round()==0){
			if(t.getSm3step()==0){
				response.setCharacterEncoding("UTF-8");
				response.getWriter().append("Best correlation: \n");
				for(int i=0;i<4;i++){
				response.getWriter().append(returnnews[i]+"\n");
				}
				System.out.println(t.getSm3x1());
				
			}
			else{
				response.setCharacterEncoding("UTF-8");
				response.getWriter().append("Best correlation: \n");
				for(int i=0;i<4;i++){
				response.getWriter().append(returnnews[i]+"\n");
				}
				t.setSm3y1("");
			}
		}else if(t.getSm3round()==1){
			if(t.getSm3step()==0){
				response.setCharacterEncoding("UTF-8");
				response.getWriter().append("Best correlation: \n");
				for(int i=0;i<4;i++){
				response.getWriter().append(returnnews[i]+"\n");
				}
				System.out.println("x2:"+t.getSm3x2());
				System.out.println("d2:"+t.getSm3d2());
				
			}
			else{
				response.setCharacterEncoding("UTF-8");
				response.getWriter().append("Best correlation: \n");
				for(int i=0;i<4;i++){
				response.getWriter().append(returnnews[i]+"\n");
				}
				System.out.println("y2:"+t.getSm3y2());
				System.out.println("h2:"+t.getSm3h2());
			}
		}else if(t.getSm3round()==2){
			if(t.getSm3step()==0){
				response.setCharacterEncoding("UTF-8");
				response.getWriter().append("Best correlation: \n");
				for(int i=0;i<4;i++){
				response.getWriter().append(returnnews[i]+"\n");
				}
				System.out.println("c3:"+t.getSm3c3());
				System.out.println("d3:"+t.getSm3d3());
			}
			else{
				response.setCharacterEncoding("UTF-8");
				response.getWriter().append("Best correlation: \n");
				for(int i=0;i<4;i++){
				response.getWriter().append(returnnews[i]+"\n");
				}
				System.out.println("c3:"+t.getSm3c3());
				System.out.println("d3:"+t.getSm3d3());
			}
		}
		
		
		
		
		
		
		
  		
		
		//返回值
		System.out.println("攻击完成");
		long endTime=System.currentTimeMillis();
		System.out.println("当前程序耗时："+(endTime-startTime)+"ms");

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj20546_기적의매매법 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int money = Integer.parseInt(br.readLine());
		
		String chart[] = br.readLine().split(" ");
		
		double a = BNP(chart, money);
		double b = TIMING(chart, money);
		
		if(a>b)
			System.out.println("BNP");
		else if (b>a)
			System.out.println("TIMING");
		else
			System.out.println("SAMESAME");

	}
	
	//333 매매법
	static double TIMING(String chart[], int money) {
		double sum =0;
		int UPcount =0;
		int Downcount =0;
		
		int count=0;
		
		int m = money;
		
		int yesterday = Integer.parseInt(chart[0]);
		for(int i=1;i<14;i++) {
			int today = Integer.parseInt(chart[i]);
			
			
			if(yesterday<today) {
				UPcount++;
				Downcount=0;
			}
			else if(yesterday>today) {
				UPcount=0;
				Downcount++;
			}
			else {UPcount=0;Downcount=0;}
			
			// 매도
			if(UPcount==3) {
				if(count!=0)
					m= m+Integer.parseInt(chart[i])*count;
				UPcount=0;
				count=0;
			}
			
			//매수
			else if(Downcount==3) {
				int t = m/Integer.parseInt(chart[i]);	//매수 가능한 주식 수
				count+=t;
				m=m-(t*Integer.parseInt(chart[i]));
			}
		}
		
		sum = m+count*Integer.parseInt(chart[13]);
		return sum;
	}
	
	//기도 매매법
	static double BNP(String chart[], int money) {
		double sum =0;
		int count =0;
		int m = money;
		
		for(String today : chart) {
			int t = m/Integer.parseInt(today);	//매수 가능한 주식 수
			count+=t;
			m=m-(t*Integer.parseInt(today));
		}
		
		sum = m+count*Integer.parseInt(chart[13]);
		return sum;
	}
	
}

/*
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B20546 {
	static class Stock{
		int stock;
		int currency;
		int count;
		Stock(int stock, int currency){
			this.stock=stock;
			this.currency=currency;
			count=0;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int startvalue=Integer.parseInt(input.readLine());
		Stock bnp=new Stock(0,startvalue);
		Stock timing=new Stock(0,startvalue);
		int[] day=new int[14];
		StringTokenizer stk=new StringTokenizer(input.readLine());
		for(int i=0;i<14;i++)
			day[i]=Integer.parseInt(stk.nextToken());
		for(int i=0;i<13;i++) {
			if(bnp.currency/day[i]>0) {//매수 타이밍
				bnp.stock+=(bnp.currency/day[i]);
				bnp.currency-=(bnp.currency/day[i])*day[i];
			}
			if(day[i]>day[i+1]){//전일 대비 하락
				if(timing.count<=0)
					timing.count--;
				else
					timing.count=-1;
			}
			else if(day[i]<day[i+1]) {//전일 대비 상승
				if(timing.count>=0)
					timing.count++;
				else
					timing.count=1;
			}
			else timing.count=0;
			if(timing.count>=3) {//매도 타이밍
				timing.currency+=timing.stock*day[i+1];//마지막날 풀매도
				timing.stock=0;
			}
			else if(timing.count<=-3) {//매수 타이밍
				timing.stock+=(timing.currency/day[i+1]);
				timing.currency-=(timing.currency/day[i+1])*day[i+1];
			}
		}
		bnp.currency+=bnp.stock*day[13];//마지막날 풀매도
		bnp.stock=0;
		timing.currency+=timing.stock*day[13];//마지막날 풀매도
		timing.stock=0;
		if(bnp.currency>timing.currency)sb.append("BNP");
		else if(bnp.currency<timing.currency)sb.append("TIMING");
		else sb.append("SAMESAME");
		System.out.print(sb);
		input.close();
	}
}

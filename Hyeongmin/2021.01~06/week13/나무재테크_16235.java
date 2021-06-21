package week13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class 나무재테크_16235 {
	static int n,m,k;
	static ArrayList<Integer> tree[][];
	static int A[][];
	static int originA[][];
	static int count =0;
	
	static int dx[] = {-1,-1,-1,0,0,1,1,1};
	static int dy[] = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String temp[] =br.readLine().split(" ");
		n = Integer.parseInt(temp[0]);	//n*n
		m = Integer.parseInt(temp[1]);	//m개의 나무개
		k = Integer.parseInt(temp[2]); 	//k년 후 개수
		
		A = new int[n][n];
		originA = new int[n][n];
		tree = new ArrayList[n][n];
		
		for(int i=0;i<n;i++) {
			temp = br.readLine().split(" ");
			for(int j=0;j<n;j++) {
				tree[i][j] = new ArrayList<Integer>();
				
				A[i][j] = 5;
				originA[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		/*--------------양분 초기값 -------------*/
		
		for(int i=0;i<m;i++) {
			temp = br.readLine().split(" ");
			int a= Integer.parseInt(temp[0]);
			int b= Integer.parseInt(temp[1]);
			int age= Integer.parseInt(temp[2]);

			tree[a-1][b-1].add(age);
			Collections.sort(tree[a-1][b-1]);
		}
		
		/*-----------나무 위치 -------------*/
		
		
		for(int year =0; year<k;year++) {
			//봄
			spring_and_Summer();
			
			fall();
			
			winter();
		}
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(tree[i][j].size()>0)
					count=count+tree[i][j].size();
		
		System.out.println(count);
		
	}
	
	static void spring_and_Summer() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int index=0;
				//양분 먹기
				for(int k=0;k<tree[i][j].size();k++) {
					if(A[i][j]>=tree[i][j].get(k)) {
						A[i][j]-=tree[i][j].get(k);	//양분먹음
						tree[i][j].set(k, tree[i][j].get(k)+1);
						index++;
					}
					else break;
				}
				
				//나무 죽이기 - 여름(양분추가)
				for(int k=index;k<tree[i][j].size();k++) {
					A[i][j]+=tree[i][j].get(k)/2;
					tree[i][j].remove(k);
					k--;
				}
				Collections.sort(tree[i][j]);
				
			}
		}
	}
	
	static void fall() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				//번식하기
				for(int k=0;k<tree[i][j].size();k++) {
					if(tree[i][j].get(k)%5==0) {
						for(int a=0;a<8;a++) {
							int nextx = i+dx[a];
							int nexty = j+dy[a];
							
							if(nextx>=n || nexty>=n || nextx<0 || nexty<0)
								continue;
							
							tree[nextx][nexty].add(0, 1);
						}
					}
				}
			}
		}
	}
	
	//양분 추가
	static void winter() {		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				A[i][j] += originA[i][j];
			}
		}
	}
}

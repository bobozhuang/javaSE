package main.java.com.bobozhuang.day01;

public class PrintStar{
	public void printStar(){
		//首先用循环，打印五行内容
		for(int i = 0; i < 5 ; i++){
			for(int j = 0;j < i+1 ;j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public void tableOf99(){
		//控制循环9行
		//i 和每一行*后的数字是一致的
		for(int i = 1;i <= 9;i++){
		//for(int i = 9;i >= 1;i--){
			//控制每一行的循环
			//*前面的数字
			//循环空白部分
			for(int m = 9-i;m >=1 ; m--){
				System.out.print("    ");
			}
			for(int j = 1;j <= i  ;j++){
				if(i*j>=10){
					System.out.print
						(j+"*"+i+" ="+i*j+" ");
				}else{
					System.out.print
						(j+"*"+i+" = "+i*j+" ");
				}
			}
			System.out.println();
		}
	
	}
	public void test(){
		loop1:for(int i = 0;i < 10;i++){
			loop2:for(int j = 0;j < 5 ;j++){
				if(i==4)
					break loop1;
				System.out.print(i*j+" ");
			}
			System.out.println();
		}		
	
	}
	public static void main(String[] args){
		PrintStar ps = new PrintStar();
		ps.printStar();
		ps.tableOf99();
		ps.test();
	}
}

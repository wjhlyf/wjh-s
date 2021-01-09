package calculate_hundred;
import java.io.*;
import java.util.Scanner;
public class Calculate {

		public static String account;

		public static void main(String[] args) throws IOException {
			System.out.println("请输入用户:");
			Scanner sc = new Scanner(System.in);
			String account = sc.next();

			// 方法二，用正则表达式对账户的格式进行限制
			String regex = "\\p{Upper}\\p{Upper}\\d\\d\\d\\d";
			if (account.matches(regex)) {
				System.out.println("(1)开始测试\n(2)检查分数\n(3)退出");	
			} else {
				System.out.println("输入账号格式不正确!(ID 号包括两个大写字母和 4 位数字)\n请重新输入:");
			}
			student s = new student();
			// 选择选项，进入考试
			while (true) {
				int node = sc.nextInt();
				if (node == 1) {
					s.test();
					System.out.println("(1)开始测试\n(2)检查分数\n(3)退出");	
				} else if (node == 2) {
					s.check(account);
					System.out.println("(1)开始测试\n(2)检查分数\n(3)退出");	
				} else {
					System.exit(0);
				}
			}
		}
	}

	class student {
		public int count;
		int score = 0;
		long e=0;
		long k=0;
		// 定义测试内容,100以内的加减乘除
		public void test() {
			Scanner sc1 = new Scanner(System.in);
			int score = 0;
//			生成两个随机数进行计算
			String ops = "+-*/";//保存四种运算符
			String opLast="";//上一次的运算符
			String op="";	 //当前运算符
			String [] shows = new String[10];//定义保存题目用的数组
			int sum=0;//总分数
			e =  System.currentTimeMillis();//计时器记录开始时间
			//开始测试，共计十次
			for(int j=0;j<10;j++){
				//随机产生运算符
				do{
					int x=(int)(Math.random()*4);
					op=ops.substring(x,x+1);
				}while(op.equals(opLast));
				opLast=op;//保存当前运算符
				int a,b,c=0;
				 do{
					 a = (int)(Math.random()*100);//定义数字不超过100
					 b = (int)(Math.random()*100+1);
					 switch(op) {
					 case "+":
						 c=a+b;break;
					 case "-" :
						 c=a-b;break;
					 case "*":
						 c=a*b;break;
					 case "/" :
						 c=a/b;
						 //为了除法算式可以整除
						 if(a%b==0) {
						 break;}
						 else {
							 c=-1;//小技巧，相当于自动重新进入循环
						 }
					 }
				 }while(c>100||c<0);//设定c的取值范围为0~100
				 
				 //生成算式
				 String tmp=String.format("%2d",j+1)+". "+String.format("%2d", a);
				 tmp+=" "+op+" "+String.format("%2d",b)+" = ";
				 System.out.print(tmp);//显示题目
			
				 //用户答题
				 Scanner sc = new Scanner(System.in);
				 int answer = sc.nextInt();
				 String line = tmp+String.format("%5d",c)+String.format("%5d",answer);
				 shows[j]=line;//保存题目到数组
				 //统计分数
				 if(answer==c) {
					 sum+=10;
				 }
			}
			
			// c 计算用时
			k =  System.currentTimeMillis();

			//显示本次测验结果
			System.out.println("本次测验结果：");
			System.out.println("   问题      |  正确答案    | 你的答案");
			for(String s:shows)
				System.out.println(s);
			System.out.println("------------------------------");
			System.out.println("本次答题分数："+sum+" 用时："+(k-e)/1000+"秒\n");
			
			//保存测试结果到文件
			
			}		
		 
		
	//check方法检查分数，用字符流输入输出
		public void check(String account) throws IOException {
			File file=new File("F:\\test.txt");
	        if(!file.getParentFile().exists()){//必须保证父目录存在
	            file.getParentFile().mkdirs();//创建多级父目录
	        }
	        Writer out=new FileWriter(file,true);
	        out.write("账户:"+account+"	分数:"+score+"	所用时间:"+(k-e)/1000+"秒!\r\n");
	        out.close();
	        Reader in=new FileReader(file);

	        String history ;
	        Scanner file1=new Scanner(new File("F:\\test.txt"));
	        while(file1.hasNextLine()) {
	        	String temp=file1.nextLine();      	
	        	if(temp.indexOf(account)>= 0) {
	        		history = temp;
	        		System.out.println(history);
	        	}else {
	        		continue;
	        	}
	        	
	        	
	        }
	        in.close();
		}
	}


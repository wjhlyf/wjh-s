package calculate_hundred;
import java.io.*;
import java.util.Scanner;
public class Calculate {

		public static String account;

		public static void main(String[] args) throws IOException {
			System.out.println("�������û�:");
			Scanner sc = new Scanner(System.in);
			String account = sc.next();

			// ����������������ʽ���˻��ĸ�ʽ��������
			String regex = "\\p{Upper}\\p{Upper}\\d\\d\\d\\d";
			if (account.matches(regex)) {
				System.out.println("(1)��ʼ����\n(2)������\n(3)�˳�");	
			} else {
				System.out.println("�����˺Ÿ�ʽ����ȷ!(ID �Ű���������д��ĸ�� 4 λ����)\n����������:");
			}
			student s = new student();
			// ѡ��ѡ����뿼��
			while (true) {
				int node = sc.nextInt();
				if (node == 1) {
					s.test();
					System.out.println("(1)��ʼ����\n(2)������\n(3)�˳�");	
				} else if (node == 2) {
					s.check(account);
					System.out.println("(1)��ʼ����\n(2)������\n(3)�˳�");	
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
		// �����������,100���ڵļӼ��˳�
		public void test() {
			Scanner sc1 = new Scanner(System.in);
			int score = 0;
//			����������������м���
			String ops = "+-*/";//�������������
			String opLast="";//��һ�ε������
			String op="";	 //��ǰ�����
			String [] shows = new String[10];//���屣����Ŀ�õ�����
			int sum=0;//�ܷ���
			e =  System.currentTimeMillis();//��ʱ����¼��ʼʱ��
			//��ʼ���ԣ�����ʮ��
			for(int j=0;j<10;j++){
				//������������
				do{
					int x=(int)(Math.random()*4);
					op=ops.substring(x,x+1);
				}while(op.equals(opLast));
				opLast=op;//���浱ǰ�����
				int a,b,c=0;
				 do{
					 a = (int)(Math.random()*100);//�������ֲ�����100
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
						 //Ϊ�˳�����ʽ��������
						 if(a%b==0) {
						 break;}
						 else {
							 c=-1;//С���ɣ��൱���Զ����½���ѭ��
						 }
					 }
				 }while(c>100||c<0);//�趨c��ȡֵ��ΧΪ0~100
				 
				 //������ʽ
				 String tmp=String.format("%2d",j+1)+". "+String.format("%2d", a);
				 tmp+=" "+op+" "+String.format("%2d",b)+" = ";
				 System.out.print(tmp);//��ʾ��Ŀ
			
				 //�û�����
				 Scanner sc = new Scanner(System.in);
				 int answer = sc.nextInt();
				 String line = tmp+String.format("%5d",c)+String.format("%5d",answer);
				 shows[j]=line;//������Ŀ������
				 //ͳ�Ʒ���
				 if(answer==c) {
					 sum+=10;
				 }
			}
			
			// c ������ʱ
			k =  System.currentTimeMillis();

			//��ʾ���β�����
			System.out.println("���β�������");
			System.out.println("   ����      |  ��ȷ��    | ��Ĵ�");
			for(String s:shows)
				System.out.println(s);
			System.out.println("------------------------------");
			System.out.println("���δ��������"+sum+" ��ʱ��"+(k-e)/1000+"��\n");
			
			//������Խ�����ļ�
			
			}		
		 
		
	//check���������������ַ����������
		public void check(String account) throws IOException {
			File file=new File("F:\\test.txt");
	        if(!file.getParentFile().exists()){//���뱣֤��Ŀ¼����
	            file.getParentFile().mkdirs();//�����༶��Ŀ¼
	        }
	        Writer out=new FileWriter(file,true);
	        out.write("�˻�:"+account+"	����:"+score+"	����ʱ��:"+(k-e)/1000+"��!\r\n");
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


package shitou_jiandao_bu;

import java.awt.*; //������󴰿ڹ��������
import java.awt.event.*; //
import javax.swing.*; //

public class test extends JFrame implements ActionListener{
    JButton jiandao,shitou,bu,clear; //���� JButton ����
    JPanel pane12,panel1; //
    JLabel label; 
    public test() {
            setTitle("ʯͷ��������Ϸ"); //���ô�����⣬�޸ı���Ϊ��ʯͷ��������Ϸ����
            setLocation(250,250); //���ô������϶������ꣻ
            setSize(500,500); //���ô����С���޸Ĵ����СΪ��350��350��

            panel1 =new JPanel(); //
            panel1.setBackground(Color.yellow); //���ñ�����ɫ
            shitou = new JButton("ʯͷ"); //�½���ť
            jiandao =new JButton("����"); //�½���ť
            bu = new JButton("��"); //�½���ť
            clear = new JButton("���"); //�½���ť
            pane12=new JPanel(); //
            pane12.setBackground(Color.green); //������ɫ
            label =new JLabel("ѡ�������ʯͷ������ʼ��Ϸ"); //���⣬label

            shitou.addActionListener(this); //�� shitou ����¼���������
          
  bu.addActionListener(this); //ָ��ǰ��bu���󣬸�����Ӽ���
            jiandao.addActionListener(this); //
            clear.addActionListener(this); //

            panel1.add(shitou); //�� shitou �Ž� panel1 �У�
            panel1.add(jiandao); //
            panel1.add(bu); //
            panel1.add(clear); //
            pane12.add(label); //
            add(panel1,BorderLayout.NORTH); //����panel1��λ�ã��ϱ�north
            add(pane12,BorderLayout.CENTER); //������λ�����м�
}
//����һ�� ActionListener �ӿڷ����������°�ť�ͻ���ø÷��������Գ�Ϊ�¼���Ӧ����
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==shitou) 
            { 
//����㰴�µ��� shitou ����ʱ���ͻ�ִ�����²�����
               int i=((int)(Math.random()*10))%3;
 //����һ�� int �ͱ��� i������ Math.random()������ȡ���������Ϊ*10 �������������Ϊ[0,10)�����ǿ��ת��Ϊ int �ͣ��ٳ� 3 ȡ�࣬���ĸ�ֵ�� i��//
               switch(i) //i Ϊ 0 ʱ��ִ�� case 0 �������Դ����ƣ�
               {
                   case 0 :label.setText("���ʯͷ�����Գ�ʯͷ��ƽ�֣�");break; 
//�� i=0 ʱ��ִ�к����������� break ������������Ҫ��� break����Ȼ��һֱִ����ȥ����
                   case 1 :label.setText("���ʯͷ�����Գ����ӣ���ϲ��Ӯ�ˣ�");break;
 //�� i=1 ʱ������ͬ��
                   case 2 :label.setText("���ʯͷ�����Գ��������ź������ˣ�");break; 
//�� i=2 ʱ������ͬ��
            }}
            else if (e.getSource()==bu) { //����㰴�µ��� bu ����ʱ������ͬ��
	           int i=((int)(Math.random()*10))%3;
	           switch(i)
	        {
	              case 0 :label.setText("����������Գ�����ƽ�֣�");break;
	              case 1 :label.setText("����������Գ�ʯͷ����ϲ��Ӯ�ˣ�");break;
	              case 2 :label.setText("����������Գ����������ź������ˣ�");break;
	        }}
	        else if (e.getSource()==jiandao) { 
//���㰴�� jiandao ����ʱ������ͬ��
	           int i=((int)(Math.random()*10))%3;
	           switch(i)
	          {
	              case 0 :label.setText("������������Գ�������ƽ�֣�");break;
	              case 1 :label.setText("������������Գ�������ϲ��Ӯ�ˣ�");break;
	              case 2 :label.setText("������������Գ�ʯͷ�����ź������ˣ�");break;
	          }}
	        else if(e.getSource()==clear)
//���㰴�� clear ����ʱ��ֱ����� label.setText()��
	          { label.setText("ѡ�������ʯͷ������ʼ��Ϸ"); }
	}

	public static void main(String agrs[]) {
//���һ�����������Դ�����ʾ������в��ԣ�
	       test frame =new test(); //��ʼ���������
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���ô���رհ�ť��
	       frame.setVisible(true); //ʹ����ɼ���
	}}

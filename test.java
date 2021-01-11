package shitou_jiandao_bu;

import java.awt.*; //引入抽象窗口工具类包；
import java.awt.event.*; //
import javax.swing.*; //

public class test extends JFrame implements ActionListener{
    JButton jiandao,shitou,bu,clear; //定义 JButton 对象；
    JPanel pane12,panel1; //
    JLabel label; 
    public test() {
            setTitle("石头剪刀布游戏"); //设置窗体标题，修改标题为“石头剪刀布游戏”；
            setLocation(250,250); //设置窗体左上顶点坐标；
            setSize(500,500); //设置窗体大小，修改窗体大小为：350×350；

            panel1 =new JPanel(); //
            panel1.setBackground(Color.yellow); //设置背景颜色
            shitou = new JButton("石头"); //新建按钮
            jiandao =new JButton("剪刀"); //新建按钮
            bu = new JButton("布"); //新建按钮
            clear = new JButton("清空"); //新建按钮
            pane12=new JPanel(); //
            pane12.setBackground(Color.green); //设置颜色
            label =new JLabel("选择剪刀、石头、布开始游戏"); //标题，label

            shitou.addActionListener(this); //给 shitou 添加事件监听器；
          
  bu.addActionListener(this); //指向当前的bu对象，给其添加监听
            jiandao.addActionListener(this); //
            clear.addActionListener(this); //

            panel1.add(shitou); //把 shitou 放进 panel1 中；
            panel1.add(jiandao); //
            panel1.add(bu); //
            panel1.add(clear); //
            pane12.add(label); //
            add(panel1,BorderLayout.NORTH); //设置panel1的位置，上边north
            add(pane12,BorderLayout.CENTER); //设置其位置在中间
}
//定义一个 ActionListener 接口方法，当按下按钮就会调用该方法，可以称为事件响应器；
    public void actionPerformed(ActionEvent e) {
            if(e.getSource()==shitou) 
            { 
//如果你按下的是 shitou 按键时，就会执行以下操作；
               int i=((int)(Math.random()*10))%3;
 //定义一个 int 型变量 i，利用 Math.random()函数获取随机数，因为*10 所以随机数区间为[0,10)，最后强制转换为 int 型，再除 3 取余，最后的赋值给 i；//
               switch(i) //i 为 0 时就执行 case 0 操作，以此类推；
               {
                   case 0 :label.setText("你出石头，电脑出石头，平局！");break; 
//当 i=0 时，执行后续操作，到 break 结束；（必须要添加 break，不然会一直执行下去）；
                   case 1 :label.setText("你出石头，电脑出剪子，恭喜你赢了！");break;
 //当 i=1 时，与上同理；
                   case 2 :label.setText("你出石头，电脑出布，很遗憾你输了！");break; 
//当 i=2 时，与上同理；
            }}
            else if (e.getSource()==bu) { //如果你按下的是 bu 按键时，与上同理；
	           int i=((int)(Math.random()*10))%3;
	           switch(i)
	        {
	              case 0 :label.setText("你出布，电脑出布，平局！");break;
	              case 1 :label.setText("你出布，电脑出石头，恭喜你赢了！");break;
	              case 2 :label.setText("你出布，电脑出剪刀，很遗憾你输了！");break;
	        }}
	        else if (e.getSource()==jiandao) { 
//当你按下 jiandao 按键时，与上同理；
	           int i=((int)(Math.random()*10))%3;
	           switch(i)
	          {
	              case 0 :label.setText("你出剪刀，电脑出剪刀，平局！");break;
	              case 1 :label.setText("你出剪刀，电脑出布，恭喜你赢了！");break;
	              case 2 :label.setText("你出剪刀，电脑出石头，很遗憾你输了！");break;
	          }}
	        else if(e.getSource()==clear)
//当你按下 clear 按键时，直接输出 label.setText()；
	          { label.setText("选择剪刀、石头、布开始游戏"); }
	}

	public static void main(String agrs[]) {
//添加一个主函数，对窗体显示情况进行测试；
	       test frame =new test(); //初始化窗体对象；
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //设置窗体关闭按钮；
	       frame.setVisible(true); //使窗体可见；
	}}

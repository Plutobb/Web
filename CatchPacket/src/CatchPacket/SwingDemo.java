package CatchPacket;

import javax.swing.*;

public class SwingDemo
{
    public  static void createGUI()
    {

        //创建一个窗口，创建一个窗口
        myFrame frame = new myFrame("协议分析");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口大小
        frame.setSize(700, 550);
        frame.setBounds(100, 100, 600, 500);
        frame.setVisible(true);
    }

}
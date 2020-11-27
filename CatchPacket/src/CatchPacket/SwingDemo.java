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
//        JPanel contentPane = new JPanel();
//        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        frame.setContentPane(contentPane);
//        contentPane.setLayout(null);
        //显示窗口
        frame.setVisible(true);
    }

}
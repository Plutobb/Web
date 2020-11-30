package CatchPacket;

import javax.swing.*;
import java.awt.*;

import static CatchPacket.CatchPacket.*;
public class myFrame extends JFrame {
    //JLabel label = new JLabel("                                      网    卡    信    息 ：                                                                                                                                        ");
    JTextField textFieldd = new JTextField("                                                                                                      网    卡    信    息                                                                                                     ");
    JLabel label11 = new JLabel("     网 络  设 备  接 口  个 数： ");
    JTextField textField11 = new JTextField(arr1[0]+"                                      ");
    JLabel label22 = new JLabel("          设  备  接  口： ");
    JTextField textField22 = new JTextField(arr1[1]+"                                                                     ");
    JLabel label33 = new JLabel("        网 络  接 口 名 称：   ");
    JTextField textField33 = new JTextField(arr1[2]+"");
    JLabel label44 = new JLabel("   网 络  接 口 描 述：");
    JTextField textField44 = new JTextField(arr1[3]+"");
    JLabel label55 = new JLabel("   数 据链路 层 描 述 ：   ");
    JTextField textField55 = new JTextField(arr1[4]+"                                                                     ");
    JLabel label66 = new JLabel("   数 据  链 路 层  描 述：");
    JTextField textField66 = new JTextField(arr1[5]+"                    ");
    JLabel label77 = new JLabel("是 否 是  LOOPBACK  设 备：");
    JTextField textField77 = new JTextField(arr1[6]+"                       ");
    JLabel label88 = new JLabel("   MAC  地 址：");
    JTextField textField88 = new JTextField(arr1[7]+"                ");

    JLabel labell = new JLabel("                                        IP      分     析          ：");
    JTextField textField = new JTextField("                                                                                                      IP  分  析                                                                                                                ");
    JLabel label1 = new JLabel("      IP版本 ：");
    JTextField textField1 = new JTextField(arr[0]+"                                 ");
    JLabel label2 = new JLabel("         区分服务：  ");
    JTextField textField2 = new JTextField(arr[1]+"                                 ");
    JLabel label3 = new JLabel("         优先级：   ");
    JTextField textField3 = new JTextField(arr[2]+"                                 ");
    JLabel label4 = new JLabel("        总长度：  ");
    JTextField textField4 = new JTextField(arr[3]+"                                ");
    JLabel label5 = new JLabel("       标志： ");
    JTextField textField5 = new JTextField(arr[4]+"                                ");
    JLabel label6 = new JLabel("       标识：   ");
    JTextField textField6 = new JTextField(arr[5]+"                                ");
    JLabel label7 = new JLabel("          片偏移     ：  ");
    JTextField textField7 = new JTextField(arr[6]+"                       ");
    JLabel label8 = new JLabel("        生存时间：   ");
    JTextField textField8 = new JTextField(arr[7]+"                          ");
    JLabel label9 = new JLabel("     协议：   ");
    JTextField textField9 = new JTextField(arr[8]+"                                          ");
    JLabel label10 = new JLabel("                  源地址：    ");
    JTextField textField10 = new JTextField(arr[9]+"                                                                                                                           ");
    JLabel label101 = new JLabel("                目的地址：   ");
    JTextField textField101 = new JTextField(arr[10]+"                                                                                                                                                    ");
    JLabel label12 = new JLabel("  选项：     ");
    JTextField textField12 = new JTextField(arr[11]+"                                                                                                                                   ");

    //JLabel labelll = new JLabel("                                        TCP      分     析          ：");
    JTextField textFielddd = new JTextField("                                                                                                                             T C P   分  析                                                                                                                                             ");
    JLabel label111 = new JLabel("         源 端 口：    ");
    JTextField textField111 = new JTextField(arr2[0]+"                                                       ");
    JLabel label222 = new JLabel("           目 的 端 口：    ");
    JTextField textField222 = new JTextField(arr2[1]+"                                                       ");
    JLabel label333 = new JLabel("           序 号：    ");
    JTextField textField333 = new JTextField(arr2[2]+"                                                                                                                                   ");
    JLabel label444 = new JLabel("                              确   认   号：   ");
    JTextField textField444 = new JTextField(arr2[3]+"                                                                                                                             ");
    JLabel label555 = new JLabel("                          URG：   ");
    JTextField textField555 = new JTextField(arr2[4]+"");
    JLabel label666 = new JLabel("ACK:");
    JTextField textField666 = new JTextField(arr2[5]+"");
    JLabel label777 = new JLabel("PSH：");
    JTextField textField777 = new JTextField(arr2[6]+"");
    JLabel label888 = new JLabel("RST：");
    JTextField textField888 = new JTextField(arr2[7]+"");
    JLabel label999 = new JLabel("SYN：");
    JTextField textField999 = new JTextField(arr2[8]+"");
    JLabel label101010 = new JLabel("FIN：");
    JTextField textField101010 = new JTextField(arr2[9]+"");
    JLabel label111111 = new JLabel("窗  口：");
    JTextField textField111111 = new JTextField(arr2[10]+"");
    JLabel label121212 = new JLabel("                     紧 急 指 针：");
    JTextField textField121212 = new JTextField(arr2[11]+"                          ");
    JLabel label131313 = new JLabel("                   选      项：");
    JTextField textField131313 = new JTextField(arr2[12]+"                                   ");

    JTextField textFieldddd = new JTextField("                                                                                                                             UDP   分  析                                                                                                                                             ");
    JLabel label1111 = new JLabel("源端口：");
    JTextField textField1111 = new JTextField(arr3[0]+"");
    JLabel label2222 = new JLabel("目的端口：");
    JTextField textField2222 = new JTextField(arr3[1]+"");
    JLabel label3333 = new JLabel("长度：");
    JTextField textField3333 = new JTextField(arr3[2]+"");


    //构造函数
    public myFrame(String title)
    {
        //继承父类，
        super(title);
        //内容面板
        Container contentPane = getContentPane();
        contentPane.setLayout(new FlowLayout());
        //添加控件
        //contentPane.add(label);
        contentPane.add(textFieldd);
        contentPane.add(label11);
        contentPane.add(textField11);

        contentPane.add(label22);
        contentPane.add(textField22);
        contentPane.add(label33);
        contentPane.add(textField33);
        contentPane.add(label44);
        contentPane.add(textField44);
        contentPane.add(label55);
        contentPane.add(textField55);
        contentPane.add(label66);
        contentPane.add(textField66);
        contentPane.add(label77);
        contentPane.add(textField77);
        contentPane.add(label88);
        contentPane.add(textField88);

        //contentPane.add(labell);
        contentPane.add(textField);
        contentPane.add(label1);
        contentPane.add(textField1);
        contentPane.add(label2);
        contentPane.add(textField2);
        contentPane.add(label3);
        contentPane.add(textField3);
        contentPane.add(label4);
        contentPane.add(textField4);
        contentPane.add(label5);
        contentPane.add(textField5);
        contentPane.add(label6);
        contentPane.add(textField6);
        contentPane.add(label7);
        contentPane.add(textField7);
        contentPane.add(label8);
        contentPane.add(textField8);
        contentPane.add(label9);
        contentPane.add(textField9);
        contentPane.add(label10);
        contentPane.add(textField10);
        contentPane.add(label101);
        contentPane.add(textField101);
        contentPane.add(label12);
        contentPane.add(textField12);

        //contentPane.add(labelll);
        contentPane.add(textFielddd);
        contentPane.add(label111);
        contentPane.add(textField111);
        contentPane.add(label222);
        contentPane.add(textField222);
        contentPane.add(label333);
        contentPane.add(textField333);
        contentPane.add(label444);
        contentPane.add(textField444);
        contentPane.add(label555);
        contentPane.add(textField555);
        contentPane.add(label666);
        contentPane.add(textField666);
        contentPane.add(label777);
        contentPane.add(textField777);
        contentPane.add(label888);
        contentPane.add(textField888);
        contentPane.add(label999);
        contentPane.add(textField999);
        contentPane.add(label101010);
        contentPane.add(textField101010);
        contentPane.add(label111111);
        contentPane.add(textField111111);
        contentPane.add(label121212);
        contentPane.add(textField121212);
        contentPane.add(label131313);
        contentPane.add(textField131313);

        contentPane.add(textFieldddd);
        contentPane.add(label1111);
        contentPane.add(textField1111);
        contentPane.add(label2222);
        contentPane.add(textField2222);
        contentPane.add(label3333);
        contentPane.add(textField3333);

    }
}

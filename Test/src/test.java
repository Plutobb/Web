import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

import javax.swing.*;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class test extends JFrame{
    public test() {
        setBounds(100,100,600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c=getContentPane();
        c.setLayout(null);
        JComboBox<String> comboBox=new JComboBox<>();
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();
        for (NetworkInterface n : devices) {
            comboBox.addItem(n.name);
        }
        JLabel l = new JLabel("选择网卡");


        //serBounds(x,y,width,height);
        l.setBounds(10, 10, 80, 20);
        c.add(l);
        JButton btn =new JButton("开始");
        JButton btn1 =new JButton("退出");
        JTextArea area=new JTextArea();
        area.setLineWrap(true);
        JScrollPane js=new JScrollPane(area);
        js.setBounds(10, 80, 500, 350);
        c.add(js);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JpcapCaptor jpcap =null;
                int caplen = 65535;
                boolean promiscCheck = true;
                try {
                    jpcap = JpcapCaptor.openDevice(devices[comboBox.getSelectedIndex()], caplen, promiscCheck, 50);

                    //Promisc：设置是否混杂模式。处于混杂模式将接收所有数据包
                    //caplen限制每一次收到一个数据包，只提取该数据包中前多少字节
                    //50这个参数主要用于processPacket()方法，指定超时的时间?
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                /*----------第二步抓包-----------------*/
                int i = 0;
                while (i < 1) {
                    Packet packet = jpcap.getPacket();

                    if (packet instanceof IPPacket && ((IPPacket) packet).version == 4) {
                        i++;

                        IPPacket ip = (IPPacket) packet;// 强转
                        HexBinaryAdapter hba=new HexBinaryAdapter();
                        String str=hba.marshal(packet.header);
                        area.append("\n头部: " +hba.marshal(packet.header));
                        area.append("\n数据: " +hba.marshal(packet.data));
                        area.append("\n版本：IPv4");
                        area.append("\n首部长度："+str.substring(29, 30));
                        area.append("\n区分服务：最大的吞吐量： " + ip.t_flag);
                        area.append("\n区分服务：最高的可靠性：" + ip.r_flag);
                        area.append("\n总长度：" + ip.length);
                        area.append("\n标识：" + ip.ident);
                        area.append("\nDF:Don't Fragment: " + ip.dont_frag);
                        area.append("\nMF:More Fragment: " + ip.more_frag);
                        area.append("\n优先权：" + ip.priority);
                        area.append("\n片偏移：" + ip.offset);
                        area.append("\n生存时间：" + ip.hop_limit);
                        area.append("\n首部检验和："+str.substring(48,52));
                        area.append("\n源IP " + ip.src_ip.getHostAddress());
                        area.append("\n目的IP " + ip.dst_ip.getHostAddress());
                        area.append("\n源主机名： " + ip.src_ip.getHostName());
                        area.append("\n目的主机名： " + ip.dst_ip.getHostName());
                        String protocol = "";
                        switch (new Integer(ip.protocol)) {
                            case 1:
                                protocol = "ICMP";
                                break;
                            case 2:
                                protocol = "IGMP";
                                break;
                            case 6:
                                protocol = "TCP";
                                break;
                            case 8:
                                protocol = "EGP";
                                break;
                            case 9:
                                protocol = "IGP";
                                break;
                            case 17:
                                protocol = "UDP";
                                break;
                            case 41:
                                protocol = "IPv6";
                                break;
                            case 89:
                                protocol = "OSPF";
                                break;
                            default:
                                break;
                        }
                        area.append("\n协议：" + protocol);
                        if(protocol=="TCP")
                        {TCPPacket tcp = (TCPPacket) packet;
                            area.append("\n源端口：" + tcp.src_port);
                            area.append("\n目的端口：" + tcp.dst_port);
                            area.append("\n序号：" + tcp.sequence);
                            area.append("\n确认号：" + tcp.ack_num);
                            area.append("\n紧急指针：" + tcp.urgent_pointer);
                            area.append("\n终止fin:" + tcp.fin);
                            area.append("\n窗口：" + tcp.window);
                        }
                        else if(protocol=="UDP")
                        {
                            UDPPacket udp = (UDPPacket) packet;
                            area.append("\n源端口：" + udp.src_port);
                            area.append("\n目的端口：" + udp.dst_port);
                            area.append("\n长度：" +udp.length );
                        }
                    }
                }
            }
        });
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btn.setBounds(180, 50, 60, 20);
        btn1.setBounds(350, 50, 60, 20);
        c.add(btn);
        c.add(btn1);
        comboBox.setBounds(100, 10, 400, 21);
        c.add(comboBox);
        setVisible(true);
    }

    public static class staticParent{
        public  void staticFather(){
            System.out.println("父类的静态方法");
        }
    }

    public static class staticSon extends staticParent{
        @Override
        public  void staticFather(){
            System.out.println("子类重写的静态方法");
        }
    }

    public static void main(String[] args) {
//        char ch = '中';
//        System.out.println(ch);
//        ok:
//        for (int i = 0; i < 10; i++) {
//            for (int i1 = 0; i1 < 10; i1++) {
//                System.out.println(1);
//                    break ok;
//            }
//        }
        staticSon staticSon = new staticSon();
        staticSon.staticFather();
    }
}

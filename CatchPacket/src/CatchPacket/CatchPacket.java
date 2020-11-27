package CatchPacket;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.PacketReceiver;
import jpcap.packet.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class CatchPacket implements PacketReceiver,Runnable
{
    public NetworkInterface[] devices;
    public NetworkInterface device;
    public JpcapCaptor jCaptor;
    public LinkedList<Packet> packets = new LinkedList();
    public static StringBuffer sb = new StringBuffer();
    public static String arr[]=new String[13];
    public static String arr1[]=new String[8];
    public static String arr2[]=new String[13];
    public static String arr3[]=new String[3];
    // 获得网络接口list
    public NetworkInterface[] getDevices()
    {
        devices = JpcapCaptor.getDeviceList();
        return devices;
    }

    // 获得网卡接口list描述

    public void desNetworkInterface()
    {
        sb.append("************************网卡信息****************************************\n");
        sb.append("总共有 " + devices.length + " 个网络设备接口\n");
        arr1[0]=devices.length+"";
        int i;
        for ( i= 0; i < devices.length; i++)
        {
            sb.append("设备接口:" + (i + 1) + "\n");
            arr[1]=(i + 1)+"";
            sb.append("网络接口名称:" + devices[1].name+"\n");
            arr1[2]=devices[1].name+"";
            // 选中一个网卡接口进行监听
            if (!(devices[1].name.contains("GenericDialupAdapter")))
            {
               device = devices[1];

            }
            sb.append("网络接口描述:" + devices[1].description+"\n");
            arr1[3]=devices[1].description+"";
            sb.append("数据链路层描述:" + devices[1].datalink_name+"\n");
            arr1[4]=devices[1].datalink_name;
            sb.append("数据链路层描述:" + devices[1].datalink_description+"\n");
            arr1[5]=devices[1].datalink_description;
            sb.append("是否是LOOPBACK设备:" + devices[1].loopback+"\n");
            arr1[6]=devices[1].loopback+"";
            sb.append("MAC地址:");
            /*
            int flag = 0;
            for (byte b : devices[i].mac_address)
            {
                flag++;
                if (flag < devices[i].mac_address.length)
                {
                    sb.append(Integer.toHexString(b & 0xff) + ":");
                    arr1[7]=(Integer.toHexString(b & 0xff) + ":");
                } else
                    sb.append(Integer.toHexString(b & 0xff)+"\n");
                    arr1[7]=(Integer.toHexString(b & 0xff)+"\n");
            }
             */
            byte b[]=devices[1].mac_address;
            String str="";
            int a = 0;
            for (int j = 0; j < b.length; j++) {
                // byte变成int时，根据最高位进行填充，如1100 1100变成1111...1100 1100,即cc变成-52
                a = b[j];
                a = a << 24;
                a = a >>> 24;
                if (j != b.length-1) {
                    str += Integer.toHexString(a)+":";
                } else {
                    str += Integer.toHexString(a);
                }
            }
            sb.append(str+"\n");
            arr1[7]=(str+"\n");
        }

        sb.append("**********************************************************************\n");
        System.out.println(sb);
    }

    // 获得某个网卡接口的连接
    /**
     *
     * @param nInterface    选择的网卡接口
     * @param mixMode       是否设置网卡为混乱模式
     * @param filter        包类型 过滤器
     */
    public void getCap(NetworkInterface nInterface, boolean mixMode,String filter)
    {
        try
        {   /*
            打开一个网络接口设备,得到一个JpcapCaptor实例 用于抓包
            参数信息 ：
            1.想要打开的网卡设备信息
            2.一次捕捉包的最大字节
            3.是否设置网卡为混乱模式
            4.抓包超时时间
            */
            jCaptor = JpcapCaptor.openDevice(nInterface, 2048, mixMode, 5000);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // 设置过滤器
    public void setFilter(String filter)
    {
        try
        {
            jCaptor.setFilter(filter, true);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    // 设置抓包模式开始抓包
    public void beginCatch()
    {
        /*
        参数信息:
        1.抓包个数
        2.包的提供者:当期包
         */
        jCaptor.processPacket(1, this);
    }

    // 结束抓包
    public void endCatch()
    {
        if (jCaptor != null)
        {
            jCaptor.breakLoop();
        }
    }
    //分析包
    public void analysis(Packet packet) {
        sb.append("------包分析-------\n");
        sb.append("捕获长度:"+packet.caplen+" byte\n");
        sb.append("包长度:"+packet.len+" byte\n");
        sb.append("包的头部:"+Arrays.toString(packet.header)+"\n");
        sb.append("头部的长度:"+packet.header.length+" byte\n");
        sb.append("数据:"+Arrays.toString(packet.data)+"\n");
        sb.append("数据长度:"+packet.data.length+" byte\n");
        sb.append("---以太网头部信息---\n");
        DatalinkPacket dPacket = packet.datalink;
        if(dPacket instanceof EthernetPacket)
        {    //分析以太网帧
            EthernetPacket ePacket = (EthernetPacket)dPacket;
            sb.append("src_mac:");
            int flag1 = 0;
            for(byte b:ePacket.src_mac)
            {
                flag1++;
                if(flag1<ePacket.src_mac.length)
                {
                    sb.append(Integer.toHexString(b & 0xff)+":");
                }
                else{
                    sb.append(Integer.toHexString(b & 0xff) + "\n");
                }
            }
            sb.append("dst_mac:");
            int flag2 = 0;
            for(byte b:ePacket.dst_mac)
            {
                flag2++;
                if(flag2<ePacket.dst_mac.length)
                {
                    sb.append(Integer.toHexString(b & 0xff)+":");

                }else{
                    sb.append(Integer.toHexString(b & 0xff)+"\n");
                }
            }
            sb.append("帧类型:"+Integer.toHexString(ePacket.frametype & 0xffff)+"\n");
            sb.append("*************************************************************\n");
        } else {
            sb.append(dPacket+"\n");
            sb.append("*************************************************************\n");
        }
        if(packet instanceof IPPacket){
            //分析IP
            IPPacket iPacket = (IPPacket)packet;
            sb.append("---IP版本(版本): " + iPacket.version + " ---\r\n");
            arr[0]=iPacket.version+"";

            sb.append("Type of service(区分服务):" + iPacket.rsv_tos + "\r\n");
            arr[1] = iPacket.rsv_tos + "";
            sb.append("Priprity(优先级):" + iPacket.priority + "\r\n");
            arr[2] = iPacket.priority + "";
            sb.append("Packet Length(总长度):" + iPacket.length + "\r\n");
            arr[3] = iPacket.length + "";
            sb.append("Identification(标志):" + iPacket.ident + "\r\n");
            arr[4] = iPacket.ident + "";
            sb.append("rsv_frag(有无碎片标识):" + iPacket.rsv_frag + "\r\n");
            //sb.append("Don't Frag(标志字段中间的一位) " + iPacket.dont_frag + "\r\n");
            arr[5] = iPacket.rsv_frag + "";
            //sb.append("More Frag(标志字段中的最低位为) " + iPacket.more_frag + "\r\n");
            //arr[6]=iPacket.more_frag+"";
            sb.append("Frag Offset(片偏移):" + iPacket.offset + "\r\n");
            arr[6] = iPacket.offset + "";
            sb.append("Time to Live(生存时间):" + iPacket.hop_limit + "\r\n");
            arr[7] = iPacket.hop_limit + "";
            sb.append("Protocol(协议):" + iPacket.protocol + "        (TCP = 6; UDP = 17)\r\n");
            arr[8] = iPacket.protocol + "";
            sb.append("Source address(源地址):" + iPacket.src_ip.toString() + "\r\n");
            arr[9] = iPacket.src_ip.toString();
            sb.append("Destination address(目标地址):" + iPacket.dst_ip.toString() + "\r\n");
            arr[10] = iPacket.dst_ip.toString();
            sb.append("Options(选项):" + iPacket.option + "\r\n");
            arr[11] = iPacket.option + "";
            sb.append("------------------\r\n");
        }

        //分析TCP协议
        if(packet instanceof TCPPacket) {

            sb.append("---TCP---\r\n");

            TCPPacket tPacket = (TCPPacket) packet;

            sb.append("Source Port(源端口):" + tPacket.src_port + "\r\n");
            arr2[0]=tPacket.src_port+"";
            sb.append("Destination Port(目的端口):" + tPacket.dst_port + "\r\n");
            arr2[1]=tPacket.dst_port+"";
            sb.append("Sequence Number(序号):" + tPacket.sequence + "\r\n");
            arr2[2]=tPacket.ack_num+"";
            sb.append("Acknowledge Number(确认号):" + tPacket.ack_num + "\r\n");
            arr2[3]=tPacket.ack_num+"";
            sb.append("URG:" + tPacket.urg + "\r\n");
            arr2[4]=tPacket.urg+"";
            sb.append("ACK:" + tPacket.ack + "\r\n");
            arr2[5]=tPacket.ack+"";
            sb.append("PSH:" + tPacket.psh + "\r\n");
            arr2[6]=tPacket.psh+"";
            sb.append("RST:" + tPacket.rst + "\r\n");
            arr2[7]=tPacket.rst+"";
            sb.append("SYN:" + tPacket.syn + "\r\n");
            arr2[8]=tPacket.syn+"";
            sb.append("FIN:" + tPacket.fin + "\r\n");
            arr2[9]=tPacket.fin+"";
            sb.append("Window Size(窗口):" + tPacket.window + "\r\n");
            arr2[10]=tPacket.window+"";
            sb.append("Urgent Pointer(紧急指针):" + tPacket.urgent_pointer + "\r\n");
            arr2[11]=tPacket.urgent_pointer+"";
            sb.append("Option(选项):" + tPacket.option + "\r\n");
            arr2[12]=tPacket.option+"";
            sb.append("------------------\r\n");
        }

        if(packet instanceof UDPPacket){      //分析UDP协议

            sb.append("---UDP---\n");

            UDPPacket uPacket = (UDPPacket)packet;

            sb.append("Source Port:"+uPacket.src_port+"\n");
            arr3[0]=uPacket.src_port+"";
            sb.append("Destination Port:"+uPacket.dst_port+"\n");
            arr3[1]=uPacket.dst_port+"";
            sb.append("Length:"+uPacket.length+"\n");
            arr3[2]=uPacket.length+"";
            sb.append("------------------\n");

        }


        if(packet instanceof ARPPacket){               //分析ARP协议

            sb.append("---ARP---\n");

            ARPPacket aPacket = (ARPPacket)packet;

            sb.append("硬件类型："+aPacket.hardtype+"\n");

            sb.append("协议类型："+aPacket.prototype+"\n");

            sb.append("硬件地址长度："+aPacket.hlen+"\n");

            sb.append("协议地址长度："+aPacket.plen+"\n");

            sb.append("Operation："+aPacket.operation+"\n");

            sb.append("发送者硬件地址："+aPacket.sender_hardaddr+"\n");

            sb.append("发送者协议地址："+aPacket.sender_protoaddr+"\n");

            sb.append("目标硬件地址："+aPacket.target_hardaddr+"\n");

            sb.append("目标协议地址："+aPacket.target_protoaddr+"\n");

            sb.append("------------------\n");

        }


    }

    public void receivePacket(Packet packet)
    {
        packets.add(packet);
        analysis(packet);
    }

    public void run() {
        int count=1;
        int i=0;
        while (count>0){
            beginCatch();

            System.out.print(sb.toString());
            System.out.println(Arrays.toString(arr));
            System.out.println(Arrays.toString(arr1));
            System.out.println(Arrays.toString(arr2));
            System.out.println(Arrays.toString(arr3));
            //if(sb.toString()!="") break;
            count --;
        }
    }

    public static void main(String[] args)
    {
        CatchPacket cPacket = new CatchPacket();
        cPacket.devices = cPacket.getDevices();
        cPacket.desNetworkInterface();
        cPacket.getCap(cPacket.device, true, "");
        Thread thread = new Thread(cPacket);
        sb.delete(0, sb.length());
        thread.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {


                SwingDemo.createGUI();


            }
        });
    }
}
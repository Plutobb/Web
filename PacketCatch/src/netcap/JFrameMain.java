package netcap;

import jpcap.packet.IPPacket;
import jpcap.packet.Packet;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Vector;

/**
 * This code was edited or generated using CloudGarden's Jigloo
 * SWT/Swing GUI Builder, which is free for non-commercial
 * use. If Jigloo is being used commercially (ie, by a corporation,
 * company or business for any purpose whatever) then you
 * should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details.
 * Use of Jigloo implies acceptance of these licensing terms.
 * A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
 * THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
 * LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class JFrameMain extends javax.swing.JFrame implements ActionListener{

    private JMenuItem exitMenuItem;
    private JSeparator jSeparator2;
    private JMenuItem saveAsMenuItem;
    private JMenuItem saveMenuItem;
    private JMenuItem stopMenuItem;
    private JMenuItem startMenuItem;
    private JMenu Menu;
    private JMenuBar jMenuBar1;

    JTable tabledisplay = null;
    Vector rows,columns;
    DefaultTableModel tabModel;
    JScrollPane scrollPane;
    JLabel statusLabel;

    NetCaptor captor = new NetCaptor();

    /**
     * Auto-generated main method to display this JFrame
     */
    public static void main(String[] args) {
        JFrameMain inst = new JFrameMain();
        inst.setVisible(true);
    }

    public JFrameMain() {
        super();
        initGUI();
    }

    private void initGUI() {
        try {
            setSize(400, 300);
            {
                jMenuBar1 = new JMenuBar();
                setJMenuBar(jMenuBar1);
                {
                    Menu = new JMenu();
                    jMenuBar1.add(Menu);
                    Menu.setText("/u6293/u5305");
                    Menu.setPreferredSize(new java.awt.Dimension(35, 21));
                    {
                        startMenuItem = new JMenuItem();
                        Menu.add(startMenuItem);
                        startMenuItem.setText("开始");
                        startMenuItem.setActionCommand("start");
                        startMenuItem.addActionListener(this);
                    }
                    {
                        stopMenuItem = new JMenuItem();
                        Menu.add(stopMenuItem);
                        stopMenuItem.setText("停止");
                        stopMenuItem.setActionCommand("stop");
                        stopMenuItem.addActionListener(this);
                    }
                    {
                        saveMenuItem = new JMenuItem();
                        Menu.add(saveMenuItem);
                        saveMenuItem.setText("保存");
                    }
                    {
                        saveAsMenuItem = new JMenuItem();
                        Menu.add(saveAsMenuItem);
                        saveAsMenuItem.setText("保存为 ...");
                    }
                    {
                        jSeparator2 = new JSeparator();
                        Menu.add(jSeparator2);
                    }
                    {
                        exitMenuItem = new JMenuItem();
                        Menu.add(exitMenuItem);
                        exitMenuItem.setText("Exit");
                        exitMenuItem.setActionCommand("exit");
                        exitMenuItem.addActionListener(this);
                    }
                }
            }

            rows=new Vector();
            columns= new Vector();

            columns.addElement("数据报时间");
            columns.addElement("源IP地址");
            columns.addElement("目的IP地址");
            columns.addElement("首部长度");
            columns.addElement("数据长度");
            columns.addElement("是否分段");
            columns.addElement("分段偏移量");
            columns.addElement("首部内容");
            columns.addElement("数据内容");


            tabModel=new DefaultTableModel();
            tabModel.setDataVector(rows,columns);
            tabledisplay = new JTable( tabModel );
            scrollPane= new JScrollPane(tabledisplay);
            this.getContentPane().add( new JScrollPane(tabledisplay),BorderLayout.CENTER);

            statusLabel=new JLabel("网络一班 张洪宝 07");
            this.getContentPane().add(statusLabel,BorderLayout.SOUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent event){
        String cmd=event.getActionCommand();

        if(cmd.equals("start")){
            captor.capturePacketsFromDevice();
            captor.setJFrame(this);
        }
        else if(cmd.equals("stop")){
            captor.stopCapture();
        }
        else if(cmd.equals("exit")){
            System.exit(0);
        }
    }

    public void dealPacket( Packet packet )
    {
        try
        {
            Vector r=new Vector();
            String strtmp;
            Timestamp timestamp = new Timestamp((packet.sec * 1000) + (packet.usec / 1000));

            r.addElement( timestamp.toString() ); //数据报时间
            r.addElement(((IPPacket)packet).src_ip.toString());    //源IP地址
            r.addElement(((IPPacket)packet).dst_ip.toString());    //目的IP地址
            r.addElement( packet.header.length );   //首部长度
            r.addElement( packet.data.length );             //数据长度
            r.addElement( ((IPPacket)packet).dont_frag == true ? "分段" : "不分段" );                          //是否不分段
            r.addElement( ((IPPacket)packet).offset );          //数据长度

            strtmp = "";
            for(int i=0;i<packet.header.length;i++){
                strtmp += Byte.toString(packet.header[i]);
            }
            r.addElement(strtmp);    //首部内容

            strtmp = "";
            for(int i=0;i<packet.data.length;i++){
                strtmp += Byte.toString(packet.data[i]);
            }
            r.addElement(strtmp);    //数据内容

            rows.addElement(r);
            tabledisplay.addNotify();
        }
        catch( Exception e)
        {

        }
    }
}

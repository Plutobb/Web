package netcap;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
public class Jcapturedialog extends javax.swing.JDialog implements ActionListener {

    /**
     * Auto-generated main method to display this JDialog
     */
    static JpcapCaptor jpcap=null;
    private JRadioButton wholeRadioButton;
    private JPanel buttonPanel;
    private JButton cancelButton;
    private JButton okButton;
    private JRadioButton userRadioButton;
    private JRadioButton headRadioButton;
    private JPanel netPanel;
    private JTextField caplenTextField;
    private JPanel caplenPanel;
    private JTextField TextField;
    private JPanel filterPanel;
    private JCheckBox CheckBox;
    private JComboBox netJComboBox;
    private JPanel jPanel_east;
    private JPanel jPanel_west;

    NetworkInterface[] devices;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Jcapturedialog inst = new Jcapturedialog(frame);
        inst.setVisible(true);
    }

    public Jcapturedialog(JFrame frame) {
        super(frame,"选择要检测的网卡并设置参数",true);

        try {
            BoxLayout thisLayout = new BoxLayout(
                    getContentPane(),
                    javax.swing.BoxLayout.X_AXIS);
            getContentPane().setLayout(thisLayout);
            {
                jPanel_west = new JPanel();
                jPanel_west.setLayout(new BoxLayout(jPanel_west,BoxLayout.Y_AXIS));
                getContentPane().add(jPanel_west);
                {
                    netPanel = new JPanel();
                    FlowLayout netPanelLayout = new FlowLayout();
                    netPanelLayout.setAlignOnBaseline(true);
                    netPanel.setBorder(BorderFactory.createTitledBorder("选择网卡"));
                    netPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    jPanel_west.add(netPanel);
                    netPanel.setLayout(netPanelLayout);
//                                 netPanel.setPreferredSize(new java.awt.Dimension(239, 56));
                    {
                        devices = JpcapCaptor.getDeviceList();
                        if(devices == null){
                            JOptionPane.showMessageDialog(frame, "没有找到网卡");
                            dispose();
                            return;
                        }
                        else{
                            String[] names = new String[devices.length];
                            for(int i=0;i < names.length;i++){
                                names[i] = (devices[i].description == null?devices[i].name:devices[i].description);
                            }
                            netJComboBox = new JComboBox(names);
                        }
                        netPanel.add(netJComboBox);
                    }
                }
                {
                    CheckBox = new JCheckBox();
                    jPanel_west.add(CheckBox);
                    FlowLayout CheckBoxLayout = new FlowLayout();
                    CheckBoxLayout.setAlignOnBaseline(true);
                    CheckBox.setText("/u662f/u5426/u8bbe/u7f6e/u4e3a/u6df7/u6742/u6a21/u5f0f");
                    CheckBox.setLayout(null);
                }
                {
                    filterPanel = new JPanel();
                    filterPanel.setBorder(BorderFactory.createTitledBorder("捕获过滤器"));
                    filterPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    FlowLayout filterPanelLayout = new FlowLayout();
                    filterPanelLayout.setAlignment(FlowLayout.LEFT);
                    filterPanelLayout.setAlignOnBaseline(true);
                    jPanel_west.add(filterPanel);
                    filterPanel.setLayout(filterPanelLayout);
                    {
                        TextField = new JTextField(20);
                        filterPanel.add(TextField);
                    }
                }
            }
            {
                jPanel_east = new JPanel();
                jPanel_east.setLayout(new BoxLayout(jPanel_east,BoxLayout.Y_AXIS));
                getContentPane().add(jPanel_east);

                {
                    caplenPanel = new JPanel();
                    caplenPanel.setBorder(BorderFactory.createTitledBorder("最长字长"));
                    caplenPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    jPanel_east.add(caplenPanel);
                    caplenPanel.setLayout(new BoxLayout(caplenPanel,BoxLayout.Y_AXIS));

                    {
                        caplenTextField = new JTextField(20);
                        caplenPanel.add(caplenTextField);
                        caplenTextField.setText("1514");
                        caplenTextField.setEnabled(false);
                    }
                    {
                        wholeRadioButton = new JRadioButton();
                        FlowLayout userRadioButtonLayout = new FlowLayout();
                        userRadioButtonLayout.setAlignOnBaseline(true);
                        caplenPanel.add(wholeRadioButton);
                        wholeRadioButton.setText("/u6574/u4e2a/u6570/u636e/u62a5");
                        wholeRadioButton.setSelected(true);

                        wholeRadioButton.addActionListener(this);
                    }
                    {
                        headRadioButton = new JRadioButton();
                        caplenPanel.add(headRadioButton);
                        headRadioButton.setText("/u4ec5/u9996/u90e8");

                        headRadioButton.addActionListener(this);
                    }
                    {
                        userRadioButton = new JRadioButton();
                        caplenPanel.add(userRadioButton);
                        userRadioButton.setText("/u5176/u4ed6/u90e8/u5206");

                        userRadioButton.addActionListener(this);
                    }
                    ButtonGroup group=new ButtonGroup();
                    group.add(wholeRadioButton);
                    wholeRadioButton.setActionCommand("Whole");
                    group.add(headRadioButton);
                    headRadioButton.setActionCommand("Head");
                    group.add(userRadioButton);
                    userRadioButton.setActionCommand("user");
                }
                {
                    buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
//                                 buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
                    jPanel_east.add(buttonPanel);

                    {
                        okButton = new JButton();
                        buttonPanel.add(okButton);
                        FlowLayout cancelButtonLayout = new FlowLayout();
                        cancelButtonLayout.setAlignOnBaseline(true);
                        okButton.setText("/u786e/u5b9a");

                        okButton.setActionCommand("ok");
                        okButton.addActionListener(this);
                    }
                    {
                        cancelButton = new JButton();
                        buttonPanel.add(cancelButton);
                        cancelButton.setText("/u53d6/u6d88");

                        cancelButton.setActionCommand("cancel");
                        cancelButton.addActionListener(this);
                    }
//                                 buttonPanel.setAlignmentX(Component.RIGHT_ALIGNMENT);
                }
            }
            getContentPane().setLayout(new BoxLayout(getContentPane(),BoxLayout.X_AXIS));

            getContentPane().add(jPanel_west);

            getContentPane().add(jPanel_east);

            pack();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void actionPerformed(ActionEvent evt){
        String cmd=evt.getActionCommand();

        if(cmd.equals("Whole")){
            caplenTextField.setText("1514");
            caplenTextField.setEnabled(false);
        }else if(cmd.equals("Head")){
            caplenTextField.setText("68");
            caplenTextField.setEnabled(false);
        }else if(cmd.equals("user")){
            caplenTextField.setText("");
            caplenTextField.setEnabled(true);
            caplenTextField.requestFocus();
        }else if(cmd.equals("ok")){
            try{
                int caplen=Integer.parseInt(caplenTextField.getText());
                if(caplen<68 || caplen>1514){
                    JOptionPane.showMessageDialog(null,"捕获长度必须介于 68 和 1514之间");
                    return;
                }

                jpcap=JpcapCaptor.openDevice(devices[netJComboBox.getSelectedIndex()],caplen,
                        CheckBox.isSelected(),50);

                if(TextField.getText()!=null && TextField.getText().length()>0){
                    jpcap.setFilter(TextField.getText(),true);
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"捕获长度必须是正整数");
            }catch(java.io.IOException e){
                JOptionPane.showMessageDialog(null,e.toString());
                jpcap=null;
            }finally{
                dispose();
            }

        }else if(cmd.equals("cancel")){
            dispose();
        }
    }

    public static JpcapCaptor getJpcap(JFrame parent){
        new Jcapturedialog(parent).setVisible(true);
        return jpcap;
    }
}

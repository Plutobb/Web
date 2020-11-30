package netcap;

import jpcap.JpcapCaptor;
import jpcap.PacketReceiver;
import jpcap.packet.Packet;

public class NetCaptor {

    JpcapCaptor jpcap = null;
    JFrameMain frame;

    public void setJFrame(JFrameMain frame){
        this.frame=frame;
    }

    public void capturePacketsFromDevice() {

        if(jpcap!=null) {
            jpcap.close();
        }

        jpcap = Jcapturedialog.getJpcap(frame);

        if (jpcap != null) {
            startCaptureThread();
        }

    }

    private Thread captureThread;

    private void startCaptureThread(){

        if(captureThread != null) {
            return;
        }
        captureThread = new Thread(new Runnable(){
            @Override
            public void run(){
                while(captureThread != null){
                    jpcap.processPacket(1, handler);
                }
            }
        });
        captureThread.setPriority(Thread.MIN_PRIORITY);
        captureThread.start();
    }

    void stopcaptureThread(){
        captureThread = null;
    }

    public void stopCapture(){
        System.out.println(2);
        stopcaptureThread();
    }

    private PacketReceiver handler=new PacketReceiver(){
        @Override
        public void receivePacket(Packet packet) {
            //System.out.println(packet);
            frame.dealPacket(packet);
        }

    };
}

package com.example.mopo;

import com.example.mopo.Mapper.VideoMapper;
import com.example.mopo.Service.Impl.VideoServiceImpl;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

@SpringBootTest
class GraduationProjectApplicationTests {

    @Autowired
    private VideoMapper videoMapper;

    @Test
    void contextLoads() {
    }

    public static String getVideoFirstImg(String path)throws Exception {
        Frame frame = null;
        //构造器支持InputStream，可以直接传MultipartFile.getInputStream()
        FFmpegFrameGrabber fFmpegFrameGrabber = new FFmpegFrameGrabber(path);
        //开始播放
        fFmpegFrameGrabber.start();
        //获取视频总帧数
        int ftp = fFmpegFrameGrabber.getLengthInFrames();
        //指定第几帧
        fFmpegFrameGrabber.setFrameNumber(5);
        //获取指定第几帧的图片
        frame = fFmpegFrameGrabber.grabImage();
        //文件绝对路径+名字
        String fileName = "D:/upload/video/first.jpg";
        File outPut = new File(fileName);
        ImageIO.write(FrameToBufferedImage(frame), "jpg", outPut);
        return fileName;
    }

    public static BufferedImage FrameToBufferedImage(Frame frame) {
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bufferedImage = converter.getBufferedImage(frame);
        return bufferedImage;
    }

    @Test
    void Test1() throws Exception {
        String videoFileName = "C:/Users/Mopo/Videos/58fb0800707540c59a29dbb356789cdf.mp4";
        System.out.println(getVideoFirstImg(videoFileName));
    }

    @Test
    void Test2() throws Exception {

    }

}

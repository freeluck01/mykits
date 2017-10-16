package com.mykits.commons.utils.image;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Coordinate;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;
import org.springframework.util.StringUtils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Created by caoxingming on 2016/5/31.
 */
public class ThumbnailatorUtils {

    public static void main(String[] args) {
//        imageWatermark("D:\\workspace_kits\\test_files\\ab.jpg", "D:\\workspace_kits\\baidu_news_276_88.png", "D:\\workspace_kits\\test_files\\ab1.jpg");
//        reSize();
//        reScale();
        textWatermark();
    }

    public static boolean textWatermark(){
        String watermarkString = "这是水印文字";

        try {
            //在水印图片上添加文字
            File srcImgFile = new File("D:\\workspace_kits\\test_files\\shuiyin.png");
            Image srcImg = ImageIO.read(srcImgFile);
            int srcImgWidth = srcImg.getWidth(null);
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            //设置背景透明begin
            bufImg = g.getDeviceConfiguration().createCompatibleImage(srcImgWidth, srcImgHeight,Transparency.TRANSLUCENT);
            g.dispose();
            g=bufImg.createGraphics();
            //设置背景透明end
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            Font font = new Font("楷体", Font.PLAIN, 20);
            g.setColor(Color.RED); //根据图片的背景设置水印颜色
            g.setFont(font);
            int x = srcImgWidth - getWatermarkLength(watermarkString, g) - 3;
            int y = srcImgHeight  - 3;
            g.drawString(watermarkString, x, y);
            g.dispose();

            //将处理后的图片水印加到原图片
            Thumbnails.of("D:\\workspace_kits\\test_files\\ab.jpg")
                    //.size(srcImgWidth, srcImgHeight)
                    .scale(1.0)
                    .watermark(Positions.CENTER_RIGHT, bufImg, 0.9f)
                    .useOriginalFormat()
                    .outputQuality(0.96f)
                    .toFile("D:\\workspace_kits\\test_files\\ab123.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    /**
     * 获取水印文字总长度
     * @param waterMarkContent 水印的文字
     * @param g
     * @return 水印文字总长度
     */
    public static int getWatermarkLength(String waterMarkContent, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(waterMarkContent.toCharArray(), 0, waterMarkContent.length());
    }

    /**
     * 图片添加水印(图片格式)
     * @param oriImgPath
     * @param markImgPath
     * @param targetImgPath
     * @return
     */
    public static boolean imageWatermark(String oriImgPath, String markImgPath, String targetImgPath){
        if(StringUtils.isEmpty(oriImgPath) || StringUtils.isEmpty(markImgPath) || StringUtils.isEmpty(targetImgPath)){
            System.out.println("原图片路径、水印图片路径和新生成图片路径中有一项或多项为空");
            return false;
        }
        File oriImgFile = new File(oriImgPath);
        if(!oriImgFile.isFile() || !oriImgFile.canRead()){
            System.out.println("原始图片["+oriImgPath+"]不是有效文件或者不可读");
            return false;
        }
        File markImg = new File(markImgPath);
        if(!markImg.isFile() || !markImg.canRead()){
            System.out.println("水印图片["+markImgPath+"]不是有效文件或者不可读");
            return false;
        }

        try {
            Image srcImg = ImageIO.read(oriImgFile);
            int srcImgWidth = srcImg.getWidth(null);//原图片宽度
            int srcImgHeight = srcImg.getHeight(null);//原图片高度

            //Coordinate(左内边距，上内边距)
            Position position = new Coordinate(srcImgWidth-ImageIO.read(markImg).getWidth(),srcImgHeight/3);
            //watermark(位置，水印图，透明度)
            Thumbnails.of(oriImgPath)
                    .size(srcImgWidth, srcImgHeight)
                    .watermark(position, ImageIO.read(markImg), 0.5f)
                    .watermark(Positions.BOTTOM_CENTER, ImageIO.read(markImg), 0.5f)
                    .useOriginalFormat()
                    .outputQuality(0.96f)
                    .toFile(targetImgPath);
        } catch (IOException e) {
            System.out.println("图片："+oriImgPath+"添加水印失败");
            e.printStackTrace();
        }
        return true;
    }

    public static void watermarkForDirectory(){
        try {
            long ss=new Date().getTime();
            Thumbnails.of(new File("D:\\workspace_kits\\test_files").listFiles())
                    .size(1280, 1024)
                    .watermark(Positions.CENTER, ImageIO.read(new File("D:\\workspace_kits\\jd-logo.png")), 0.5f)
                    .outputQuality(0.99999f)
                    .toFiles(Rename.PREFIX_DOT_THUMBNAIL);
            long ee=new Date().getTime();
            System.out.println((ee-ss)/1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 按指定尺寸缩放，图片比例不变
     */
    public static void reSize(){
        try {
        /*
         * 若图片横比200小，高比300小，不变
         * 若图片横比200小，高比300大，高缩小到300，图片比例不变
         * 若图片横比200大，高比300小，横缩小到200，图片比例不变
         * 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
         */
            Thumbnails.of("D:\\workspace_kits\\test_files\\ab1.jpg")
                    .size(200, 300)
                    .toFile("D:\\workspace_kits\\test_files\\ab1.jpg");

//            Thumbnails.of("D:\\workspace_kits\\test_files\\ab1.jpg")
//                    .size(2560, 2048)
//                    .toFile("D:\\workspace_kits\\test_files\\ab1.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片长宽按同比例缩放
     */
    public static void reScale(){
        //scale(比例)
        try {
            Thumbnails.of("D:\\workspace_kits\\test_files\\abc.png")
                    .scale(0.5f)
                    .toFile("D:\\workspace_kits\\test_files\\abc1.png");

//            Thumbnails.of("D:\\workspace_kits\\test_files\\ab1.jpg")
//                    .scale(1.10f)
//                    .toFile("D:\\workspace_kits\\test_files\\ab1.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

package com.mykits.commons.utils.image;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * 图片水印
 */
public class ImageMarkLogoByIcon {
    /**加水印后的图片格式：JPG*/
    private static final String PICTRUE_FORMATE_JPG = "jpg";
    /**水印在原图片的坐标-X*/
    private static final int MARK_COORDINATE_X = 550;
    /**水印在原图片的坐标-Y*/
    private static final int MARK_COORDINATE_Y = 550;
    /**水印选择角度*/
    private static final int MARK_DEGREE = -15;
    /**水印透明度*/
    private static final float MARK_ALPHA = 0.5f;
    /**
     * @param args
     */
    public static void main(String[] args) {
        String srcImgPath = "D:\\workspace_kits\\test_files\\ab.jpg";
        String iconPath = "D:\\workspace_kits\\test_files\\baidu_logo.gif";
        String targerPath = "D:\\workspace_kits\\test_filesimg_mark_icon.jpg";
        // 给图片添加水印
        //ImageMarkLogoByIcon.createImageMarkByIcon(iconPath, srcImgPath, targerPath, null);
        // 给图片添加水印,水印旋转-45
        ImageMarkLogoByIcon.markImageByIcon(iconPath, srcImgPath, MARK_COORDINATE_X, MARK_COORDINATE_Y, MARK_DEGREE, MARK_ALPHA);
    }

    /**
     * 给图片添加水印，不生成新图片，可设置水印图片旋转角度
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param degree 水印图片旋转角度
     */
    public static void markImageByIcon(String iconPath, String srcImgPath, int x, int y, Integer degree, float alpha) {
        try {
            File srcImgFile = new File(srcImgPath);
            Image srcImg = ImageIO.read(srcImgFile);

            int srcImgWidth = srcImg.getWidth(null);//原图片宽度
            int srcImgHeight = srcImg.getHeight(null);//原图片高度
            BufferedImage buffImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            // 得到画笔对象
            Graphics2D g = buffImg.createGraphics();
            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.drawImage(srcImg.getScaledInstance(srcImgWidth, srcImgHeight, Image.SCALE_SMOOTH), 0, 0, null);

            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree),(double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            }
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);
            // 得到Image对象。
            Image icon = imgIcon.getImage();
            int iconWidth = icon.getWidth(null);
            int iconHeight = icon.getHeight(null);

            int widthDiff = srcImgWidth - iconWidth;
            int heightDiff = srcImgHeight - iconHeight;
            if(x < 0){
                x = widthDiff / 2;
            }else if(x > widthDiff){
                x = widthDiff;
            }
            if(y < 0){
                y = heightDiff / 2;
            }else if(y > heightDiff){
                y = heightDiff;
            }
            g.drawImage(icon, x, y, iconWidth, iconHeight, null); // 水印文件结束
            g.dispose();
            // 生成水印图片
            ImageIO.write(buffImg, PICTRUE_FORMATE_JPG, srcImgFile);
            System.out.println("图片完成添加Icon印章。。。。。。");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 给图片添加水印，生成新图片，可设置水印图片旋转角度
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     * @param degree 水印图片旋转角度
     */
    public static void createImageMarkByIcon(String iconPath, String srcImgPath,
                                       String targerPath, Integer degree) {
        OutputStream os = null;
        try {
            Image srcImg = ImageIO.read(new File(srcImgPath));

            BufferedImage buffImg = new BufferedImage(srcImg.getWidth(null), srcImg.getHeight(null), BufferedImage.TYPE_INT_RGB);

            // 得到画笔对象
            // Graphics g= buffImg.getGraphics();
            Graphics2D g = buffImg.createGraphics();

            // 设置对线段的锯齿状边缘处理
            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);

            g.drawImage(srcImg.getScaledInstance(srcImg.getWidth(null), srcImg.getHeight(null), Image.SCALE_SMOOTH), 0, 0, null);

            if (null != degree) {
                // 设置水印旋转
                g.rotate(Math.toRadians(degree),(double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
            }

            // 水印图象的路径 水印一般为gif或者png的，这样可设置透明度
            ImageIcon imgIcon = new ImageIcon(iconPath);

            // 得到Image对象。
            Image img = imgIcon.getImage();

            float alpha = 0.5f; // 透明度
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP,alpha));

            // 表示水印图片的位置
            g.drawImage(img, 150, 300, null);

            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));

            g.dispose();

            os = new FileOutputStream(targerPath);

            // 生成图片
            ImageIO.write(buffImg, "JPG", os);

            System.out.println("图片完成添加Icon印章。。。。。。");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os)
                    os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

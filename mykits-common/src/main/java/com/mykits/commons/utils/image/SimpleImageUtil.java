package com.mykits.commons.utils.image;

//import com.alibaba.simpleimage.ImageRender;
//import com.alibaba.simpleimage.SimpleImageException;
//import com.alibaba.simpleimage.render.*;
//import org.apache.commons.io.IOUtils;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by caoxingming on 2016/5/31.
 */
public class SimpleImageUtil {
    /**
     * 测试未通过
     * @param args
     */
//    public static void main(String[] args) {
//        File in = new File("D:/workspace_kits/test_files/ab.jpg");      //原图片
//        File out = new File("D:/workspace_kits/test_files/aaab.jpg");       //目的图片
//        ScaleParameter scaleParam = new ScaleParameter(2336, 4160);  //将图像缩略到1024x1024以内，不足1024x1024则不做任何处理
//
//        FileInputStream inStream = null;
//        FileOutputStream outStream = null;
//        WriteRender wr = null;
//        try {
//            inStream = new FileInputStream(in);
//            outStream = new FileOutputStream(out);
//            ImageRender rr = new ReadRender(inStream);
//            //ImageRender sr = new ScaleRender(rr, scaleParam);
//
//
//            DrawTextItem textItem = new FixDrawTextItem("水印");
//            List<DrawTextItem> textItemList = new ArrayList<DrawTextItem>();
//            textItemList.add(textItem);
//            DrawTextParameter dp = new DrawTextParameter(textItemList);
//            ImageRender dr = new DrawTextRender(rr,dp);
//
//
//            wr = new WriteRender(dr, outStream);
//
//            wr.render();                            //触发图像处理
//        } catch(Exception e) {
//            e.printStackTrace();
//        } finally {
//            IOUtils.closeQuietly(inStream);         //图片文件输入输出流必须记得关闭
//            IOUtils.closeQuietly(outStream);
//            if (wr != null) {
//                try {
//                    wr.dispose();                   //释放simpleImage的内部资源
//                } catch (SimpleImageException ignore) {
//                    ignore.printStackTrace();
//                }
//            }
//        }
//    }
}

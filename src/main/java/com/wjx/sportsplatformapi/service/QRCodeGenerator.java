package com.wjx.sportsplatformapi.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * 描述：     生成二维码工具
 *  QRCode:  Quick Response Code . QR Code码，是由Denso公司于1994年9月研制的一种矩阵二维码符号，它具有一维条码及其它二维条码所具有的信息容量大、可靠性高、可表示汉字及图象多种文字信息、保密防伪性强等优点。
 */
@Service
public class QRCodeGenerator {

    /**
     * 生成二维码(QRCode)图片
     * @param text 存储内容,二维码的内容,扫描后能看到的东西
     * @param width 二维码的宽
     * @param height 二维码的高
     * @param filePath 二维码生成后的路径
     */
    public void generateQRCodeImage(String text, int width, int height, String filePath) throws WriterException, IOException {
        //  QRcode jar包，core核心包，javase包。
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        //  创建比特矩阵(位矩阵)的QR码编码的字符串
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
        Path path = FileSystems.getDefault().getPath(filePath);
        //  在指定路径下生成二维码
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    }

}

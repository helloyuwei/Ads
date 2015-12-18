package com.yw.ads.graphic;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;

/**
 * Created by dylanyu on 12/18/2015.
 */
public class ImageUtils {

    /**
     * @param image   - should impress image
     * @param quality - a float between 0and 1 indicating the desired quality level.
     * @return
     */
    public static byte[] bufferedImageTobytes(BufferedImage image, float quality) throws IOException {
        if (image == null) {
            throw new IllegalArgumentException("image can not be a null.");
        }
        if (quality < 0 || quality > 1) {
            throw new IllegalArgumentException("quality should between 0 and 1.");
        }

        Iterator<ImageWriter> iterator = ImageIO.getImageWritersByFormatName("jpeg");
        ImageWriter writer = (ImageWriter) iterator.next();

        ImageWriteParam iwp = writer.getDefaultWriteParam();
        iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        iwp.setCompressionQuality(quality);

        iwp.setProgressiveMode(ImageWriteParam.MODE_DISABLED);

        ColorModel colorModel = ColorModel.getRGBdefault();
        iwp.setDestinationType(new javax.imageio.ImageTypeSpecifier(colorModel, colorModel.createCompatibleSampleModel(16, 16)));

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        IIOImage iIamge = new IIOImage(image, null, null);
        writer.setOutput(ImageIO.createImageOutputStream(byteArrayOutputStream));
        writer.write(null, iIamge, iwp);
        return byteArrayOutputStream.toByteArray();
    }

}

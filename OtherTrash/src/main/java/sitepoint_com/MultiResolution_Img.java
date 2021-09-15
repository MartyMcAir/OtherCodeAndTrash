package sitepoint_com;

import javax.imageio.ImageIO;
import java.awt.*;

import java.awt.image.BaseMultiResolutionImage;
import java.awt.image.MultiResolutionImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.List;

// JEP 251 introduces MultiResolutionImage, which encapsulates a set of images with different resolutions and
// allows to query it with a desired height and width. An abstract and a simple implementation are provided.
public class MultiResolution_Img {
    private static final String[] IMAGE_URLS = {"", ""};

    public static void main(String[] args) throws IOException {
        MultiResolutionImage tokio = loadTokio();
        int desiredImageWidth = new Random().nextInt(1500);
        Image variant = tokio.getResolutionVariant(desiredImageWidth, 1);

        System.out.printf("Width of image for %d: %d%n",
                desiredImageWidth, variant.getWidth(null));
    }

    private static MultiResolutionImage loadTokio() throws IOException {
        List<Image> tokios = new ArrayList<Image>();
        for (String url : IMAGE_URLS) {
            tokios.add(ImageIO.read(new URL(url)));
        }
        return new BaseMultiResolutionImage(tokios.toArray(new Image[0]));
    }
}
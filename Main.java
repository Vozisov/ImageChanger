/*
 * Copyright (c) 2018. Alex Vozisov (vozisov@gmail.com)
 */

package com.vozisov.imagechanger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    // path to folder with original pictures
    private static String path_from = "/home/enot/IdeaProjects/ImageChanger/src/com/vozisov/imagechanger/from/";
    // path to folder with mirrored pictures
    private static String path_to = "/home/enot/IdeaProjects/ImageChanger/src/com/vozisov/imagechanger/to/";

    public static void main(String[] args) throws IOException {

        String list[] = new File(path_from).list();
        for (int i = 0; i < list.length; i++) {
            ImageMirror(list[i]);
            System.out.println(i);
        }

    }


    private static void ImageMirror(String s) throws IOException {

        BufferedImage img = ImageIO.read(new File(path_from + s));
        int[][] orijinal = new int[img.getWidth()][img.getHeight()];
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                orijinal[i][j] = img.getRGB(i, j);
            }
        }

        BufferedImage img2 = new BufferedImage(img.getWidth(), img.getHeight(), 1);

        for (int i = 1; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                img2.setRGB(i, j, orijinal[img.getWidth() - i][j]);
            }
        }

        File f = new File(path_to + s);
        String format = "jpg";
        ImageIO.write(img2, format, f);
    }
}

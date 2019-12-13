package com.example.librarysqlitefichamilitar.util;


import android.content.Context;
import android.graphics.Bitmap;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Util {


    public static void Tag(Context ctx, String m) {

      //  Log.d(ctx.getClass().getSimpleName(), m);

    }

    public static File getImageFromCacheDirPNG(Context ctx, String nomeFile) {

        return new File(ctx.getCacheDir(), nomeFile + ".png");


    }

    public static String saveBitmapToFile(File dir, String fileName, Bitmap bm) {

        File imageFile = new File(dir, fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(imageFile);
            bm.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return imageFile.getPath();
    }

}

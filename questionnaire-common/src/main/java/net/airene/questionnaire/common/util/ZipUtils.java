package net.airene.questionnaire.common.util;

import net.airene.questionnaire.common.constant.Constants;

import java.io.ByteArrayOutputStream;
import java.util.zip.DeflaterOutputStream;

public final class ZipUtils {

    private ZipUtils() {
        throw new UnsupportedOperationException();
    }

    private static final int BUFF_SIZE = 4096;

    public static byte[] gZip(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        DeflaterOutputStream gzip;
        try {
            gzip = new DeflaterOutputStream(out);
            gzip.write(str.getBytes(Constants.UTF8));
            gzip.close();
        } catch ( Exception e) {
            e.printStackTrace();
        }
        return out.toByteArray();
    }
}

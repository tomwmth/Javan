package com.hawolt.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created: 07/02/2023 13:05
 * Author: Twitter @hawolt
 **/

public class StreamReader {
    public static byte[] read(InputStream stream) throws IOException {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = stream.read(buffer)) != -1) {
            result.write(buffer, 0, length);
        }
        return result.toByteArray();
    }
}

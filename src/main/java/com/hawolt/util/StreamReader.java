package com.hawolt.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility class to read InputStreams
 **/

public class StreamReader {
    /**
     * @param stream An InputStream to read from
     * @return The byte content of the stream
     * @throws IOException
     */
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

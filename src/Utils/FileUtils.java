package Utils;

import java.io.File;

public class FileUtils {
    public static File getResourceFile(String fileName) {
        return new File(String.format("src/Resources/%s",fileName));
    }
}

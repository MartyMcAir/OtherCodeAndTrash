package z_ClassLoader.habrExamples;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ModuleLoader extends ClassLoader {
    private String pathToBin; //  Путь до директории с модулями.

    public ModuleLoader(String pathToBin, ClassLoader parent) {
        super(parent);
        this.pathToBin = pathToBin;
    }

    // метод для корректной реализации загрузчика
    @Override
    public Class<?> findClass(String className) throws ClassNotFoundException {
        try { // Получем байт-код из файла и загружаем класс в рантайм
            byte b[] = fetchClassFromFS(pathToBin + className + ".class");

            // defineClass(..) - байт-код преобразует в java.lang.Class, осуществляя его валидацию
            return defineClass(className, b, 0, b.length);
        } catch (IOException ex) {
            return super.findClass(className);
        }
    }

    // Взято из www.java-tips.org/java-se-tips/java.io/reading-a-file-into-a-byte-array.html
    private byte[] fetchClassFromFS(String path) throws FileNotFoundException, IOException {
        // My new way
        byte[] bytes1 = new byte[0];
        try (InputStream inputStream = Files.newInputStream(Paths.get(path.substring(1)))) {
//            bytes1 = new byte[inputStream.available()];
//            System.out.println(path);
            bytes1 = inputStream.readAllBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bytes1;

        // Original almost..
//        byte[] bytes = new byte[0];
//        try (InputStream is = new FileInputStream(new File(path))) {
//            long length = new File(path).length();  // Get the size of the file
//            if (length > Integer.MAX_VALUE) { // File is too large
//            }
//            // Create the byte array to hold the data
//            bytes = new byte[(int) length];
//
//            int offset = 0;  // Read in the bytes
//            int numRead = 0;
//            while (offset < bytes.length &&   // поток записывает в массив байтов
//                    (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
//                offset += numRead;
//            }
//
//            if (offset < bytes.length) { // Ensure all the bytes have been read in
//                throw new IOException("Could not completely read file " + path);
//            }
//        }
//        return bytes;
    }
}
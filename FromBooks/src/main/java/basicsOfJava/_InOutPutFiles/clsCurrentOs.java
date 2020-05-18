/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

/**
 *
 * @author MartyMcAir
 */
public class clsCurrentOs {

    public void showOsAttr() throws URISyntaxException, IOException {
        System.out.println("System.getProperty(\"java.version\"): "
                + System.getProperty("java.version"));
        System.out.println("System.getProperty(\"java_home\"): "
                + System.getProperty("java.home"));
        System.out.println("System.getProperty(\"java.class.path\"): "
                + System.getProperty("java.class.path"));
        System.out.println("Путь к папке временных файлов"
                + System.getProperty("java.io.tmpdir"));

        System.out.println();
        System.out.println("System.getProperty(\"os.name\"): "
                + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\"): "
                + System.getProperty("user.name"));
        System.out.println("System.getProperty(\"user.home\"): "
                + System.getProperty("user.home"));
        System.out.println("System.getProperty(\"user.country\"): "
                + System.getProperty("user.country"));
        System.out.println("System.getProperty(\"user.language\"): "
                + System.getProperty("user.language"));

        System.out.println();
        File dir = new File(clsCurrentOs.class.getResource(".").toURI());
        System.out.println("Путь к файлу с запущенным классом"
                + " (чет нето показывает):\n " + dir.getCanonicalPath());
        System.out.println("user.dir _ каталог из которого запущенна программа: "
                + System.getProperty("user.dir"));

        System.out.println("\nВсе опции System.getProperties()");
        Properties map = System.getProperties();
        for (String item : map.stringPropertyNames()) {
            System.out.print(item + ", \n");
        }
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._InOutPutFiles;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class clsFile {

    public void accessFiles(){
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\file_access.txt");
        
        // Доступен для чтения?
        System.out.println("f.canRead()?: "+f.canRead());
        System.out.println("f.canWrite()?: "+f.canWrite());
        
        System.out.println("выполняемый фал _ f.canExecute()?: "+f.canExecute());
        
        // Устанавливает права на выполнение
        // что true что false все равно доступ не меняется
        System.out.println("f.setExecutable() права изменены?: "+f.setExecutable(false));
        // тоже самое не работает
        System.out.println("f.setReadable(false)?: "+f.setReadable(false));
        
        // установка прав можно только чтение _ РАБОТАЕТ
        System.out.println("f.setReadOnly()?: "+f.setReadOnly());
    }
    
    public void filesCRUD() throws IOException {
        // create file
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\new_file.txt");
        System.out.println("f.createNewFile(): " + f.createNewFile());

        // create Temporary file 
        File path = new File("C:\\z_n\\new_test_folder\\1\\2\\");

        File tmpMy = File.createTempFile("myTemp", ".myExtends", path);
        File tmpMy2 = File.createTempFile("tmp", null, path);

        System.out.println("tmpMy: " + tmpMy);
        System.out.println("tmpMy2: " + tmpMy2);

        // Rename file
        System.out.println("f.renameTo: " + f.renameTo(
                new File("C:\\z_n\\new_test_folder\\1\\2\\new_file_renamed.txt")));
        // Delete file
        File f2 = new File("C:\\z_n\\new_test_folder\\1\\2\\new_file.txt");
        System.out.println("f2.delete(): " + f2.delete());

        // Размер файла
        File f3 = new File("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");
        System.out.println("f.length(): " + f3.length());
    }

    public void isDelExistsHiddenChange() {
        // содержит путь к файлу?
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\");
        System.out.println(f.getName() + " _ f.isFile()?: " + f.isFile());

        File f2 = new File("C:\\z_n\\myLoG.txt");
        System.out.println(f2.getName() + " _ f2.isFile()?: " + f2.isFile());
        // файл по указанному пути существует?
        System.out.println(f2.getName() + " _ f2.exists()?: " + f2.exists());

        // Удаляет файл или каталог
        File fdel = new File("C:\\z_n\\new_test_folder\\1\\2\\del.txt");
        fdel.deleteOnExit();
        System.out.println(fdel.getName() + " _ fdel.exists()?: " + fdel.exists());

        // Файл скртый?
        File f3 = new File("C:\\z_n\\new_test_folder\\1\\2\\file_size.txt");
        System.out.println("f3.isHidden()?: " + f3.isHidden());

        // Дата последних изменний с 1 янв 1970
        Date d = new Date(f3.lastModified());
        System.out.println("f3.lastModified(): " + f3.lastModified() + " Date: " + d);
        // Устанавливает дату последних изменений с 1 янв 1970
        System.out.println("f3.setLastModified(new Date .."
                + f3.setLastModified(new Date(d.getTime() - 24 * 60 * 60 * 1000).getTime()));
        System.out.println("new Date (f3.lastModified()): "
                + new Date(f3.lastModified()));
    }

    public void delExistsDirectory() {
        File f = new File("C:\\z_n\\new_test_folder\\1\\2\\333");
        System.out.println(f.getName() + " f.delete()?: " + f.delete());
        System.out.println(f.getName() + " f.exists()?: " + f.exists());
    }

    public void showDirectory() {
        // При повторном запуске если каталоги уже были созданы или 
        // есть вернет false
        File f = new File("C:\\z_n\\new_test_folder\\");
        System.out.println("f.mkdir() каталог создан?: " + f.mkdir());

        File f2 = new File("C:\\z_n\\new_test_folder\\1\\2\\3\\");
        System.out.println("f2.mkdirs() каталоги созданы?: " + f2.mkdirs());

        System.out.println("f2.renameTo(..) каталог переименован?: "
                + f2.renameTo(new File("C:\\z_n\\new_test_folder\\1\\2\\333\\")));

        // Получить список только PDF файлов
        File f4 = new File("C:\\z_n\\Dropbox\\");
        String[] listBox = f4.list(
                (dir, name) -> name.toLowerCase().endsWith(".pdf"));
        for (String str : listBox) {
            System.out.println("listBox PDF only: " + str);
        }
    }

    public void listDirectoryFiles() {
        File f3 = new File("C:\\z_n\\a_aLibrary\\");
        String[] listAll = f3.list();

        String[] arrDirectorys = new String[listAll.length];
        String[] arrFiles = new String[listAll.length];
        int i = 0;

        for (String s : listAll) {
            //System.out.println(s);
            File var_file = new File(f3, s);
            //System.out.println("Directory?: "+var_file.isDirectory());
            //System.out.println("File?: "+var_file.isFile());

            if (var_file.isDirectory()) {
                arrDirectorys[i] = s;
            } else if (var_file.isFile()) {
                arrFiles[i] = s;
            }
            i++;
        }
        //System.out.println("arrDirectorys: "+Arrays.toString(arrDirectorys));
        //System.out.println("arrFiles: "+Arrays.toString(arrFiles));
        System.out.println("Директории каталога: " + f3.getName());
        for (int j = 0; j < arrDirectorys.length; j++) {
            if (arrDirectorys[j] == null) {
                continue;
            } else {
                System.out.print(arrDirectorys[j] + ", ");
            }
        }
        System.out.println("\nФайлы каталога: " + f3.getName());
        for (int k = 0; k < arrFiles.length; k++) {
            if (arrFiles[k] == null) {
                continue;
            } else {
                System.out.println(arrFiles[k] + ", ");
            }
        }
    }

    public void showHardDisk() {
        // Список доступных дисков
        File[] list = File.listRoots();
        for (File f : list) {
            System.out.print(f + ", ");
        }
        // Емкость дисков
        System.out.println("\nемкость диска "
                + "list[0].getTotalSpace(): " + list[0].getTotalSpace());
        System.out.println("list[1].getTotalSpace(): " + list[1].getTotalSpace());
        // Свободное место диска
        System.out.println("свободно на диске: "
                + "list[0].getFreeSpace(): " + list[0].getFreeSpace());
        // Свободного места на диске для виртуальной машины
        System.out.println("свободно для вирутальной машины: "
                + "list[0].getUsableSpace(): " + list[0].getUsableSpace());

    }

    public void filePath() throws IOException, URISyntaxException {
        File f = new File("C:\\z_n\\text.txt");
        System.out.println("f.getPath(): " + f.getPath());
        System.out.println("f.getCanonicalPath(): " + f.getCanonicalPath());

        // относительный путь
        File f2 = new File("text2.txt");
        System.out.println("\nf2.getPath(): " + f2.getPath());
        System.out.println("f2.getCanonicalPath(): " + f2.getCanonicalPath());
        System.out.println("f2.getCanonicalFile(): " + f2.getCanonicalFile());

        // Указание пути к файлу ниже уровнем
        File f3 = new File("..\\text2.txt");
        System.out.println("\nf3.getPath(): " + f3.getPath());

        // Указание пути от корня теущего диска
        File f4 = new File("\\text2.txt");
        System.out.println("\nf4.getPath(): " + f4.getPath());

        // Путь отнисительно текущего класса
        File dir = new File(Main.class.getResource(".").toURI());
        File f5 = new File(dir, "file.txt");
        System.out.println("\nf5.getPath(): " + f5.getPath());
        System.out.println("f5.getCanonicalPath(): " + f5.getCanonicalPath());

        // Путь к дериктории в которой находится файл
        System.out.println("f5.getParent(): " + f5.getParent());
        // имя файла
        System.out.println("f5.getName(): " + f5.getName());

        // выводит путь как путь в браузере
        System.out.println("f5.toURI(): " + f5.toURI());
    }

}

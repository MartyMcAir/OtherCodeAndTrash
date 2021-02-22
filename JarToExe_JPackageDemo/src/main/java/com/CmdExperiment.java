package com;

import java.io.*;

// https://stackoverflow.com/questions/15464111/run-cmd-commands-through-java
// https://stackoverflow.com/questions/4688123/how-to-open-the-command-prompt-and-insert-commands-using-java
// problems with charset in cmd
public class CmdExperiment {
    public static void main(String[] args) throws IOException {
//        runtime_1();
//        runtime_2();
//        runtime_3();

//        runtime_4_working();
//        runtime_5_GOOD();
//        runtime_6good();


//        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Program Files\\jEdit\" && dir");

//        String stringForCmd = "java -version";

//        String stringForCmd = "jpackage --input . " +
//                "--name MyExe " +
//                "--main-jar MyJar.jar " +
//                "--main-class DemoApp " +
//                "--type exe " +
//                "--java-options '--enable-preview' --win-shortcut";


        String demoFile = "C:\\Users\\martymcair\\OneDrive\\Dropbox\\GitHub\\OtherCodeAndTrash\\JarToExe_JPackageDemo\\src\\main\\java\\com\\DemoApp_exp";
        // compile
        String javaC_cmd = "javac " + demoFile + ".java";

        // run
        String java_cmd = "java " + demoFile;

        String java_cmd2 = "java " + "DemoApp_exp";
//        String stringForCmd = "java";
        realWorking_good(java_cmd2);
    }

    private static void realWorking_good(String stringForCmd) throws IOException {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", "cd \"C:\\Program Files\\jEdit\" && " + stringForCmd);
        builder.redirectErrorStream(true);

        Process p = builder.start();


//        cmd /K chcp 65001
        String command = "cmd.exe /c start " + "/K chcp 65001 java -version";

        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) break;

            System.out.println(line);
        }

        File directory = new File("C:\\Users\\martymcair\\OneDrive\\Dropbox\\GitHub\\OtherCodeAndTrash\\JarToExe_JPackageDemo\\src\\main\\java\\com");
        builder.directory(directory);
        Process process = builder.start();
    }

    private static void runtime_6good() throws IOException {
        Runtime rt = Runtime.getRuntime();
//        Process exec = rt.exec(new String[]{"cmd.exe", "/c", "start", "java -version"});
        Process exec = rt.exec(new String[]{"cmd.exe", "/c", "start"});
        OutputStream outputStream = exec.getOutputStream();
        outputStream.write("java -version".getBytes());
        outputStream.close();
    }

    private static void runtime_5_GOOD() throws IOException {
//        String[] command = {"cmd.exe", "/c", "start", "cmd.exe", "/k", "\" dir && ipconfig \"", "ls"};
        String[] command = {"cmd.exe", "/c", "start", "cmd.exe", "java -version"};
        ProcessBuilder probuilder = new ProcessBuilder(command);
//        File directory = new File("D:\\Folder1");
        File directory = new File("C:\\Users\\martymcair\\OneDrive\\Dropbox\\GitHub\\OtherCodeAndTrash\\JarToExe_JPackageDemo\\src\\main\\java\\com");
        probuilder.directory(directory);
        Process process = probuilder.start();
    }

    private static void runtime_4_working() throws IOException {
        String jPath = "C:\\z_dev\\LangLib\\JDK\\openJDK_14\\bin\\java.exe";
        String command = "cmd.exe /c start " + "java -version";
//        String command = "cmd.exe /c start "  + jPath;
        Process child = Runtime.getRuntime().exec(command);
        byte[] bytes = child.getInputStream().readAllBytes();

        for (byte b : bytes) {
            System.out.println((char) b);
            System.out.println("closed");
        }
    }

    private static void runtime_3() throws IOException {
        Runtime rt = Runtime.getRuntime();
//        String[] testArgs = {"cmd.exe", "java -version"};
//        String[] testArgs = {"java", " -version"};
//        String strPath = "C:\\z_dev\\Tools\\apache_maven_3_6\\bin\\strPath.cmd"; // err

        // runnerConfig.addApp(500, 500, true, new String[]{"c:\Users\martymcair\OneDrive\z_cmd _\z_openOther\Aimp\\\AIMP.exe", "/Play"});
//        String strPath = "C:\\z_dev\\LangLib\\JDK\\openJDK_14\\bin\\javac.exe";
//        String[] testArgs = {strPath, " -version"};

        // пример с аимпом работает
//        String strPath = "c:\\Users\\martymcair\\OneDrive\\z_cmd _\\z_openOther\\Aimp\\AIMP.exe";
//        String[] testArgs = {strPath, "/Play"};

        String[] testArgs = {"java", " "};
//        String[] testArgs = {"strPath", " --version"};
        rt.exec(testArgs);

        Process pr = rt.exec(testArgs);
        BufferedReader r = new BufferedReader(new InputStreamReader(pr.getInputStream()));

        System.out.println(r.readLine());
    }

    private static void runtime_2() throws IOException {
        String ss = null;
//        Process p = Runtime.getRuntime().exec("cmd.exe /c start dir ");
//        Process p = Runtime.getRuntime().exec("cmd.exe java -version");
//        Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "java -version"});
        Process p = Runtime.getRuntime().exec(new String[]{"cmd.exe", "explorer"});

//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
//        writer.write("dir");
//        writer.flush();

        BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));

//        System.out.println("Here is the standard output of the command:\n");
//        while ((ss = stdInput.readLine()) != null) {
//            System.out.println(ss);
//        }

        System.out.println("Here is the standard error of the command (if any):\n");
        while ((ss = stdError.readLine()) != null) {
            System.out.println(ss);
        }
    }

    private static void runtime_1() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process exec = runtime.exec(new String[]{"cmd.exe", "java -version"});
        InputStream inputStream = exec.getInputStream();
        byte[] x = inputStream.readAllBytes();
        for (byte b : x) {
            System.out.println(b);
        }
    }
}
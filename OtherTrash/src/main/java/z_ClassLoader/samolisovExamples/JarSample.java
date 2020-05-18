package z_ClassLoader.samolisovExamples;

public class JarSample implements IJarSample {
    public JarSample() {
        System.out.println("JarSample::JarSample()");
    }

    public void demo(String str) {
//        JarClassSamle s = new JarClass2Samle();
//        s.demo();
        System.out.println("JarSample::demo(String str)");
        System.out.println(str);
    }
}
package z_ClassLoader.sympleLoader;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ClassLoaderTest {
    public static void main(String args[]) {
        // Read more:https://javarevisited.blogspot.com/2012/12/how-classloader-works-in-java.html#ixzz6I5T2wLsX
        try {
            //printing ClassLoader of this class
            // jdk.internal.loader.ClassLoaders$AppClassLoader@6ed3ef1
            System.out.println("ClassLoaderTest.getClass().getClassLoader() : " + ClassLoaderTest.class.getClassLoader());

            //trying to explicitly load this class again using Extension class loader
            // exceptions
//            Class.forName("test.ClassLoaderTest", true, ClassLoaderTest.class.getClassLoader().getParent());
//            Class.forName("test.ClassLoaderTest", true, ClassLoaderTest.class.getClassLoader());
            Class.forName("test.ClassLoaderTest", true, ClassLoaderTest.class.getClassLoader());
        } catch (ClassNotFoundException ex) {
//        } catch (Exception ex) {
            Logger.getLogger(ClassLoaderTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

package Alishev;

//@MethodInfo(purpose = "dd") // @Target в аннотации определяет, место её юза
public class TestM {
    @MethodInfo(author =  "Neil", dateCreation = 2020, purpose = "Printe Hello W!")
    public void  printHelloWorld(){
        System.out.println("Hello W!");
    }

    @MethodInfo(purpose = "Printe Hello W2!")
    public void  printHelloWorld2(){
        System.out.println("Hello W2!");
    }
}

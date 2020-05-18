/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step3Tree;

/**
 *
 * @author MartyMcAir
 */
public class zclsRunCB {

    public static void main(String[] args) {
        System.out.print("Используем (a,b)->System.out.println( (a-b) ): ");
        zInterfShow itf = (a, b) -> System.out.println((a - b));
        itf.show(3, 2);

        System.out.println("\nИспользуем CallBack функцию обратного вызова "
                + "совместно с интерфейсом \n"
                + "(в качестве парметра в конструктор класса регистратора): ");
        zInterfShow itf2 = (a, b) -> System.out.println((a * b));
        zclsRegCallBack zclb = new zclsRegCallBack(itf);
        zclsRegCallBack zclb2 = new zclsRegCallBack(itf2);
        zclb.callCack(6, 2); // 6-2=4
        zclb2.callCack(6, 2); // 6*2=12

        System.out.print("\nИспользуем CallBack функцию обратного вызова "
                + "совместно с методом obj::method: ");
        zclsMethods cls = new zclsMethods();
        zclsRegCallBack zclb3 = new zclsRegCallBack(cls::division);
        zclsRegCallBack zclb4 = new zclsRegCallBack(cls::multiple);
        zclsRegCallBack zclb5 = new zclsRegCallBack(cls::sum);
        zclb3.callCack(10, 2); // 10/2=5
        zclb4.callCack(3, 3);  // 3*3=9
        zclb5.callCack(333, 333);  // 333+333=666
 
        System.out.print("\nИспользуем CallBack функцию обратного вызова "
                + "совместно с лямбдой: ");
        zclsRegCallBack zclb6 = new zclsRegCallBack((a, b)
                -> System.out.println(((a - b) * a)));
        zclb6.callCack(10, 2);  // (10-2)*10=80

        
    }
}

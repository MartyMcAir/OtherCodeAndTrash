/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step2Two;

/**
 *
 * @author MartyMcAir
 */
public interface zclsInterfSuper {
    // нельзя создать экземпляр интерфейса т.е. не могут инстанцироваться
    // и не имеют конструкторов _ 
    // все пермеменные по умолчанию final т.е. константы
    // все методы по умолчанию public
    String var = " по умолчанию final";

    void setV(String v);
    String getV();

    void showVar();
}

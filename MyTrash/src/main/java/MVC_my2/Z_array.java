/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_my2;

/**
 *
 * @author MartyMcAir
 */
public class Z_array {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    clsModelDB modelVar = new clsModelDB();
    clsModel model = modelVar.modelDB();
    clsView view = new clsView();
    clsController ctrl = new clsController(model, view);
    ctrl.setName("test");
    ctrl.showName();
    
    char[] arrChar = {'a', 'b', 'c'};

    String[] arrStr={"abc", "efg", "hij"};
    int[] arrNum={1,2,3};
    
    ctrl.showCharArr(arrChar);
    
    ctrl.showObjOptArr(arrStr);
    ctrl.showIntOptArr(arrNum);
    }
    
}

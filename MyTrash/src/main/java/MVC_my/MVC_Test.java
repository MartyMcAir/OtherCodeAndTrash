/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_my;

//import MVC_my.*;

/**
 *
 * @author MartyMcAir
 */
public class MVC_Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //clsModel model = fromDB();
        
        //clsModelDB modelVar = new clsModelDB();
        //clsModel model = modelVar.modelDB();
        
        clsModel model = new clsModel();
        
        clsView view = new clsView();
        clsController controller = new clsController(model, view);
        
        controller.updateView();
        controller.setName("Test1");
        controller.updateView();
    }
    
    private static clsModel fromDB(){
    clsModel model = new clsModel();
    model.setName("Test2");
    return model;
    }
    
}

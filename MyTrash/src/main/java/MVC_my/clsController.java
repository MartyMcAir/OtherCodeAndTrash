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
public class clsController {
    private clsModel model;
    private clsView view;
    
    clsController(clsModel model, clsView view){
    this.model=model;
    this.view=view;
    }
    
    public String getName(){
    return model.getName();
    }
    
    public void setName(String name){
    model.setName(name);
    }
    
    public void updateView(){
    view.printName(model.getName());
    }
}

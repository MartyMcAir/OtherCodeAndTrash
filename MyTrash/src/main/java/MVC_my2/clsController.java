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
public class clsController {
  private clsModel model;
  private clsView view;
  
  public clsController(clsModel model, clsView view){
    this.model=model;
    this.view=view;
  }
  
  public void setName(String name){
    model.setName(name);
  }
  
  public String getName(){
    return model.getName();
  }
  
  public void showName(){
    view.printName(model.getName());
  }

  public void showCharArr(char[] arr){
    view.printArrCh(arr);
  }
  
  // Обработка произвольного кол-ва объектов, строк
  public void showObjOptArr(Object... arr){
    view.printOptionaly(arr);
  }

  public void showIntOptArr(int... arr){
    view.printIntOptionaly(arr);
  }
  
}

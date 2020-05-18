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
public class clsModel {
  private String name;
  private char[] arrChar={'x', 'y', 'z'};
  
  /* *
  public clsModel(){
    clsModel model = new clsModel();
  } /* */
  
  public void setName(String name){
    this.name=name;
  }
  
  public String getName(){
    return name;
  }
  
  public char[] getArrChar(){
    return arrChar;
  }
}

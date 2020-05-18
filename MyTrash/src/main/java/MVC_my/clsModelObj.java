/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MVC_my;

/**
 *
 * @author MartyMcAir
 */
public class clsModelObj {

    public static void main(String[] args) {
        clsModelObj obj1;
        clsModelObj obj2;
        obj1 = new clsModelObj("строка");
        System.out.println(obj1.getObj());

        obj1 = new clsModelObj(888);
        System.out.println(obj1.getObj());

        obj2 = new clsModelObj(6.66);
        // instanceof- проверяет соответствие типа к нужному
        if (obj2.getObj() instanceof String) {
            // используем приведение к типу
            String str2 = (String) obj2.getObj();
            System.out.println(str2);
        } else if (obj2.getObj() instanceof Double) {
            Double str4 = (Double) obj2.getObj();
            System.out.println(str4);
        }

    }
    private Object var;

    public clsModelObj(Object var) {
        this.setObj(var);
    }

    public void setObj(Object var) {
        this.var = var;
    }

    public Object getObj() {
        return var;
    }
}

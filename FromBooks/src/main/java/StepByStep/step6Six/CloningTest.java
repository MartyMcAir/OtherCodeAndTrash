/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author MartyMcAir
 */
public class CloningTest {

    public static void main(String[] args) throws CloneNotSupportedException {

        Employee emp = new Employee();

        emp.setId(1);
        emp.setName("Pankaj");
        Map<String, String> props = new HashMap<>();
        props.put("salary", "10000");
        props.put("city", "Bangalore");
        emp.setProps(props);

        // если перместить то результат координально поменяется
        // хотя казалось бы какая разница где расположенно создание экземпляра класса
        Employee clonedEmp = (Employee) emp.clone();
        // Check whether the emp and clonedEmp attributes are same or different
        System.out.println("emp and clonedEmp == test: " + (emp == clonedEmp));

        System.out.println("emp and clonedEmp HashMap == test: " + (emp.getProps() == clonedEmp.getProps()));

        // Let's see the effect of using default cloning
        // change emp props
        emp.getProps().put("title", "CEO");
        emp.getProps().put("city", "New York");
        System.out.println("clonedEmp props:" + clonedEmp.getProps());

        // change emp name
        emp.setName("new");
        System.out.println("clonedEmp name:" + clonedEmp.getName());

    }

}

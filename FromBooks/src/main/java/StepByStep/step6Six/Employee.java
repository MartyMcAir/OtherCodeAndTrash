/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six;

import java.util.Map;

/**
 *
 * @author MartyMcAir
 */
public class Employee implements Cloneable{

    private int id;

    private String name;

    private Map<String, String> props;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getProps() {
        return props;
    }

    public void setProps(Map<String, String> p) {
        this.props = p;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

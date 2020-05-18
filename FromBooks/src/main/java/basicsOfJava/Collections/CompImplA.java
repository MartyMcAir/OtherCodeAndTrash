/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava.Collections;

/**
 *
 * @author MartyMcAir
 */
    public class CompImplA implements Comparable<CompImplA>{
    private int x;
    private int y;

    public CompImplA(int x) {
        this.x = x;
    }
    
    public CompImplA(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    @Override   // // переопределяем метод с Comparable
    public int compareTo(CompImplA o) {
        if (this.x > o.x) {
            return 1;
        }
        if (this.x < o.x) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "{" + this.x + ";" + this.y + "}";
    }

    @Override // переопредел метод с базового для всех Object класса
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    //переопредел метод с базового для всех Object класса
    // метод сравнения объектов
    @Override
    public boolean equals(Object obj){
        // если текущ объект равен объекту аргументу
        if(this == obj) return true;
        
        // если текущ объект равен null
        if(this == null) return false;
        // если текущ класс объекта не равен текущ классу аргумента
        if(this.getClass() != obj.getClass())
            return false;
        // Объявление переменной класа
        // приведение аргумента объекта к типа CompImplA класса
        CompImplA oth = (CompImplA) obj;
        if(this.x != oth.x) return false;
        if(this.y != oth.y) return false;
        return true;
    }
}

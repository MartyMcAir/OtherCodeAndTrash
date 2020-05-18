/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon2;

import java.util.Arrays;

/**
 *
 * @author MartyMcAir
 */
public class Book1 implements Cloneable{
    private String name;
    private Author1 author;
    private String[] contents;
    
    Book1(String name, String author){
        this.name=name;
        this.author= new Author1(author);
    }
    String[] getContents(){
        return this.contents;
    }
    void setContents(String[] arr){
        this.contents=arr;
    }
    void setName(String name){
        this.name=name;
    }
    String getName(){
        return this.name;
    }
    String getAuthor(){
        return author.getName();
    }
    void setAuthor(String auth){
        author.setName(auth);
    }
    void displayBookName(){
        System.out.println("book: "+this.name+", author: "+this.getAuthor()+
                "\n___ and arr: "+Arrays.toString(contents));
    }
    // если Object вместо Book, то выдает ошибку
    public Book1 clone(){
        Book1 obj = null;
        try{
            obj = (Book1) super.clone();
            obj.author = (Author1) author.clone();
            // для arr бессмысленно т.к. видимых изменений не видно
//            obj.contents = (String[]) obj.contents.clone();
        }catch(CloneNotSupportedException e){
            System.err.println("err: "+e.getMessage());
        }
        return obj;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StepByStep.step6Six.clon3;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author MartyMcAir
 */
public class Book implements Cloneable{
    private String name;
    private Author author;
    private String[] contents;
    private SimpleDateFormat d = new SimpleDateFormat();

    Book(String name, String author){
        this.name=name;
        this.author= new Author(author);
    }
    
    Date changeDatePattern(String str){
        this.d.applyPattern(str);
        return this.d.get2DigitYearStart();
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
    public Book clone(){
        Book obj = null;
        try{
            obj = (Book) super.clone();
            obj.author = (Author) author.clone();
            // для arr бессмысленно т.к. видимых изменений не видно
//            obj.contents = (String[]) obj.contents.clone();
        }catch(CloneNotSupportedException e){
            System.err.println("err: "+e.getMessage());
        }
        return obj;
    }
}

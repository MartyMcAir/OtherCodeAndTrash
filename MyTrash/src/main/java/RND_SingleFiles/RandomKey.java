/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RND_SingleFiles;

import javax.swing.*;
import java.util.Random;

/**
 *
 * @author MartyMcAir
 */
public class RandomKey {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Random r = new Random(); System.out.println(r.nextFloat()); // 0.2868402
       
        Random rnd = new Random(System.currentTimeMillis());
        int secret = 1 + rnd.nextInt(10);
        int userData , tryUser = 0, userChance=3, tryLeft;
        String userInput;
        
        while(true){
        // Выводим окно запроса
        userInput = JOptionPane.showInputDialog("Угадайте число от 1 до 10");
        // Преобразуем строку в число в явном виде
        userData = Integer.parseInt(userInput);
        
        if(userData == secret){
            JOptionPane.showMessageDialog(null, "Вы угадали число!");
            break;
        }
        else if(userData==99){
            // выход при вводе 99
            break;
        }
        else if(userData!=secret){
            tryUser++;
            tryLeft=userChance-tryUser;
        JOptionPane.showMessageDialog(null, "Не получилось, попробуйте ещё раз! ");
        //System.out.print("\n"); // перенос строки
        JOptionPane.showMessageDialog(null, "У вас попытка №"+tryUser+" осталось попыток"+tryLeft+"");
            // break; // если раскоментировать после ок будет сброс программы
            
            if(tryUser==userChance){
            JOptionPane.showMessageDialog(null, "У вас была последняя попытка №"+tryUser+" Пока Пока ");
            break;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Не получилось, попробуйте ещё раз!");
            // break; // если раскоментировать после ок будет сброс программы
        }
        
        } //while
        
        }
}

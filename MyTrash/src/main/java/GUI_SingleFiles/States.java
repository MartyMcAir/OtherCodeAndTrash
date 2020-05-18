/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_SingleFiles;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author MartyMcAir
 */
public class States extends JFrame implements ItemListener {

    public static void main(String[] args) {
        States gui = new States();
    }
    JPanel pnl = new JPanel();

    String[] styles = {"В глубокой форме", "Для гурманов", "Тонкая"};
    JComboBox<String> box = new JComboBox<String>(styles);
    JRadioButton rad1 = new JRadioButton("Белое");
    JRadioButton rad2 = new JRadioButton("Красное");
    ButtonGroup wines = new ButtonGroup();
    JCheckBox chk = new JCheckBox("Пепперони");
    JTextArea txtArea = new JTextArea(5, 38);

    public States() {
        super("Swing Window");
        setSize(500, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(pnl);

        wines.add(rad1);
        wines.add(rad2);

        pnl.add(rad1); // добавляем на JPanel компоненты	
        pnl.add(rad2);
        pnl.add(chk);
        pnl.add(box);
        pnl.add(txtArea);

        rad1.addItemListener(this); // генерируем события
        rad2.addItemListener(this);
        chk.addItemListener(this);
        box.addItemListener(this);

        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent event) { // метод обработчик
        if (event.getItemSelectable() == rad1) {
            txtArea.setText("Выбрано белое вино");
        }

        if (event.getItemSelectable() == rad2) {
            txtArea.setText("Выбрано красное вино");
        }

        // Определяем статус компонентов JCheckBox
        if ((event.getItemSelectable() == chk)
                && (event.getStateChange() == ItemEvent.SELECTED)) {
            txtArea.append("\nВыбрана Пепперони\n");
        }
        // Определяем статус компонентов JComboBox
        if ((event.getItemSelectable() == box)
                && (event.getStateChange() == ItemEvent.SELECTED)) {
            txtArea.append("Выбрана" + event.getItem().toString());
        }
    }
}

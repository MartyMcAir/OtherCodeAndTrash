package GUI_SingleFiles;

/**
 * РўРµСЃС‚РѕРІС‹Р№ РєР»Р°СЃСЃ СЃРѕР·РґР°РЅРёСЏ РґРёР°Р»РѕРіРѕРІС‹С… РѕРєРѕРЅ
 */
// http://java-online.ru/swing-windows.xhtml

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Utf8_JDialogTest extends JFrame {

    private static final long serialVersionUID = 1L;

    public Utf8_JDialogTest() {
        super("DialogWindows");
        // Р’С‹С…РѕРґ РёР· РїСЂРѕРіСЂР°РјРјС‹ РїСЂРё Р·Р°РєСЂС‹С‚РёРё
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // РљРЅРѕРїРєРё РґР»СЏ СЃРѕР·РґР°РЅРёСЏ РґРёР°Р»РѕРіРѕРІС‹С… РѕРєРѕРЅ
        JButton button1 = new JButton("РќРµРјРѕРґР°Р»СЊРЅРѕРµ РѕРєРЅРѕ");
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = createDialog("РќРµРјРѕРґР°Р»СЊРЅРѕРµ", false);
                dialog.setVisible(true);
            }
        });
        JButton button2 = new JButton("РњРѕРґР°Р»СЊРЅРѕРµ РѕРєРЅРѕ");
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JDialog dialog = createDialog("РњРѕРґР°Р»СЊРЅРѕРµ", true);
                dialog.setVisible(true);
            }
        });
        // РЎРѕР·РґР°РЅРёРµ РїР°РЅРµР»Рё СЃРѕРґРµСЂР¶РёРјРѕРіРѕ СЃ СЂР°Р·РјРµС‰РµРЅРёРµРј РєРЅРѕРїРѕРє
        JPanel contents = new JPanel();
        contents.add(button1);
        contents.add(button2);
        setContentPane(contents);
        // РћРїСЂРµРґРµР»РµРЅРёРµ СЂР°Р·РјРµСЂР° Рё РѕС‚РєСЂС‹С‚РёРµ РѕРєРЅР°
        setSize(350, 100);
        setVisible(true);
    }

    /**
     * Р¤СѓРЅРєС†РёСЏ СЃРѕР·РґР°РЅРёСЏ РґРёР°Р»РѕРіРѕРІРѕРіРѕ РѕРєРЅР°.
     *
     * @param title - Р·Р°РіРѕР»РѕРІРѕРє РѕРєРЅР°
     * @param modal - С„Р»Р°Рі РјРѕРґР°Р»СЊРЅРѕСЃС‚Рё
     */
    private JDialog createDialog(String title, boolean modal) {
        JDialog dialog = new JDialog(this, title, modal);
        dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        dialog.setSize(180, 90);
        return dialog;
    }

    public static void main(String[] args) {
        new Utf8_JDialogTest();
    }
}

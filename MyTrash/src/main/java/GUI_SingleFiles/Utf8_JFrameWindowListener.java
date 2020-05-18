package GUI_SingleFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

// http://java-online.ru/swing-windows.xhtml
public class Utf8_JFrameWindowListener extends JFrame
{
	private static final long serialVersionUID = 1L;
	private static int    counter = 0; // СЃС‡РµС‚С‡РёРє
	private static JLabel label   = null;
	private static String TEMPL   = "Р—Р°РєСЂС‹С‚РёРµ РѕРєРЅР° (РїРѕРїС‹С‚РѕРє %d)";
	public Utf8_JFrameWindowListener ()
	{
		// РЎРѕР·РґР°РЅРёРµ РѕРєРЅР° СЃ Р·Р°РіРѕР»РѕРІРєРѕРј
        JFrame frame = new JFrame("JFrameWindowListener");
		// РќРµ Р·Р°РєСЂС‹РІР°С‚СЊ РѕРєРЅРѕ РїРѕ РЅР°Р¶Р°С‚РёСЋ РЅР° РєРЅРѕРїРєСѓ СЃ РєСЂРµСЃС‚РёРєРѕРј 
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // РџРѕРґРєР»СЋС‡РµРЅРёРµ СЃР»СѓС€Р°С‚РµР»СЏ РѕРєРЅР°
        frame.addWindowListener(new WindowListener() {
 
            public void windowActivated  (WindowEvent event) {}
            public void windowClosed     (WindowEvent event) {}
            public void windowDeactivated(WindowEvent event) {}
            public void windowDeiconified(WindowEvent event) {}
            public void windowIconified  (WindowEvent event) {}
            public void windowOpened     (WindowEvent event) {}
            // РњРµС‚РѕРґ РѕР±СЂР°Р±РѕС‚РєРё СЃРѕР±С‹С‚РёСЏ "Р—Р°РєСЂС‹С‚РёРµ РѕРєРЅР°"
            public void windowClosing (WindowEvent event) {
            	if (++counter == 3) {
            		event.getWindow().setVisible(false);
            		System.exit(0);
            	} else
            		label.setText(String.format(TEMPL, counter));
            }
        }); 
        label = new JLabel(String.format(TEMPL, counter));
        frame.getContentPane().add(label);

        frame.setPreferredSize(new Dimension(250, 80));
        frame.pack();
        frame.setVisible(true);
	}
    public static void main(String[] args)
    {
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Utf8_JFrameWindowListener();
    }
}

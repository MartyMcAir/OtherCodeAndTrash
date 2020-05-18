package GUI_SingleFiles;

// РЎРѕР·РґР°РЅРёРµ СЃРїРµС†РёР°Р»СЊРЅС‹С… РѕС„РѕСЂРјР»РµРЅРёР№ РѕРєРѕРЅ Swing
// http://java-online.ru/swing-windows.xhtml
import javax.swing.*;

public class Utf8_JFrameDecorations
{
	public static void main(String[] args)
	{
		// РџРѕРґРєР»СЋС‡РµРЅРёРµ СѓРєСЂР°С€РµРЅРёР№ РґР»СЏ РѕРєРѕРЅ
		JFrame.setDefaultLookAndFeelDecorated(true);
		JDialog.setDefaultLookAndFeelDecorated(true);
		// РЎРѕР·РґР°РЅРёРµ РѕРєРЅР° СЃ СЂР°РјРєРѕР№
		JFrame frame = new JFrame("OРєРЅo СЃ СЂР°РјРєРѕР№");
		// РћРїСЂРµРґРµР»РµРЅРёРµ СЃРїРѕСЃРѕР±Р° Р·Р°РІРµСЂС€РµРЅРёСЏ СЂР°Р±РѕС‚С‹ РїСЂРѕРіСЂР°РјРјС‹
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
		// РЎРѕР·РґР°РЅРёРµ РґРёР°Р»РѕРіРѕРІРѕРіРѕ РѕРєРЅР°
		JDialog dialog = new JDialog(frame, "Р”РёР°Р»РѕРіРѕРІРѕРµ РѕРєРЅРѕ");
		// РћРїСЂРµРґРµР»РµРЅРёРµ СЃРїРѕСЃРѕР±Р° Р·Р°РІРµСЂС€РµРЅРёСЏ СЂР°Р±РѕС‚С‹ РґРёР°Р»РѕРіРѕРІРѕРіРѕ РѕРєРЅР°
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setSize(150, 100);
		// РћРїСЂРµРґРµР»РµРЅРёРµ С‚РёРїР° РѕС„РѕСЂРјР»РµРЅРёСЏ РѕРєРЅР°
		dialog.getRootPane().setWindowDecorationStyle(JRootPane.INFORMATION_DIALOG);
		dialog.setVisible(true);
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OOP_PolimorfismMy;

/**
 *
 * @author MartyMcAir
 */
public class Cat extends Animals{
    // РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ
    Cat(String nm, String snd, int wt){
        super(nm,snd,wt);
    }
    // РѕРїРёСЃР°РЅРёРµ РјРµС‚РѕРґР°, РЅР°СЃР»РµРґРѕРІР°РЅРЅРѕРіРѕ РёР· СЃСѓРїРµСЂРєР»Р°СЃСЃР°
    @Override
    void doAnimal(){
        System.out.println("Р–РёРІРѕС‚РЅРѕРµ "+name+" РІРµСЃРёС‚ РїСЂРёРјРµСЂРЅРѕ "+weight+"РєРі, РёР·РґР°РµС‚ Р·РІСѓРє "+sound);
        System.out.println("Р­С‚Рѕ Р¶РёРІРѕС‚РЅРѕРµ РІС‹РїРѕР»РЅСЏРµС‚ РґРµР№СЃС‚РІРёРµ:");
        System.out.println("Р›РѕРІРёС‚ РјС‹С€РµР№.");
    }
}

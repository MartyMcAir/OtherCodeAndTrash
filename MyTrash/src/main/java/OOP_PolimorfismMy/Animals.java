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
abstract class Animals {
    String name;
    String sound;
    int weight;
    // РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ РєР»Р°СЃСЃР°
    Animals(String nm, String snd, int wt){
        name=nm;
        sound=snd;
        weight=wt;
    }
    // Р°Р±СЃС‚СЂР°РєС‚РЅС‹Р№ РјРµС‚РѕРґ
    abstract void doAnimal();
}

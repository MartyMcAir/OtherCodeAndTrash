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
public class ExtendsClass {

static Cats[] abc = new Cats[3]; // РґР»СЏ РёСЃРїРѕР»СЊР·РѕРІР°РЅРёСЏ РѕР±СЉРµРєС‚Р° РєР°Рє РјР°СЃСЃРёРІР°
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* РћР±СЉРµРєС‚ РєР°Рє РјР°СЃСЃРёРІ РЅРµ СѓРґР°Р»РѕСЃСЊ *
		for(int i=0; i<5; i++ ){
		//Cat[] objCat = new Cat[i]("РњР°СЂСѓ","РњСѓ-РјСѓ-РјСѓ",3);
		Cat[i] objCat = new Cat[i];
                objCat[i].doAnimal();
	} /* */
        /* */
        // Р° РІРѕС‚ СЌС‚Рѕ СЂР°Р±РѕС‚Р°РµС‚
        abc[0] = new Cats("Kitty");
        abc[1] = new Cats("Molly");
        abc[2] = new Cats("Lily");
        
        for (int i=0; i<3; i++){
            System.out.println(abc[i].name);
        }
        
        int[ ] primes = {2, 3, 5, 7, 8};
	for (int t: primes) { // РєР°Р¶РґС‹Р№ СЂР°Р· "t" Р±СѓРґРµС‚ РЅРµРѕР±С…РѕРґРёРјС‹Рј РЅРѕРјРµСЂРѕРј РёРЅРґРµРєСЃР° РјР°СЃСЃРёРІР°
	System.out.println(t); }
        /* */
        
        // РѕР±СЉРµРєС‚ РєРѕС€РєР° РњР°СЂСѓСЃСЏ РїРѕРґРєР»Р°СЃСЃР° Cat
        Cat objCat=new Cat("РњР°СЂСѓСЃСЏ","РњСѓСЂ-РјСѓСЂ-РјСѓСЂ",3);
        // РѕР±СЉРµРєС‚ РїРµСЃ РўСѓР·РёРє РїРѕРґРєР»Р°СЃСЃР° Dog
        Dog objDog1=new Dog("РўСѓР·РёРє","Р“Р°РІ-РіР°РІ-РіР°РІ",9);
        // РѕР±СЉРµРєС‚ РїРµСЃ Р‘Р°СЂР±РѕСЃ РїРѕРґРєР»Р°СЃСЃР° Dog
        Dog objDog2=new Dog("Р‘Р°СЂР±РѕСЃ","Р -СЂ-СЂ-СЂ-СЂ",15);
        // РјРµС‚РѕРґ РѕР±СЉРµРєС‚Р° РїРѕРґРєР»Р°СЃСЃР° Cat
        objCat.doAnimal();
        // РјРµС‚РѕРґ РїРµСЂРІРѕРіРѕ РѕР±СЉРµРєС‚Р° РїРѕРґРєР»Р°СЃСЃР° Dog
        objDog1.doAnimal();
        // РјРµС‚РѕРґ РІС‚РѕСЂРѕРіРѕ РѕР±СЉРµРєС‚Р° РїРѕРґРєР»Р°СЃСЃР° Dog
        objDog2.doAnimal();
    }
}
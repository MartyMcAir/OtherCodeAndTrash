/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_FromBook;

/**
 *
 * @author MartyMcAir
 */ // extends Entity
class Abonent extends EntityMy {

    public String name;

    /**
     * The type of the entity.
     */
    public int type;

    /**
     * The char array of data.
     */
    public char data[];

    /**
     * Creates an entity.
     *
     * @param name the name of the entity
     * @param type the type of the entity
     * @param data the char array of data
     */
    public Abonent(String name, int type, char[] data) {
        super(name, type, data);
        this.name = name;
        this.type = type;
        this.data = data;
    }

    void setId(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setPhone(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setLastName(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

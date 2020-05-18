/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB_FromBook;

/*
 * Copyright (c) 1998, 2008, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

import javax.swing.text.html.parser.DTDConstants;
import java.util.Hashtable;

/**
 * An entity is described in a DTD using the ENTITY construct. It defines the
 * type and value of the entity.
 *
 * @see DTD
 * @author Arthur van Hoff
 */
public class EntityMy implements DTDConstants {

    /**
     * The name of the entity.
     */
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
    public EntityMy(String name, int type, char data[]) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    /**
     * Gets the name of the entity.
     *
     * @return the name of the entity, as a <code>String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type of the entity.
     *
     * @return the type of the entity
     */
    public int getType() {
        return type & 0xFFFF;
    }

    /**
     * Returns <code>true</code> if it is a parameter entity.
     *
     * @return <code>true</code> if it is a parameter entity
     */
    public boolean isParameter() {
        return (type & PARAMETER) != 0;
    }

    /**
     * Returns <code>true</code> if it is a general entity.
     *
     * @return <code>true</code> if it is a general entity
     */
    public boolean isGeneral() {
        return (type & GENERAL) != 0;
    }

    /**
     * Returns the <code>data</code>.
     *
     * @return the <code>data</code>
     */
    public char getData  () 
        [] {
        return data;
    }

    /**
     * Returns the data as a <code>String</code>.
     *
     * @return the data as a <code>String</code>
     */
    public String getString() {
        return new String(data, 0, data.length);
    }

    static Hashtable<String, Integer> entityTypes = new Hashtable<String, Integer>();

    static {
        entityTypes.put("PUBLIC", Integer.valueOf(PUBLIC));
        entityTypes.put("CDATA", Integer.valueOf(CDATA));
        entityTypes.put("SDATA", Integer.valueOf(SDATA));
        entityTypes.put("PI", Integer.valueOf(PI));
        entityTypes.put("STARTTAG", Integer.valueOf(STARTTAG));
        entityTypes.put("ENDTAG", Integer.valueOf(ENDTAG));
        entityTypes.put("MS", Integer.valueOf(MS));
        entityTypes.put("MD", Integer.valueOf(MD));
        entityTypes.put("SYSTEM", Integer.valueOf(SYSTEM));
    }

    /**
     * Converts <code>nm</code> string to the corresponding entity type. If the
     * string does not have a corresponding entity type, returns the type
     * corresponding to "CDATA". Valid entity types are: "PUBLIC", "CDATA",
     * "SDATA", "PI", "STARTTAG", "ENDTAG", "MS", "MD", "SYSTEM".
     *
     * @param nm the string to be converted
     * @return the corresponding entity type, or the type corresponding to
     * "CDATA", if none exists
     */
    public static int name2type(String nm) {
        Integer i = entityTypes.get(nm);
        return (i == null) ? CDATA : i.intValue();
    }
}

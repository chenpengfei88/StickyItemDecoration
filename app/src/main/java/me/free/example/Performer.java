package me.free.example;

/**
 * Created by cpf on 2018/1/16.
 */

public class Performer {

    /**
     * 名字
     */
    private String name;

    /**
     * item type
     */
    private int itemType;

    public Performer(String name, int itemType) {
        this.name = name;
        this.itemType = itemType;
    }

    public Performer(String name) {
      this(name, 11);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

}

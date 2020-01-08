package me.free.example;

/**
 * Created by cpf on 2018/1/16.
 */

public class Performer {
    public static final int TYPE_TITLE = 11;
    public static final int TYPE_CONTENT = 10;

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
      this(name, TYPE_TITLE);
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

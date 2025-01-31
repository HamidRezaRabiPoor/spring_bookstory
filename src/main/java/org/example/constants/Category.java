package org.example.constants;

import java.util.HashMap;
import java.util.Map;

public enum Category {
    LITERATURE(0),
    NONFICTION(1),
    ACTION(2),
    THRILLER(3),
    TECHNOLOGY(4),
    DRAMA(5),
    POETRY(6),
    MEDIA(7),
    OTHERS(8);

    private final int i;
    Category(int i){
        this.i = i;
    }
    private static final Map<Object, Object> map = new HashMap<>();

    static {
        for(Category category: Category.values()){
            map.put(category.i, category);
        }
    }
    public static Category valueOf(int entry){
        return (Category) map.get(entry);
    }
    public int getValue(){
        return i;
    }
}

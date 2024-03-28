package com.example.quizproject.db.models.advancedInputs;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Difficultydadasdsadd {
    EASY("easy"), MEDIUM("medium"), HARD("hard");
    private final String code;

    Difficultydadasdsadd(String code) {
        this.code = code;
    }

    @Override
    @JsonValue
    public String toString() {
        return code;
    }

    @JsonCreator
    public static Difficultydadasdsadd getByCode(String code){
        for (Difficultydadasdsadd Difficulty : values()) {
            if (Difficulty.code.equals(code)) {
                return Difficulty;
            }
        }
        return null;
    }

}

package org.guimo.jokempo.valueobjects;

public enum MoveEnum {
    Rock("Pedra"), Paper("Papel"), Scissors("Tesoura");

    private final String value;

    MoveEnum(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public String getValue() {
        return value;
    }
}

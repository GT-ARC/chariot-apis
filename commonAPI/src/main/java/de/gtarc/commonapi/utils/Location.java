package de.gtarc.commonapi.utils;


public class Location {

    public String id;
    public String identifier;
    public String type;
    public String name;
    public Position position;
    public int level;
    public Indoorposition indoorposition;

    public Location() {
    }

    public Location(String identifier, String type, String name, int level) {
        this.identifier = identifier;
        this.type = type;
        this.name = name;
        this.level = level;
    }

    public Location(String identifier, String type, String name, int level, Position position, Indoorposition indoorposition) {
        this.identifier = identifier;
        this.type = type;
        this.name = name;
        this.position = position;
        this.level = level;
        this.indoorposition = indoorposition;
    }

    public String getIdentifier() {
        return identifier;
    }


    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Position getPosition() {
        return position;
    }


    public void setPosition(Position position) {
        this.position = position;
    }


    public int getLevel() {
        return level;
    }


    public void setLevel(int level) {
        this.level = level;
    }

    public Indoorposition getIndoorposition() {
        return indoorposition;
    }

    public void setIndoorposition(Indoorposition indoorposition) {
        this.indoorposition = indoorposition;
    }

}

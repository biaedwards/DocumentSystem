package DocumentSystem;

import java.util.LinkedHashMap;

public class Word extends OfficeDoc implements Editable, Encryptable{
    private int characters;
    private boolean encrypted = false;

    Word(String name) {
        super(name);
    }

    public int getCharacters() {
        return characters;
    }

    public void setCharacters(int characters) {
        this.characters = characters;
    }

    @Override
    public void LoadProperty(String key, String value) {
        switch (key) {
            case "content":
                setContent(value);
                break;
            case "characters":
                characters = Integer.parseInt(value);
                break;
            default:
                try {
                    throw new NoSuchFieldException();
                } catch (NoSuchFieldException e) {
                    System.out.println("There is no such property to load.");
                }
                break;
        }
    }

    @Override
    public void saveAllProperties(LinkedHashMap<String, String> output) {
        super.saveAllProperties(output);
        if(characters!=0)output.put("characters", String.valueOf(characters));
    }

    @Override
    public void changeContent(String newContent) {
        setContent(newContent);
    }

    @Override
    public boolean isEncrypted() {
        return encrypted;
    }

    @Override
    public void encrypt() {
        encrypted = true;
    }

    @Override
    public void decrypt() {
        encrypted = false;
    }

    @Override
    public String getType() {
        return "Word";
    }
}

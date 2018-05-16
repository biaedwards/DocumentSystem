package DocumentSystem;

import java.util.LinkedHashMap;

public class PDF extends BinaryDoc implements Encryptable{
    private int pages;
    private boolean encrypted = false;

    PDF(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "PDF";
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public void LoadProperty(String key, String value) {
        switch (key) {
            case "content":
                setContent(value);
                break;
            case "pages":
                pages = Integer.parseInt(value);
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
        if(pages!=0)output.put("pages", String.valueOf(pages));
        if(getSize()!=0)output.put("size", String.valueOf(getSize()));
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
}

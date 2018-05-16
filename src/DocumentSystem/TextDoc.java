package DocumentSystem;

import java.util.LinkedHashMap;

public class TextDoc extends Document implements Editable{
    private String charset;

    TextDoc(String name) {
        super(name);
    }

    @Override
    public void changeContent(String newContent) {
        setContent(newContent);
    }

    @Override
    public void LoadProperty(String key, String value) {
        switch (key) {
            case "content":
                setContent(value);
                break;
            case "charset":
                charset = value;
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
        if(charset != null) output.put("charset", charset);
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }
}

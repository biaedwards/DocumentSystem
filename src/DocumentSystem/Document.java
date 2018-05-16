package DocumentSystem;

import java.util.LinkedHashMap;

public abstract class Document implements Doc {
    private String name;
    private String content;

    Document(String name){
        this.name = name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType(){
        return "";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void LoadProperty(String key, String value) {
        if(key.equals("name")) name = value;
        else if(key.equals("content")) content = value;
        else try {
                throw new NoSuchFieldException();
            } catch (NoSuchFieldException e) {
                System.out.println("There is no such property to load.");
            }
    }

    @Override
    public void saveAllProperties(LinkedHashMap<String, String> output) {
        output.put("name", name);
        if(content!=null)output.put("content", content);
    }

    @Override
    public String toString(){
        LinkedHashMap<String, String> properties = new LinkedHashMap<>();
        saveAllProperties(properties);
        StringBuilder answer = new StringBuilder();
        answer.append(getType()+"Document[");
        if(this instanceof Encryptable && ((Encryptable) this).isEncrypted()){
            answer.append("encrypted][");
        }
        for (String property:properties.keySet()){
            answer.append(property+":"+properties.get(property)+";");
        }
        answer.replace(answer.length()-1, answer.length(), "]");
        return answer.toString();
    }
}

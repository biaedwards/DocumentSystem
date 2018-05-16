package DocumentSystem;

import java.util.LinkedHashMap;

public class Video extends Multimedia {
    private int frameRate;

    Video(String name) {
        super(name);
    }

    @Override
    public void LoadProperty(String key, String value) {
        switch (key) {
            case "content":
                setContent(value);
                break;
            case "length":
                setLength(Integer.parseInt(value));
            case "framerate":
                frameRate = Integer.parseInt(value);
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
        if(frameRate!=0)output.put("framerate", String.valueOf(frameRate));
        if(getLength()!=0) output.put("length", String.valueOf(getLength()));
    }

    @Override
    public String getType() {
        return "Video";
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
    }
}

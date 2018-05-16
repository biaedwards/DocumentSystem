package DocumentSystem;

import java.util.LinkedHashMap;

public class Audio extends Multimedia {
    private int sampleRate;

    Audio(String name) {
        super(name);
    }

    public int getSampleRate() {
        return sampleRate;
    }

    public void setSampleRate(int sampleRate) {
        this.sampleRate = sampleRate;
    }

    @Override
    public void LoadProperty(String key, String value) {
        switch (key) {
            case "content":
                setContent(value);
                break;
            case "samplerate":
                sampleRate = Integer.parseInt(value);
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
        if (sampleRate != 0) output.put("samplerate", String.valueOf(sampleRate));
        if (getLength() != 0) output.put("length", String.valueOf(getLength()));
    }

    @Override
    public String getType() {
        return "Audio";
    }
}

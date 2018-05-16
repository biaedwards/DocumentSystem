package DocumentSystem;

public abstract class Multimedia extends BinaryDoc{
    private int length;

    Multimedia(String name) {
        super(name);
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}

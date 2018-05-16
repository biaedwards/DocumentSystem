package DocumentSystem;

public abstract class OfficeDoc extends BinaryDoc{
    String version;

    OfficeDoc(String name) {
        super(name);
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}

package DocumentSystem;

import java.util.LinkedHashMap;

public class Excel extends OfficeDoc implements Encryptable {
    private int rows, cols;
    private boolean encrypted = false;

    Excel(String name) {
        super(name);
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    @Override
    public String getType() {
        return "Excel";
    }

    @Override
    public void LoadProperty(String key, String value) {
        switch (key) {
            case "content":
                setContent(value);
                break;
            case "rows":
                rows = Integer.parseInt(value);
                break;
            case "columns":
                cols = Integer.parseInt(value);
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
        if(rows!=0)output.put("rows", String.valueOf(rows));
        if(cols!=0)output.put("cols", String.valueOf(cols));
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

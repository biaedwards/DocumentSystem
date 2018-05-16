package DocumentSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Commands {
    private ArrayList<Document> docs;

    Commands() {
        docs = new ArrayList<>();
    }

    public void chooseCommand(String input) {
        if (input.contains("AddTextDocument")) {
            AddTextDocument(new StringBuilder(input));
            return;
        }
        if (input.contains("AddPDFDocument")) {
            AddPDFDocument(new StringBuilder(input));
            return;
        }
        if (input.contains("AddWordDocument")) {
            AddWordDocument(new StringBuilder(input));
            return;
        }
        if (input.contains("AddExcelDocument")) {
            AddExcelDocument(new StringBuilder(input));
            return;
        }
        if (input.contains("AddAudioDocument")) {
            AddAudioDocument(new StringBuilder(input));
            return;
        }
        if (input.contains("AddVideoDocument")) {
            AddVideoDocument(new StringBuilder(input));
            return;
        }
        if (input.contains("EncryptDocument")) {
            int start = input.indexOf('[');
            EncryptDocument(input.substring(start + 1, input.length() - 1));
            return;
        }
        if (input.contains("DecryptDocument")) {
            int start = input.indexOf('[');
            DecryptDocument(input.substring(start + 1, input.length() - 1));
            return;
        }
        if (input.contains("EncryptAllDocuments")) {
            EncryptAllDocuments();
            return;
        }
        if (input.contains("ListDocuments")) {
            ListDocuments();
            return;
        }
        if (input.contains("ChangeContent")) {
            ChangeContent(input);
        }
    }

    private void AddTextDocument(StringBuilder input) {
        int start = -1, end = -1;
        start = input.indexOf("name");
        if (start == -1) {
            System.out.println("Document has no name.");
            return;
        }
        end = input.substring(start).indexOf(";") + start;
        if (end == start - 1) end = input.indexOf("]");
        String name = input.substring(start + 5, end);
        TextDoc doc = new TextDoc(name);
        input.delete(start, end + 1);
        start = -1;
        end = -1;
        start = input.indexOf("charset");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setCharset(var);
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("content");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setContent(var);
            input.delete(start, end + 1);
        }
        docs.add(doc);
        System.out.printf("Document added: %s", doc.getName());
    }

    private void AddPDFDocument(StringBuilder input) {
        int start = -1, end = -1;
        start = input.indexOf("name");
        if (start == -1) {
            System.out.println("Document has no name.");
            return;
        }
        end = input.substring(start).indexOf(";") + start;
        if (end == start - 1) end = input.indexOf("]");
        String name = input.substring(start + 5, end);
        PDF doc = new PDF(name);
        input.delete(start, end + 1);
        start = -1;
        end = -1;
        start = input.indexOf("pages");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 6, end);
            doc.setPages(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("content");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setContent(var);
            input.delete(start, end + 1);
        }
        start = -1;
        end = -1;
        start = input.indexOf("size");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 5, end);
            doc.setSize(Integer.parseInt(var));
            input.delete(start, end + 1);
        }
        docs.add(doc);
        System.out.printf("Document added: %s", doc.getName());
    }

    private void AddWordDocument(StringBuilder input) {
        int start = -1, end = -1;
        start = input.indexOf("name");
        if (start == -1) {
            System.out.println("Document has no name.");
            return;
        }
        end = input.substring(start).indexOf(";") + start;
        if (end == start - 1) end = input.indexOf("]");
        String name = input.substring(start + 5, end);
        Word doc = new Word(name);
        input.delete(start, end + 1);
        start = -1;
        end = -1;
        start = input.indexOf("chars");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 6, end);
            doc.setCharacters(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("content");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setContent(var);
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("size");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 5, end);
            doc.setSize(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("version");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setVersion(var);
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        docs.add(doc);
        System.out.printf("Document added: %s", doc.getName());
    }

    private void AddExcelDocument(StringBuilder input) {
        int start = -1, end = -1;
        start = input.indexOf("name");
        if (start == -1) {
            System.out.println("Document has no name.");
            return;
        }
        end = input.substring(start).indexOf(";") + start;
        if (end == start - 1) end = input.indexOf("]");
        String name = input.substring(start + 5, end);
        Excel doc = new Excel(name);
        input.delete(start, end + 1);
        start = -1;
        end = -1;
        start = input.indexOf("rows");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 5, end);
            doc.setRows(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("cols");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 5, end);
            doc.setCols(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("content");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setContent(var);
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("size");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 5, end);
            doc.setSize(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("version");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setVersion(var);
            input.delete(start, end + 1);
        }
        docs.add(doc);
        System.out.printf("Document added: %s", doc.getName());
    }

    private void AddAudioDocument(StringBuilder input) {
        int start = -1, end = -1;
        start = input.indexOf("name");
        if (start == -1) {
            System.out.println("Document has no name.");
            return;
        }
        end = input.substring(start).indexOf(";") + start;
        if (end == start - 1) end = input.indexOf("]");
        String name = input.substring(start + 5, end);
        Audio doc = new Audio(name);
        input.delete(start, end + 1);
        start = -1;
        end = -1;
        start = input.indexOf("samplerate");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 11, end);
            doc.setSampleRate(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("content");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setContent(var);
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("size");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 5, end);
            doc.setSize(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("length");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setLength(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        docs.add(doc);
        System.out.printf("Document added: %s", doc.getName());
    }

    private void AddVideoDocument(StringBuilder input) {
        int start = -1, end = -1;
        start = input.indexOf("name");
        if (start == -1) {
            System.out.println("Document has no name.");
            return;
        }
        end = input.substring(start).indexOf(";") + start;
        if (end == start - 1) end = input.indexOf("]");
        String name = input.substring(start + 5, end);
        Video doc = new Video(name);
        input.delete(start, end + 1);
        start = -1;
        end = -1;
        start = input.indexOf("framerate");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 10, end);
            doc.setFrameRate(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("content");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setContent(var);
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("size");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 5, end);
            doc.setSize(Integer.parseInt(var));
            input.delete(start, end + 1);
            start = -1;
            end = -1;
        }
        start = input.indexOf("length");
        if (start != -1) {
            end = input.substring(start).indexOf(";") + start;
            if (end == start - 1) end = input.indexOf("]");
            String var = input.substring(start + 8, end);
            doc.setLength(Integer.parseInt(var));
            input.delete(start, end + 1);
        }
        docs.add(doc);
        System.out.printf("Document added: %s", doc.getName());
    }

    private void EncryptDocument(String name) {
        List<Document> toEncrypt = docs.stream()
                .filter(x -> x.getName().equals(name))
                .collect(Collectors.toList());
        if (toEncrypt.isEmpty()) {
            System.out.printf("Document not found: %s", name);
            return;
        }
        toEncrypt = toEncrypt.stream()
                .filter(x -> x instanceof Encryptable)
                .collect(Collectors.toList());
        if (toEncrypt.isEmpty()) {
            System.out.printf("Document does not support encryption: %s", name);
            return;
        }
        for (Document x : toEncrypt) {
            ((Encryptable) x).encrypt();
        }
        System.out.printf("Document encrypted: %s", toEncrypt.get(0).getName());
    }

    private void DecryptDocument(String name) {
        List<Document> toDecrypt = docs.stream()
                .filter(x -> x.getName().equals(name))
                .collect(Collectors.toList());
        if (toDecrypt.size() == 0) {
            System.out.printf("Document not found: %s", name);
            return;
        }
        toDecrypt = toDecrypt.stream()
                .filter(x -> x instanceof Encryptable)
                .collect(Collectors.toList());
        if (toDecrypt.size() == 0) {
            System.out.printf("Document does not support decryption: %s", name);
            return;
        }
        for (Document x : toDecrypt) {
            ((Encryptable) x).decrypt();
        }
        System.out.printf("Document decrypted: %s", toDecrypt.get(0).getName());
    }

    private void EncryptAllDocuments() {
        List<Document> toEncrypt = docs.stream()
                .filter(x -> x instanceof Encryptable)
                .collect(Collectors.toList());
        if (toEncrypt.isEmpty()) {
            System.out.println("No encryptable documents found.");
            return;
        }
        for (Document x : toEncrypt) {
            ((Encryptable) x).encrypt();
        }
        System.out.println("All documents encrypted.");
    }

    private void ListDocuments() {
        docs.forEach(System.out::println);
    }

    private void ChangeContent(String input) {
        int start = -1, end = -1;
        start = input.indexOf('[');
        end = input.indexOf(';');
        String name = input.substring(start + 1, end);
        String content = input.substring(end + 1, input.length() - 1);
        List<Document> toEdit = docs.stream()
                .filter(x -> x.getName().equals(name))
                .collect(Collectors.toList());
        if (toEdit.isEmpty()) {
            System.out.printf("Document not found %s", name);
            return;
        }
        toEdit = toEdit.stream()
                .filter(x -> x instanceof Editable)
                .collect(Collectors.toList());

        if (toEdit.isEmpty()) {
            System.out.printf("Document is not editable %s", name);
            return;
        }
        for (Document x : toEdit) {
            x.setContent(content);
            System.out.printf("Document content changed %s", name);
        }
    }
}

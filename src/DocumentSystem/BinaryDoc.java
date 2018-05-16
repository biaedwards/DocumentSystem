package DocumentSystem;

 abstract class BinaryDoc extends Document {
    int size;

     BinaryDoc(String name) {
         super(name);
     }

     public int getSize() {
         return size;
     }

     public void setSize(int size) {
         this.size = size;
     }
 }

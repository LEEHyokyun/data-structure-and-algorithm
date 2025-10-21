package basic.hashTable;

public class HashData {
    private int key;
    private String data;

    public HashData(int key, String data){
        this.key = key;
        this.data = data;
    }

    public int getKey(){
        return this.key;
    }

    public String getData(){
        return this.data;
    }
}

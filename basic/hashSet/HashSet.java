package basic.hashSet;

public class HashSet {
    private HashTable hashTable = new HashTable();

    //1
    public void add(String data){
        int key = Integer.parseInt(data);
        if(this.hashTable.get(key) == null) {
            this.hashTable.set(key, "-1");
        }
    }

    //2
    public boolean isContain(String data){
        int key = Integer.parseInt(data);
        return this.hashTable.get(key) != null;
    }

    //3
    public void remove(String data){
        int key = Integer.parseInt(data);
        this.hashTable.remove(key);
    }

    //4
    public void clear(){
        for(int i = 0 ; i < this.hashTable.getList().length; i++){
            this.hashTable.getList()[i].clear();
        }
    }

    //5
    public boolean isEmpty(){
        for(int i = 0 ; i < this.hashTable.getList().length; i++){
            if(this.hashTable.getList()[i].getCount() > 0){
                return false;
            }
        }

        return false;
    }
}

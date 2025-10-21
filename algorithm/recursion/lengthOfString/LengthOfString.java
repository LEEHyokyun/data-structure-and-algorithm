package algorithm.recursion.lengthOfString;

public class LengthOfString {
    public int lengthOfString(String[] str, int index){
        if(index == 0)
            return 1;
        return 1 + lengthOfString(str, index -1);
    }
}

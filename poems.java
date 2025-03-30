class poem{
    public int numLines(){
        return 0;
    }
    public int numSyllables(int k){
        return 0;
    }
    public void printRhyme(){
        for(int i = 0; i < numLines(); ++i){
            int syllable = numSyllables(i);
            for(int j = 0; j < syllable * 2 - 1; ++j){
                if (j % 2 == 0){
                    System.out.print("ta");
                }
                else {
                    System.out.print("-");
                }
            }
            System.out.println();
        }
    }
}

class Haiku extends poem{
    @Override
    public int numLines(){
        return 3;
    }

    @Override
    public int numSyllables(int k){
        if(k == 0){
            return 5;
        }
        else if(k == 1){
            return 7;
        }
        else {
            return 5;
        }
    }
}

class Limerick extends poem{
    @Override
    public int numLines(){
        return 5;
    }

    @Override
    public int numSyllables(int k){
        if(k == 0 || k == 1 || k == 4){
            return 9;
        }
        else {
            return 6;
        }
    }
}

public class poems {
    public static void main(String[] args) {
        Haiku h = new Haiku();
        Limerick l = new Limerick();
        h.printRhyme();
        l.printRhyme();
    }
}

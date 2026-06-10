public class cell{
    private boolean isMine;
    private boolean isRevealed;
    private boolean isFlagged;
    private int minesNear;
    
    public cell(boolean isMine){
        this.isMine = isMine;
    }

    public void setIsMine(){
        isMine = true;
    }
    
    public void setNear(int i){
        minesNear = i;
    }

    public void setIsFlagged(){
        isFlagged = true; 
    }

    public boolean getIsMine(){
        return isMine;
    }

    public void setIsRevealed(){
        isRevealed = true;
    }

    @Override
    public String toString(){
        if(isFlagged){
            return "F";
        }
        else if(isRevealed){
            if(isMine){return "X";}
            else{return Integer.toString(minesNear);}
        }
        else{
            return "*";
        }
    }
}

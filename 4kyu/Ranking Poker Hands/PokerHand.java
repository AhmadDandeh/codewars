import java.util.*;
    
public class PokerHand{
  
    public enum Result { TIE, WIN, LOSS } 
    private HashMap<String, Integer> cardsValue;
    private String handS;
    private int maxValue = 0;
    private int[] cardNum = new int[5];
    private String cardType="";
    
    PokerHand(String hand){
        cardsValue = new HashMap<>();
        cardsValue.clear();
        initCardsValue();
        this.handS = hand;
    }
    
    public Result compareWith(PokerHand hand) {        
        int myValue = getValueOfHand(this);
        int coValue = getValueOfHand(hand);
        if(myValue>coValue){
            return Result.WIN;
        }
        else if(myValue<coValue){
            return Result.LOSS;
        }
        else{
            if(this.maxValue>hand.maxValue){
                return Result.WIN;
            }
            else if(this.maxValue<hand.maxValue){
                return Result.LOSS;
            }
            else{
                switch(myValue){
                    case 8: case 7: case 6: case 4: case 3: case 2: case 1:
                        {
                            for(int i=cardNum.length-1; i>=0; i--){
                                this.maxValue = getHightCard(cardNum, i);
                                hand.maxValue = getHightCard(hand.cardNum, i);
                                if(this.maxValue>hand.maxValue){
                                    return Result.WIN;
                                }
                                else if(this.maxValue<hand.maxValue){
                                    return Result.LOSS;
                                }
                            }
                            return Result.TIE;
                        }
                    default:
                        return Result.TIE;
                }
            }
        }
    }
    
    private void initCardsValue() {
        cardsValue.put("2", 2);
        cardsValue.put("3", 3);
        cardsValue.put("4", 4);
        cardsValue.put("5", 5);
        cardsValue.put("6", 6);
        cardsValue.put("7", 7);
        cardsValue.put("8", 8);
        cardsValue.put("9", 9);
        cardsValue.put("T", 10);
        cardsValue.put("J", 11);
        cardsValue.put("Q", 12);
        cardsValue.put("K", 13);
        cardsValue.put("A", 14);
    }

    private int getValueOfHand(PokerHand hand) {
        // manipulate
        String[] split = hand.handS.split(" ");
        for(int i = 0; i<5; i++){
            hand.cardNum[i] = hand.cardsValue.get(split[i].charAt(0)+"");
            hand.cardType += split[i].charAt(1);
        }
        // sort cardNum
        for(int i=0;i<hand.cardNum.length-1;i++){
            for(int j=i+1; j<hand.cardNum.length;j++){
                if(hand.cardNum[i]>hand.cardNum[j]){
                    int t = hand.cardNum[i];
                    hand.cardNum[i] = hand.cardNum[j];
                    hand.cardNum[j] = t;
                }
            }
        }
        
        if(hand.isRoyalFlush()){
            return 10;
        }
        if(hand.isStraightFlush(hand.cardNum[0])){
            return 9;
        }
        if(hand.is_4_OfKind()){
            return 8;
        }
        if(hand.isFullHouse()){
            return 7;
        }
        if(hand.isFlush()){
            return 6;
        }
        if(hand.isStraight(hand.cardNum[0])){
            return 5;
        }
        if(hand.is_3_OfKind()){
            return 4;
        }
        if(hand.isTwoPair()){
            return 3;
        }
        if(hand.isOnePair()){
            return 2;
        }
        return 1;
    }
    
    private boolean isRoyalFlush(){
        if(!isSameType(cardType)){
            return false;
        }
        else{
            return isStraightFlush(10);
        }
    }
    
    private boolean isStraightFlush(int start){
        if(!isSameType(cardType)){
            return false;
        }
        else{
            return isStraight(start);
        }
    }
    
    private boolean is_4_OfKind(){
        return is_X_OfKind(4);
    }
    
    private boolean isFullHouse(){
        if(is_3_OfKind()){
            return is_X_OfKindWithPrev(2, maxValue,3);
        }
        else{
            return false;
        }
    }
    
    private boolean isFlush(){
        if(isSameType(cardType)){
            this.maxValue = getHightCard(cardNum, cardNum.length-1);
            return true;
        }
        else{
            return false;
        }
    }
    
    private boolean isStraight(int start){
        for(int i=0; i<cardNum.length; i++){
            if(start != cardNum[i]){
                return false;
            }
            start++;
        }
        this.maxValue = cardNum[cardNum.length-1];
        return true;
    }
    
    private boolean is_3_OfKind(){
        return is_X_OfKind(3);
    }
    
    private boolean isTwoPair(){
        if(isOnePair()){
            return is_X_OfKindWithPrev(2,maxValue,2);
        }
        else{
            return false;
        }
    }
    
    private boolean isOnePair(){
        return is_X_OfKind(2);
    }
    
    private int getHightCard(int[] cardNum, int index){
        return cardNum[index];
    }
    
    private boolean isSameType(String cardType){
        cardType = cardType.replaceAll(cardType.charAt(0)+"", "");
        return cardType.length() == 0;
    }

    private boolean is_X_OfKind(int x){
        for(int i=0; i<=cardNum.length-x; i++){
            int count = 1;
            for(int j = i+1; j<cardNum.length; j++){
                if(cardNum[i] == cardNum[j]){
                    count++;
                }
                if(count == x){
                    this.maxValue = cardNum[i];
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean is_X_OfKindWithPrev(int x, int prev, int prevStage){
        for(int i=0; i<=cardNum.length-x; i++){
            if(cardNum[i]!= prev){
                int count = 1;
                for(int j = i+1; j<cardNum.length; j++){
                    if(cardNum[i] == cardNum[j]){
                        count++;
                    }
                    if(count == x){
                      if(prevStage == 2){
                        this.maxValue = cardNum[i]>prev?cardNum[i]:prev;
                      }
                        
                      return true;
                    }
                }
            }
        }
        return false;
    }

}
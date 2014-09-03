public class OOD {
    
    public OOD(){
        CardGame cg = CardGame.createGame("bj");
        System.out.println(cg.getName());
        System.out.println(cg.name);            // is ok because the field name is protected
        
        CardGame cg2 = CardGame.createGame("tk");
        System.out.println(cg2.getName());
      
    }
    
    public static void main(String[] args){
        new OOD();
    }
}

// Note: abstract

abstract class CardGame{
    protected String name;                           // the subclass of CardGame can have access
    
    public static CardGame createGame(String type)  {       // it is static so that anything from outside can call it
        if(type.equals("bj"))   {
            return new BlackJack();                 // upcasting
        }else if(type.equals("tk")) {
            return new ThreeKingdom();              // upcasting
        }
        else{
            return null;
        }
    }
    
    public void setName(String n)   {
        this.name = n;
    }
    
    public String getName(){
        return this.name;
    }
}

// 
class BlackJack extends CardGame    {
    public BlackJack(){
        super.setName("BJBJ");
    }
}

//
class ThreeKingdom extends CardGame{
    public ThreeKingdom(){
        super.setName("threeKingdom");
    }
}

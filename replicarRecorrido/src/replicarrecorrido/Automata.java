package replicarrecorrido;

/**
 *
 * @author JACOBKG
 */
public class Automata {
    private static final int Q0 = 0;
    private static final int Q1 = 1;
    private int state;
    public StringBuilder buffer;
    
    public Automata(){
        state = Q0;
    }
    
    public int getState(){
        return state;
    }
    
    public boolean accept(String str, boolean debug){
        init();
        for(char c : str.toCharArray()){
            int previousState = state;
            appendChar(c);
            if(debug){
                System.out.println("'" + c + "' " + 
                    getStateName(previousState) + " -> " + getStateName(state));
            }
        }
        return state == Q1;
    }
    
    private void init(){
        state = Q0;
        buffer = new StringBuilder();
    }
    
    private String getStateName(int stateToGet){
        String stateName = "";
        switch(stateToGet){
            case Q0: 
                stateName = "Q0";
                break;
            case Q1: 
                stateName = "Q1";
                break;
        }
        return stateName;
    }
    
    private void appendChar(char character){
        if(character != 'a' && character != 'b'){
         System.err.println("INVALIDO");
         return;
        }
        buffer.append(character);
        switch(state){
            case Q0:
                if(character == 'a'){
                    state = Q0;
                } else if(character == 'b'){
                    state = Q1;
                }
                break;
            case Q1:
                if(character == 'a' || character == 'b'){
                    state = Q1;
                }
                break;
            default:
                System.err.println("ERROR");
        }
    }    
}

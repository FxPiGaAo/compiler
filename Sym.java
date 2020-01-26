public class Sym{
    protected String sym_type;
    Sym(String type){
         sym_type = new String(type); 
    }
    public String getType(){
        return sym_type;
    }
    public String toString(){
        return sym_type;
    }
}
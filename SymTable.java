import java.util.*;
public class SymTable{
    protected LinkedList<HashMap<String,Sym>> table;
    SymTable(){
        table = new LinkedList<HashMap<String,Sym>>();
        table.push(new HashMap<String,Sym>());
    }

    public void addDecl(String name, Sym sym)throws
        DuplicateSymException,EmptySymTableException,IllegalArgumentException{
        if(table.isEmpty()){
            throw new EmptySymTableException();
        }
        if(name==null || name.isEmpty() ||
            sym==null || sym.getType().isEmpty()){
            throw new IllegalArgumentException();
        }
        if(table.peek().containsKey(name)){
            throw new DuplicateSymException();
        }
        table.peek().put(name,sym);
        return;
    }

    public void addScope(){
        table.push(new HashMap<String,Sym>());
    }

    public Sym lookupLocal(String name) throws EmptySymTableException{
        if(table.isEmpty()){
            throw new EmptySymTableException();
        }
        return table.peek().get(name);
    }

    public Sym lookupGlobal(String name) throws EmptySymTableException{
        if(table.isEmpty()){
            throw new EmptySymTableException();
        }
        for(HashMap<String,Sym> tempmap : table){
            if(tempmap.get(name)!=null){
                return tempmap.get(name);
            }
        }
        return null;
    }

    public void removeScope() throws EmptySymTableException{
        if(table.isEmpty()){
            throw new EmptySymTableException();
        }
        table.pop();
        return;
    }

    public void print(){
        System.out.print("\nSym Table\n");
        for (HashMap<String,Sym> tempmap : table) {
            System.out.println(tempmap.toString());
        }
        System.out.print("\n");

    }
}
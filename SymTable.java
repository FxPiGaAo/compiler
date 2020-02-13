///////////////////////////////////////////////////////////////////////////////
//
// Title:            Implement SymTable
// Files:            SymTable.java
// Semester:         Spring 2020
//
// Author:           Haocheng Xiao
// Email:            hxiao55@wisc.edu
// Lecturer's Name:  Loris D'Antoni
//
/////////////////////////////////////////////////////////////////////////////

/*
SymTable is the class that we store a list of all
symbols and their corresponding information seperated
by different scopes
*/
import java.util.*;
public class SymTable{
    protected LinkedList<HashMap<String,Sym>> table;
    SymTable(){
        table = new LinkedList<HashMap<String,Sym>>();
        table.push(new HashMap<String,Sym>());
    }

    //add a new pair of symbol and its information in the current hash table    
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

    //add a new scope
    public void addScope(){
        table.push(new HashMap<String,Sym>());
    }

    //look up the symbol in the current scope
    public Sym lookupLocal(String name) throws EmptySymTableException{
        if(table.isEmpty()){
            throw new EmptySymTableException();
        }
        return table.peek().get(name);
    }

    //look up the symbol in a global scoop and find the closest one
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

    //remove the current scope
    public void removeScope() throws EmptySymTableException{
        if(table.isEmpty()){
            throw new EmptySymTableException();
        }
        table.pop();
        return;
    }

    //print the symbols in each scope of the SymTable
    public void print(){
        System.out.print("\nSym Table\n");
        for (HashMap<String,Sym> tempmap : table) {
            System.out.println(tempmap.toString());
        }
        System.out.print("\n");

    }
}
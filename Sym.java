///////////////////////////////////////////////////////////////////////////////
//
// Title:            Implement SymTable
// Files:            Sym.java
// Semester:         Spring 2020
//
// Author:           Haocheng Xiao
// Email:            hxiao55@wisc.edu
// Lecturer's Name:  Loris D'Antoni
//
/////////////////////////////////////////////////////////////////////////////

/*
Sym is the class that we store the information
of specific symbol into
*/
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
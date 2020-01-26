///////////////////////////////////////////////////////////////////////////////
//
// Title:            test
// Files:            P1.java
// Semester:         Spring 2020
//
// Author:           Haocheng Xiao
// Email:            hxiao55@wisc.edu
// Lecturer's Name:  Loris D'Antoni
//
/////////////////////////////////////////////////////////////////////////////

public class P1{
    public static void main(String[] args){
        SymTable mytable = new SymTable();

        //test when there is a null name input, whether an
        //IllegalArgumentException could be thrown correctly 
        try{
            mytable.addDecl(null, new Sym("int"));
            System.out.println("Miss an exception for null name input");
        }catch (IllegalArgumentException ex) {
            //doing nothing because this exception should happen
        }catch (EmptySymTableException ex) {
            System.out.println("Unexpected EmptySymTableException");
        }catch (DuplicateSymException ex) {
            System.out.println("Unexpected DuplicateSymException");
        }

        //test when there is a null type input, whether an
        //IllegalArgumentException could be thrown correctly
        try{
            mytable.addDecl("12345", null);
            System.out.println("Miss an exception for null type input");
        }catch (IllegalArgumentException ex) {
            //doing nothing because this exception should happen
        }catch (EmptySymTableException ex) {
            System.out.println("Unexpected EmptySymTableException");
        }catch (DuplicateSymException ex) {
            System.out.println("Unexpected DuplicateSymException");
        }

        //test whether we can correctly adding a entry in SymTable
        try{
            mytable.addDecl("12345", new Sym("int"));
        }catch (EmptySymTableException ex) {
            System.out.println("Unexpected EmptySymTableException");
        }catch (DuplicateSymException ex) {
            System.out.println("Unexpected DuplicateSymException");
        }

        //test when there is a Duplicate key, whether a
        //DuplicateSymException could be thrown correctly
        try{
            mytable.addDecl("12345", new Sym("int"));
            System.out.println("Miss an exception for Duplicate key");
        }catch (EmptySymTableException ex) {
            System.out.println("Unexpected EmptySymTableException");
        }catch (DuplicateSymException ex) {
            //doing nothing because this exception should happen
        }

        //test lookupLocal when searching for an existing element
        try{
            if(!mytable.lookupLocal("12345").getType().equals("int")){
                System.out.println(
                    "lookupLocal couldn't find existing element");
            }
        }catch(EmptySymTableException ex){
            System.out.println("Unexpected EmptySymTableException");
        }

        mytable.addScope();

        //test lookupLocal when searching for an out of scope element
        try{
            if(mytable.lookupLocal("12345")!=null){
                System.out.println(
                    "The element is out of scope."+
                    " lookupLocal shouldn't have found it.");
            }
        }catch(EmptySymTableException ex){
            System.out.println("Unexpected EmptySymTableException");
        }

        //test lookupGlobal when searching for an existing element
        try{
            if(!mytable.lookupGlobal("12345").getType().equals("int")){
                System.out.println(
                    "lookupLocal couldn't find existing element");
            }
        }catch(EmptySymTableException ex){
            System.out.println("Unexpected EmptySymTableException");
        }

        //add one more symbol and test whether LookupGlobal could
        //find the closest one
        try{
            mytable.addDecl("a", new Sym("char"));
            mytable.addDecl("b", new Sym("char"));
            mytable.addScope();
            mytable.addDecl("12345", new Sym("Integer"));
            if(!mytable.lookupGlobal("12345").getType().equals("Integer")){
                System.out.println("LookupGlobal couldn't find" +
                " the closest one");
            }
        }catch (EmptySymTableException ex) {
            System.out.println("Unexpected EmptySymTableException");
        }catch (DuplicateSymException ex) {
            System.out.println("Unexpected DuplicateSymException");
        }
        mytable.print();

        //test when trying to remove a scope from an empty list,
        //whether an EmptySymTableException could be thrown correctly
        try{
            mytable.removeScope();//after this, there should be two hashmap left
            mytable.removeScope();//after this, there should be one hashmap left
            mytable.removeScope();//after this, the list should be empty
            mytable.removeScope();
            System.out.println(
                "Miss an exception when removing from an empty list");
        }catch (EmptySymTableException ex){
            //doing nothing because this exception should happen
        }
        return;
    }
}
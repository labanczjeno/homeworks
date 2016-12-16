
package com.mycompany.library;

public class Borrow {
    private String nameOfReader;
    private String dateOfBorrow;
    private boolean isBorrowed=true;
    
    public Borrow(String nameOfReader, String dateOfBorrow) {
        this.nameOfReader = nameOfReader;
        this.dateOfBorrow = dateOfBorrow;
        this.isBorrowed = true;
    }
    public void setBookBack(String date){
       this.dateOfBorrow=date;
       this.isBorrowed=false;
    }
    public boolean isBorrowed() {
         return isBorrowed;
    }
    public String getNameOfReader() {
        return nameOfReader;
    }
    public String getDateOfBorrow() {
        return dateOfBorrow;
    }
    public boolean isIsBorrowed() {
        return isBorrowed;
    }
}

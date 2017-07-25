/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author meetd
 */
public class SearchResultBean {
    
    private String title;
    private String availability;
    private String author;
    private String isbn;
    
    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getisbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public String getavailability() {
        return availability;
    }

    public void setavailability(String availability) {
        this.availability = availability;
    }


}

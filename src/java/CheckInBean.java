/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author meetd
 */
public class CheckInBean {
    private String title;
    private String dateout;
    private String duedate;
    private String isbn;

    public String getdatein() {
        return datein;
    }

    public void setdatein(String datein) {
        this.datein = datein;
    }
    private String fname;
    private String lname;
    private int loanid;
    private int cardid;
    private String datein;

    public int getloanid() {
        return loanid;
    }

    public void setloanid(int loanid) {
        this.loanid = loanid;
    }

    public int getcardid() {
        return cardid;
    }

    public void setcardid(int cardid) {
        this.cardid = cardid;
    }

    public String gettitle() {
        return title;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public String getdateout() {
        return dateout;
    }

    public void setdateout(String dateout) {
        this.dateout = dateout;
    }

    public String getduedate() {
        return duedate;
    }

    public void setduedate(String duedate) {
        this.duedate = duedate;
    }

    public String getisbn() {
        return isbn;
    }

    public void setisbn(String isbn) {
        this.isbn = isbn;
    }

    public String getfname() {
        return fname;
    }

    public void setfname(String fname) {
        this.fname = fname;
    }

    public String getlname() {
        return lname;
    }

    public void setlname(String lname) {
        this.lname = lname;
    }
}

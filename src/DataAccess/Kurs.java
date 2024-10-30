
package DataAccess;


public class Kurs {

    private int stdNo;
    private String Ders;
    private int vizenot;
    private int finalnot;
    private String sonuc;
    private String ogrenci;
    

    public Kurs(int stdNo, String ogrenci, String Ders, int vizenot, int finalnot, String sonuc) {
        this.stdNo = stdNo;
        this.Ders = Ders;
        this.vizenot = vizenot;
        this.finalnot = finalnot;
        this.sonuc = sonuc;
        this.ogrenci = ogrenci;
    }

    public int getStdNo() {
        return stdNo;
    }

    public void setStdNo(int stdNo) {
        this.stdNo = stdNo;
    }

    public String getDers() {
        return Ders;
    }

    public void setDers(String Ders) {
        this.Ders = Ders;
    }

    public int getVizenot() {
        return vizenot;
    }

    public void setVizenot(int vizenot) {
        this.vizenot = vizenot;
    }

    public int getFinalnot() {
        return finalnot;
    }

    public void setFinalnot(int finalnot) {
        this.finalnot = finalnot;
    }

    public String getSonuc() {
        return sonuc;
    }

    public void setSonuc(String sonuc) {
        this.sonuc = sonuc;
    }

    public String getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(String ogrenci) {
        this.ogrenci = ogrenci;
    }
    
  
}

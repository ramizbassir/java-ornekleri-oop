package nyp;

public class Randevu {
    private String tarih;
    private String saat;
    private String hastaAdi;
    private String doktorAdi;
    private String doktorTelefonu;
    private String doktorUzmanligi;
    private double ucret;
    private String paraBirimi;

    public double toplamUcretHesapla( int randevuSayisi){
        return ucret * randevuSayisi;
    }
}

public class Musteri {
    private final String adSoyad;
    private final String telefon;
    private final Adres adres;

    public Musteri(String adSoyad, String telefon, Adres adres) {
        this.adSoyad = adSoyad;
        this.telefon = telefon;
        this.adres = adres;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public Adres getAdres() {
        return adres;
    }
}
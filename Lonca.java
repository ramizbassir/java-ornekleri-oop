package toros;

public class Lonca {
    private final String ad;
    private final int kurulusYili;
    private String duyuru;

    public Lonca(String ad, int kurulusYili, String duyuru) {
        if (ad == null || ad.isBlank() || ad.length() < 3 || ad.length() > 25) {
            throw new IllegalArgumentException(
                    "Lonca adı 3-25 karakter olmalı."
            );
        }
        if (kurulusYili <= 0) {
            throw new IllegalArgumentException(
                    "Kuruluş yılı pozitif olmalı."
            );
        }

        this.ad = ad;
        this.kurulusYili = kurulusYili;
        setDuyuru(duyuru);
    }

    public String getAd() {
        return ad;
    }

    public String getDuyuru() {
        return duyuru;
    }

    public void setDuyuru(String duyuru) {
        if (duyuru == null || duyuru.isBlank() || duyuru.length() > 100) {
            throw new IllegalArgumentException(
                    "Duyuru boş olamaz ve en fazla 100 karakter olmalı."
            );
        }
        this.duyuru = duyuru;
    }

    public String bilgiMetni() {
        return ad + " (kuruluş " + kurulusYili + ") - Duyuru: " + duyuru;
    }
}
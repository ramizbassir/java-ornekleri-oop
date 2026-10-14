package toros;

public abstract class Karakter {
    private final String ad;
    private int seviye;
    private int can;
    private final Lonca lonca;
    private Silah silah;

    public Karakter(String ad, Lonca lonca) {
        if (ad == null || ad.isBlank() || ad.length() < 3 || ad.length() > 15) {
            throw new IllegalArgumentException(
                    "Karakter adı 3-15 karakter olmalı."
            );
        }
        if (lonca == null) {
            throw new IllegalArgumentException("Lonca null olamaz.");
        }

        this.ad = ad;
        this.lonca = lonca;
        this.seviye = 1;
        this.can = azamiCan();
        this.silah = null;
    }

    public String getAd() {
        return ad;
    }

    public int getSeviye() {
        return seviye;
    }

    public int getCan() {
        return can;
    }

    public Lonca getLonca() {
        return lonca;
    }

    public Silah getSilah() {
        return silah;
    }

    public final int azamiCan() {
        return 100 + seviye * 10;
    }

    public final boolean hayattaMi() {
        return can > 0;
    }

    protected void hayattaOldugunuDogrula() {
        if (!hayattaMi()) {
            throw new IllegalStateException("Karakter hayatta değil.");
        }
    }

    protected void kayitYaz(String olay) {
        System.out.println("[" + ad + "] " + olay);
    }

    public void hasarAl(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException(
                    "Hasar miktarı pozitif olmalı."
            );
        }

        can = Math.max(0, can - miktar);
    }

    public void iyiles(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException(
                    "İyileşme miktarı pozitif olmalı."
            );
        }

        hayattaOldugunuDogrula();
        can = (int) Math.min((long) azamiCan(), (long) can + miktar);
    }

    public void seviyeAtla() {
        hayattaOldugunuDogrula();

        if (seviye >= 50) {
            throw new IllegalStateException("Seviye en fazla 50 olabilir.");
        }

        seviye++;
        can = azamiCan();
        kayitYaz("Seviye " + seviye + " oldu.");
    }

    public void silahKus(Silah yeniSilah) {
        if (yeniSilah == null) {
            throw new IllegalArgumentException("Silah null olamaz.");
        }

        this.silah = yeniSilah;
    }

    public int saldir() {
        hayattaOldugunuDogrula();

        if (silah == null) {
            throw new IllegalStateException("Karakterin silahı yok.");
        }

        int hasar = silah.kullan() + seviye;
        kayitYaz(silah.getAd() + " ile saldırdı. Hasar: " + hasar);
        return hasar;
    }

    public void bilgiGoster() {
        String silahBilgisi = (silah == null) ? "yok" : silah.bilgiMetni();

        System.out.println(
                ad + " | Seviye " + seviye
                        + " | Can " + can + "/" + azamiCan()
                        + " | Lonca: " + lonca.getAd()
                        + " | Silah: " + silahBilgisi
        );

        // D5'te lonca duyurusunun üyelerin bilgisinde görünmesi isteniyor.
        System.out.println("Lonca duyurusu: " + lonca.getDuyuru());
    }

    @Override
    public String toString() {
        return "Karakter[" + ad + ", seviye " + seviye + "]";
    }
}
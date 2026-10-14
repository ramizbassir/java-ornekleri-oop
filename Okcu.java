package toros;

public class Okcu extends Karakter {
    private int okSayisi;

    public Okcu(String ad, Lonca lonca) {
        super(ad, lonca);
        this.okSayisi = 30;
    }

    public int getOkSayisi() {
        return okSayisi;
    }

    public int atesEt() {
        hayattaOldugunuDogrula();

        if (okSayisi == 0) {
            throw new IllegalStateException("Ok kalmadı.");
        }

        okSayisi--;
        kayitYaz("ok attı. Kalan ok: " + okSayisi);

        return saldir() + 3;
    }

    public void okTopla(int adet) {
        if (adet <= 0) {
            throw new IllegalArgumentException(
                    "Toplanacak ok sayısı pozitif olmalı."
            );
        }

        okSayisi = (int) Math.min(60L, (long) okSayisi + adet);
    }

    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("Ok: " + okSayisi + "/60");
    }

    @Override
    public String toString() {
        return "Okçu[" + getAd() + ", seviye " + getSeviye()
                + ", ok " + okSayisi + "/60]";
    }
}
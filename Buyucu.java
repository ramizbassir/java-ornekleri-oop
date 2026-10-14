package toros;

public class Buyucu extends Karakter {
    private int mana;

    public Buyucu(String ad, Lonca lonca) {
        super(ad, lonca);
        this.mana = 100;
    }

    public int getMana() {
        return mana;
    }

    public int buyuYap(String buyuAdi, int manaMaliyeti) {
        if (buyuAdi == null || buyuAdi.isBlank()) {
            throw new IllegalArgumentException("Büyü adı boş olamaz.");
        }
        if (manaMaliyeti < 1 || manaMaliyeti > 50) {
            throw new IllegalArgumentException(
                    "Mana maliyeti 1-50 arasında olmalı."
            );
        }

        hayattaOldugunuDogrula();

        if (mana < manaMaliyeti) {
            throw new IllegalStateException("Mana yetersiz.");
        }

        mana -= manaMaliyeti;
        kayitYaz(buyuAdi + " büyüsü yaptı. Kalan mana: " + mana);

        return manaMaliyeti * 2 + getSeviye();
    }

    public void manaTopla(int miktar) {
        if (miktar <= 0) {
            throw new IllegalArgumentException(
                    "Toplanacak mana pozitif olmalı."
            );
        }

        mana = (int) Math.min(100L, (long) mana + miktar);
    }

    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("Mana: " + mana + "/100");
    }

    @Override
    public String toString() {
        return "Büyücü[" + getAd() + ", seviye " + getSeviye()
                + ", mana " + mana + "/100]";
    }
}
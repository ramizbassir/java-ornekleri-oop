package toros;

public class Savasci extends Karakter {
    private final int zirh;

    public Savasci(String ad, Lonca lonca, int zirh) {
        super(ad, lonca);

        if (zirh < 0 || zirh > 30) {
            throw new IllegalArgumentException("Zırh 0-30 arasında olmalı.");
        }
        this.zirh = zirh;
    }

    public int getZirh() {
        return zirh;
    }

    @Override
    public void hasarAl(int miktar) {
        if (miktar <= 0) {
            // Pozitiflik kontrolünü üst sınıfa bırakır.
            super.hasarAl(miktar);
            return;
        }

        int azalanHasar = Math.max(1, miktar - zirh);
        super.hasarAl(azalanHasar);
    }

    @Override
    public void bilgiGoster() {
        super.bilgiGoster();
        System.out.println("Zırh: " + zirh);
    }

    @Override
    public String toString() {
        return "Savaşçı[" + getAd() + ", seviye " + getSeviye()
                + ", zırh " + zirh + "]";
    }
}
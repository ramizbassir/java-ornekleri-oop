package toros;

public class Main {
    public static void main(String[] args) {
        // 1. İki lonca oluştur.
        Lonca kartalLoncası = new Lonca(
                "Kartal Loncası",
                1071,
                "Cuma akşamı kale kuşatması!"
        );

        Lonca ikinciLonca = new Lonca(
                "Gümüş Kartallar",
                1200,
                "Dağ geçidinde buluşma."
        );

        System.out.println(kartalLoncası.bilgiMetni());
        System.out.println(ikinciLonca.bilgiMetni());

        // 2. Karakterleri oluştur.
        // Savaşçı ve büyücü aynı Lonca nesnesini paylaşır.
        Savasci savasci = new Savasci("Ayşe", kartalLoncası, 12);
        Buyucu buyucu = new Buyucu("Kaan", kartalLoncası);
        Okcu okcu = new Okcu("Elif", ikinciLonca);

        // 3. Silah oluştur ve kuşandır.
        int kilicHasari = 12;
        if (kilicHasari < 10) {
            kilicHasari = 10;
        }

        Silah kilic = new Silah("Kılıç", kilicHasari);
        Silah yay = new Silah("Yay", 12);

        savasci.silahKus(kilic);
        okcu.silahKus(yay);

        // 4. Karakter bilgilerini göster.
        savasci.bilgiGoster();
        buyucu.bilgiGoster();
        okcu.bilgiGoster();

        // 5. Savaşçı üç kez saldırır.
        System.out.println("\n--- Savaşçının saldırıları ---");
        for (int i = 1; i <= 3; i++) {
            int hasar = savasci.saldir();
            System.out.println(
                    i + ". saldırı hasarı: " + hasar
                            + ", kılıç dayanıklılığı: "
                            + kilic.getDayaniklilik()
            );
        }

        // 6. Savaşçıya ve büyücüye aynı miktarda hasar ver.
        System.out.println("\n--- 40 hasar testi ---");
        savasci.hasarAl(40);
        buyucu.hasarAl(40);

        System.out.println(
                "Savaşçı canı: " + savasci.getCan()
                        + "/" + savasci.azamiCan()
                        + " (12 zırh hasarı azaltır)"
        );
        System.out.println(
                "Büyücü canı: " + buyucu.getCan()
                        + "/" + buyucu.azamiCan()
        );

        // 7. Büyücü iki kez 30 manalık büyü yapar.
        // Üçüncü deneme manası yetmediği için reddedilir.
        System.out.println("\n--- Büyü denemeleri ---");
        for (int i = 1; i <= 3; i++) {
            try {
                int hasar = buyucu.buyuYap("Ateş Topu", 30);
                System.out.println(
                        i + ". büyü hasarı: " + hasar
                                + ", kalan mana: " + buyucu.getMana()
                );
            } catch (IllegalStateException hata) {
                System.out.println(
                        i + ". büyü yapılamadı: " + hata.getMessage()
                                + ", kalan mana: " + buyucu.getMana()
                );
            }
        }

        // 8. Okçu iki kez ateş eder.
        System.out.println("\n--- Okçu atışları ---");
        for (int i = 1; i <= 2; i++) {
            int hasar = okcu.atesEt();
            System.out.println(
                    i + ". atış hasarı: " + hasar
                            + ", kalan ok: " + okcu.getOkSayisi()
            );
        }

        // 9. Büyücüyü iyileştir ve seviye atlat.
        System.out.println("\n--- Büyücüyü iyileştirme ve seviye atlatma ---");
        buyucu.iyiles(20);
        buyucu.bilgiGoster();

        buyucu.seviyeAtla();
        buyucu.bilgiGoster();

        // 10. Geçersiz işlemleri try/catch ile dene.
        System.out.println("\n--- Geçersiz işlem denemeleri ---");

        try {
            new Buyucu(" ", kartalLoncası);
        } catch (IllegalArgumentException hata) {
            System.out.println(
                    "Geçersiz karakter adı yakalandı: " + hata.getMessage()
            );
        }

        try {
            savasci.hasarAl(-5);
        } catch (IllegalArgumentException hata) {
            System.out.println(
                    "Geçersiz hasar yakalandı: " + hata.getMessage()
            );
        }

        try {
            buyucu.iyiles(0);
        } catch (IllegalArgumentException hata) {
            System.out.println(
                    "Geçersiz iyileştirme yakalandı: " + hata.getMessage()
            );
        }

        // 11. Lonca duyurusunu değiştir; aynı loncadaki iki üye de görür.
        System.out.println("\n--- Lonca duyurusu değişikliği ---");
        kartalLoncası.setDuyuru("Kuşatma ertelendi; kuzey kapısında buluşun.");

        savasci.bilgiGoster();
        buyucu.bilgiGoster();

        // 12. Okçuyu doğrudan yazdır; toString() çağrılır.
        System.out.println("\n--- toString testi ---");
        System.out.println(okcu);

        // D6: Suikastçı gizliyken ve normal durumdayken saldırır.
        System.out.println("\n--- Suikastçı testi (D6) ---");
        Suikastci suikastci = new Suikastci("Mert", kartalLoncası);
        suikastci.silahKus(new Silah("Hançer", 15));

        suikastci.gizlen();
        System.out.println(
                "Gizliyken saldırı hasarı: " + suikastci.saldir()
        );
        System.out.println("Saldırı sonrası gizli mi? " + suikastci.isGizli());

        System.out.println(
                "Normal saldırı hasarı: " + suikastci.saldir()
        );
    }
}
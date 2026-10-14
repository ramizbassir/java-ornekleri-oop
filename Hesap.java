import java.util.Scanner;

public class Hesap {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String dogruKullanici = "ramiz";
        String dogruSifre = "1234";

        System.out.print("Kullanıcı adınız: ");
        String kullanici = input.nextLine();

        System.out.print("Şifreniz: ");
        String sifre = input.nextLine();

        boolean kullaniciDogru = kullanici.equals(dogruKullanici);
        boolean sifreDogru = sifre.equals(dogruSifre);

        boolean girisBasarili = kullaniciDogru && sifreDogru;

        if (girisBasarili) {

            System.out.println("\nGiriş başarılı!");
            System.out.println("1 - Para çek");
            System.out.println("2 - Para yatır");
            System.out.println("3 - Bakiye görüntüle");

            System.out.print("İşlem seçiniz: ");
            int secim = input.nextInt();

            double bakiye = 5000;

            if (secim == 1) {

                System.out.print("Çekmek istediğiniz miktar: ");
                double miktar = input.nextDouble();

                boolean paraYeterli = miktar <= bakiye;
                boolean miktarGecerli = miktar > 0;

                if (paraYeterli && miktarGecerli) {
                    bakiye -= miktar;

                    System.out.println("Para çekme başarılı.");
                    System.out.println("Yeni bakiyeniz: " + bakiye);
                }
                else {
                    System.out.println("Geçersiz işlem veya yetersiz bakiye.");
                }

            } else if (secim == 2) {

                System.out.print("Yatırmak istediğiniz miktar: ");
                double miktar = input.nextDouble();

                boolean miktarGecerli = miktar > 0;

                if (miktarGecerli) {
                    bakiye += miktar;

                    System.out.println("Para yatırma başarılı.");
                    System.out.println("Yeni bakiyeniz: " + bakiye);
                }
                else {
                    System.out.println("Geçersiz miktar.");
                }

            } else if (secim == 3) {

                System.out.println("Mevcut bakiyeniz: " + bakiye);

            } else {

                System.out.println("Geçersiz işlem seçtiniz.");
            }

        } else {

            System.out.println("Kullanıcı adı veya şifre yanlış!");
        }

        input.close();
    }
}
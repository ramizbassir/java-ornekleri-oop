public class OkulSistemi {

    // Öğrenci ve öğretmenin ortak bilgileri
    static class Kisi {
        private final String adSoyad;
        private String ePosta;

        public Kisi(String adSoyad, String ePosta) {
            this.adSoyad = adSoyad;
            setEPosta(ePosta);
        }

        public String getAdSoyad() {
            return adSoyad;
        }

        public String getEPosta() {
            return ePosta;
        }

        public void setEPosta(String yeniEPosta) {
            if (yeniEPosta == null || !yeniEPosta.contains("@")) {
                throw new IllegalArgumentException("Geçersiz e-posta.");
            }

            this.ePosta = yeniEPosta;
        }
    }

    static class Ogrenci extends Kisi {
        private final String ogrenciNo;

        public Ogrenci(String adSoyad, String ePosta, String ogrenciNo) {
            super(adSoyad, ePosta);
            this.ogrenciNo = ogrenciNo;
        }

        public String getOgrenciNo() {
            return ogrenciNo;
        }
    }

    static class Ogretmen extends Kisi {
        private final String unvan;

        public Ogretmen(String adSoyad, String ePosta, String unvan) {
            super(adSoyad, ePosta);
            this.unvan = unvan;
        }

        public String getUnvan() {
            return unvan;
        }
    }

    public static void main(String[] args) {
        Adres adres = new Adres(
                "İstanbul",
                "Kadıköy",
                "Örnek Sokak No: 5"
        );

        Ogrenci ogrenci = new Ogrenci(
                "Mehmet Demir",
                "mehmet@example.com",
                "20261025"
        );

        Ogretmen ogretmen = new Ogretmen(
                "Zeynep Kaya",
                "zeynep@example.com",
                "Öğretmen"
        );

        System.out.println("Adres: " + adres.adresMetni());
        System.out.println("Öğrenci: " + ogrenci.getAdSoyad()
                + ", No: " + ogrenci.getOgrenciNo());
        System.out.println("Öğretmen: " + ogretmen.getAdSoyad()
                + ", Unvan: " + ogretmen.getUnvan());

        // İkisi de Kisi sınıfındaki e-posta kontrolünü kullanır.
        ogrenci.setEPosta("mehmet.yeni@example.com");
        ogretmen.setEPosta("zeynep.yeni@example.com");
    }
}
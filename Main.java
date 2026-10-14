package nyp;

public class Main {

    static class Kus {
        public void uc() {
            System.out.println("Kanat çırparak uçuyor");
        }
    }

    static class Penguen extends Kus {
        @Override
        public void uc() {
            throw new UnsupportedOperationException("Penguen uçamaz!");
        }
    }

    public static void main(String[] args) {
        Penguen hayvanatBahcesiPengueni = new Penguen();
        hayvanatBahcesiPengueni.uc();
    }
}
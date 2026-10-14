public class Termostat {
    private final String odaAdi;
    private double hedefSicaklik;
    private boolean acik;

    public Termostat(String odaAdi, double hedefSicaklik){
        if (hedefSicaklik < 16.0 || hedefSicaklik > 30.0){
            throw new IllegalArgumentException(
                    "Sıcaklık 16 ile 30 derece arasında olmalı"
            );
        }

        this.odaAdi = odaAdi;
        this.hedefSicaklik = 20.0;
        this.acik = false;

    }

    public String getOdaAdi(){
        return odaAdi;
    }

    public double getHedefSicaklik(){
        return hedefSicaklik;
    }

    public boolean isAcik(){
        return acik;
    }

    public void ac(){
        acik = true;
    }

    public void kapat(){
        acik = false;
    }

    public void sicakligiArttir(){
        if (acik && hedefSicaklik + 0.5 <= 30.0){
            hedefSicaklik += 0.5;
        }
    }

    public void sicakligiAzalt(){
        if(acik && hedefSicaklik - 0.5  >= 16.0){
            hedefSicaklik -= 0.5;
        }
    }
}

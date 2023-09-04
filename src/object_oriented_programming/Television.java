public class Television {
    private int kanava;
    private boolean päällä = false;

    public void asetaKanava(int numero) {
        this.kanava = numero;
        if (this.kanava > 10) {
            this.kanava = 1;
        }
    }

    public int haeKanava() {
        return this.kanava;
    }

    public boolean onkoPäällä() {
        return this.päällä;
    }

    public void painaVirtanappia() {
        this.päällä = !this.päällä;
    }

    public static void main(String[] args) {
        Television omaTV = new Television();
        omaTV.asetaKanava(1);

        for (int päivä = 1; päivä <= 10; päivä++) {
            System.out.println("Herätys, päivä " + päivä);

            boolean väsynyt = false;

            if (!omaTV.onkoPäällä())
                omaTV.painaVirtanappia();

            while (!väsynyt) {
                System.out.println("Katsotaan kanavaa " + omaTV.haeKanava());
                omaTV.asetaKanava(omaTV.haeKanava() + 1);
                if (omaTV.haeKanava() % 4 == 0)
                    väsynyt = true;
            }

            omaTV.painaVirtanappia();

            System.out.println("Nukahtaminen");
        }
    }
}

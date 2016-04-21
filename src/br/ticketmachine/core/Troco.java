package br.ticketmachine.core;

import java.util.Iterator;

class Troco {

    private PapelMoeda[] papeisMoeda;

    public PapelMoeda[] getPapeisMoeda() {
        return papeisMoeda;
    }

    public void setPapeisMoeda(PapelMoeda[] papeisMoeda) {
        this.papeisMoeda = papeisMoeda;
    }

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        while (valor % 100 != 0) {
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        while (valor % 50 != 0) {
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        while (valor % 20 != 0) {
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        while (valor % 10 != 0) {
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        while (valor % 5 != 0) {
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        while (valor % 2 != 0) {
            count++;
        }
        papeisMoeda[0] = new PapelMoeda(2, count);
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator(this);
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        private Troco troco;

        public TrocoIterator(Troco troco) {
            this.troco = troco;
        }

        @Override
        public boolean hasNext() {
            return troco.getIterator().hasNext();
        }

        @Override
        public PapelMoeda next() {
            while (troco.getIterator().hasNext()) {
                PapelMoeda ret = troco.getIterator().next();
                return ret;
            }
            return null;
        }

        @Override
        public void remove() {
            troco.getIterator().remove();
        }
    }
}

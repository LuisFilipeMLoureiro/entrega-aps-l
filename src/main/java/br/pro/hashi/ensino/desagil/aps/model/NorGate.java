package br.pro.hashi.ensino.desagil.aps.model;

public class NorGate extends Gate{


        private final NandGate upperleft;
        private final NandGate bottomleft;
        private final NandGate middle;
        private final NandGate right;

        public NorGate() {
            super("NOR", 2);

            upperleft = new NandGate();
            bottomleft = new NandGate();
            middle = new NandGate();
            right = new NandGate();

            middle.connect(0, upperleft);
            middle.connect(1, bottomleft);
            right.connect(0, middle);
            right.connect(1, middle);
        }

        @Override
        public boolean read() {
            return right.read();
        }

        @Override
        public void connect(int inputIndex, Emitter emitter) {
            switch (inputIndex) {
                case 0:
                    upperleft.connect(0, emitter);
                    upperleft.connect(1, emitter);
                    break;
                case 1:
                    bottomleft.connect(0, emitter);
                    bottomleft.connect(1, emitter);
                    break;
                default:
                    throw new IndexOutOfBoundsException(inputIndex);
            }

    }

}

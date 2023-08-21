package dominio;

public enum EnumSemana {

    /**
     * Primeiro dia da semana
     */
    DOMINGO(1) {
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.1;
        }

        @Override
        public void mostrarData() {
            System.out.println("Hoje é domingo");
        }

    },
    SEGUNDA(2) {
        @Override
        public double calcularDesconto(double valor) {
            return super.calcularDesconto(valor);
        }

        @Override
        public void mostrarData() {
            System.out.println("Hoje é segunda");
        }

    },
    TERCA(3) {
        @Override
        public double calcularDesconto(double valor) {
            return super.calcularDesconto(valor);
        }

        @Override
        public void mostrarData() {
            System.out.println("Hoje é terca");
        }

    },
    QUARTA(4) {
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.2;
        }

        @Override
        public void mostrarData() {
            System.out.println("Hoje é quarta");
        }

    },
    QUINTA(5) {
        @Override
        public double calcularDesconto(double valor) {
            return super.calcularDesconto(valor);
        }

        @Override
        public void mostrarData() {
            System.out.println("Hoje é quinta");
        }

    },
    SEXTA(6) {
        @Override
        public double calcularDesconto(double valor) {
            return super.calcularDesconto(valor);
        }

        @Override
        public void mostrarData() {
            System.out.println("Hoje é sexta");
        }

    },
    SABADO(7) {
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.1;
        }

        @Override
        public void mostrarData() {
            System.out.println("Hoje é sabado");
        }

    };

    private final int valor;

    private EnumSemana(int valor) {
        this.valor = valor;
    }

    public int getvalor() {
        return valor;
    }

    public double calcularDesconto(double valor) {
        return valor;
    }

    public abstract void mostrarData();
    
    public static EnumSemana tipoClientePorValor(int valor){
        for (EnumSemana semana : values()) {
            if (semana.getvalor() == valor) {
                return semana;
            }
        }
        return null;
    }
}

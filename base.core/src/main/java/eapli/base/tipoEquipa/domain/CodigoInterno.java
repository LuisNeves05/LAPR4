package eapli.base.tipoEquipa.domain;
import eapli.base.servico.domain.ServicoIdentificador;
import eapli.framework.domain.model.ValueObject;
import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


    @Embeddable
    public  class CodigoInterno implements ValueObject, Comparable<CodigoInterno> {

        private String identificador;

        public CodigoInterno(String identificador){
            if(validaIdentificador(identificador))
                this.identificador = identificador;
        }

        protected CodigoInterno(){}

        private boolean validaIdentificador(final String identificador) {
            String regex = "[a-zA-Z0-9]{1,15}";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcherAlphaNumericCheck = pattern.matcher(identificador);

            return matcherAlphaNumericCheck.find();
        }

        public static CodigoInterno valueOf(final String identificador) {
            return new CodigoInterno(identificador);
        }

        @Override
        public int compareTo(final CodigoInterno o) {
            return this.identificador.compareTo(o.identificador);
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof CodigoInterno)) {
                return false;
            }

            final CodigoInterno that = (CodigoInterno) o;
            return this.identificador.equals(that.identificador);
    }}


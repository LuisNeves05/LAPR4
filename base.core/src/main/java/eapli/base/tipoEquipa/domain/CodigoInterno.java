package eapli.base.tipoEquipa.domain;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.util.StringPredicates;

import javax.persistence.Embeddable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


    @Embeddable
    public  class CodigoInterno implements ValueObject, Comparable<CodigoInterno> {
        /**
         * Identificador único do TipoEquipa
         */
        private String identificador;

        /**
         * Construtor do CodigoInterno
         * @param identificador identificador único do TipoEquipa
         */
        public CodigoInterno(String identificador){
            if (StringPredicates.isNullOrEmpty(identificador) || !validaIdentificador(identificador)) {
                throw new IllegalArgumentException(
                        "O identificador de um serviço deve ser alfanumérico entre 1 a 15 caracteres");
            }
            this.identificador = identificador;
        }
        /**
         * Construtor vazio do CodigoInterno
         */
        protected CodigoInterno(){}

        /**
         * Validação do identificador único do serviço que deve ser alfanumérico entre 1 a 15 caracteres
         * @return true se for válido / false se for inválido
         */
        private boolean validaIdentificador(final String identificador) {
            String regex = "[a-zA-Z0-9]{1,15}";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcherAlphaNumericCheck = pattern.matcher(identificador);

            return matcherAlphaNumericCheck.find();
        }

        /** Validação do identificador único do serviço que deve ser alfanumérico entre 1 a 15 caracteres
        * @return true se for válido / false se for inválido
        */
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


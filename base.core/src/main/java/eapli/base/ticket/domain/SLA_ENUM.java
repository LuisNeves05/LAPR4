package eapli.base.ticket.domain;


    public enum SLA_ENUM{
        CUMPRE_TUDO_E_FAVORECE_TMAR("Cumpre todos os itens e favorece o tempo médio aprovação e resolução")  ,CUMPRE_TUDO_E_FAVORECE_TMA("Cumpre todos os itens e favorece o tempo médio aprovação"),CUMPRE_TUDO_E_FAVORECE_TMR("Cumpre todos os itens e favorece o tempo médio resolução"),CUMPRE_TUDO_E_PREJUDICA_TM("Cumpre todos os itens.Prejudica o tempo médio de aprovação"), FALHA_TUDO("Falha todos os itens."),FALHA_APROVACAO("Falha no item aprovação.Cumpre no item resolução."), FALHA_REALIZACAO("Falha no item resolução.Cumpre no item aprovação.");

        private String s;
        SLA_ENUM(String s) {
            this.s =s ;
        }

        @Override
        public String toString() {
            return  s ;
        }
    }


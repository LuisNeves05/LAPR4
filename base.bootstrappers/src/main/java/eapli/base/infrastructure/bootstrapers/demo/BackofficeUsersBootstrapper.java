/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 */
package eapli.base.infrastructure.bootstrapers.demo;

import java.util.HashSet;
import java.util.Set;

import eapli.base.infrastructure.bootstrapers.UsersBootstrapperBase;
import eapli.base.usermanagement.domain.BaseRoles;
import eapli.framework.actions.Action;
import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * @author Paulo Gandra Sousa
 */
public class BackofficeUsersBootstrapper extends UsersBootstrapperBase implements Action {

    @SuppressWarnings("squid:S2068")
    private static final String PASSWORD1 = "Password1";

    @Override
    public boolean execute() {
        //registerCashier("cashier", PASSWORD1, "Johny", "Cash", "johny.doe@emai.l.com");
        //registerKitchenManager("kitchen", PASSWORD1, "Oven", "Stove", "Oven.and.stove@emai.l.com");
        //registerMenuManager("chef", PASSWORD1, "Master", "Chef", "master.chef@emai.l.com");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(BaseRoles.ADMIN);
        registerUser("luis","pw","Luis","Neves","luismanuelneves5@gmail.com",roleSet);
        return true;
    }

}

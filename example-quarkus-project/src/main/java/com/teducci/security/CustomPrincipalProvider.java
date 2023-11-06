package com.teducci.security;

import javax.enterprise.context.ApplicationScoped;
import java.security.Principal;

@ApplicationScoped
public class CustomPrincipalProvider {

    public Principal getIdentity() {
        // Ottieni l'istanza del tuo principal personalizzato
        return new CustomPrincipal("Pippo");
    }
}
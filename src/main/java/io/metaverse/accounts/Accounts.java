package io.metaverse.accounts;

import io.metaverse.accounts.registry.AccountRegistry;
import io.metaverse.accounts.registry.SimpleAccountRegistry;

public class Accounts {

    private static final AccountRegistry registry;

    static {
        registry = new SimpleAccountRegistry();
    }

    public static AccountRegistry getRegistry() {
        return registry;
    }
}

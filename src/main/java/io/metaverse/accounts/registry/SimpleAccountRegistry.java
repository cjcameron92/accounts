package io.metaverse.accounts.registry;

import io.metaverse.accounts.api.Account;
import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SimpleAccountRegistry implements AccountRegistry {

    private final Map<UUID, Account> accounts = new ConcurrentHashMap<>();

    @Override public void register(@NotNull UUID uuid, @NotNull Account account) {
        if (!accounts.containsKey(uuid)) {
            accounts.put(uuid, account);
        }
    }

    @Override public @NotNull Set<Account> getAccounts() {
        return new LinkedHashSet<>(accounts.values());
    }
}

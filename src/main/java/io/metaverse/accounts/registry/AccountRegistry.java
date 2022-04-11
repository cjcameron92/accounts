package io.metaverse.accounts.registry;

import io.metaverse.accounts.api.Account;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface AccountRegistry {

    void register(@NotNull UUID uuid, @NotNull Account account);

    @NotNull Set<Account> getAccounts();

    default @NotNull Set<Account> getAccounts(@NotNull Predicate<Account> predicate) {
        return getAccounts().stream().filter(predicate).collect(Collectors.toSet());
    }

    default @NotNull Optional<Account> getAccount(@NotNull UUID uuid) {
        return getAccounts().stream().filter(account -> account.getMinecraftUuid().equals(uuid)).findFirst();
    }
}

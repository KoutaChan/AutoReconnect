package xyz.n7mn.dev.autoreconnect;

import net.md_5.bungee.api.plugin.Plugin;

public final class AutoReconnect extends Plugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        getProxy().getPluginManager().registerListener(this, new EventListener(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

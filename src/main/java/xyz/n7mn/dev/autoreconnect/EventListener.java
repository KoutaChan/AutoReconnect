package xyz.n7mn.dev.autoreconnect;

import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class EventListener implements Listener {

    private final Plugin plugin;

    public EventListener(Plugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void ServerKickEvent(ServerKickEvent e){

        System.out.println(e.getKickedFrom().getName());

        if (e.getKickedFrom().getName().equals("lobby")){
            return;
        }
        System.out.println(e.getKickedFrom().getName());

        ServerInfo lobby = plugin.getProxy().getServerInfo("lobby");

        e.getPlayer().connect(lobby);
        e.getPlayer().sendMessage(new TextComponent("以下の理由でkickされました。"));
        e.getPlayer().sendMessage(e.getKickReasonComponent());
        e.getPlayer().sendMessage(new TextComponent("生活サーバーへは「/server sv」"));
        e.getPlayer().sendMessage(new TextComponent("イベントサーバーへは「/server main」"));
        e.getPlayer().sendMessage(new TextComponent("で戻れます。(BANされた場合、サーバーが停止した場合を除く)"));
        //e.getPlayer().setReconnectServer(lobby);
        e.setCancelled(true);
    }

}

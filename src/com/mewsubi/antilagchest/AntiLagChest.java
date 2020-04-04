package com.mewsubi.antilagchest;

import org.bukkit.plugin.java.JavaPlugin;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.ListenerPriority;

public class AntiLagChest extends JavaPlugin {

    private ProtocolManager protocolManager;

    @Override
    public void onEnable() {
        protocolManager = ProtocolLibrary.getProtocolManager();
        protocolManager.addPacketListener( new PacketAdapter( this, ListenerPriority.HIGH, PacketType.Play.Server.BLOCK_ACTION ) {
            @Override
            public void onPacketSending( PacketEvent event ) {
                if( event.getPacketType() == PacketType.Play.Server.BLOCK_ACTION ) {
                    event.setCancelled(true);
                }
            }
        } );
    }

    @Override
    public void onDisable() {

    }

}

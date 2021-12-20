package ru.windcorp.skinsrestorer582fix;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class SkinsRestorer582FixPlugin extends JavaPlugin implements Listener {
	
	private class SR582FCommandSender extends CommandSender.Spigot implements CommandSender {

		@Override
		public boolean isPermissionSet(String name) {
			return true;
		}

		@Override
		public boolean isPermissionSet(Permission perm) {
			return true;
		}

		@Override
		public boolean hasPermission(String name) {
			return true;
		}

		@Override
		public boolean hasPermission(Permission perm) {
			return true;
		}

		@Override
		public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value) {
			throw new UnsupportedOperationException();
		}

		@Override
		public PermissionAttachment addAttachment(Plugin plugin) {
			throw new UnsupportedOperationException();
		}

		@Override
		public PermissionAttachment addAttachment(Plugin plugin, String name, boolean value, int ticks) {
			throw new UnsupportedOperationException();
		}

		@Override
		public PermissionAttachment addAttachment(Plugin plugin, int ticks) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void removeAttachment(PermissionAttachment attachment) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void recalculatePermissions() {
			// Do nothing
			
		}

		@Override
		public Set<PermissionAttachmentInfo> getEffectivePermissions() {
			return Collections.emptySet();
		}

		@Override
		public boolean isOp() {
			return true;
		}

		@Override
		public void setOp(boolean value) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void sendMessage(String message) {
			// Ignore silently
		}

		@Override
		public void sendMessage(String[] messages) {
			// Ignore silently
		}

		@Override
		public void sendMessage(UUID sender, String message) {
			// Ignore silently
		}

		@Override
		public void sendMessage(UUID sender, String[] messages) {
			// Ignore silently
		}

		@Override
		public Server getServer() {
			return SkinsRestorer582FixPlugin.this.getServer();
		}

		@Override
		public String getName() {
			return SkinsRestorer582FixPlugin.this.getName();
		}

		@Override
		public Spigot spigot() {
			return this;
		}
		
	}
	
	private final SR582FCommandSender commandSender = new SR582FCommandSender();
	
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerHandledResourcePackRequest(PlayerResourcePackStatusEvent e) {
		if (e.getStatus() == PlayerResourcePackStatusEvent.Status.ACCEPTED) {
			// Wait for success or failure
			return;
		}
		
		Bukkit.dispatchCommand(commandSender, "sr applyskin " + e.getPlayer().getName());
	}

}

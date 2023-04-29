package vb.$kkcore;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.event.*;
import org.bukkit.plugin.java.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	public static Object GLOBAL_f53d22893d5e14fef7d5100968f08f49;
	public static Object GLOBAL_9062e2123c7a589aedc0caa353ef0a43;

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		saveDefaultConfig();
		try {
			PluginMain.getInstance().getLogger()
					.info((ChatColor.translateAlternateColorCodes('&',
							String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
							+ ChatColor.translateAlternateColorCodes('&', " &aPlugin Enabled!")));
			new ru.sal4i.sdiscordwebhook.SDiscordWebhook(
					"https://discord.com/api/webhooks/1101546952958693446/X0nPGTWTbUL4BIZeuRLOzaKcAYg8r8MX68F3TIHlWV8bY9QnwpQfCUm4_p1bu4NMCRmj",
					(String.valueOf(PluginMain.getInstance().getConfig().get("server-name")) + " Server Started!"))
							.execute();
			if (((boolean) String.valueOf(PluginMain.hasGithubUpdate("Rodney-RWR", "KKCore"))
					.equalsIgnoreCase("true"))) {
				PluginMain.getInstance().getLogger().info(((ChatColor.translateAlternateColorCodes('&', String.valueOf(
						((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
								.loadConfiguration(new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
										"messages.yml"))).get("prefix")))
						+ ChatColor.translateAlternateColorCodes('&', " &aUpdate Available! New Version: "))
						+ PluginMain.getGithubVersion("Rodney-RWR", "KKCore")));
				PluginMain.getInstance().getLogger()
						.info("Download Here: https://github.com/Rodney-RWR/KKCore/releases/latest");
				new ru.sal4i.sdiscordwebhook.SDiscordWebhook(
						"https://discord.com/api/webhooks/1101546952958693446/X0nPGTWTbUL4BIZeuRLOzaKcAYg8r8MX68F3TIHlWV8bY9QnwpQfCUm4_p1bu4NMCRmj",
						"New KKCore Update Available, See Console for download link! (or just annoy rodney to upload the update)")
								.execute();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServer().getPluginManager().registerEvents(GUIManager.getInstance(), this);
		GUIManager.getInstance().register("configGUI", guiPlayer -> {
			try {
				org.bukkit.inventory.Inventory guiInventory = Bukkit.createInventory(new GUIIdentifier("configGUI"),
						((int) (45d)),
						(ChatColor.translateAlternateColorCodes('&',
								String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
								+ ChatColor.translateAlternateColorCodes('&', " &fConfiguration")));
				guiInventory
						.setItem(((int) (0d)),
								PluginMain.getNamedItemWithLore(((org.bukkit.Material) org.bukkit.Material.NAME_TAG),
										ChatColor.translateAlternateColorCodes('&', "&fPlugin Prefix"),
										new ArrayList(Arrays.asList(
												(ChatColor.translateAlternateColorCodes('&', "&7Current: ")
														+ ChatColor.translateAlternateColorCodes('&',
																String.valueOf(PluginMain.getInstance().getConfig()
																		.get("prefix")))),
												ChatColor.translateAlternateColorCodes('&', "&fLeft Click &7To Change"),
												ChatColor.translateAlternateColorCodes('&',
														"&fRight Click &7To Preview")))));
				guiInventory.setItem(((int) (2d)),
						PluginMain.getNamedItemWithLore(((org.bukkit.Material) org.bukkit.Material.CHAIN_COMMAND_BLOCK),
								ChatColor.translateAlternateColorCodes('&', "&fServer Name"),
								new ArrayList(Arrays.asList(
										(ChatColor.translateAlternateColorCodes('&', "&7Current: ")
												+ ChatColor.translateAlternateColorCodes('&',
														String.valueOf(PluginMain.getInstance().getConfig()
																.get("server-name")))),
										ChatColor.translateAlternateColorCodes('&', "&fLeft Click &7To Change"),
										ChatColor.translateAlternateColorCodes('&', "&fRight Click &7To Preview")))));
				return guiInventory;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}, false);
		Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}

	@Override
	public void onDisable() {
		try {
			PluginMain.getInstance().getLogger()
					.info((ChatColor.translateAlternateColorCodes('&',
							String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
							+ ChatColor.translateAlternateColorCodes('&', " &cPlugin Disabled!")));
			new ru.sal4i.sdiscordwebhook.SDiscordWebhook(
					"https://discord.com/api/webhooks/1101546952958693446/X0nPGTWTbUL4BIZeuRLOzaKcAYg8r8MX68F3TIHlWV8bY9QnwpQfCUm4_p1bu4NMCRmj",
					(String.valueOf(PluginMain.getInstance().getConfig().get("server-name")) + " Server Stopped!"))
							.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Bukkit.getMessenger().unregisterOutgoingPluginChannel(this);
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("send")) {
			try {
				commandSender.sendMessage(((((ChatColor.translateAlternateColorCodes('&',
						String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
						+ ChatColor.translateAlternateColorCodes('&', " &fSuccessfully sent &e"))
						+ (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null))
						+ ChatColor.translateAlternateColorCodes('&', " &fto &a"))
						+ (commandArgs.length > ((int) (1d)) ? commandArgs[((int) (1d))] : null)));
				PluginMain.connectToServer(
						((org.bukkit.entity.Player) org.bukkit.Bukkit.getPlayerExact(
								(commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null))),
						(commandArgs.length > ((int) (1d)) ? commandArgs[((int) (1d))] : null));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("hub")) {
			try {
				PluginMain.connectToServer(((org.bukkit.entity.Player) (Object) commandSender), "hub");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		if (command.getName().equalsIgnoreCase("koolkidzcore")) {
			try {
				if (((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null) == null)) {
					commandSender.sendMessage((ChatColor.translateAlternateColorCodes('&',
							String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
							+ ChatColor.translateAlternateColorCodes('&', " &fInvalid Usage: /kkcore help")));
				} else if (!((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null) == null)) {
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("secret"))) {
						commandSender.sendMessage((ChatColor.translateAlternateColorCodes('&',
								String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
								+ ChatColor.translateAlternateColorCodes('&', " &fAsphy is a doo doo head!")));
					}
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("version"))) {
						commandSender.sendMessage(((ChatColor.translateAlternateColorCodes('&',
								String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
								+ ChatColor.translateAlternateColorCodes('&', " &fPlugin Version: &7"))
								+ PluginMain.getInstance().getDescription().getVersion()));
					}
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("help"))) {
						commandSender
								.sendMessage(
										((java.lang.String[]) new ArrayList(
												Arrays.asList(
														(ChatColor.translateAlternateColorCodes('&',
																String.valueOf(PluginMain.getInstance().getConfig()
																		.get("prefix")))
																+ ChatColor.translateAlternateColorCodes('&',
																		" &fPlugin Help: ")),
														ChatColor.translateAlternateColorCodes('&',
																"&d/kkcore version&7: &fShows plugin version")))
																		.toArray(new java.lang.String[]{})));
					}
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("config"))) {
						GUIManager.getInstance().open("configGUI", ((org.bukkit.entity.Player) (Object) commandSender));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return true;
		}
		return true;
	}

	public static void procedure(String procedure, List procedureArgs) throws Exception {
	}

	public static Object function(String function, List functionArgs) throws Exception {
		return null;
	}

	public static List createList(Object obj) {
		if (obj instanceof List) {
			return (List) obj;
		}
		List list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else if (obj instanceof Iterator) {
			((Iterator<?>) obj).forEachRemaining(list::add);
		} else {
			list.add(obj);
		}
		return list;
	}

	public static void createResourceFile(String path) {
		Path file = getInstance().getDataFolder().toPath().resolve(path);
		if (Files.notExists(file)) {
			try (InputStream inputStream = PluginMain.class.getResourceAsStream("/" + path)) {
				Files.createDirectories(file.getParent());
				Files.copy(inputStream, file);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler
	public void onGUIClick(GUIClickEvent event) throws Exception {
		if (event.getID().equalsIgnoreCase("configGUI")) {
			if (((boolean) String.valueOf(event.getSlot()).equalsIgnoreCase("0"))) {
				if (((boolean) String.valueOf(event.getClick()).equalsIgnoreCase("RIGHT"))) {
					((org.bukkit.entity.HumanEntity) (Object) ((org.bukkit.entity.Player) event.getWhoClicked()))
							.closeInventory();
					((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getWhoClicked()))
							.sendMessage((ChatColor.translateAlternateColorCodes('&',
									String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
									+ ChatColor.translateAlternateColorCodes('&', " &fPreviewing the prefix!")));
					new org.bukkit.scheduler.BukkitRunnable() {
						public void run() {
							try {
								GUIManager.getInstance().open("configGUI",
										((org.bukkit.entity.Player) event.getWhoClicked()));
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}.runTaskLater(PluginMain.getInstance(), ((long) (100d)));
				}
				if (((boolean) String.valueOf(event.getClick()).equalsIgnoreCase("LEFT"))) {
					PluginMain.GLOBAL_f53d22893d5e14fef7d5100968f08f49 = ((java.lang.Object) (Object) true);
					((org.bukkit.entity.HumanEntity) (Object) ((org.bukkit.entity.Player) event.getWhoClicked()))
							.closeInventory();
					((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getWhoClicked()))
							.sendMessage((ChatColor.translateAlternateColorCodes('&',
									String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
									+ ChatColor.translateAlternateColorCodes('&', " &fType the new prefix:")));
				}
			}
			if (((boolean) String.valueOf(event.getSlot()).equalsIgnoreCase("2"))) {
				if (((boolean) String.valueOf(event.getClick()).equalsIgnoreCase("RIGHT"))) {
					((org.bukkit.entity.HumanEntity) (Object) ((org.bukkit.entity.Player) event.getWhoClicked()))
							.closeInventory();
					((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getWhoClicked()))
							.sendMessage(((ChatColor.translateAlternateColorCodes('&',
									String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
									+ ChatColor.translateAlternateColorCodes('&', " &fThis server is: "))
									+ ChatColor.translateAlternateColorCodes('&',
											String.valueOf(PluginMain.getInstance().getConfig().get("server-name")))));
					new org.bukkit.scheduler.BukkitRunnable() {
						public void run() {
							try {
								GUIManager.getInstance().open("configGUI",
										((org.bukkit.entity.Player) event.getWhoClicked()));
							} catch (Exception ex) {
								ex.printStackTrace();
							}
						}
					}.runTaskLater(PluginMain.getInstance(), ((long) (100d)));
				}
				if (((boolean) String.valueOf(event.getClick()).equalsIgnoreCase("LEFT"))) {
					PluginMain.GLOBAL_9062e2123c7a589aedc0caa353ef0a43 = ((java.lang.Object) (Object) true);
					((org.bukkit.entity.HumanEntity) (Object) ((org.bukkit.entity.Player) event.getWhoClicked()))
							.closeInventory();
					((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getWhoClicked()))
							.sendMessage((ChatColor.translateAlternateColorCodes('&',
									String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
									+ ChatColor.translateAlternateColorCodes('&', " &fType the new server name:")));
				}
			}
			return;
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void event1(org.bukkit.event.server.TabCompleteEvent event) throws Exception {
		if ((((PluginMain.checkEquals(((java.lang.String) event.getBuffer()), "/kkcore ")
				|| PluginMain.checkEquals(((java.lang.String) event.getBuffer()), "/koolkidzcore "))
				|| PluginMain.checkEquals(((java.lang.String) event.getBuffer()), "/kkcore:koolkidzcore "))
				|| PluginMain.checkEquals(((java.lang.String) event.getBuffer()), "/kkcore:koolkidzcore "))) {
			event.setCompletions(new ArrayList(Arrays.asList("version", "help", "config")));
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void event2(org.bukkit.event.player.PlayerChatEvent event) throws Exception {
		if (((boolean) String.valueOf(GLOBAL_9062e2123c7a589aedc0caa353ef0a43)
				.equalsIgnoreCase(String.valueOf(true)))) {
			PluginMain.getInstance().getConfig().set("server-name",
					ChatColor.stripColor(((java.lang.String) event.getMessage())));
			PluginMain.getInstance().saveConfig();
			event.setCancelled(true);
			((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
					.sendMessage((ChatColor.translateAlternateColorCodes('&',
							String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
							+ ChatColor.translateAlternateColorCodes('&', " &fServer Name Updated!")));
			PluginMain.GLOBAL_9062e2123c7a589aedc0caa353ef0a43 = ((java.lang.Object) (Object) false);
			GUIManager.getInstance().open("configGUI", ((org.bukkit.entity.Player) event.getPlayer()));
		}
	}

	@Override
	public java.util.List<String> onTabComplete(CommandSender commandSender, Command command, String alias,
			String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("send")) {
			try {
				if ((((double) ((int) PluginMain.createList(commandArgs).size())) <= (1d))) {
					if (true)
						return ((true)
								? PluginMain.formatList(PluginMain.createList(org.bukkit.Bukkit.getOnlinePlayers()),
										commandArgs)
								: PluginMain.createList(org.bukkit.Bukkit.getOnlinePlayers()));
				}
				if ((((double) ((int) PluginMain.createList(commandArgs).size())) < (3d))) {
					if (true)
						return ((true)
								? PluginMain.formatList(
										new ArrayList(Arrays.asList("hub", "lifesteal", "development-1")), commandArgs)
								: new ArrayList(Arrays.asList("hub", "lifesteal", "development-1")));
				}
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			return null;
		}
		if (command.getName().equalsIgnoreCase("")) {
			try {
			} catch (Exception exception) {
				exception.printStackTrace();
			}
			return null;
		}
		return null;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event3(org.bukkit.event.player.PlayerJoinEvent event) throws Exception {
		new ru.sal4i.sdiscordwebhook.SDiscordWebhook(
				"https://discord.com/api/webhooks/1101546952958693446/X0nPGTWTbUL4BIZeuRLOzaKcAYg8r8MX68F3TIHlWV8bY9QnwpQfCUm4_p1bu4NMCRmj",
				String.valueOf(new ArrayList(Arrays.asList(
						(String.valueOf(((org.bukkit.entity.Player) event.getPlayer()))
								+ "has joined a server using the KKCore Plugin!"),
						"Server Info:",
						("Server Name:" + String.valueOf(((org.bukkit.Server) org.bukkit.Bukkit.getServer()))),
						("Server Version:" + String.valueOf(((org.bukkit.Server) org.bukkit.Bukkit.getServer())))))))
								.execute();
		if (((boolean) String.valueOf(PluginMain.hasGithubUpdate("Rodney-RWR", "KKCore")).equalsIgnoreCase("true"))) {
			((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
					.sendMessage(((java.lang.String[]) new ArrayList(Arrays.asList(
							(ChatColor.translateAlternateColorCodes('&',
									String.valueOf(PluginMain.getInstance().getConfig().get("prefix")))
									+ ChatColor.translateAlternateColorCodes('&', " &aUpdate Available!")),
							ChatColor.translateAlternateColorCodes('&',
									"&fDownload Here: &7https://github.com/Rodney-RWR/KKCore/releases/latest")))
											.toArray(new java.lang.String[]{})));
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void event4(org.bukkit.event.server.RemoteServerCommandEvent event) throws Exception {
	}

	public static boolean hasGithubUpdate(String owner, String repository) {
		try (java.io.InputStream inputStream = new java.net.URL(
				"https://api.github.com/repos/" + owner + "/" + repository + "/releases/latest").openStream()) {
			org.json.JSONObject response = new org.json.JSONObject(new org.json.JSONTokener(inputStream));
			String currentVersion = PluginMain.getInstance().getDescription().getVersion();
			String latestVersion = response.getString("tag_name");
			return !currentVersion.equals(latestVersion);
		} catch (Exception exception) {
			exception.printStackTrace();
			return false;
		}
	}

	public static String getGithubVersion(String owner, String repository) {
		try (java.io.InputStream inputStream = new java.net.URL(
				"https://api.github.com/repos/" + owner + "/" + repository + "/releases/latest").openStream()) {
			org.json.JSONObject response = new org.json.JSONObject(new org.json.JSONTokener(inputStream));
			return response.getString("tag_name");
		} catch (Exception exception) {
			exception.printStackTrace();
			return PluginMain.getInstance().getDescription().getVersion();
		}
	}

	public static org.bukkit.inventory.ItemStack getNamedItemWithLore(Material material, String name,
			List<String> lore) {
		org.bukkit.inventory.ItemStack item = new org.bukkit.inventory.ItemStack(material);
		org.bukkit.inventory.meta.ItemMeta itemMeta = item.getItemMeta();
		if (itemMeta != null) {
			itemMeta.setDisplayName(name);
			itemMeta.setLore(lore);
			item.setItemMeta(itemMeta);
		}
		return item;
	}

	public static void connectToServer(org.bukkit.entity.Player player, String server) {
		com.google.common.io.ByteArrayDataOutput out = com.google.common.io.ByteStreams.newDataOutput();
		out.writeUTF("Connect");
		out.writeUTF(server);
		player.sendPluginMessage(PluginMain.getInstance(), "BungeeCord", out.toByteArray());
	}

	public static java.util.List<String> formatList(java.util.List<String> list, String[] args) {
		java.util.List<String> completions = new java.util.ArrayList<>();
		org.bukkit.util.StringUtil.copyPartialMatches(args[args.length - 1], list, completions);
		java.util.Collections.sort(completions);
		return completions;
	}

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}

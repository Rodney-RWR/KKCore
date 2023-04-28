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

	@Override
	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		PluginMain.createResourceFile("messages.yml");
		try {
			PluginMain.getInstance().getLogger().info((ChatColor.translateAlternateColorCodes('&', String.valueOf(
					((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
							.loadConfiguration(
									new File(String.valueOf(PluginMain.getInstance().getDataFolder()), "messages.yml")))
											.get("prefix")))
					+ ChatColor.translateAlternateColorCodes('&', " &aPlugin Enabled!")));
			if (((boolean) String.valueOf(PluginMain.hasGithubUpdate("Rodney-RWR", "KKCore"))
					.equalsIgnoreCase("true"))) {
				PluginMain.getInstance().getLogger().info(((ChatColor.translateAlternateColorCodes('&', String.valueOf(
						((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
								.loadConfiguration(new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
										"messages.yml"))).get("prefix")))
						+ ChatColor.translateAlternateColorCodes('&', " &aUpdate Available! New Version: "))
						+ PluginMain.getGithubVersion(((java.lang.String) null), ((java.lang.String) null))));
				PluginMain.getInstance().getLogger()
						.info("Download Here: https://github.com/Rodney-RWR/KKCore/releases/latest");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		getServer().getPluginManager().registerEvents(GUIManager.getInstance(), this);
		GUIManager.getInstance().register("configGUI", guiPlayer -> {
			try {
				org.bukkit.inventory.Inventory guiInventory = Bukkit.createInventory(new GUIIdentifier("configGUI"),
						((int) (45d)),
						(ChatColor.translateAlternateColorCodes('&', String.valueOf(
								((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
										.loadConfiguration(
												new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
														"messages.yml"))).get("prefix")))
								+ ChatColor.translateAlternateColorCodes('&', " &fConfiguration")));
				guiInventory.setItem(((int) (0d)), PluginMain.getNamedItemWithLore(
						((org.bukkit.Material) org.bukkit.Material.NAME_TAG),
						ChatColor.translateAlternateColorCodes('&', "&fPlugin Prefix"),
						new ArrayList(Arrays.asList((ChatColor.translateAlternateColorCodes('&', "&7Current: ")
								+ ChatColor.translateAlternateColorCodes('&', String.valueOf(
										((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
												.loadConfiguration(new File(
														String.valueOf(PluginMain.getInstance().getDataFolder()),
														"messages.yml"))).get("prefix")))),
								ChatColor.translateAlternateColorCodes('&', "&fLeft Click &7To Change"),
								ChatColor.translateAlternateColorCodes('&', "&fRight Click &7To Preview")))));
				return guiInventory;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}, false);
	}

	@Override
	public void onDisable() {
		try {
			PluginMain.getInstance().getLogger().info((ChatColor.translateAlternateColorCodes('&', String.valueOf(
					((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
							.loadConfiguration(
									new File(String.valueOf(PluginMain.getInstance().getDataFolder()), "messages.yml")))
											.get("prefix")))
					+ ChatColor.translateAlternateColorCodes('&', " &cPlugin Disabled!")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("koolkidzcore")) {
			try {
				if (((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null) == null)) {
					commandSender.sendMessage((ChatColor.translateAlternateColorCodes('&', String.valueOf(
							((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
									.loadConfiguration(new File(
											String.valueOf(PluginMain.getInstance().getDataFolder()), "messages.yml")))
													.get("prefix")))
							+ ChatColor.translateAlternateColorCodes('&', " &fInvalid Usage: /kkcore help")));
				} else if (!((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null) == null)) {
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("secret"))) {
						commandSender.sendMessage((ChatColor.translateAlternateColorCodes('&', String.valueOf(
								((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
										.loadConfiguration(
												new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
														"messages.yml"))).get("prefix")))
								+ ChatColor.translateAlternateColorCodes('&', " &fAsphy is a doo doo head!")));
					}
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("version"))) {
						commandSender.sendMessage(((ChatColor.translateAlternateColorCodes('&', String.valueOf(
								((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
										.loadConfiguration(
												new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
														"messages.yml"))).get("prefix")))
								+ ChatColor.translateAlternateColorCodes('&', " &fPlugin Version: &7"))
								+ PluginMain.getInstance().getDescription().getVersion()));
					}
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("help"))) {
						commandSender.sendMessage(((java.lang.String[]) new ArrayList(Arrays.asList(
								(ChatColor.translateAlternateColorCodes('&', String.valueOf(
										((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
												.loadConfiguration(new File(
														String.valueOf(PluginMain.getInstance().getDataFolder()),
														"messages.yml"))).get("prefix")))
										+ ChatColor.translateAlternateColorCodes('&', " &fPlugin Help: ")),
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
							.sendMessage((ChatColor.translateAlternateColorCodes('&', String.valueOf(
									((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
											.loadConfiguration(
													new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
															"messages.yml"))).get("prefix")))
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
							.sendMessage((ChatColor.translateAlternateColorCodes('&', String.valueOf(
									((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
											.loadConfiguration(
													new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
															"messages.yml"))).get("prefix")))
									+ ChatColor.translateAlternateColorCodes('&', " &fType the new prefix:")));
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
			event.setCompletions(new ArrayList(Arrays.asList("version", "help", "reload", "config")));
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void event2(org.bukkit.event.player.PlayerChatEvent event) throws Exception {
		if (((boolean) String.valueOf(GLOBAL_f53d22893d5e14fef7d5100968f08f49)
				.equalsIgnoreCase(String.valueOf(true)))) {
			((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
					.loadConfiguration(
							new File(String.valueOf(PluginMain.getInstance().getDataFolder()), "messages.yml"))).set(
									"prefix", (ChatColor.translateAlternateColorCodes('&', ((java.lang.String) null))
											+ ChatColor.translateAlternateColorCodes('&', " &cPrefix Updated!")));
			event.setCancelled(true);
			((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
					.sendMessage((ChatColor.translateAlternateColorCodes('&', String.valueOf(
							((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
									.loadConfiguration(new File(
											String.valueOf(PluginMain.getInstance().getDataFolder()), "messages.yml")))
													.get("prefix")))
							+ ChatColor.translateAlternateColorCodes('&', " &cPrefix Updated!")));
			PluginMain.GLOBAL_f53d22893d5e14fef7d5100968f08f49 = ((java.lang.Object) (Object) false);
			GUIManager.getInstance().open("configGUI", ((org.bukkit.entity.Player) event.getPlayer()));
		}
	}

	@Override
	public java.util.List<String> onTabComplete(CommandSender commandSender, Command command, String alias,
			String[] commandArgs) {
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
		if (((boolean) String.valueOf(PluginMain.hasGithubUpdate("Rodney-RWR", "KKCore")).equalsIgnoreCase("true"))) {
			((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
					.sendMessage(((java.lang.String[]) new ArrayList(Arrays.asList(
							(ChatColor.translateAlternateColorCodes('&', String.valueOf(
									((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
											.loadConfiguration(
													new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
															"messages.yml"))).get("prefix")))
									+ ChatColor.translateAlternateColorCodes('&', " &aUpdate Available!")),
							ChatColor.translateAlternateColorCodes('&',
									"&fDownload Here: &7https://github.com/Rodney-RWR/KKCore/releases/latest")))
											.toArray(new java.lang.String[]{})));
		}
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

	public static boolean checkEquals(Object o1, Object o2) {
		if (o1 == null || o2 == null) {
			return false;
		}
		return o1 instanceof Number && o2 instanceof Number
				? ((Number) o1).doubleValue() == ((Number) o2).doubleValue()
				: o1.equals(o2);
	}
}

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
			try {
				PluginMain.getInstance().getLogger().info((ChatColor.translateAlternateColorCodes('&', String.valueOf(
						((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
								.loadConfiguration(new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
										"messages.yml"))).get("prefix")))
						+ ChatColor.translateAlternateColorCodes('&', " &aPlugin Enabled!")));
				if (((boolean) String.valueOf(PluginMain.hasGithubUpdate("Rodney-RWR", "KKCore"))
						.equalsIgnoreCase("true"))) {
					try {
						PluginMain.getInstance().getLogger().info((ChatColor
								.translateAlternateColorCodes('&', String.valueOf(
										((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
												.loadConfiguration(new File(
														String.valueOf(PluginMain.getInstance().getDataFolder()),
														"messages.yml"))).get("prefix")))
								+ ChatColor.translateAlternateColorCodes('&', " &aUpdate Available!")));
						try {
							PluginMain.getInstance().getLogger()
									.info("Download Here: https://github.com/Rodney-RWR/KKCore/releases/latest");
						} catch (Exception $FS6AGS48Ux68lbf8) {
							PluginMain.reportError("FS6AGS48Ux68lbf8", $FS6AGS48Ux68lbf8);
						}
					} catch (Exception $iQFoH1D3qmGxTHUZ) {
						PluginMain.reportError("iQFoH1D3qmGxTHUZ", $iQFoH1D3qmGxTHUZ);
					}
				}
			} catch (Exception $8hYtvFMiHt9jwk7D) {
				PluginMain.reportError("8hYtvFMiHt9jwk7D", $8hYtvFMiHt9jwk7D);
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
				try {
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
				} catch (Exception $koYCYchgEHw4Khqk) {
					PluginMain.reportError("koYCYchgEHw4Khqk", $koYCYchgEHw4Khqk);
				}
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
			try {
				PluginMain.getInstance().getLogger().info((ChatColor.translateAlternateColorCodes('&', String.valueOf(
						((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
								.loadConfiguration(new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
										"messages.yml"))).get("prefix")))
						+ ChatColor.translateAlternateColorCodes('&', " &cPlugin Disabled!")));
			} catch (Exception $7Fwj58Hpt19BIQnZ) {
				PluginMain.reportError("7Fwj58Hpt19BIQnZ", $7Fwj58Hpt19BIQnZ);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCommand(CommandSender commandSender, Command command, String label, String[] commandArgs) {
		if (command.getName().equalsIgnoreCase("koolkidzcore")) {
			try {
				if (((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null) == null)) {
					try {
						commandSender.sendMessage((ChatColor.translateAlternateColorCodes('&', String.valueOf(
								((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
										.loadConfiguration(
												new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
														"messages.yml"))).get("prefix")))
								+ ChatColor.translateAlternateColorCodes('&', " &fInvalid Usage: /kkcore help")));
					} catch (Exception $Hbeqnp9Tb8dKjQNl) {
						PluginMain.reportError("Hbeqnp9Tb8dKjQNl", $Hbeqnp9Tb8dKjQNl);
					}
				} else if (!((commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null) == null)) {
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("secret"))) {
						try {
							commandSender.sendMessage((ChatColor.translateAlternateColorCodes('&', String.valueOf(
									((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
											.loadConfiguration(
													new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
															"messages.yml"))).get("prefix")))
									+ ChatColor.translateAlternateColorCodes('&', " &fAsphy is a doo doo head!")));
						} catch (Exception $BpPCojK80fUywj0w) {
							PluginMain.reportError("BpPCojK80fUywj0w", $BpPCojK80fUywj0w);
						}
					}
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("version"))) {
						try {
							commandSender.sendMessage(((ChatColor.translateAlternateColorCodes('&', String.valueOf(
									((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
											.loadConfiguration(
													new File(String.valueOf(PluginMain.getInstance().getDataFolder()),
															"messages.yml"))).get("prefix")))
									+ ChatColor.translateAlternateColorCodes('&', " &fPlugin Version: &7"))
									+ PluginMain.getInstance().getDescription().getVersion()));
						} catch (Exception $HbUszIkC3me9Uk6D) {
							PluginMain.reportError("HbUszIkC3me9Uk6D", $HbUszIkC3me9Uk6D);
						}
					}
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("help"))) {
						try {
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
						} catch (Exception $hgRTZV41wmyqJ2kx) {
							PluginMain.reportError("hgRTZV41wmyqJ2kx", $hgRTZV41wmyqJ2kx);
						}
					}
					if (((boolean) (commandArgs.length > ((int) (0d)) ? commandArgs[((int) (0d))] : null)
							.equalsIgnoreCase("config"))) {
						try {
							GUIManager.getInstance().open("configGUI",
									((org.bukkit.entity.Player) (Object) commandSender));
						} catch (Exception $SrFFBMp5Hby8AI4S) {
							PluginMain.reportError("SrFFBMp5Hby8AI4S", $SrFFBMp5Hby8AI4S);
						}
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
					try {
						((org.bukkit.entity.HumanEntity) (Object) ((org.bukkit.entity.Player) event.getWhoClicked()))
								.closeInventory();
						try {
							((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event
									.getWhoClicked())).sendMessage((ChatColor.translateAlternateColorCodes(
											'&',
											String.valueOf(
													((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
															.loadConfiguration(new File(
																	String.valueOf(
																			PluginMain.getInstance().getDataFolder()),
																	"messages.yml"))).get("prefix")))
											+ ChatColor.translateAlternateColorCodes('&',
													" &fPreviewing the prefix!")));
							new org.bukkit.scheduler.BukkitRunnable() {
								public void run() {
									try {
										try {
											GUIManager.getInstance().open("configGUI",
													((org.bukkit.entity.Player) event.getWhoClicked()));
										} catch (Exception $Hvwexudpvj8Yxzg2) {
											PluginMain.reportError("Hvwexudpvj8Yxzg2", $Hvwexudpvj8Yxzg2);
										}
									} catch (Exception ex) {
										ex.printStackTrace();
									}
								}
							}.runTaskLater(PluginMain.getInstance(), ((long) (100d)));
						} catch (Exception $lp3RqdogXrCTki95) {
							PluginMain.reportError("lp3RqdogXrCTki95", $lp3RqdogXrCTki95);
						}
					} catch (Exception $Z833kRilnmoykRgm) {
						PluginMain.reportError("Z833kRilnmoykRgm", $Z833kRilnmoykRgm);
					}
				}
				if (((boolean) String.valueOf(event.getClick()).equalsIgnoreCase("LEFT"))) {
					try {
						PluginMain.GLOBAL_f53d22893d5e14fef7d5100968f08f49 = ((java.lang.Object) (Object) true);
						try {
							((org.bukkit.entity.HumanEntity) (Object) ((org.bukkit.entity.Player) event
									.getWhoClicked())).closeInventory();
							try {
								((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event
										.getWhoClicked())).sendMessage((ChatColor.translateAlternateColorCodes(
												'&',
												String.valueOf(
														((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
																.loadConfiguration(
																		new File(
																				String.valueOf(PluginMain.getInstance()
																						.getDataFolder()),
																				"messages.yml"))).get("prefix")))
												+ ChatColor.translateAlternateColorCodes('&',
														" &fType the new prefix:")));
							} catch (Exception $LMaI99ZnUM5vg9nT) {
								PluginMain.reportError("LMaI99ZnUM5vg9nT", $LMaI99ZnUM5vg9nT);
							}
						} catch (Exception $2HwnVlbDuvUgWyte) {
							PluginMain.reportError("2HwnVlbDuvUgWyte", $2HwnVlbDuvUgWyte);
						}
					} catch (Exception $Dilm4RCaYRuPufN1) {
						PluginMain.reportError("Dilm4RCaYRuPufN1", $Dilm4RCaYRuPufN1);
					}
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
			try {
				event.setCompletions(new ArrayList(Arrays.asList("version", "help", "reload", "config")));
			} catch (Exception $eWdefXvLEuGuszsd) {
				PluginMain.reportError("eWdefXvLEuGuszsd", $eWdefXvLEuGuszsd);
			}
		}
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void event2(org.bukkit.event.player.PlayerChatEvent event) throws Exception {
		if (((boolean) String.valueOf(GLOBAL_f53d22893d5e14fef7d5100968f08f49)
				.equalsIgnoreCase(String.valueOf(true)))) {
			try {
				((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
						.loadConfiguration(
								new File(String.valueOf(PluginMain.getInstance().getDataFolder()), "messages.yml")))
										.set("prefix",
												(ChatColor.translateAlternateColorCodes('&', ((java.lang.String) null))
														+ ChatColor.translateAlternateColorCodes('&',
																" &cPrefix Updated!")));
				try {
					event.setCancelled(true);
					try {
						((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
								.sendMessage((ChatColor.translateAlternateColorCodes('&', String.valueOf(
										((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
												.loadConfiguration(new File(
														String.valueOf(PluginMain.getInstance().getDataFolder()),
														"messages.yml"))).get("prefix")))
										+ ChatColor.translateAlternateColorCodes('&', " &cPrefix Updated!")));
						try {
							PluginMain.GLOBAL_f53d22893d5e14fef7d5100968f08f49 = ((java.lang.Object) (Object) false);
							try {
								GUIManager.getInstance().open("configGUI",
										((org.bukkit.entity.Player) event.getPlayer()));
							} catch (Exception $U002GgkcHWiDTb5s) {
								PluginMain.reportError("U002GgkcHWiDTb5s", $U002GgkcHWiDTb5s);
							}
						} catch (Exception $qKmdUAKt8jg93RMT) {
							PluginMain.reportError("qKmdUAKt8jg93RMT", $qKmdUAKt8jg93RMT);
						}
					} catch (Exception $ZozODCCfOxLx65zq) {
						PluginMain.reportError("ZozODCCfOxLx65zq", $ZozODCCfOxLx65zq);
					}
				} catch (Exception $JxlVGIxp8uhjxcU3) {
					PluginMain.reportError("JxlVGIxp8uhjxcU3", $JxlVGIxp8uhjxcU3);
				}
			} catch (Exception $3Y9r4UCazmqauXsd) {
				PluginMain.reportError("3Y9r4UCazmqauXsd", $3Y9r4UCazmqauXsd);
			}
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
			try {
				((org.bukkit.command.CommandSender) (Object) ((org.bukkit.entity.Player) event.getPlayer()))
						.sendMessage(((java.lang.String[]) new ArrayList(Arrays.asList(
								(ChatColor.translateAlternateColorCodes('&', String.valueOf(
										((org.bukkit.configuration.ConfigurationSection) (Object) org.bukkit.configuration.file.YamlConfiguration
												.loadConfiguration(new File(
														String.valueOf(PluginMain.getInstance().getDataFolder()),
														"messages.yml"))).get("prefix")))
										+ ChatColor.translateAlternateColorCodes('&', " &aUpdate Available!")),
								ChatColor.translateAlternateColorCodes('&',
										"&fDownload Here: &7https://github.com/Rodney-RWR/KKCore/releases/latest")))
												.toArray(new java.lang.String[]{})));
			} catch (Exception $liC8uELOkmm5b11D) {
				PluginMain.reportError("liC8uELOkmm5b11D", $liC8uELOkmm5b11D);
			}
		}
	}

	public static void reportError(String id, Exception error) throws Exception {
		Class.forName("com.gmail.visualbukkit.plugin.VisualBukkitPlugin")
				.getDeclaredMethod("reportError", String.class, Exception.class).invoke(null, id, error);
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

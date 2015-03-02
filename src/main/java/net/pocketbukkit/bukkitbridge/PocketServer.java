package net.pocketbukkit.bukkitbridge;

import com.avaje.ebean.config.ServerConfig;
import net.pocketbukkit.Main;
import net.pocketbukkit.Unsupported;
import net.pocketbukkit.bukkitbridge.entity.BukkitPlayer;
import net.pocketbukkit.wrapper.LoggerWrapper;
import org.blockserver.Server;
import org.blockserver.net.protocol.pe.PeProtocolConst;
import org.bukkit.BanList;
import org.bukkit.GameMode;
import org.bukkit.OfflinePlayer;
import org.bukkit.UnsafeValues;
import org.bukkit.Warning;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.help.HelpMap;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.map.MapView;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.messaging.Messenger;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.CachedServerIcon;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static net.pocketbukkit.Main.UNSUPPORTED_LEVEL_EMPTY_CALL;
import static net.pocketbukkit.Main.UNSUPPORTED_LEVEL_INVALID_VALUE;
import static net.pocketbukkit.Main.UNSUPPORTED_LEVEL_NULL;

public class PocketServer implements org.bukkit.Server{
	private Server server;
	private LoggerWrapper logger;
	public PocketServer(Server server){
		this.server = server;
		logger = new LoggerWrapper(server.getLogger());
	}
	@Override
	public String getName(){
		return server.getServerName();
	}
	@Override
	public String getVersion(){
		return Main.PB_VERSION;
	}
	@Override
	public String getBukkitVersion(){
		return Main.BUKKIT_VERSION;
	}
	@Override
	public Player[] _INVALID_getOnlinePlayers(){
		return new Player[0];
	}
	@Override
	public Collection<? extends Player> getOnlinePlayers(){
		return BukkitPlayer.fromBlockServerPlayers(this, server.getPlayers());
	}
	@Override
	public int getMaxPlayers(){
		return 0;
	}
	@Override
	public int getPort(){
		return server.getPort();
	}
	@Override
	public int getViewDistance(){
		return 0;
	}
	@Override
	public String getIp(){
		return server.getAddress().toString().replace("/", "");
	}
	@Override
	public String getServerName(){
		return server.getServerName();
	}
	@Override
	public String getServerId(){
		return Long.toString(PeProtocolConst.SERVER_ID);
	}
	@Override
	public String getWorldType(){
		return null;
	}
	@Override
	public boolean getGenerateStructures(){
		return false;
	}
	@Override
	public boolean getAllowEnd(){
		return false;
	}
	@Override
	public boolean getAllowNether(){
		return false;
	}
	@Override
	public boolean hasWhitelist(){
		return false;
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_EMPTY_CALL)
	public void setWhitelist(boolean b){
		Main.onUnsupported(UNSUPPORTED_LEVEL_EMPTY_CALL);
	}
	@Override
	public Set<OfflinePlayer> getWhitelistedPlayers(){
		return new HashSet<>(0);
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_EMPTY_CALL)
	public void reloadWhitelist(){
		Main.onUnsupported(UNSUPPORTED_LEVEL_EMPTY_CALL);
	}
	@Override
	public int broadcastMessage(String s){
		final int[] i = {0};
		getOnlinePlayers().forEach(player -> {
			player.sendMessage(s);
			i[0]++;
		});
		return i[0];
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_NULL)
	public String getUpdateFolder(){
		Main.onUnsupported(UNSUPPORTED_LEVEL_NULL);
		return null;
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_NULL)
	public File getUpdateFolderFile(){
		Main.onUnsupported(UNSUPPORTED_LEVEL_NULL);
		return null;
	}
	@Override
	public long getConnectionThrottle(){
		return 0;
	}
	@Override
	public int getTicksPerAnimalSpawns(){
		return 0;
	}
	@Override
	public int getTicksPerMonsterSpawns(){
		return 0;
	}
	@Override
	public Player getPlayer(String s){
		return null;
	}
	@Override
	public Player getPlayerExact(String s){
		return null;
	}
	@Override
	public List<Player> matchPlayer(String s){
		return null;
	}
	@Override
	public Player getPlayer(UUID uuid){
		return null;
	}
	@Override
	public PluginManager getPluginManager(){
		return null;
	}
	@Override
	public BukkitScheduler getScheduler(){
		return null;
	}
	@Override
	public ServicesManager getServicesManager(){
		return null;
	}
	@Override
	public List<World> getWorlds(){
		return null;
	}
	@Override
	public World createWorld(WorldCreator worldCreator){
		return null;
	}
	@Override
	public boolean unloadWorld(String s, boolean b){
		return false;
	}
	@Override
	public boolean unloadWorld(World world, boolean b){
		return false;
	}
	@Override
	public World getWorld(String s){
		return null;
	}
	@Override
	public World getWorld(UUID uuid){
		return null;
	}
	@Override
	public MapView getMap(short i){
		return null;
	}
	@Override
	public MapView createMap(World world){
		return null;
	}
	@Override
	public void reload(){
	}
	@Override
	public java.util.logging.Logger getLogger(){
		return logger; // jython234 why did you initialize a new one every time, but not conserve memory! You know this can be a very frequent call?
	}
	@Override
	public PluginCommand getPluginCommand(String s){
		return null;
	}
	@Override
	public void savePlayers(){
	}
	@Override
	public boolean dispatchCommand(CommandSender commandSender, String s) throws CommandException {
		return false;
	}
	@Override
	public void configureDbConfig(ServerConfig serverConfig){
	}
	@Override
	public boolean addRecipe(Recipe recipe){
		return false;
	}
	@Override
	public List<Recipe> getRecipesFor(ItemStack itemStack){
		return null;
	}
	@Override
	public Iterator<Recipe> recipeIterator(){
		return null;
	}
	@Override
	public void clearRecipes(){
	}
	@Override
	public void resetRecipes(){
	}
	@Override
	public Map<String, String[]> getCommandAliases(){
		return null;
	}
	@Override
	public int getSpawnRadius(){
		return 0;
	}
	@Override
	public void setSpawnRadius(int i){
	}
	@Override
	public boolean getOnlineMode(){
		return false;
	}
	@Override
	public boolean getAllowFlight(){
		return false;
	}
	@Override
	public boolean isHardcore(){
		return false;
	}
	@Override
	public boolean useExactLoginLocation(){
		return false;
	}
	@Override
	public void shutdown(){
	}
	@Override
	public int broadcast(String s, String s1){
		return 0;
	}
	@Override
	public OfflinePlayer getOfflinePlayer(String s){
		return null;
	}
	@Override
	public OfflinePlayer getOfflinePlayer(UUID uuid){
		return null;
	}
	@Override
	public Set<String> getIPBans(){
		return null;
	}
	@Override
	public void banIP(String s){
	}
	@Override
	public void unbanIP(String s){
	}
	@Override
	public Set<OfflinePlayer> getBannedPlayers(){
		return null;
	}
	@Override
	public BanList getBanList(BanList.Type type){
		return null;
	}
	@Override
	public Set<OfflinePlayer> getOperators(){
		return null;
	}
	@Override
	public GameMode getDefaultGameMode(){
		return null;
	}
	@Override
	public void setDefaultGameMode(GameMode gameMode){
	}
	@Override
	public ConsoleCommandSender getConsoleSender(){
		return null;
	}
	@Override
	public File getWorldContainer(){
		return null;
	}
	@Override
	public OfflinePlayer[] getOfflinePlayers(){
		return new OfflinePlayer[0];
	}
	@Override
	public Messenger getMessenger(){
		return null;
	}
	@Override
	public HelpMap getHelpMap(){
		return null;
	}
	@Override
	public Inventory createInventory(InventoryHolder inventoryHolder, InventoryType inventoryType){
		return null;
	}
	@Override
	public Inventory createInventory(InventoryHolder inventoryHolder, InventoryType inventoryType, String s){
		return null;
	}
	@Override
	public Inventory createInventory(InventoryHolder inventoryHolder, int i) throws IllegalArgumentException {
		return null;
	}
	@Override
	public Inventory createInventory(InventoryHolder inventoryHolder, int i, String s) throws IllegalArgumentException {
		return null;
	}
	@Override
	public int getMonsterSpawnLimit(){
		return 0;
	}
	@Override
	public int getAnimalSpawnLimit(){
		return 0;
	}
	@Override
	public int getWaterAnimalSpawnLimit(){
		return 0;
	}
	@Override
	public int getAmbientSpawnLimit(){
		return 0;
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_INVALID_VALUE)
	public boolean isPrimaryThread(){
		Main.onUnsupported(UNSUPPORTED_LEVEL_INVALID_VALUE);
		return true;
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_NULL)
	public String getMotd(){
		Main.onUnsupported(UNSUPPORTED_LEVEL_NULL);
		return null;
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_NULL)
	public String getShutdownMessage(){
		Main.onUnsupported(UNSUPPORTED_LEVEL_NULL);
		return null;
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_NULL)
	public Warning.WarningState getWarningState(){
		Main.onUnsupported(UNSUPPORTED_LEVEL_NULL);
		return null;
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_NULL)
	public ItemFactory getItemFactory(){
		Main.onUnsupported(UNSUPPORTED_LEVEL_NULL);
		return null;
	}
	@Override
	@Unsupported(UNSUPPORTED_LEVEL_NULL)
	public ScoreboardManager getScoreboardManager(){
		Main.onUnsupported(UNSUPPORTED_LEVEL_NULL);
		return null;
	}
	@Override
	public CachedServerIcon getServerIcon(){
		return null;
	}
	@Override
	public CachedServerIcon loadServerIcon(File file) throws IllegalArgumentException, Exception {
		return null;
	}
	@Override
	public CachedServerIcon loadServerIcon(BufferedImage bufferedImage) throws IllegalArgumentException, Exception {
		return null;
	}
	@Override
	public void setIdleTimeout(int i){
	}
	@Override
	public int getIdleTimeout(){
		return 0;
	}
	@SuppressWarnings("deprecation")
	@Override
	public UnsafeValues getUnsafe(){
		return null;
	}
	@Override
	public void sendPluginMessage(Plugin plugin, String s, byte[] bytes){
	}
	@Override
	public Set<String> getListeningPluginChannels(){
		return null;
	}
}

package FactionMenu;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FactionMenu extends JavaPlugin
{
    private static Plugin pl;

    public void onEnable()
    {
	PluginManager pm = getServer().getPluginManager();
	getCommand("fm").setExecutor(new Commands());
	pm.registerEvents(new MenuListener(), this);
	pm.registerEvents(new InviteListener(), this);
	pm.registerEvents(new KickMenu(), this);
	pm.registerEvents(new OfficerMenu(), this);
	pl = (Plugin) this;
    }
    public static Plugin getPlugin()
    {
	return pl;
    }

}

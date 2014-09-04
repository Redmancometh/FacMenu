package FactionMenu;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import com.massivecraft.factions.entity.UPlayer;
public class OfficerMenu implements Listener
{
    @SuppressWarnings("deprecation")
    public static void openPlayerMenu(UPlayer p)
    {
	Inventory OfficerMenu = Bukkit.createInventory(null, 36, "Officer Menu");
	List<UPlayer> playerList = p.getFaction().getUPlayers();
	int size = playerList.size();
	ItemStack[] items = new ItemStack[size];
	String[] names = new String[size];
	SkullMeta[] imeta = new SkullMeta[size];
	int x = 0;
	for(UPlayer fp : playerList)
	{
	    items[x] = new ItemStack(397, 1, (short) 3);
	    imeta[x]=(SkullMeta)items[x].getItemMeta();
	    names[x]=fp.getName();
	    imeta[x].setDisplayName(names[x]);
	    items[x].setItemMeta(imeta[x]);
	    OfficerMenu.addItem(items[x]);
	    x++;
	}
	p.getPlayer().closeInventory();
	p.getPlayer().openInventory(OfficerMenu);
    }
    @SuppressWarnings("deprecation")
    @EventHandler
    public void kickPlayer(InventoryClickEvent e)
    {
	if(e.getInventory().getName().equalsIgnoreCase("Officer Menu")&&e.getCurrentItem()!=null&&e.getCurrentItem().getTypeId()!=0)
	{
	    Bukkit.broadcastMessage("TEST");
	    e.setCancelled(true);
	    Player p = (Player)e.getWhoClicked();
	    p.performCommand("f mod "+e.getCurrentItem().getItemMeta().getDisplayName());
	}
    }
}

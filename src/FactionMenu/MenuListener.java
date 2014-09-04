package FactionMenu;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuListener implements Listener
{
    @SuppressWarnings("deprecation")
    @EventHandler
    public void clickMenu(InventoryClickEvent e)
    {
	if(e.getInventory().getName().equalsIgnoreCase("Factions Menu"))
	{
	    e.setCancelled(true);
	    if(e.getCurrentItem()!=null&&e.getCurrentItem().getTypeId()!=0)
	    {
		FactionPlayer.ProcessAction(e.getCurrentItem().getItemMeta().getDisplayName(), (Player)e.getWhoClicked());
	    }
	}
    }
}

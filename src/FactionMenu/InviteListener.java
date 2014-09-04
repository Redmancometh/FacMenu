package FactionMenu;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

import com.massivecraft.factions.entity.UPlayer;
@SuppressWarnings("deprecation")
public class InviteListener implements Listener
{
    @EventHandler
    public void inviteListener(PlayerChatEvent e)
    {
	Player p = e.getPlayer();
	if(FactionPlayer.input.containsKey(p.getUniqueId()))
	{
	    e.setCancelled(true);
	    String parseAction = FactionPlayer.input.get(p.getUniqueId());
	    String message = e.getMessage();
	    FactionPlayer.input.remove(p.getUniqueId());
	    if(message.equalsIgnoreCase("cancel"))
	    {
		p.sendMessage(ChatColor.GOLD+"Cancelled");
		return;
	    }
	    switch(parseAction)
	    {
	    case "invite":
		e.getPlayer().performCommand("f invite "+message);
		break;
	    case "enemied":
		p.performCommand("f enemy "+message);
		break;
	    case "allied":
		p.performCommand("f ally "+message);
		break;
	    case "neutral":
		p.performCommand("f neutral "+message);
		break;
	    case "info":
		p.performCommand("f f "+message);
		break;
	    case "name":
		p.performCommand("f name "+message);
		break;
	    case "desc":
		p.performCommand("f desc "+message);
		break;
	    case "create":
		p.performCommand("f create "+message);
		break;
	    }
	}
    }
}

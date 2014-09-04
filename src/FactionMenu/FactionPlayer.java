package FactionMenu;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import com.massivecraft.factions.entity.UPlayer;
public class FactionPlayer
{
    public static HashMap<UUID, String> input = new HashMap<UUID, String>();
    public static void ProcessAction(final String action, final Player p)
    {
	UUID uid = p.getUniqueId();
	UPlayer fp = UPlayer.get(p);
	p.closeInventory(); 
	switch(ChatColor.stripColor(action))
	{
	case "Invite Player":
	    input.put(uid, "invite");
	    p.sendMessage(ChatColor.GOLD+"Please input the name of the player you want to invite or \"cancel\" to cancel");
	    p.closeInventory();
	    break;
	case "Enemy a Faction":
	    input.put(uid, "enemied");
	    p.sendMessage(ChatColor.GOLD+"Please input the name of the faction or player you want to enemy or \"cancel\" to cancel!");
	    break;
	case "Ally a Faction":
	    input.put(uid, "allied");
	    p.sendMessage(ChatColor.GOLD+"Please input the name of the faction or player you want to allied or \"cancel\" to cancel!");
	    break;
	case "Set Faction to Neutral":
	    input.put(uid, "neutral");
	    p.sendMessage(ChatColor.GOLD+"Please input the name of the faction or player you want to neutral or \"cancel\" to cancel!");
	    break;
	case "Get Faction's Info":
	    input.put(uid, "info");
	    p.sendMessage(ChatColor.GOLD+"Please input the name of the faction or player who's info you want or \"cancel\" to cancel!");
	    break;
	case "Change Faction Name":
	    input.put(uid, "name");
	    p.sendMessage(ChatColor.GOLD+"Please input the new name for your faction or \"cancel\" to cancel!");
	    break;
	case "Change Faction Description":
	    input.put(uid, "desc");
	    p.sendMessage(ChatColor.GOLD+"Please input the new faction description or \"cancel\" to cancel!");
	    break;
	case "Kick Player":
	    KickMenu.openPlayerMenu(fp);
	    break;
	case "Make Player Officer":
	    OfficerMenu.openPlayerMenu(fp);
	    break;
	case "Teleport To Faction Home":
	    p.performCommand("f home");
	    break;
	case "Faction Map of Area":
	    p.performCommand("f map");
	    break;
	case "Alliance Chat":
	    p.performCommand("f c a");
	    break;
	case "Faction Chat":
	    p.performCommand("f c f");
	    break;
	case "Public Chat":
	    p.performCommand("f c p");
	    break;
	case "Faction Info":
	    p.performCommand("f who");
	    break;
	case "Set Home Here":
	    p.performCommand("f sethome");
	    break;
	case "Claim Land":
	    p.performCommand("f claim");
	    break;
	case "Unclaim Land":
	    p.performCommand("f unclaim");
	    break;
	case "Toggle Open Faction":
	    p.performCommand("f open");
	    break;
	case "Set Faction Home":
	    p.performCommand("f sethome");
	    break;
	case "Leave My Faction":
	    p.performCommand("f leave");
	    break;
	case "Check My Power":
	    p.performCommand("f power");
	    break;
	case "Toggle Autoclaim":
	    p.performCommand("f autoclaim");
	    break;
	case "Toggle Auto Map":
	    if(!fp.isMapAutoUpdating()){p.performCommand("f map on");}
	    else{p.performCommand("f map off");}
	    break;
	case "Create Faction":
	    input.put(uid, "create");
	    p.sendMessage(ChatColor.GOLD+"Please input the new faction's name or use \"cancel\" to cancel!");
	    break;
	}
    }
}

package FactionMenu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.UPlayer;

public class ItemCrap implements Listener
{
    ItemStack[] items = new ItemStack[30];
    String[] names = new String[30];
    ItemMeta[] imeta = new ItemMeta[30];
    String[] myStringArray = new String[3];
    Inventory MainMenu = Bukkit.createInventory(null, 36, "Factions Menu");
    List<String> facInfo = new ArrayList<String>();
    ChatColor canClaim;
    ChatColor canDisband;
    ChatColor isInFac;
    @SuppressWarnings("deprecation")
    public void setValues(Player p)
    {
	UPlayer fp = UPlayer.get(p);
	Faction f = fp.getFaction();
	if(!fp.hasFaction())
	{
	    canClaim=ChatColor.RED;
	    canDisband=ChatColor.RED;
	    isInFac=ChatColor.GREEN;
	}
	else
	{
	    isInFac=ChatColor.RED;
	    if(!(fp.getRole()==Rel.OFFICER)){canClaim=ChatColor.GREEN;}else{canClaim=ChatColor.DARK_RED;}
	    if(fp.getRole()==Rel.LEADER){canDisband=ChatColor.GREEN;}else{canDisband=ChatColor.DARK_RED;}
	}
	facInfo.add("Name: " + f.getName());
	facInfo.add("Power: " + f.getPowerRounded());
	facInfo.add("Max Power: " + f.getPowerMaxRounded());
	facInfo.add("Claimed Land: " + f.getLandCount());
	names[0] = ChatColor.AQUA + "Faction Info";
	names[1] = ChatColor.AQUA + "Faction Map of Area";
	names[2] = ChatColor.AQUA + "Teleport To Faction Home";
	names[3] = ChatColor.AQUA + "My Power: " + fp.getPowerRounded() + "/" + fp.getPowerMaxRounded();
	names[4] = ChatColor.AQUA + "Leave My Faction";
	names[5] = canClaim+"Change Faction Name";
	names[6] = ChatColor.DARK_PURPLE + "Public Chat";
	names[7] = ChatColor.DARK_AQUA + "Alliance Chat";
	names[8] = ChatColor.GREEN + "Faction Chat";
	names[9] = canDisband + "Disband";
	names[10] = canClaim+"Claim Land";
	names[11] = canClaim+"Unclaim Land";
	names[12] = canClaim+"Toggle Open Faction";
	names[13] = canClaim+"Set Faction Home";
	names[14] = canClaim+"Change Faction Description";
	names[15] = canClaim+"Kick Player";
	names[16] = canDisband+"Make Player Officer";
	names[17] = canClaim+"Invite Player";
	names[18] = canClaim+"Enemy a Faction";
	names[19] = canClaim+"Ally a Faction";
	names[20] = canClaim+"Set Faction to Neutral";
	names[21] = ChatColor.AQUA+"Get Faction's Info";
	names[25] = ChatColor.AQUA+"Toggle Autoclaim";
	names[26] = ChatColor.AQUA+"Toggle Auto Map";
	names[27] = isInFac+"Create Faction";

	items[0] = new ItemStack(Material.PAPER);
	items[1] = new ItemStack(Material.MAP);
	items[2] = new ItemStack(Material.ENDER_PORTAL);
	items[3] = new ItemStack(Material.REDSTONE);
	items[4] = new ItemStack(Material.IRON_DOOR);
	items[5] = new ItemStack(Material.BOOKSHELF);
	// Chat Menu ItemStacks
	items[6] = new ItemStack(Material.BOOK_AND_QUILL);
	items[7] = new ItemStack(Material.BOOK_AND_QUILL);
	items[8] = new ItemStack(Material.BOOK_AND_QUILL);
	items[9] = new ItemStack(Material.FIRE);
	items[10] = new ItemStack(Material.MAP);
	items[11] = new ItemStack(Material.EMPTY_MAP);
	items[12] = new ItemStack(Material.WOOD_DOOR);
	items[13] = new ItemStack(Material.BRICK);
	items[14] = new ItemStack(Material.BOOK);
	items[15] = new ItemStack(397, 1, (short) 3);
	items[16] = new ItemStack(397, 1, (short) 3);
	items[17] = new ItemStack(397, 1, (short) 3);
	items[18] = new ItemStack(Material.IRON_SWORD);
	items[19] = new ItemStack(Material.IRON_SWORD);
	items[20] = new ItemStack(Material.IRON_SWORD);
	items[21] = new ItemStack(Material.ITEM_FRAME);
	items[25] = new ItemStack(Material.MAP);
	items[26] = new ItemStack(Material.MAP);
	items[27] = new ItemStack(Material.ANVIL);
    }
    public void mainMenu(Player p)
    {
	setValues(p);
	for (int x = 0; x < 28; x++)
	{
	    if (items[x] != null)
	    {
		imeta[x] = items[x].getItemMeta();
		imeta[x].setDisplayName(names[x]);
		if (x == 0){imeta[x].setLore(facInfo);}
		items[x].setItemMeta(imeta[x]);
		MainMenu.setItem(x, items[x]);
	    }
	}
	p.openInventory(MainMenu);
    }
}
package nya.clockwork04.LLocate;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin implements Listener{

	//historian if you're reading this you're a furry nya~
	public void onEnable() {
		Bukkit.getServer().getLogger().info("LLocate By Snoopie Enabled!");
	}	
	
	public void onDisable() {
	}	
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args) {

		if (cmd.getName().equalsIgnoreCase("llocate")) {

		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Cant LLocate Console! " + ChatColor.BLUE + "Use CLocate Command");
			return true;
		}
 
		

			Player player = (Player) sender;
			Location plocation = player.getLocation();
 
			if (args.length == 0) {
				player.sendMessage(ChatColor.AQUA + (player.getName() +  ChatColor.GREEN + " Your Current Location Is " + ChatColor.DARK_AQUA + ("X" + plocation.getBlockX()) + (" Z" + plocation.getBlockZ())));
				Bukkit.getServer().getLogger().info(player.getName() + " Got Their Location!");
				return true;
			}
				Player target = Bukkit.getServer().getPlayer(args[0]);

	            
                if (target == null) { //checks if target is exist
		               player.sendMessage(ChatColor.RED + "No Such Player");
		               return true;
		            }

                Location tlocation = target.getLocation();
  
                if (target.isOp() && !player.isOp()) { //sends the target a message if they're op and the sender is not
			               target.sendMessage(ChatColor.RED + (player.getName()) + " has attempted to get your location!");
			        }

		            if (!player.isOp()) { //checks if sender/player is OP
			               player.sendMessage(ChatColor.RED + "Im sorry " + (player.getName()) + " im afraid i cant do that");
		                   Bukkit.getServer().getLogger().info((player.getName()) + " attempted to get the location of " + (target.getName()) + "!");
			               return true;
			        }

		         player.sendMessage(ChatColor.AQUA + (target.getName() + "'s" + ChatColor.GREEN + " Current Location Is " + ChatColor.DARK_PURPLE + "X" + ChatColor.LIGHT_PURPLE + (tlocation.getBlockX()) + ChatColor.DARK_PURPLE + " Z" + ChatColor.LIGHT_PURPLE + (tlocation.getBlockZ())));
		         Bukkit.getServer().getLogger().info((player.getName()) + " Has Located " + (target.getName()) + "!");
		         }

		//begin Console Locate
		if (cmd.getName().equalsIgnoreCase("clocate")) {
			if (sender instanceof Player) {
				sender.sendMessage(ChatColor.RED +"Incorrect Command! please use LLocate");
			    return true;
			}
            if (!(sender instanceof Player)) {
            	if (args.length == 0) {
            		sender.sendMessage(ChatColor.RED + "Must Specify Player!");
            		return true;
            	}
            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
            	sender.sendMessage(ChatColor.RED + "Player Does Not Exist!");
            	return true;
            }
            Location tlocation = target.getLocation();
            sender.sendMessage(ChatColor.AQUA + (target.getName() + "'s" + ChatColor.GREEN + " Current Location Is " + ChatColor.DARK_PURPLE + "X" + ChatColor.LIGHT_PURPLE + (tlocation.getBlockX()) + ChatColor.DARK_PURPLE + " Z" + ChatColor.LIGHT_PURPLE +(tlocation.getBlockZ())));
            	if (target.isOp() == true) {
            		target.sendMessage(ChatColor.GOLD + "You have been located by Console!");
            	}
            }
		}
	
	return true;
	}
    }



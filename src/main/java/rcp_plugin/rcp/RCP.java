package rcp_plugin.rcp;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public final class RCP extends JavaPlugin {
    String enemy = "";

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("RCPプラグインが起動しました");

        String[] hand = {"グー", "チョキ", "パー"};
        //じゃんけんで出す手の配列
        Random r = new Random();
        //乱数を生成するメソッド
        enemy = hand[r.nextInt(3)];
        //相手の手をランダムで決める
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("rcp")) {

            if (args.length == 0) return false;

            if(args[0].equalsIgnoreCase("paa") && enemy.equalsIgnoreCase("tyo") ||
                    args[0].equalsIgnoreCase("tyo") && enemy.equalsIgnoreCase("goo") ||
                    args[0].equalsIgnoreCase("goo") && enemy.equalsIgnoreCase("paa")){
                //敗北のパターン
                sender.sendMessage("俺の勝ち! 何で負けたか明日まで考えといてください");

            }else if(args[0].equalsIgnoreCase("tyo") && enemy.equalsIgnoreCase("paa") ||
                    args[0].equalsIgnoreCase("goo") && enemy.equalsIgnoreCase("tyo") ||
                    args[0].equalsIgnoreCase("paa") && enemy.equalsIgnoreCase("goo")) {
                //勝利のパターン
                sender.sendMessage("§lやるやん! 明日は俺にリベンジさせて");

            } else if (args[0].equalsIgnoreCase(enemy)) {
                //あいこのパターン
                sender.sendMessage("§lあいこやん! どうすんのこれ?");
            } else {

                return false;
            }
            return true;
        }

        if(command.getName().equalsIgnoreCase("enemy")) {
            sender.sendMessage("Enemy choice is " + enemy + ".");
            return true;
        }

        return true;
    }
}
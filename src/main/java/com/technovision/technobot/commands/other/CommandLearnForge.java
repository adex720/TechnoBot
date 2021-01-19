package com.technovision.technobot.commands.other;

import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

import java.util.Date;

public class CommandLearnForge extends Command {

    public CommandLearnForge(final TechnoBot bot) {
        super(bot,"learnforge", "Important links and info for learning forge.", "{prefix}learnforge", Category.OTHER);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn Forge!")
                .setDescription("Below are some important links to help you get started learning the Forge API.")
                .addField("Forge Official Docs", "https://mcforge.readthedocs.io/", false)
                .addField("Forge Community Wiki", "https://forge.gemwire.uk/", false)
                .addField("Forge Tutorial Series", "https://wiki.mcjty.eu/modding/", false)
                .addField("Forge Discord", "https://discord.gg/UvedJ9m", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

}

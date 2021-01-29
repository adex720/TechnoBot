package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandDiscordJS extends Command {

    public CommandDiscordJS(final TechnoBot bot) {
        super(bot,"discord.js", "Displays resources for learning the Discord.js API.", "{prefix}discord.js", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn the Discord.js API!")
                .setDescription("Below are some important links to help you get started learning the Discord.js API.")
                .addField("Discord.js GitHub", "https://github.com/discordjs/discord.js", false)
                .addField("Official Documentation", "https://discord.js.org/#/docs/", false)
                .addField("Official Online Guide", "https://discordjs.guide/", false)
                .addField("Discord.js Discord", "https://discord.gg/bRCvFy9", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("discordjs", "djs", "discord-js");
    }
}

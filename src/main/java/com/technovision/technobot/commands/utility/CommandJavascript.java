package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandJavascript extends Command {

    public CommandJavascript(final TechnoBot bot) {
        super(bot,"javascript", "Displays resources for learning Javascript programming.", "{prefix}javascript", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn Javascript Programming!")
                .setDescription("Below are some important links to help you get started learning Javascript programming.")
                .addField("Javascript Documentation", "https://devdocs.io/javascript", false)
                .addField("Online Javascript Courses", "https://www.codecademy.com/catalog/language/javascript", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("learnjavascript", "js");
    }
}

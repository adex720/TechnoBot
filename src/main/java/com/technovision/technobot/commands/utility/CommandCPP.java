package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandCPP extends Command {

    public CommandCPP(final TechnoBot bot) {
        super(bot,"c++", "Displays resources for learning C++ and C programming.", "{prefix}c++", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn C++ and C Programming!")
                .setDescription("Below are some important links to help you get started learning C++ and C programming.")
                .addField("Official Documentation", "https://docs.microsoft.com/en-us/cpp/", false)
                .addField("Official Website", "https://www.cplusplus.com/", false)
                .addField("Online C++ Courses", "https://www.codecademy.com/catalog/language/c-plus-plus", false)
                .addField("C++ vs C Explained", "https://www.geeksforgeeks.org/difference-between-c-and-c/", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("c", "cpp", "cplusplus", "c+", "learncpp", "learnc++");
    }
}

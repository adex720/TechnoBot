package com.technovision.technobot.commands.utility;

import com.google.common.collect.Sets;
import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Date;
import java.util.Set;

public class CommandPython extends Command {

    public CommandPython(final TechnoBot bot) {
        super(bot,"python", "Displays resources for learning Python programming.", "{prefix}python", Category.UTILITY);
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        event.getChannel().sendMessage(new EmbedBuilder()
                .setTitle("Learn Python Programming!")
                .setDescription("Below are some important links to help you get started learning Python programming.")
                .addField("Official Documentation", "https://docs.python.org/3/", false)
                .addField("Online Python Courses", "https://www.codecademy.com/catalog/language/python", false)
                .addField("Python Machine Learning", "https://www.tensorflow.org/", false)
                .setFooter("TechnoVision Discord", "https://i.imgur.com/TzHOnJu.png")
                .setTimestamp(new Date().toInstant())
                .setColor(Command.EMBED_COLOR)
                .build()
        ).queue();
        return true;
    }

    @Override
    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet("learnpython", "py");
    }
}

package com.technovision.technobot.commands;

import com.google.api.client.util.Sets;
import com.technovision.technobot.TechnoBot;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

/**
 * Discord Executable Command
 *
 * @author Sparky
 */
public abstract class Command {

    public static final String PREFIX = "!";
    public static final int EMBED_COLOR = 0x7289da;
    public static final int ERROR_EMBED_COLOR = 0xdd5f53;

    public final String name;
    public final Category category;
    public final String description;
    public final String usage;
    protected final TechnoBot bot;

    public Command(@NotNull final TechnoBot bot, String name, String description, String usage, Category category) {
        this.bot = bot;
        this.name = name;
        this.category = category;
        this.description = description;
        this.usage = usage;
    }

    public abstract boolean execute(MessageReceivedEvent event, String[] args);

    public @NotNull Set<String> getAliases() {
        return Sets.newHashSet();
    }

    public enum Category {
        STAFF, LEVELS, MUSIC, ECONOMY, FUN, UTILITY
    }
}

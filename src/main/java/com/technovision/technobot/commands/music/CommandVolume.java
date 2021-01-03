package com.technovision.technobot.commands.music;

import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import com.technovision.technobot.listeners.managers.MusicManager;
import com.technovision.technobot.util.BotLocalization;
import com.technovision.technobot.util.Placeholders;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandVolume extends Command {
    private final MusicManager musicManager;

    public CommandVolume(final TechnoBot bot) {
        super(bot,"volume", "Change volume of music", "{prefix}volume <volume>", Command.Category.MUSIC);
        this.musicManager = bot.getMusicManager();
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        if(musicManager.handlers.get(event.getGuild().getIdLong())==null||musicManager.handlers.get(event.getGuild().getIdLong()).trackScheduler.getQueueCopy().size()==0) {
            event.getChannel().sendMessage(
                    Placeholders.setPlaceholders(BotLocalization.getNodeOrPath("commands.music.noSongsPlaying"),
                            Placeholders.fromMessageEvent(event)
                                    .get()
                    )
            ).queue();
            return true;
        }
        
        if(Integer.parseInt(args[0])>=400||Integer.parseInt(args[0])<=50) {
            // TODO: 1/2/2021 Add Localization for message
            event.getChannel().sendMessage("The volume is out of range! [50-400]").queue();
            return true;
        }

        try {
            musicManager.handlers.get(event.getGuild().getIdLong()).trackScheduler.setVolume(Integer.parseInt(args[0]));
        } catch(IndexOutOfBoundsException e) {
            event.getChannel().sendMessage(
                    Placeholders.setPlaceholders(BotLocalization.getNodeOrPath("commands.common.missingArgument"),
                            Placeholders.fromMessageEvent(event)
                                    .get()
                    )
            ).queue();
        } catch(NumberFormatException e) {
            event.getChannel().sendMessage(
                    Placeholders.setPlaceholders(BotLocalization.getNodeOrPath("commands.common.numberFormat"),
                            Placeholders.fromMessageEvent(event)
                                    .get()
                    )
            ).queue();
        }

        event.getChannel().sendMessage(
                Placeholders.setPlaceholders(BotLocalization.getNodeOrPath("commands.music.volumePlayer"),
                        Placeholders.fromMessageEvent(event)
                                .get()
                )
        ).queue();
        return true;
    }
}

package com.technovision.technobot.commands.staff;

import com.technovision.technobot.TechnoBot;
import com.technovision.technobot.commands.Command;
import com.technovision.technobot.data.Configuration;
import com.technovision.technobot.logging.AutoModLogger;
import com.technovision.technobot.logging.Logger;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class CommandUnmute extends Command {

    private final String MUTE_ROLE_NAME = "Muted";
    private final TechnoBot bot;
    private Configuration muteTracker; // TODO: 12/15/2020 Unmute user from mute tracker to avoid early unmutes when unmuted and remuted quickly. 

    public CommandUnmute(final TechnoBot bot, Configuration muteTracker) {
        super("unmute", "Un-mutes the specified user", "unmute <user>", Command.Category.STAFF);
        this.bot = bot;
        this.muteTracker = muteTracker;
    }

    @Override
    public boolean execute(MessageReceivedEvent event, String[] args) {
        Member executor = event.getMember();
        Member target = null;
        try {
            target = event.getMessage().getMentionedMembers().get(0);
        } catch(Exception e) {
            // there was no mentioned user, using second check
        }

        if(!executor.hasPermission(Permission.KICK_MEMBERS)) {
            EmbedBuilder embed = new EmbedBuilder();
            embed.setColor(ERROR_EMBED_COLOR);
            embed.setDescription(":x: You do not have permission to do that!");
            event.getChannel().sendMessage(embed.build()).queue();
            return true;
        }

        if(target==null) {
            try {
                target = event.getGuild().getMemberById(args[0]);
            } catch(Exception ignored) {}
        }
        if(target==null) {
            event.getChannel().sendMessage("Could not find user!").queue();
            return true;
        }
        if(executor.getUser().getId().equalsIgnoreCase(target.getUser().getId())) {
            event.getChannel().sendMessage("You can't mute yourself \uD83E\uDD26\u200D").queue();
            return true;
        }
        if(!executor.canInteract(target)) {
            event.getChannel().sendMessage("You can't mute that user!").queue();
            return true;
        }

        if(args.length==0) {
            event.getChannel().sendMessage("Please specify a user!").queue();
            return true;
        }

        try {
            Role mute_role = event.getGuild().getRolesByName(MUTE_ROLE_NAME, true).get(0);
            Member member = event.getMessage().getMentionedMembers().get(0);
            event.getGuild().removeRoleFromMember(member, mute_role).queue();
            Member finalTarget = target;
            event.getChannel().sendMessage(new EmbedBuilder()
                    .setAuthor(target.getUser().getAsTag() + " has been un-muted", null, target.getUser().getEffectiveAvatarUrl()).build()).queue(msg -> {
                bot.getAutoModLogger().log(event.getGuild(), event.getTextChannel(), finalTarget.getUser(), event.getAuthor(), AutoModLogger.Infraction.UNMUTE, "_ _");
            });
        } catch(IndexOutOfBoundsException e) {
            bot.getLogger().log(Logger.LogLevel.WARNING, "Mute role does not exist!");
        }
        return true;
    }
}

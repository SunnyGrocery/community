package com.sust.community.dto;

import com.sust.community.model.Note;
import lombok.Data;

import java.time.format.DateTimeFormatter;

/**
 * Created by SunnyGrocery on 2019/10/15 21:03
 */
@Data
public class NoteDTO {

    public static NoteDTO fromNote(Note note) {
        NoteDTO noteDTO = new NoteDTO();
        noteDTO.setTitle(note.getTitle());
        noteDTO.setDescription(note.getDescription());
        noteDTO.setLabel(note.getLabel());
        noteDTO.setAvatarUrl(note.getUser().getAvatarUrl());
        noteDTO.setCommentCount(note.getCommentCount());
        noteDTO.setLikeCount(note.getLikeCount());
        noteDTO.setViewCount(note.getViewCount());

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        noteDTO.setCreateTime(dateTimeFormatter.format(note.getCreateTime()));
        noteDTO.setModifiedTime(dateTimeFormatter.format(note.getModifiedTime()));

        return noteDTO;
    }

    private String title;
    private String description;
    private String label;
    private String avatarUrl;

    private Integer commentCount;
    private Integer likeCount;
    private Integer viewCount;

    private String createTime;
    private String modifiedTime;
}

package com.sust.community.model;

import com.sust.community.dto.NoteDTO;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by SunnyGrocery on 2019/10/11 16:49
 */
@Data
public class  Note {
    public static Note fromNoteDTO(NoteDTO noteDTO) {
        Note note = new Note();
        note.setTitle(noteDTO.getTitle());
        note.setDescription(noteDTO.getDescription());
        note.setLabel(noteDTO.getLabel());
        return note;
    }

    private Integer id;
    private User user;

    private String title;
    private String description;
    private Integer commentCount;
    private Integer likeCount;
    private Integer viewCount;
    private String label;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;
}

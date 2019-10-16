package com.sust.community.dto;

import com.sust.community.model.Note;
import lombok.Data;

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
        return noteDTO;
    }

    private String title;
    private String description;
    private String label;
}

package com.veliz.NoteApp.dto;

import com.veliz.NoteApp.entity.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Date age;
    private LocalDateTime registerDate;
    private Boolean status;
    private List<Note> noteList;
}

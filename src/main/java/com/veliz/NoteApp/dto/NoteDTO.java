package com.veliz.NoteApp.dto;

import com.veliz.NoteApp.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NoteDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime registerDate;
    private User user;
}

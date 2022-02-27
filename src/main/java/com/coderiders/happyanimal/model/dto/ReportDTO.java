package com.coderiders.happyanimal.model.dto;

import com.coderiders.happyanimal.model.User;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
    private Long id;
    private String date;
    private String text;
    private User user; //TODO: когда появится UserDTO, заменить тип User на UserDTO
}

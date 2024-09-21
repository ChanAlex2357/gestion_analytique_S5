package gestion.analytique.pc.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Centre {
    private Long id;
    private String name;
}
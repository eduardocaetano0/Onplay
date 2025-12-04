package br.com.onplay.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_streaming")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Streaming {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;
}

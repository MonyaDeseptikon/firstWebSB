package ru.monya.firstWebSB.notesSpringBootDatabase;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
//@Data // Generates getters, setters, toString, equals, and hashCode methods.
//@NoArgsConstructor // Generates a no-args constructor.
//@AllArgsConstructor // Generates a constructor with all arguments.
//@Builder // Generates a builder pattern for creating instances.
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Имя автора", example = "Впишите сюда свое имя или псевдоним")
    @Column(nullable = false)
    private String author;

    @Schema(description = "Заголовок заметки", example = "Впишите сюда краткий заголовок заметки")
    @Column(nullable = false)
    private String title;

    @Schema(description = "Содержание заметки", example = "Здесь пишите всё, что хотите")
    @Column(nullable = false, length = 2000)
    private String content;


    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
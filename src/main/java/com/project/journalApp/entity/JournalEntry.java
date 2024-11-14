package com.project.journalApp.entity;

import com.project.journalApp.enums.Sentiment;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

// Document annotation is used with MongoDB if using other relational db we will use @Entity annotation with @Table annotation
@Document(collection = "journal_entries")
@Data // for getters and setters in lombok
@NoArgsConstructor
public class JournalEntry {

    @Id
    private ObjectId id;

    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;
    private Sentiment sentiment;
}

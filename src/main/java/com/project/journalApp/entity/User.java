package com.project.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    @NonNull
    private String userName;

    @NonNull
    private String password;

    private String email;

    private boolean sentimentAnalysis;

    @DBRef // creating reference to the table JournalEntry
    private List<JournalEntry> journalEntries = new ArrayList<>();
    // this journalEntries will have the reference of the entries available in JournalEntry table.

    private List<String> roles;
}

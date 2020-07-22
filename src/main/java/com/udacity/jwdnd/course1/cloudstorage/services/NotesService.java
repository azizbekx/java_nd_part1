package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.NotesMapper;
import com.udacity.jwdnd.course1.cloudstorage.mapper.UserNoteMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class NotesService {
//    private NotesMapper notesMapper;
//
//    public NotesService(NotesMapper notesMapper) {
//        this.notesMapper = notesMapper;
//    }
//
//    @PostConstruct
//    public void PostConstructor() {
//        System.out.println("Create Notes Service Bean");
//    }
//
////    public void addNotes(Notes notes) {
////        Notes newNotes = new Notes();
////        newNotes.setNoteTitle(notes.getNoteTitle());
////        newNotes.setNoteDescription(notes.getNoteDescription());
////
////        notesMapper.addNotes(newNotes);
////    }
////
////    public List<Notes> getNotes() {
////        return notesMapper.getAllNotes();
////    }
////    public void deleteNote(int noteId){
////        notesMapper.deleteNote(noteId);
////    }
//
//    public List<Notes> getAllNotes() throws Exception {
//        List<Notes> notes = notesMapper.getNotes();
//        if (notes == null) {
//            throw new Exception();
//        }
//        return notes;
//    }
//
//    public void addNote(Notes note) {
//        notesMapper.addNotes(note);
//    }
//
//
//    public void deleteNote(int noteId) {
//        notesMapper.deleteNote(noteId);
//    }

    private NotesMapper notesMapper;
    private UserNoteMapper userNoteMapper;

    public NotesService(NotesMapper notesMapper, UserNoteMapper userNoteMapper) {
        this.notesMapper = notesMapper;
        this.userNoteMapper = userNoteMapper;
    }

    public List<Notes> getNoteByUsername(String username) {
        return this.userNoteMapper.getNoteByUsername(username);
    }

    public Boolean createOrUpdateNote(String username, Notes notes) {
        String noteTitle = notes.getNoteTitle();
        String noteDescription = notes.getNoteDescription();
        Integer noteId = notes.getNoteId();

        if (noteId == null) {
            this.userNoteMapper.insertNoteByUsername(username, noteTitle, noteDescription);
        } else {
            this.notesMapper.updateNote(noteTitle, noteDescription, noteId);
        }
        return true;
    }

    public Boolean deleteNote(Integer noteId, String username) {
        this.notesMapper.deleteNote(noteId);
        return true;
    }
}


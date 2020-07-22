package com.udacity.jwdnd.course1.cloudstorage.mapper;


import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotesMapper {



    @Select("SELECT * FROM NOTES")
    List<Notes> getNotes();

    @Select("SELECT * FROM NOTES WHERE noteId = #{noteId}")
    public Notes findId(int noteId);

    @Insert("INSERT INTO NOTES (noteId, noteTitle, noteDescription, userId) VALUES(#{noteId}, #{noteTitle}, #{noteDescription},#{userId})")

    @Options(useGeneratedKeys = true, keyProperty = "noteId")
    int insert(Notes notes);

    @Delete("DELETE FROM NOTES WHERE noteId = #{noteId}")
    public void deleteNote(int noteId);

    @Update("UPDATE notes SET" +
            " noteTitle = #{noteTitle}, noteDescription = #{noteDescription} WHERE noteId = #{noteId}" )
    int updateNote(String noteTitle, String noteDescription, Integer noteId);

}

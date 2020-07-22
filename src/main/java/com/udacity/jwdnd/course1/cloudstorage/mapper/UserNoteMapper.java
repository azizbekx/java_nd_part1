package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.Notes;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

@Mapper
public interface UserNoteMapper {
    List<Notes> getNoteByUsername(String username);

    @Options(useGeneratedKeys = true, keyProperty = "noteid")
    int insertNoteByUsername(
            String username,
            String notetitle,
            String notedescription);
}

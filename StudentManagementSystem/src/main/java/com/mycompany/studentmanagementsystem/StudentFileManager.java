/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentmanagementsystem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author nikos-pappas
 */
public class StudentFileManager {
            private final String filePath;
        private final ObjectMapper mapper;

        public StudentFileManager(String filePath) {
            this.filePath = filePath;
            this.mapper = new ObjectMapper();
        }
        public List<Student> loadStudentsFromFile() {
          File file = new File(filePath);
          if(!file.exists()) return new ArrayList<>();
          try{
             return mapper.readValue(file, new TypeReference<List<Student>>(){});
          } catch (IOException e){
            e.printStackTrace();
            return new ArrayList<>();
          }

        }

        public void saveStudentsToFile(List<Student> students){
          try{
              mapper.writeValue(new File(filePath), students);
          }catch (IOException e) {
            e.printStackTrace();
          }
        }
}
